package com.pawan.TheSparksBank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;



import com.pawan.TheSparksBank.Data.DatabaseHandler;
import com.pawan.TheSparksBank.Model.CustomerDetails;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button allCustomersButton;
    List<CustomerDetails> customerDetailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        allCustomersButton = findViewById(R.id.allCustomersButton);

        DatabaseHandler handler = new DatabaseHandler(MainActivity.this);

        handler.addCustomer(new CustomerDetails("Ajay", "ajay@gmail.com", "90000"));
        handler.addCustomer(new CustomerDetails("Lalit", "lalit@gmail.com", "30000"));
        handler.addCustomer(new CustomerDetails("Steve", "steve@gmail.com", "120000"));
        handler.addCustomer(new CustomerDetails("Elon", "elon@gmail.com", "80000"));
        handler.addCustomer(new CustomerDetails("Bill", "bill@gmail.com", "20000"));
        handler.addCustomer(new CustomerDetails("Warren", "warren@gmail.com", "800000"));
        handler.addCustomer(new CustomerDetails("Mark", "mark@gmail.com", "60000"));
        handler.addCustomer(new CustomerDetails("jeff", "jeff@gmail.com", "69000"));
        handler.addCustomer(new CustomerDetails("Pawan", "pawan@gmail.com", "40000"));
        handler.addCustomer(new CustomerDetails("Tony", "tony@gmail.com", "380000"));

        customerDetailsList = handler.getAllCustomers();
        Log.d("TAG", "onCreate: " + customerDetailsList.size());

        allCustomersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomerList.class);
                intent.putExtra("list", (Serializable) customerDetailsList);
                startActivity(intent);
            }
        });
    }
}