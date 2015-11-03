package zhang.zhixuan.mobileapp_airline;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ruicai on 1/11/15.
 */
public class TicketDBHelper extends SQLiteOpenHelper {

    public static final int    databaseVersion                  = 1;
    public static final String databaseName                     = "TicketDB";

    public static final String tableName                        = "TicketTable";
    public static final String columnName_ID                = "_id";
    public static final String columnName_referenceN              = "referenceN";
    public static final String columnName_passport   = "passport";
    public static final String columnName_email   = "email";


    private static final String SQLite_CREATE =
            "CREATE TABLE " + tableName + "(" + columnName_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + columnName_referenceN + " TEXT NOT NULL,"+columnName_passport + " TEXT NOT NULL,"
                    +columnName_email + " TEXT NOT NULL);";

    private static final String SQLite_DELETE = "DROP TABLE IF EXISTS " + tableName;


    public TicketDBHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }


    // note: becase MyDBHelper extends SQLiteOpenHelper, we need to implement onCreate
    //       and onUpgrade, else Android Studio will complain of error.

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLite_CREATE);
    }

    // onUpgrade is called if the database version is increased in your application code
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLite_DELETE);
        onCreate(db);
    }


}
