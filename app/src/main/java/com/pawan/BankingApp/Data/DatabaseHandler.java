package com.pawan.BankingApp.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.pawan.BankingApp.R;
import com.pawan.BankingApp.Model.CustomerDetails;
import com.pawan.BankingApp.Util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY,"
                + Util.KEY_NAME + " TEXT,"
                + Util.KEY_EMAIL + " TEXT,"
                + Util.KEY_BALANCE + " INTEGER" + ")";
        db.execSQL(CREATE_CONTACT_TABLE);// creating our table

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = String.valueOf(R.string.dbdrop);
        db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});

        //create a table again
        onCreate(db);
    }

    public void addCustomer(CustomerDetails customerDetails){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, customerDetails.getName());
        values.put(Util.KEY_EMAIL, customerDetails.getEmail());
        values.put(Util.KEY_BALANCE, customerDetails.getBalance());

        Log.d("database", "addCustomer: "+ values.getAsString(Util.KEY_NAME));

        //insert to row
        db.insert(Util.TABLE_NAME, null, values);
        db.close(); // closing db connection
    }

    //get all Customers
    public List<CustomerDetails> getAllCustomers(){
        List<CustomerDetails> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

        if(cursor.moveToFirst()){
            do{
                CustomerDetails customer  = new CustomerDetails();
                customer.setId(Integer.parseInt(cursor.getString(0)));
                customer.setName(cursor.getString(1));
                customer.setEmail(cursor.getString(2));
                customer.setBalance(cursor.getString(3));

                contactList.add(customer);
            }while(cursor.moveToNext());
        }
        cursor.close();

        return contactList;
    }

    //Update Contact
    public void updateCustomer(CustomerDetails customerDetails){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, customerDetails.getName());
        values.put(Util.KEY_EMAIL, customerDetails.getEmail());
        values.put(Util.KEY_BALANCE, customerDetails.getBalance());

        //update row
        //update(tablename, values, where id = 3)
        db.update(Util.TABLE_NAME, values, Util.KEY_ID + "=?",
                new String[]{String.valueOf(customerDetails.getId())});
        db.close();
    }

    public void deleteTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from customers");
    }

}
