package com.pawan.BankingApp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pawan.BankingApp.R;
import com.pawan.BankingApp.Model.CustomerDetails;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<CustomerDetails> customerList;
    private OnCustomerClickListener customerClickListener;

    public RecyclerViewAdapter(List<CustomerDetails> customerList, OnCustomerClickListener onCustomerClickListener) {
        this.customerList = customerList;
        this.customerClickListener = onCustomerClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_customers, parent, false);
        return new ViewHolder(view, customerClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CustomerDetails customer = customerList.get(position);

        holder.name.setText(customer.getName());
        holder.email.setText(customer.getEmail());
        holder.balance.setText(customer.getBalance());

    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView email;
        public TextView balance;
        OnCustomerClickListener onCustomerClickListener;
        public ViewHolder(@NonNull View itemView, OnCustomerClickListener onCustomerClickListener) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTextView);
            email = itemView.findViewById(R.id.emailTextView);
            balance = itemView.findViewById(R.id.balanceTextView);
            this.onCustomerClickListener = onCustomerClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onCustomerClickListener.onCustomerClick(customerList.get(getAdapterPosition()));
        }
    }
}
