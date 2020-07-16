package com.example.circuitpool.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.circuitpool.model.Accounts;
import com.example.circuitpool.model.Admin;
import com.example.circuitpool.model.Orders;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG = "DatabaseHelper";

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "StoreManager";

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_ACCOUNTS);
        db.execSQL(CREATE_TABLE_ADMIN);
        db.execSQL(CREATE_TABLE_ORDERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_ADMIN);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_ORDERS);

        onCreate(db);
    }








    private static final String TABLE_ACCOUNTS = "accounts";

    private static final String ACCOUNT_ID = "id";

    private static final String ACCOUNT_NAME = "name";

    private static final String CREATE_TABLE_ACCOUNTS = "CREATE TABLE "
            + TABLE_ACCOUNTS + "(" + ACCOUNT_ID + " INTEGER PRIMARY KEY,"
            + ACCOUNT_NAME + " TEXT" + ")";


    public long createAccounts(Accounts accounts) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ACCOUNT_NAME, accounts.getName());

        // insert row
        long account_id = db.insert(TABLE_ACCOUNTS, null, values);

        return account_id;
    }

    public Accounts getAccounts(long account_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_ACCOUNTS + " WHERE "
                + ACCOUNT_ID + " = " + account_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Accounts td = new Accounts();
        td.setId(c.getInt(c.getColumnIndex(ACCOUNT_ID)));
        td.setName((c.getString(c.getColumnIndex(ACCOUNT_NAME))));

        return td;
    }

    public List<Accounts> getAllAccounts() {
        List<Accounts> accounts = new ArrayList<Accounts>();
        String selectQuery = "SELECT  * FROM " + TABLE_ACCOUNTS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Accounts td = new Accounts();
                td.setId(c.getInt((c.getColumnIndex(ACCOUNT_ID))));
                td.setName((c.getString(c.getColumnIndex(ACCOUNT_NAME))));

                // adding to todo list
                accounts.add(td);
            } while (c.moveToNext());
        }

        return accounts;
    }

    public int updateAccounts(Accounts accounts) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ACCOUNT_NAME, accounts.getName());

        // updating row
        return db.update(TABLE_ACCOUNTS, values, ACCOUNT_ID + " = ?",
                new String[]{String.valueOf(accounts.getId())});
    }

    public void deleteAccounts(long account_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ACCOUNTS, ACCOUNT_ID + " = ?",
                new String[]{String.valueOf(account_id)});
    }








    private static final String TABLE_ADMIN = "admin";

    private static final String ADMIN_NAME = "admin name";

    private static final String ADMIN_PASSWORD = "admin password";

    private static final String CREATE_TABLE_ADMIN = "CREATE TABLE "
            + TABLE_ADMIN + "(" + ADMIN_NAME + "TEXT,"
            + ADMIN_PASSWORD + "TEXT" + ")";


    public String createAdmin(Admin admin) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ADMIN_NAME, admin.getUsername());
        values.put(ADMIN_PASSWORD, admin.getPassword());

        // insert row
        String admin_name = String.valueOf(db.insert(TABLE_ADMIN, null, values));

        return admin_name;
    }

    public Admin getAdmin(String admin_name) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_ADMIN + " WHERE "
                + ADMIN_NAME;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Admin td = new Admin();
        td.setUsername((c.getString(c.getColumnIndex(ADMIN_NAME))));
        td.setPassword(c.getString(c.getColumnIndex(ADMIN_PASSWORD)));

        return td;
    }

    public List<Admin> getAllAdmin() {
        List<Admin> admin = new ArrayList<Admin>();
        String selectQuery = "SELECT  * FROM " + TABLE_ADMIN;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Admin td = new Admin();
                td.setUsername((c.getString(c.getColumnIndex(ADMIN_NAME))));
                td.setPassword(c.getString(c.getColumnIndex(ADMIN_PASSWORD)));

                // adding to todo list
                admin.add(td);
            } while (c.moveToNext());
        }

        return admin;
    }

    public int updateAdmin(Admin admin) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ADMIN_NAME, admin.getUsername());
        // updating row
        return db.update(TABLE_ADMIN, values, ADMIN_NAME + " = ?",
                new String[]{String.valueOf(admin.getUsername())});
    }

    public void deleteAdmin(String admin_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ADMIN, ADMIN_NAME + " = ?",
                new String[]{String.valueOf(admin_name)});
    }









    private static final String TABLE_ORDERS = "orders";

    private static final String ORDER_ID = "order_id";

    private static final String ORDER_PRICE = "order_price";

    private static final String SUPPLIER_ID = "supplier_id";

    private static final String TRANS_ID = "trans_id";

    private static final String ORDER_STATUS = "order_status";


    private static final String CREATE_TABLE_ORDERS = "CREATE TABLE "
            + TABLE_ORDERS + "(" + ORDER_ID + " INTEGER PRIMARY KEY,"
            + ORDER_PRICE + " INTEGER, " + SUPPLIER_ID + "INTEGER PRIMARY KEY, "
            + TRANS_ID + "INTEGER PRIMARY KEY, " + ORDER_STATUS + "TEXT " + ")";


    public long createOrders(Orders orders) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ORDER_PRICE, orders.getOrder_price());
        values.put(ORDER_STATUS, orders.getOrder_status());

        // insert row
        long order_id = db.insert(TABLE_ORDERS, null, values);

        return order_id;
    }

    public Orders getOrders(long order_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_ORDERS + " WHERE "
                + ORDER_ID;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Orders td = new Orders();
        td.setOrder_price((c.getColumnIndex(ORDER_PRICE)));
        td.setOrder_status((c.getString(c.getColumnIndex(ORDER_STATUS))));

        return td;
    }


    public List<Orders> getAllOrders() {
        List<Orders> orders = new ArrayList<Orders>();
        String selectQuery = "SELECT  * FROM " + TABLE_ORDERS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Orders td = new Orders();
                td.setOrder_price((c.getColumnIndex(ORDER_PRICE)));
                td.setOrder_status(c.getString(c.getColumnIndex(ORDER_STATUS)));

                // adding to todo list
                orders.add(td);
            } while (c.moveToNext());
        }

        return orders;
    }

    public int updateOrders(Orders orders) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ORDER_PRICE, orders.getOrder_price());
        values.put(ORDER_STATUS, orders.getOrder_status());


        // updating row
        return db.update(TABLE_ORDERS, values, ORDER_ID + " = ?",
                new String[]{String.valueOf(orders.getOrder_id())});
    }

    public void deleteOrders(long order_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ORDERS, ORDER_ID + " = ?",
                new String[]{String.valueOf(order_id)});
    }


}
