package com.pawan.TheSparksBank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.pawan.TheSparksBank.Adapter.TransactionAdapter;
import com.pawan.TheSparksBank.Model.Transaction;
import com.pawan.TheSparksBank.Model.TransactionList;

import java.util.List;

public class TransactionDetails extends AppCompatActivity {
    List<Transaction> transactionList;
    private RecyclerView transactionRV;
    private TransactionAdapter transactionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_details);

        getSupportActionBar().hide();

        transactionRV = findViewById(R.id.transactionRV);
        transactionRV.setHasFixedSize(true);
        transactionRV.setLayoutManager(new LinearLayoutManager(this));

        transactionList = TransactionList.getTransactionList();
        transactionAdapter = new TransactionAdapter(transactionList);
        transactionRV.setAdapter(transactionAdapter);
    }
}