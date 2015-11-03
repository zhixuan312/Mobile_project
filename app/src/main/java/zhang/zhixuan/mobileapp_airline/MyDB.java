package zhang.zhixuan.mobileapp_airline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.widget.Toast;

/**
 * Created by ruicai on 31/10/15.
 */
public class MyDB {
    MyDBHelper       DBHelper;
    SQLiteDatabase db;
    final Context context;

    public MyDB(Context ctx) {
        this.context = ctx;
        DBHelper = new MyDBHelper(this.context);
    }


    public MyDB open() {
        db = DBHelper.getWritableDatabase();

        Toast.makeText(context, Environment.getDataDirectory().toString(), Toast.LENGTH_SHORT).show();

        return this;
    }

    public void close() {
        DBHelper.close();
    }

    public long insertMember(String firstN, String secondN, String gender, String passport, String email) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(MyDBHelper.columnName_memberFirstName, firstN);
        initialValues.put(MyDBHelper.columnName_memberSecondName, secondN);
        initialValues.put(MyDBHelper.columnName_memberGender, gender);
        initialValues.put(MyDBHelper.columnName_memberPassport, passport);
        initialValues.put(MyDBHelper.columnName_memberEmail, email);

        return db.insert(MyDBHelper.tableName, null, initialValues);
    }

    public int deleteFurniture(long id) {
        return  db.delete(MyDBHelper.tableName, MyDBHelper.columnName_memberID + "=" + id, null);
    }

    public int deleteAllFurniture() {
        return db.delete(MyDBHelper.tableName, "1", null);    // delete all records
    }

    public int updateFurniture(long id, String firstN, String secondN, String gender, String passport, String email) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(MyDBHelper.columnName_memberFirstName, firstN);
        initialValues.put(MyDBHelper.columnName_memberSecondName, secondN);
        initialValues.put(MyDBHelper.columnName_memberGender, gender);
        initialValues.put(MyDBHelper.columnName_memberPassport, passport);
        initialValues.put(MyDBHelper.columnName_memberEmail, email);
        return db.update(MyDBHelper.tableName, initialValues, MyDBHelper.columnName_memberID + "=" + id, null);
    }

    public Cursor getAllMembers() {
        return db.query(
                MyDBHelper.tableName,
                new String[]{
                        MyDBHelper.columnName_memberID,
                        MyDBHelper.columnName_memberFirstName,
                        MyDBHelper.columnName_memberSecondName,
                        MyDBHelper.columnName_memberGender,
                        MyDBHelper.columnName_memberPassport,
                        MyDBHelper.columnName_memberEmail},
                null, null, null, null, null);
    }


    public Cursor getMember(long id) {
        Cursor mCursor = db.query(MyDBHelper.tableName,
                new String[] {
                        MyDBHelper.columnName_memberID,
                        MyDBHelper.columnName_memberFirstName,
                        MyDBHelper.columnName_memberSecondName,
                        MyDBHelper.columnName_memberGender,
                        MyDBHelper.columnName_memberPassport,
                        MyDBHelper.columnName_memberEmail},
                MyDBHelper.columnName_memberID+"="+id,
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

}
