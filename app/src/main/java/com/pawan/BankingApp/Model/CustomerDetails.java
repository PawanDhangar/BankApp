package com.pawan.TheSparksBank.Model;

import java.io.Serializable;

public class CustomerDetails implements Serializable {
    private int id;
    private String name;
    private String email;
    private String balance;

    public CustomerDetails(){

    }

    public CustomerDetails(String name, String email, String balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
