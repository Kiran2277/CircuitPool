package com.example.circuitpool.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.circuitpool.model.Accounts;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG = "DatabaseHelper";

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "StoreManager";

    private static final String TABLE_ACCOUNTS = "accounts";

    private static final String KEY_ID = "id";

    private static final String KEY_NAME = "name";

    private static final String CREATE_TABLE_ACCOUNTS = "CREATE TABLE "
            + TABLE_ACCOUNTS + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT" + ")";

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_ACCOUNTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);

        onCreate(db);
    }

    public long createAccounts(Accounts accounts) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, accounts.getName());

        // insert row
        long account_id = db.insert(TABLE_ACCOUNTS, null, values);

        return account_id;
    }

    public Accounts getAccounts(long account_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_ACCOUNTS + " WHERE "
                + KEY_ID + " = " + account_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Accounts td = new Accounts();
        td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        td.setName((c.getString(c.getColumnIndex(KEY_NAME))));

        return td;
    }

    public List<Accounts> getAllToDos() {
        List<Accounts> todos = new ArrayList<Accounts>();
        String selectQuery = "SELECT  * FROM " + TABLE_ACCOUNTS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Accounts td = new Accounts();
                td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                td.setName((c.getString(c.getColumnIndex(KEY_NAME))));

                // adding to todo list
                todos.add(td);
            } while (c.moveToNext());
        }

        return todos;
    }

    public int updateAccounts(Accounts accounts) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, accounts.getName());

        // updating row
        return db.update(TABLE_ACCOUNTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(accounts.getId()) });
    }

    public void deleteAccounts(long account_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ACCOUNTS, KEY_ID + " = ?",
                new String[] { String.valueOf(account_id) });
    }

}
