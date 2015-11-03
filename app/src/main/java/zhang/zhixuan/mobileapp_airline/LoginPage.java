package zhang.zhixuan.mobileapp_airline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {

    EditText login_et_id;
    EditText login_et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction;

        Fragment facebookFragment = new FacebookFragment();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.login_fl_Facebook, facebookFragment);
        fragmentTransaction.commit();

        login_et_password = (EditText)findViewById(R.id.login_et_password);
    }

    public void login_register(View View) {
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);

    }
}

