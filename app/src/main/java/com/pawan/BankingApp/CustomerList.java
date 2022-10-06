package com.pawan.BankingApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pawan.BankingApp.Adapter.OnCustomerClickListener;
import com.pawan.BankingApp.Adapter.RecyclerViewAdapter;
import com.pawan.BankingApp.Model.CustomerDetails;

import java.io.Serializable;
import java.util.List;

public class CustomerList extends AppCompatActivity implements OnCustomerClickListener {
    private RecyclerView recyclerView;
    private Button transactionButton;
    List<CustomerDetails> customerDetailsList;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        getSupportActionBar().hide();

        transactionButton = findViewById(R.id.transactionButton);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent getIntent = getIntent();
        customerDetailsList = (List<CustomerDetails>) getIntent.getSerializableExtra("list");

        recyclerViewAdapter = new RecyclerViewAdapter(customerDetailsList, this);
        recyclerView.setAdapter(recyclerViewAdapter);

        transactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerList.this, TransactionDetails.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCustomerClick(CustomerDetails customer) {
        Intent intent = new Intent(CustomerList.this, com.pawan.BankingApp.CustomerDetails.class);
        intent.putExtra("list", (Serializable) customerDetailsList);
        intent.putExtra("selectedCustomer", (Serializable) customer);
        startActivity(intent);
    }
}