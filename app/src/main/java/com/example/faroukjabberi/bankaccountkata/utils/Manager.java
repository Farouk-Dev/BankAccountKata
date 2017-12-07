package com.example.faroukjabberi.bankaccountkata.utils;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.widget.Toast;


import com.example.faroukjabberi.bankaccountkata.Activities.MainActivity;
import com.example.faroukjabberi.bankaccountkata.R;
import com.example.faroukjabberi.bankaccountkata.models.AccountStatement;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by farouk.jabberi on 22/11/2017.
 */
public class Manager {
    /**
     * Replace fragment.
     *
     * @param activity the activity
     * @param fragment the fragment
     */
    public  static  void  replaceFragment(Activity activity, Fragment fragment){
        FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();

    }

    /**
     * Show message.
     *
     * @param context the context
     * @param message the message
     */
    public static void showMessage(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    /**
     * Add account statement.
     *
     * @param realm     the realm
     * @param amount    the amount
     * @param date      the date
     * @param balance   the balance
     * @param operation the operation
     */
    public static void addAccountStatement(Realm realm,String amount , String date , String balance,String operation){
        realm.beginTransaction();
        AccountStatement accountStatement = realm.createObject(AccountStatement.class);
        accountStatement.setAmount(amount);
        accountStatement.setOperation(operation);
        accountStatement.setBalance(balance);
        accountStatement.setDate(date);
        realm.commitTransaction();
    }

    /**
     * Get account statements realm results.
     *
     * @param realm the realm
     * @return the realm results
     */
    public static RealmResults<AccountStatement> getAccountStatements(Realm realm){
        RealmResults<AccountStatement> results = realm.where(AccountStatement.class).findAll();
      return results;
    }


}
