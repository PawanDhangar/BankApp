package com.pawan.TheSparksBank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



import com.pawan.TheSparksBank.Data.DatabaseHandler;
import com.pawan.TheSparksBank.Model.Transaction;
import com.pawan.TheSparksBank.Model.TransactionList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerDetails extends AppCompatActivity {
    List<com.pawan.TheSparksBank.Model.CustomerDetails> customerDetailsList;
    com.pawan.TheSparksBank.Model.CustomerDetails senderCustomer;
    List<String> spinnerList;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        spinnerList = new ArrayList<>();

        AtomicInteger userAmountINT = new AtomicInteger();
        DatabaseHandler handler = new DatabaseHandler(getBaseContext());

        TextView name = findViewById(R.id.details_name);
        TextView email = findViewById(R.id.details_email);
        TextView balance = findViewById(R.id.details_balance);
        Button transferButton = findViewById(R.id.tranferButton);
        EditText amountText = findViewById(R.id.enterAmount);
        Editable transferAmount = amountText.getText();
        spinner = findViewById(R.id.spinner);

        Log.d("money", "onCreate: " + transferAmount);

        Intent getIntent = getIntent();
        customerDetailsList = (List<com.pawan.TheSparksBank.Model.CustomerDetails>) getIntent.getSerializableExtra("list");
        senderCustomer = (com.pawan.TheSparksBank.Model.CustomerDetails) getIntent.getSerializableExtra("selectedCustomer");

        name.setText(senderCustomer.getName());
        email.setText(senderCustomer.getEmail());
        balance.setText(senderCustomer.getBalance());
        userAmountINT.set(Integer.parseInt(senderCustomer.getBalance()));

        for(int i = 0; i < customerDetailsList.size(); i++){
            String customerName = customerDetailsList.get(i).getName();
            if(!customerName.equals(senderCustomer.getName())){
                spinnerList.add(customerName);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.selected_item, spinnerList);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        spinner.setAdapter(adapter);


        transferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(transferAmount)){
                    Toast.makeText(CustomerDetails.this, R.string.amountWarning, Toast.LENGTH_LONG).show();
                }else{
                    String str = String.valueOf(transferAmount);
                    int transferAmountINT = Integer.parseInt(str);
                    if(transferAmountINT > userAmountINT.get()){
                        Toast.makeText(CustomerDetails.this, R.string.amountLimitWarning, Toast.LENGTH_LONG).show();
                    }else{
                        String selectedCustomerName = spinner.getSelectedItem().toString();
                        com.pawan.TheSparksBank.Model.CustomerDetails receiverCustomer = new com.pawan.TheSparksBank.Model.CustomerDetails();
                        for(com.pawan.TheSparksBank.Model.CustomerDetails customerDetails : customerDetailsList){
                            if(customerDetails.getName().equals(selectedCustomerName)){
                                receiverCustomer.setName(customerDetails.getName());
                                receiverCustomer.setEmail(customerDetails.getEmail());
                                receiverCustomer.setBalance(customerDetails.getBalance());
                                receiverCustomer.setId(customerDetails.getId());
                            }
                        }

                        int senderBalance = Integer.parseInt(senderCustomer.getBalance()) - transferAmountINT;
                        int receiverBalance = Integer.parseInt(receiverCustomer.getBalance()) + transferAmountINT;

                        senderCustomer.setBalance(String.valueOf(senderBalance));
                        receiverCustomer.setBalance(String.valueOf(receiverBalance));

                        handler.updateCustomer(senderCustomer);
                        handler.updateCustomer(receiverCustomer);

                        Toast.makeText(CustomerDetails.this, "Transaction Successful", Toast.LENGTH_SHORT)
                                .show();
                        customerDetailsList.clear();
                        customerDetailsList = handler.getAllCustomers();

                        Transaction transaction = new Transaction();
                        transaction.setSenderName(senderCustomer.getName());
                        transaction.setReceiverName(receiverCustomer.getName());
                        transaction.setAmount(transferAmountINT);
                        transaction.setDate(new Date());

                        TransactionList.addToList(transaction);

                        Intent intent = new Intent(CustomerDetails.this, CustomerList.class);
                        intent.putExtra("list", (Serializable) customerDetailsList);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}