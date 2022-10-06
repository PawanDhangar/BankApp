package com.pawan.BankingApp.Model;

import java.util.ArrayList;
import java.util.List;

public class TransactionList {
    private static List<Transaction> transactionList = new ArrayList<>();

    public static void addToList(Transaction transaction){
        transactionList.add(transaction);
    }
    public static List<Transaction> getTransactionList(){
        return transactionList;
    }
}
