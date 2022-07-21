package com.pawan.TheSparksBank.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pawan.TheSparksBank.R;
import com.pawan.TheSparksBank.Model.Transaction;

import java.text.SimpleDateFormat;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.Holder> {
    private List<Transaction> transactionList;

    public TransactionAdapter(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @NonNull
    @Override
    public TransactionAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_transaction, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.Holder holder, int position) {
        if(transactionList.isEmpty()){
            holder.noTransactionTV.setVisibility(View.VISIBLE);
            holder.senderText.setVisibility(View.GONE);
            holder.receiverText.setVisibility(View.GONE);
            holder.amountText.setVisibility(View.GONE);
            holder.dateText.setVisibility(View.GONE);
        }
        else{
            holder.noTransactionTV.setVisibility(View.GONE);
            holder.senderText.setVisibility(View.VISIBLE);
            holder.receiverText.setVisibility(View.VISIBLE);
            holder.amountText.setVisibility(View.VISIBLE);
            holder.dateText.setVisibility(View.VISIBLE);

            Transaction transaction = transactionList.get(position);

            holder.senderText.setText(transaction.getSenderName());
            holder.receiverText.setText(transaction.getReceiverName());
            holder.amountText.setText(String.valueOf(transaction.getAmount()));

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            holder.dateText.setText(formatter.format(transaction.getDate()));
        }
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        public TextView senderText;
        public TextView receiverText;
        public TextView amountText;
        public TextView dateText;
        public TextView noTransactionTV;
        public Holder(@NonNull View itemView) {
            super(itemView);

            senderText = itemView.findViewById(R.id.senderTextView);
            receiverText = itemView.findViewById(R.id.receiverTextView);
            amountText = itemView.findViewById(R.id.amountTextView);
            dateText = itemView.findViewById(R.id.dateTextView);
            noTransactionTV = itemView.findViewById(R.id.noTransactionTextView);
        }
    }
}
