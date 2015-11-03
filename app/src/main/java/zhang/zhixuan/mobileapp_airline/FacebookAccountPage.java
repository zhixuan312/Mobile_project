package zhang.zhixuan.mobileapp_airline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

public class FacebookAccountPage extends AppCompatActivity {

    TextView facebookAccount_tv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_account_page);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction;

        Fragment facebookFragment = new FacebookFragment();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.facebookAccount_fl_facebook, facebookFragment);
        fragmentTransaction.commit();

        Profile profile = Profile.getCurrentProfile();
        facebookAccount_tv_profile = (TextView)findViewById(R.id.facebookAccount_tv_profile);
        facebookAccount_tv_profile.setText(profile.getName());
        ProfilePictureView profilePictureView;

        profilePictureView = (ProfilePictureView) findViewById(R.id.facebook_profileImage);

        profilePictureView.setProfileId(profile.getId());

    }



}
