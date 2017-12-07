package com.example.faroukjabberi.bankaccountkata.models;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

/**
 * Created by farouk.jabberi on 21/11/2017.
 */

public class AccountStatement extends RealmObject implements Parcelable {
    private String date;
    private String amount;
    private String balance;
    private String operation;
    private int a;

    public AccountStatement(String date, String amount, String balance, String operation) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.operation = operation;
    }

    public AccountStatement() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeString(this.amount);
        dest.writeString(this.balance);
        dest.writeString(this.operation);
    }

    protected AccountStatement(Parcel in) {
        this.date = in.readString();
        this.amount = in.readString();
        this.balance = in.readString();
        this.operation = in.readString();
    }

    public static final Parcelable.Creator<AccountStatement> CREATOR = new Parcelable.Creator<AccountStatement>() {
        @Override
        public AccountStatement createFromParcel(Parcel source) {
            return new AccountStatement(source);
        }

        @Override
        public AccountStatement[] newArray(int size) {
            return new AccountStatement[size];
        }
    };
}
