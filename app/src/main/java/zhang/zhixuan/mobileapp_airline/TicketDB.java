package zhang.zhixuan.mobileapp_airline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.widget.Toast;

/**
 * Created by ruicai on 1/11/15.
 */
public class TicketDB {
    TicketDBHelper       DBHelper;
    SQLiteDatabase db;
    final Context context;

    public TicketDB(Context ctx) {
        this.context = ctx;
        DBHelper = new TicketDBHelper(this.context);
    }


    public TicketDB open() {
        db = DBHelper.getWritableDatabase();

        Toast.makeText(context, Environment.getDataDirectory().toString(), Toast.LENGTH_SHORT).show();

        return this;
    }

    public void close() {
        DBHelper.close();
    }

    public long insertMember(String referenceN, String passport, String email) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(TicketDBHelper.columnName_referenceN, referenceN);
        initialValues.put(TicketDBHelper.columnName_passport, passport);
        initialValues.put(TicketDBHelper.columnName_email, email);


        return db.insert(TicketDBHelper.tableName, null, initialValues);
    }

    public int deleteFurniture(long id) {
        return  db.delete(TicketDBHelper.tableName, TicketDBHelper.columnName_ID + "=" + id, null);
    }

    public int deleteAllFurniture() {
        return db.delete(TicketDBHelper.tableName, "1", null);    // delete all records
    }

    public int updateFurniture(long id, String referenceN, String passport, String email) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(TicketDBHelper.columnName_referenceN, referenceN);
        initialValues.put(TicketDBHelper.columnName_passport, passport);
        initialValues.put(TicketDBHelper.columnName_email, email);
        return db.update(TicketDBHelper.tableName, initialValues, TicketDBHelper.columnName_ID + "=" + id, null);
    }

    public Cursor getAllMembers() {
        return db.query(
                TicketDBHelper.tableName,
                new String[]{
                        TicketDBHelper.columnName_ID,
                        TicketDBHelper.columnName_referenceN,
                        TicketDBHelper.columnName_passport,
                        TicketDBHelper.columnName_email
                },
                null, null, null, null, null);
    }


    public Cursor getMember(long id) {
        Cursor mCursor = db.query(TicketDBHelper.tableName,
                new String[] {
                        TicketDBHelper.columnName_ID,
                        TicketDBHelper.columnName_referenceN,
                        TicketDBHelper.columnName_passport,
                        TicketDBHelper.columnName_email},
                TicketDBHelper.columnName_ID+"="+id,
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public Cursor getMemberByEmail(String email) {
        Cursor mCursor = db.query(TicketDBHelper.tableName,
                new String[] {
                        TicketDBHelper.columnName_ID,
                        TicketDBHelper.columnName_referenceN,
                        TicketDBHelper.columnName_passport,
                        TicketDBHelper.columnName_email},
                TicketDBHelper.columnName_email+" = ?",new String[]{email+""}
                , null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

}