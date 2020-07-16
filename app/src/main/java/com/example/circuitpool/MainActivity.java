package com.example.circuitpool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.circuitpool.helper.DatabaseHelper;
import com.example.circuitpool.model.Accounts;
import com.example.circuitpool.model.Admin;

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








        Admin admin1 = new Admin("admin1");
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


        Admin admin2 = new Admin("admin2");
        db.createAdmin(admin2);
        Admin admin3 = new Admin("admin3");
        db.createAdmin(admin3);
        Admin admin4 = new Admin("admin4");
        db.createAdmin(admin4);





    }
}
