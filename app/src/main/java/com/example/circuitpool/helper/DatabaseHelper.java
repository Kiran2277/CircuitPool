package com.example.circuitpool.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.circuitpool.model.Accounts;
import com.example.circuitpool.model.Admin;
import com.example.circuitpool.model.Items;
import com.example.circuitpool.model.Orders;
import com.example.circuitpool.model.Products;
import com.example.circuitpool.model.Raw_Materials;
import com.example.circuitpool.model.Shop_Owners;
import com.example.circuitpool.model.Staffs;
import com.example.circuitpool.model.Suppliers;
import com.example.circuitpool.model.Transactions;

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
        db.execSQL(CREATE_TABLE_ITEMS);
        db.execSQL(CREATE_TABLE_PRODUCTS);
        db.execSQL(CREATE_TABLE_MATERIALS);
        db.execSQL(CREATE_TABLE_SHOP_OWNERS);
        db.execSQL(CREATE_TABLE_STAFFS);
        db.execSQL(CREATE_TABLE_SUPPLIERS);
        db.execSQL(CREATE_TABLE_TRANSACTIONS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_ADMIN);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_ORDERS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_ITEMS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_MATERIALS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_SHOP_OWNERS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_STAFFS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_SUPPLIERS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_TRANSTACIONS);

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

        Accounts at = new Accounts();
        at.setId(c.getLong(c.getColumnIndex(ACCOUNT_ID)));
        at.setName((c.getString(c.getColumnIndex(ACCOUNT_NAME))));

        return at;
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
                Accounts at = new Accounts();
                at.setId(c.getLong((c.getColumnIndex(ACCOUNT_ID))));
                at.setName((c.getString(c.getColumnIndex(ACCOUNT_NAME))));


                accounts.add(at);
            } while (c.moveToNext());
        }

        return accounts;
    }

    public long updateAccounts(Accounts accounts) {
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

        Admin ad = new Admin();
        ad.setUsername((c.getString(c.getColumnIndex(ADMIN_NAME))));
        ad.setPassword(c.getString(c.getColumnIndex(ADMIN_PASSWORD)));

        return ad;
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
                Admin ad = new Admin();
                ad.setUsername((c.getString(c.getColumnIndex(ADMIN_NAME))));
                ad.setPassword(c.getString(c.getColumnIndex(ADMIN_PASSWORD)));


                admin.add(ad);
            } while (c.moveToNext());
        }

        return admin;
    }

    public String updateAdmin(Admin admin) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ADMIN_NAME, admin.getUsername());
        // updating row
        return String.valueOf(db.update(TABLE_ADMIN, values, ADMIN_NAME + " = ?",
                new String[]{String.valueOf(admin.getUsername())}));
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
            + ORDER_PRICE + " INTEGER, " + SUPPLIER_ID + "INTEGER, "
            + TRANS_ID + "INTEGER, " + ORDER_STATUS + "TEXT " + ")";


    public long createOrders(Orders orders) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ORDER_PRICE, orders.getOrder_price());
        values.put(ORDER_STATUS, orders.getOrder_status());
        values.put(SUPPLIER_ID, orders.getSupplier_id());
        values.put(TRANS_ID, orders.getTrans_id());

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

        Orders od = new Orders();
        od.setOrder_status((c.getString(c.getColumnIndex(ORDER_STATUS))));
        od.setOrder_price(c.getLong(c.getColumnIndex(ORDER_PRICE)));
        od.setSupplier_id((c.getLong(c.getColumnIndex(SUPPLIER_ID))));
        od.setTrans_id(c.getLong((c.getColumnIndex(TRANS_ID))));


        return od;
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
                Orders od = new Orders();
                od.setOrder_status((c.getString(c.getColumnIndex(ORDER_STATUS))));
                od.setOrder_price(c.getLong(c.getColumnIndex(ORDER_PRICE)));
                od.setSupplier_id((c.getLong(c.getColumnIndex(SUPPLIER_ID))));
                od.setTrans_id(c.getLong((c.getColumnIndex(TRANS_ID))));


                orders.add(od);
            } while (c.moveToNext());
        }

        return orders;
    }

    public long updateOrders(Orders orders) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ORDER_PRICE, orders.getOrder_price());
        values.put(ORDER_STATUS, orders.getOrder_status());
        values.put(SUPPLIER_ID, orders.getSupplier_id());
        values.put(TRANS_ID, orders.getTrans_id());


        // updating row
        return db.update(TABLE_ORDERS, values, ORDER_ID + " = ?",
                new String[]{String.valueOf(orders.getOrder_id())});
    }

    public void deleteOrders(long order_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ORDERS, ORDER_ID + " = ?",
                new String[]{String.valueOf(order_id)});
    }












    private static final String TABLE_ITEMS = "items";

    private static final String ITEM_ID = "item_id";

    private static final String ITEM_QTY = "item_qty";

    private static final String ITEM_RATE = "item_rate";


    private static final String CREATE_TABLE_ITEMS = "CREATE TABLE "
            + TABLE_ITEMS + "(" + ITEM_ID + " INTEGER PRIMARY KEY,"
            + ORDER_ID + " INTEGER, " + ITEM_QTY + "INTEGER, "
            + ITEM_RATE+ "INTEGER " + ")";


    public long createItems(Items items) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ORDER_ID, items.getOrder_id());
        values.put(ITEM_QTY, items.getItem_qty());
        values.put(ITEM_RATE, items.getItem_rate());

        // insert row
        long item_id = db.insert(TABLE_ORDERS, null, values);

        return item_id;

    }


    public Items getItems(long item_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_ITEMS + " WHERE "
                + ITEM_ID;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Items it = new Items();
        it.setOrder_id(c.getLong(c.getColumnIndex(ORDER_ID)));
        it.setItem_qty((c.getLong(c.getColumnIndex(ITEM_QTY))));
        it.setItem_rate(c.getLong((c.getColumnIndex(ITEM_RATE))));

        return it;
    }


    public List<Items> getAllItems() {
        List<Items> items = new ArrayList<Items>();
        String selectQuery = "SELECT  * FROM " + TABLE_ITEMS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Items it = new Items();
                it.setOrder_id(c.getColumnIndex(ORDER_ID));
                it.setItem_qty(c.getColumnIndex(ITEM_QTY));
                it.setItem_rate(c.getColumnIndex(ITEM_RATE));



                items.add(it);
            } while (c.moveToNext());
        }

        return items;
    }


    public long updateItems(Items items) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ORDER_ID, items.getOrder_id());
        values.put(ITEM_QTY, items.getItem_qty());
        values.put(ITEM_RATE, items.getItem_rate());


        // updating row
        return db.update(TABLE_ITEMS, values, ITEM_ID + " = ?",
                new String[]{String.valueOf(items.getItem_id())});
    }

    public void deleteItems(long item_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, ITEM_ID + " = ?",
                new String[]{String.valueOf(item_id)});
    }














    private static final String TABLE_PRODUCTS = "items";

    private static final String PRODUCT_ID = "product_id";

    private static final String PRODUCT_CURRENT_STOCK = "current_stock";

    private static final String PRODUCT_MINIMUM_STOCK = "minimum_stock";

    private static final String PRODUCT_NAME = "product_name";


    private static final String CREATE_TABLE_PRODUCTS = "CREATE TABLE "
            + TABLE_PRODUCTS + "(" + PRODUCT_ID + " INTEGER PRIMARY KEY,"
            + PRODUCT_CURRENT_STOCK + " INTEGER, " + PRODUCT_MINIMUM_STOCK + "INTEGER, "
            + PRODUCT_NAME + "TEXT " + ")";


    public long createProducts(Products products) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PRODUCT_NAME, products.getProduct_name());
        values.put(PRODUCT_CURRENT_STOCK, products.getCurrent_stock());
        values.put(PRODUCT_MINIMUM_STOCK, products.getMinimum_stock());


        // insert row
        long product_id = db.insert(TABLE_ACCOUNTS, null, values);

        return product_id;
    }


    public Products getProducts(long product_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_ACCOUNTS + " WHERE "
                + ACCOUNT_ID + " = " + product_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Products pd = new Products();
        pd.setProduct_id(c.getLong(c.getColumnIndex(PRODUCT_ID)));
        pd.setProduct_name((c.getString(c.getColumnIndex(PRODUCT_NAME))));
        pd.setMinimum_stock(c.getLong(c.getColumnIndex(PRODUCT_MINIMUM_STOCK)));
        pd.setCurrent_stock(c.getLong(c.getColumnIndex(PRODUCT_CURRENT_STOCK)));

        return pd;

    }


    public List<Products> getAllProducts() {
        List<Products> products = new ArrayList<Products>();
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Products pd = new Products();
                pd.setProduct_id(c.getLong(c.getColumnIndex(PRODUCT_ID)));
                pd.setProduct_name((c.getString(c.getColumnIndex(PRODUCT_NAME))));
                pd.setMinimum_stock(c.getLong(c.getColumnIndex(PRODUCT_MINIMUM_STOCK)));
                pd.setCurrent_stock(c.getLong(c.getColumnIndex(PRODUCT_CURRENT_STOCK)));


                products.add(pd);
            } while (c.moveToNext());
        }

        return products;

    }


    public long updateProducts(Products products) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PRODUCT_NAME, products.getProduct_name());
        values.put(PRODUCT_CURRENT_STOCK, products.getCurrent_stock());
        values.put(PRODUCT_MINIMUM_STOCK, products.getMinimum_stock());

        // updating row
        return db.update(TABLE_PRODUCTS, values, PRODUCT_ID + " = ?",
                new String[]{String.valueOf(products.getProduct_id())});
    }

    public void deleteProducts(long product_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCTS, PRODUCT_ID + " = ?",
                new String[]{String.valueOf(product_id)});
    }














    private static final String TABLE_MATERIALS = "raw_materials";

    private static final String MATERIAL_ID = "product_id";

    private static final String MATERIAL_MEASURE = "current_stock";

    private static final String MATERIAL_MINIMUM_STOCK = "minimum_stock";

    private static final String MATERIAL_CURRENT_STOCK = "minimum_stock";

    private static final String MATERIAL_NAME = "product_name";



    private static final String CREATE_TABLE_MATERIALS = "CREATE TABLE "
            + TABLE_MATERIALS + "(" + MATERIAL_ID + " INTEGER PRIMARY KEY,"
            + MATERIAL_CURRENT_STOCK + " INTEGER, " + MATERIAL_MINIMUM_STOCK + "INTEGER, "
            + MATERIAL_NAME + "TEXT, " + MATERIAL_MEASURE + "INTEGER " + ")";


    public long createRAW_Materials(Raw_Materials raw_materials) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MATERIAL_NAME, raw_materials.getMaterial_name());
        values.put(MATERIAL_CURRENT_STOCK, raw_materials.getCurrent_stock());
        values.put(MATERIAL_MINIMUM_STOCK, raw_materials.getMinimum_stock());
        values.put(MATERIAL_MEASURE, raw_materials.getMaterial_measure());



        // insert row
        long material_id = db.insert(TABLE_MATERIALS, null, values);

        return material_id;
    }


    public Raw_Materials getRaw_Materials(long material_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_MATERIALS + " WHERE "
                + MATERIAL_ID + " = " + material_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Raw_Materials rm = new Raw_Materials();
        rm.setMaterial_measure(c.getLong(c.getColumnIndex(MATERIAL_MEASURE)));
        rm.setCurrent_stock((c.getLong(c.getColumnIndex(MATERIAL_CURRENT_STOCK))));
        rm.setMinimum_stock(c.getLong(c.getColumnIndex(MATERIAL_MINIMUM_STOCK)));
        rm.setMaterial_name(c.getString(c.getColumnIndex(MATERIAL_NAME)));

        return rm;

    }


    public List<Raw_Materials> getAllRaw_Materials() {
        List<Raw_Materials> raw_materials = new ArrayList<Raw_Materials>();
        String selectQuery = "SELECT  * FROM " + TABLE_MATERIALS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Raw_Materials rm = new Raw_Materials();
                rm.setMaterial_measure(c.getLong(c.getColumnIndex(MATERIAL_MEASURE)));
                rm.setCurrent_stock((c.getLong(c.getColumnIndex(MATERIAL_CURRENT_STOCK))));
                rm.setMinimum_stock(c.getLong(c.getColumnIndex(MATERIAL_MINIMUM_STOCK)));
                rm.setMaterial_name(c.getString(c.getColumnIndex(MATERIAL_NAME)));


                raw_materials.add(rm);
            } while (c.moveToNext());
        }

        return raw_materials;

    }


    public long updateRaw_Materials(Raw_Materials raw_materials) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MATERIAL_NAME, raw_materials.getMaterial_name());
        values.put(MATERIAL_CURRENT_STOCK, raw_materials.getCurrent_stock());
        values.put(MATERIAL_MINIMUM_STOCK, raw_materials.getMinimum_stock());
        values.put(MATERIAL_MEASURE, raw_materials.getMaterial_measure());

        // updating row
        return db.update(TABLE_MATERIALS, values, MATERIAL_ID + " = ?",
                new String[]{String.valueOf(raw_materials.getMaterial_id())});
    }

    public void deleteRaw_Matertials(long material_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MATERIALS, MATERIAL_ID + " = ?",
                new String[]{String.valueOf(material_id)});
    }












    private static final String TABLE_SHOP_OWNERS = "shop_owners";

    private static final String SHOP_ID = "shop_id";

    private static final String SHOP_NAME = "shop_name";

    private static final String SHOP_PASSWORD = "shop_password";



    private static final String CREATE_TABLE_SHOP_OWNERS = "CREATE TABLE "
            + TABLE_SHOP_OWNERS + "(" + SHOP_ID + " INTEGER PRIMARY KEY,"
            + SHOP_NAME + " TEXT, " + SHOP_PASSWORD + "TEXT "
            + ")";


    public long createShop_Owners(Shop_Owners shop_owners) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SHOP_NAME, shop_owners.getShop_name());
        values.put(SHOP_PASSWORD, shop_owners.getShop_password());


        // insert row
        long shop_id = db.insert(TABLE_SHOP_OWNERS, null, values);

        return shop_id;
    }


    public Shop_Owners getShop_Owners(long shop_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_SHOP_OWNERS + " WHERE "
                + SHOP_ID + " = " + shop_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Shop_Owners so = new Shop_Owners();
        so.setShop_name(c.getString(c.getColumnIndex(SHOP_NAME)));
        so.setShop_password((c.getString(c.getColumnIndex(SHOP_PASSWORD))));

        return so;

    }


    public List<Shop_Owners> getAllShop_Owners() {
        List<Shop_Owners> shop_owners = new ArrayList<Shop_Owners>();
        String selectQuery = "SELECT  * FROM " + TABLE_SHOP_OWNERS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Shop_Owners so = new Shop_Owners();
                so.setShop_name(c.getString(c.getColumnIndex(SHOP_NAME)));
                so.setShop_password((c.getString(c.getColumnIndex(SHOP_PASSWORD))));


                shop_owners.add(so);
            } while (c.moveToNext());
        }

        return shop_owners;

    }


    public long updateShop_Owners(Shop_Owners shop_owners) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SHOP_NAME, shop_owners.getShop_name());
        values.put(SHOP_PASSWORD, shop_owners.getShop_password());

        // updating row
        return db.update(TABLE_SHOP_OWNERS, values, SHOP_ID + " = ?",
                new String[]{String.valueOf(shop_owners.getShop_id())});
    }

    public void deleteShop_Owners(long shop_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SHOP_OWNERS, SHOP_ID + " = ?",
                new String[]{String.valueOf(SHOP_ID)});
    }













    private static final String TABLE_STAFFS = "shop_owners";

    private static final String STAFF_ID = "shop_id";

    private static final String STAFF_NAME = "shop_name";

    private static final String STAFF_PASSWORD = "shop_password";



    private static final String CREATE_TABLE_STAFFS = "CREATE TABLE "
            + TABLE_STAFFS + "(" + STAFF_ID + " INTEGER PRIMARY KEY,"
            + STAFF_NAME + " TEXT, " + STAFF_PASSWORD + "TEXT "
            + ")";


    public long createStaffs(Staffs staffs) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(STAFF_NAME, staffs.getStaff_name());
        values.put(STAFF_PASSWORD, staffs.getStaff_password());


        // insert row
        long staff_id = db.insert(TABLE_STAFFS, null, values);

        return staff_id;
    }


    public Staffs getStaffs(long staff_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_STAFFS + " WHERE "
                + STAFF_ID + " = " + staff_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Staffs st = new Staffs();
        st.setStaff_name(c.getString(c.getColumnIndex(STAFF_NAME)));
        st.setStaff_password((c.getString(c.getColumnIndex(STAFF_PASSWORD))));

        return st;

    }


    public List<Staffs> getAllStaffs() {
        List<Staffs> staffs = new ArrayList<Staffs>();
        String selectQuery = "SELECT  * FROM " + TABLE_STAFFS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Staffs st = new Staffs();
                st.setStaff_name(c.getString(c.getColumnIndex(STAFF_NAME)));
                st.setStaff_password((c.getString(c.getColumnIndex(STAFF_PASSWORD))));


                staffs.add(st);
            } while (c.moveToNext());
        }

        return staffs;

    }


    public long updateStaffs(Staffs staffs) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(STAFF_NAME, staffs.getStaff_name());
        values.put(STAFF_PASSWORD, staffs.getStaff_password());

        // updating row
        return db.update(TABLE_STAFFS, values, STAFF_ID + " = ?",
                new String[]{String.valueOf(staffs.getStaff_id())});
    }

    public void deleteStaffs(long staff_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STAFFS, STAFF_ID + " = ?",
                new String[]{String.valueOf(STAFF_ID)});
    }













    private static final String TABLE_SUPPLIERS = "suppliers";

    private static final String SUPPLIER_NAME = "supplier_name";


    private static final String CREATE_TABLE_SUPPLIERS = "CREATE TABLE "
            + TABLE_SUPPLIERS + "(" + SUPPLIER_ID + " INTEGER PRIMARY KEY,"
            + SUPPLIER_NAME + " TEXT, " + ACCOUNT_ID + "INTEGER "
            + ")";


    public long createSuppliers(Suppliers suppliers) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUPPLIER_NAME, suppliers.getSupplier_name());
        values.put(ACCOUNT_ID, suppliers.getAccount_id());


        // insert row
        long supplier_id = db.insert(TABLE_SUPPLIERS, null, values);

        return supplier_id;
    }


    public Suppliers getSuppliers(long supplier_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_SUPPLIERS + " WHERE "
                + SUPPLIER_ID + " = " + supplier_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Suppliers su = new Suppliers();
        su.setSupplier_name(c.getString(c.getColumnIndex(SUPPLIER_NAME)));
        su.setAccount_id((c.getLong(c.getColumnIndex(ACCOUNT_ID))));

        return su;

    }


    public List<Suppliers> getAllSuppliers() {
        List<Suppliers> suppliers = new ArrayList<Suppliers>();
        String selectQuery = "SELECT  * FROM " + TABLE_SUPPLIERS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Suppliers su = new Suppliers();
                su.setSupplier_name(c.getString(c.getColumnIndex(SUPPLIER_NAME)));
                su.setAccount_id((c.getLong(c.getColumnIndex(ACCOUNT_ID))));


                suppliers.add(su);
            } while (c.moveToNext());
        }

        return suppliers;

    }


    public long updateSuppliers(Suppliers suppliers) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUPPLIER_NAME, suppliers.getSupplier_name());
        values.put(ACCOUNT_ID, suppliers.getAccount_id());

        // updating row
        return db.update(TABLE_SUPPLIERS, values, SUPPLIER_ID + " = ?",
                new String[]{String.valueOf(suppliers.getSupplier_id())});
    }

    public void deleteSuppliers(long supplier_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SUPPLIERS, SUPPLIER_ID + " = ?",
                new String[]{String.valueOf(SUPPLIER_ID)});
    }













    private static final String TABLE_TRANSTACIONS = "transactions";

    private static final String TRANS_PARTICLE = "trans_particle";

    private static final String TRANS_CREDIT = "trans_credit";

    private static final String TRANS_DEBIT = "trans_debit";

    private static final String TRANS_BALANCE = "trans_balance";

    private static final String TRANS_FROM_ACCOUNT_ID = "trans_from_account_id";

    private static final String TRANS_TO_ACCOUNT_ID = "trams_to_account_id";



    private static final String CREATE_TABLE_TRANSACTIONS = "CREATE TABLE "
            + TABLE_TRANSTACIONS + "(" + TRANS_ID + " INTEGER PRIMARY KEY,"
            + TRANS_PARTICLE + " TEXT, " + TRANS_CREDIT + "INTEGER, "
            + TRANS_DEBIT + "INTEGER, " + TRANS_BALANCE + "INTEGER, "
            + TRANS_FROM_ACCOUNT_ID + "INTEGER, " + TRANS_TO_ACCOUNT_ID
            + "INTEGER " + ")";


    public long createTransactions(Transactions transactions) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TRANS_PARTICLE, transactions.getTrans_particle());
        values.put(TRANS_FROM_ACCOUNT_ID, transactions.getFrom_account_id());
        values.put(TRANS_TO_ACCOUNT_ID, transactions.getTo_account_id());
        values.put(TRANS_DEBIT, transactions.getTrans_debit());
        values.put(TRANS_CREDIT, transactions.getTrans_credit() );
        values.put(TRANS_BALANCE, transactions.getTrans_balance());



        // insert row
        long trans_id = db.insert(TABLE_TRANSTACIONS, null, values);

        return trans_id;
    }


    public Transactions getTransactions(long trans_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_TRANSTACIONS + " WHERE "
                + TRANS_ID + " = " + trans_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Transactions ts = new Transactions();
        ts.setTrans_particle(c.getString(c.getColumnIndex(TRANS_PARTICLE)));
        ts.setTrans_debit((c.getLong(c.getColumnIndex(TRANS_DEBIT))));
        ts.setTrans_credit((c.getLong(c.getColumnIndex(TRANS_CREDIT))));
        ts.setTrans_balance((c.getLong(c.getColumnIndex(TRANS_BALANCE))));
        ts.setFrom_account_id((c.getLong(c.getColumnIndex(TRANS_FROM_ACCOUNT_ID))));
        ts.setTo_account_id((c.getLong(c.getColumnIndex(TRANS_TO_ACCOUNT_ID))));


        return ts;

    }


    public List<Transactions> getAllTransactions() {
        List<Transactions> transactions = new ArrayList<Transactions>();
        String selectQuery = "SELECT  * FROM " + TABLE_TRANSTACIONS;

        Log.e(LOG, selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Transactions ts = new Transactions();
                ts.setTrans_particle(c.getString(c.getColumnIndex(TRANS_PARTICLE)));
                ts.setTrans_debit((c.getLong(c.getColumnIndex(TRANS_DEBIT))));
                ts.setTrans_credit((c.getLong(c.getColumnIndex(TRANS_CREDIT))));
                ts.setTrans_balance((c.getLong(c.getColumnIndex(TRANS_BALANCE))));
                ts.setFrom_account_id((c.getLong(c.getColumnIndex(TRANS_FROM_ACCOUNT_ID))));
                ts.setTo_account_id((c.getLong(c.getColumnIndex(TRANS_TO_ACCOUNT_ID))));


                transactions.add(ts);
            } while (c.moveToNext());
        }

        return transactions;

    }


    public long updateTransactions(Transactions transactions) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TRANS_PARTICLE, transactions.getTrans_particle());
        values.put(TRANS_FROM_ACCOUNT_ID, transactions.getFrom_account_id());
        values.put(TRANS_TO_ACCOUNT_ID, transactions.getTo_account_id());
        values.put(TRANS_DEBIT, transactions.getTrans_debit());
        values.put(TRANS_CREDIT, transactions.getTrans_credit() );
        values.put(TRANS_BALANCE, transactions.getTrans_balance());

        // updating row
        return db.update(TABLE_TRANSTACIONS, values, TRANS_ID + " = ?",
                new String[]{String.valueOf(transactions.getTrans_id())});
    }

    public void deleteTransactions(long trans_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TRANSTACIONS, TRANS_ID + " = ?",
                new String[]{String.valueOf(TRANS_ID)});
    }






}
