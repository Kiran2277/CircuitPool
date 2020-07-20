package com.example.circuitpool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.circuitpool.helper.DatabaseHelper;
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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(getApplicationContext());


        Accounts a1 = new Accounts("a1");
        long id = db.createAccounts(a1);
        a1.setId(id);

        Toast.makeText(this, "from java " + a1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java " + a1.toString());

        Toast.makeText(this, "from db " + db.getAccounts(id).toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from db " + db.getAccounts(id).toString());

        a1.setName("a1new");
        db.updateAccounts(a1);

        Toast.makeText(this, "from java after update " + a1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java after update " + a1.toString());

        Toast.makeText(this, "from db after update " + db.getAccounts(id).toString(), Toast.LENGTH_LONG).show();
        Log.d("CircuitPool", "from db after update " + db.getAccounts(id).toString());


        Accounts a2 = new Accounts("a2");
        db.createAccounts(a2);
        Accounts a3 = new Accounts("a3");
        db.createAccounts(a3);
        Accounts a4 = new Accounts("a4");
        db.createAccounts(a4);

        List<Accounts> accounts = db.getAllAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            Toast.makeText(this, "before delete " + accounts.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "before delete " + accounts.get(i).toString());

        }

        db.deleteAccounts(a1.getId());

        List<Accounts> accountsList = db.getAllAccounts();
        for (int i = 0; i < accountsList.size(); i++) {
            Toast.makeText(this, "after delete " + accountsList.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "after delete " + accountsList.get(i).toString());

        }








        Admin admin1 = new Admin("admin1","00000");
        String username = db.createAdmin(admin1);
        admin1.setUsername(username);


        Toast.makeText(this, "from java " + admin1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java " + admin1.toString());

        Toast.makeText(this, "from db " + db.getAdmin(username).toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from db " + db.getAdmin(username).toString());

        admin1.setUsername("admin1new");
        db.updateAdmin(admin1);

        Toast.makeText(this, "from java after update " + admin1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java after update " + admin1.toString());

        Toast.makeText(this, "from db after update " + db.getAdmin(username).toString(), Toast.LENGTH_LONG).show();
        Log.d("CircuitPool", "from db after update " + db.getAdmin(username).toString());


        Admin admin2 = new Admin("admin2","00000");
        db.createAdmin(admin2);
        Admin admin3 = new Admin("admin3","55555");
        db.createAdmin(admin3);
        Admin admin4 = new Admin("admin4","45623");
        db.createAdmin(admin4);


        List<Admin> admins = db.getAllAdmin();
        for (int i = 0; i < admins.size(); i++) {
            Toast.makeText(this, "before delete " + accounts.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "before delete " + accounts.get(i).toString());

        }

        db.deleteAdmin(admin1.getUsername());

        List<Admin> adminList = db.getAllAdmin();
        for (int i = 0; i < adminList.size(); i++) {
            Toast.makeText(this, "after delete " + adminList.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "after delete " + adminList.get(i).toString());

        }









        Orders orders1 = new Orders(1,500,11,100000,"new");
        long order_id = db.createOrders(orders1);
        orders1.setOrder_id(order_id);

        Toast.makeText(this, "from java " + orders1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java " + orders1.toString());

        Toast.makeText(this, "from db " + db.getOrders(order_id).toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from db " + db.getOrders(order_id).toString());


        db.updateOrders(orders1);

        Toast.makeText(this, "from java after update " + orders1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java after update " + orders1.toString());

        Toast.makeText(this, "from db after update " + db.getOrders(order_id).toString(), Toast.LENGTH_LONG).show();
        Log.d("CircuitPool", "from db after update " + db.getOrders(order_id).toString());


        Orders orders2 = new Orders(2,500,456,8520,"asd");
        db.createOrders(orders2);
        Orders orders3 = new Orders(3,500,8520,74523,"fghjk");
        db.createOrders(orders3);
        Orders orders4 = new Orders(4,500,965210,7528520,"zxcv");
        db.createOrders(orders4);


        List<Orders> orders = db.getAllOrders();
        for (int i = 0; i < orders.size(); i++) {
            Toast.makeText(this, "before delete " + orders.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "before delete " + orders.get(i).toString());

        }

        db.deleteOrders(orders1.getOrder_id());

        List<Orders> ordersList = db.getAllOrders();
        for (int i = 0; i < ordersList.size(); i++) {
            Toast.makeText(this, "after delete " + ordersList.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "after delete " + ordersList.get(i).toString());

        }











        Items items1 = new Items(01,02,10,100);
        long item_id = db.createItems(items1);
        items1.setItem_id(item_id);

        Toast.makeText(this, "from java " + items1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java " + items1.toString());

        Toast.makeText(this, "from db " + db.getItems(item_id).toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from db " + db.getItems(item_id).toString());


        db.updateItems(items1);

        Toast.makeText(this, "from java after update " + items1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java after update " + items1.toString());

        Toast.makeText(this, "from db after update " + db.getItems(item_id).toString(), Toast.LENGTH_LONG).show();
        Log.d("CircuitPool", "from db after update " + db.getItems(item_id).toString());


        Items items2 = new Items(02,03,8,400);
        db.createItems(items2);
        Items items3 = new Items(03,05,5,400);
        db.createItems(items3);
        Items items4 = new Items(04,05,7,600);
        db.createItems(items4);


        List<Items> items = db.getAllItems();
        for (int i = 0; i < items.size(); i++) {
            Toast.makeText(this, "before delete " + items.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "before delete " + items.get(i).toString());

        }

        db.deleteItems(items1.getItem_id());

        List<Items> itemsList = db.getAllItems();
        for (int i = 0; i < itemsList.size(); i++) {
            Toast.makeText(this, "after delete " + itemsList.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "after delete " + itemsList.get(i).toString());

        }










        Products products1 = new Products(022,50,05,"new1");
        long product_id = db.createProducts(products1);
        products1.setProduct_id(product_id);

        Toast.makeText(this, "from java " + products1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java " + products1.toString());

        Toast.makeText(this, "from db " + db.getProducts(product_id).toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from db " + db.getProducts(product_id).toString());

        products1.setProduct_name("new_product");
        db.updateProducts(products1);

        Toast.makeText(this, "from java after update " + products1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java after update " + products1.toString());

        Toast.makeText(this, "from db after update " + db.getProducts(product_id).toString(), Toast.LENGTH_LONG).show();
        Log.d("CircuitPool", "from db after update " + db.getProducts(product_id).toString());


        Products products2 = new Products(55,100,05,"new23");
        db.createProducts(products2);
        Products products3 = new Products(88,200,05,"new34");
        db.createProducts(products3);
        Products products4 = new Products(587,300,02,"new3456");
        db.createProducts(products4);


        List<Products> products = db.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            Toast.makeText(this, "before delete " +  products.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "before delete " + products.get(i).toString());

        }

        db.deleteProducts(products1.getProduct_id());

        List<Products> productsList = db.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            Toast.makeText(this, "after delete " + productsList.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "after delete " + productsList.get(i).toString());

        }










        Raw_Materials raw_materials1 = new Raw_Materials(0012,50,100,02,"new52");
        long material_id = db.createRAW_Materials(raw_materials1);
        raw_materials1.setMaterial_id(material_id);

        Toast.makeText(this, "from java " + raw_materials1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java " + raw_materials1.toString());

        Toast.makeText(this, "from db " + db.getRaw_Materials(material_id).toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from db " + db.getRaw_Materials(material_id).toString());

        raw_materials1.setMaterial_name("new_material");
        db.updateRaw_Materials(raw_materials1);

        Toast.makeText(this, "from java after update " + raw_materials1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java after update " + raw_materials1.toString());

        Toast.makeText(this, "from db after update " + db.getRaw_Materials(material_id).toString(), Toast.LENGTH_LONG).show();
        Log.d("CircuitPool", "from db after update " + db.getRaw_Materials(material_id).toString());


        Raw_Materials raw_materials2 = new Raw_Materials(01,5204,741,01,"new12345");
        db.createRAW_Materials(raw_materials2);
        Raw_Materials raw_materials3 = new Raw_Materials(02,852,963,02,"new234567");
        db.createRAW_Materials(raw_materials3);
        Raw_Materials raw_materials4 = new Raw_Materials(03,8520,456,3,"new7890");
        db.createRAW_Materials(raw_materials4);


        List<Raw_Materials> raw_materials = db.getAllRaw_Materials();
        for (int i = 0; i < raw_materials.size(); i++) {
            Toast.makeText(this, "before delete " +  raw_materials.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "before delete " + raw_materials.get(i).toString());

        }

        db.deleteRaw_Matertials(raw_materials1.getMaterial_id());

        List<Raw_Materials> raw_materialsList = db.getAllRaw_Materials();
        for (int i = 0; i < raw_materials.size(); i++) {
            Toast.makeText(this, "after delete " + raw_materialsList.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "after delete " + raw_materialsList.get(i).toString());

        }









        Shop_Owners shop_owners1 = new Shop_Owners(120,"abcd","0000");
        long shop_id = db.createShop_Owners(shop_owners1);
        shop_owners1.setShop_id(shop_id);

        Toast.makeText(this, "from java " + shop_owners1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java " + shop_owners1.toString());

        Toast.makeText(this, "from db " + db.getShop_Owners(shop_id).toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from db " + db.getShop_Owners(shop_id).toString());

        shop_owners1.setShop_name("sdfg");
        db.updateShop_Owners(shop_owners1);

        Toast.makeText(this, "from java after update " + shop_owners1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java after update " + shop_owners1.toString());

        Toast.makeText(this, "from db after update " + db.getShop_Owners(shop_id).toString(), Toast.LENGTH_LONG).show();
        Log.d("CircuitPool", "from db after update " + db.getShop_Owners(shop_id).toString());


        Shop_Owners shop_owners2 = new Shop_Owners(21,"new7890","78963");
        db.createShop_Owners(shop_owners2);
        Shop_Owners shop_owners3 = new Shop_Owners(22,"new78780","78963");
        db.createShop_Owners(shop_owners3);
        Shop_Owners shop_owners4 = new Shop_Owners(26,"new5690","78963");
        db.createShop_Owners(shop_owners4);


        List<Shop_Owners> shop_owners = db.getAllShop_Owners();
        for (int i = 0; i < shop_owners.size(); i++) {
            Toast.makeText(this, "before delete " +  shop_owners.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "before delete " + shop_owners.get(i).toString());

        }

        db.deleteShop_Owners(shop_owners1.getShop_id());

        List<Shop_Owners> shop_ownersList = db.getAllShop_Owners();
        for (int i = 0; i < shop_owners.size(); i++) {
            Toast.makeText(this, "after delete " + shop_ownersList.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "after delete " + shop_ownersList.get(i).toString());

        }















        Staffs staffs1 = new Staffs(1254,"qwerty","qwe123");
        long staff_id = db.createStaffs(staffs1);
        staffs1.setStaff_id(staff_id);

        Toast.makeText(this, "from java " + staffs1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java " + staffs1.toString());

        Toast.makeText(this, "from db " + db.getStaffs(staff_id).toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from db " + db.getStaffs(staff_id).toString());

        staffs1.setStaff_name("qwe789");
        db.updateStaffs(staffs1);

        Toast.makeText(this, "from java after update " + staffs1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java after update " + staffs1.toString());

        Toast.makeText(this, "from db after update " + db.getStaffs(staff_id).toString(), Toast.LENGTH_LONG).show();
        Log.d("CircuitPool", "from db after update " + db.getStaffs(staff_id).toString());


        Staffs staffs2 = new Staffs(03,"asdf123","asd8520");
        db.createStaffs(staffs2);
        Staffs staffs3 = new Staffs(05,"axcv123","acvbn820");
        db.createStaffs(staffs3);
        Staffs staffs4 = new Staffs(73,"aertyu123","ahjk780");
        db.createStaffs(staffs4);


        List<Staffs> staffs = db.getAllStaffs();
        for (int i = 0; i < staffs.size(); i++) {
            Toast.makeText(this, "before delete " +  staffs.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "before delete " + staffs.get(i).toString());

        }

        db.deleteStaffs(staffs1.getStaff_id());

        List<Staffs> staffsList = db.getAllStaffs();
        for (int i = 0; i < staffs.size(); i++) {
            Toast.makeText(this, "after delete " + staffsList.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "after delete " + staffsList.get(i).toString());

        }











        Suppliers suppliers1 = new Suppliers(1254,"qwerty",1230);
        long supplier_id = db.createSuppliers(suppliers1);
        suppliers1.setSupplier_id(supplier_id);

        Toast.makeText(this, "from java " + suppliers1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java " + suppliers1.toString());

        Toast.makeText(this, "from db " + db.getSuppliers(supplier_id).toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from db " + db.getSuppliers(supplier_id).toString());

        suppliers1.setSupplier_name("qwe789");
        db.updateSuppliers(suppliers1);

        Toast.makeText(this, "from java after update " + suppliers1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java after update " + suppliers1.toString());

        Toast.makeText(this, "from db after update " + db.getSuppliers(supplier_id).toString(), Toast.LENGTH_LONG).show();
        Log.d("CircuitPool", "from db after update " + db.getSuppliers(supplier_id).toString());


        Suppliers suppliers2 = new Suppliers(07,"asghj23",79652);
        db.createSuppliers(suppliers2);
        Suppliers suppliers3 = new Suppliers(04,"asert23",79652);
        db.createSuppliers(suppliers3);
        Suppliers suppliers4 = new Suppliers(07,"aswerty23",79652);
        db.createSuppliers(suppliers4);


        List<Suppliers> suppliers = db.getAllSuppliers();
        for (int i = 0; i < suppliers.size(); i++) {
            Toast.makeText(this, "before delete " +  suppliers.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "before delete " + suppliers.get(i).toString());

        }

        db.deleteSuppliers(suppliers1.getSupplier_id());

        List<Suppliers> suppliersList = db.getAllSuppliers();
        for (int i = 0; i < suppliers.size(); i++) {
            Toast.makeText(this, "after delete " + suppliersList.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "after delete " + suppliersList.get(i).toString());

        }













        Transactions transactions1 = new Transactions(014,7896,852,7410,"asdfg",7456321,321456);
        long trans_id = db.createTransactions(transactions1);
        transactions1.setTrans_id(trans_id);

        Toast.makeText(this, "from java " + transactions1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java " + transactions1.toString());

        Toast.makeText(this, "from db " + db.getTransactions(trans_id).toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from db " + db.getTransactions(trans_id).toString());


        db.updateTransactions(transactions1);

        Toast.makeText(this, "from java after update " + transactions1.toString(), Toast.LENGTH_LONG).show();

        Log.d("CircuitPool", "from java after update " + transactions1.toString());

        Toast.makeText(this, "from db after update " + db.getTransactions(trans_id).toString(), Toast.LENGTH_LONG).show();
        Log.d("CircuitPool", "from db after update " + db.getTransactions(trans_id).toString());


        Transactions transactions2 = new Transactions(014,789654,654123,4560,"qwerty",321456,741258);
        db.createTransactions(transactions2);
        Transactions transactions3 = new Transactions(023,789654,654123,4560,"qwerty",321456,741258);
        db.createTransactions(transactions3);
        Transactions transactions4 = new Transactions(017,789654,654123,4560,"qwerty",321456,741258);
        db.createTransactions(transactions4);


        List<Transactions> transactions = db.getAllTransactions();
        for (int i = 0; i < transactions.size(); i++) {
            Toast.makeText(this, "before delete " +  transactions.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "before delete " + transactions.get(i).toString());

        }

        db.deleteTransactions(transactions1.getTrans_id());

        List<Transactions> transactionsList = db.getAllTransactions();
        for (int i = 0; i < transactions.size(); i++) {
            Toast.makeText(this, "after delete " + transactionsList.get(i).toString(), Toast.LENGTH_LONG).show();
            Log.d("CircuitPool", "after delete " + transactionsList.get(i).toString());

        }



    }
}
