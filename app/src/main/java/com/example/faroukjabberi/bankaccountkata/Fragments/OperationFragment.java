package com.example.faroukjabberi.bankaccountkata.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.faroukjabberi.bankaccountkata.R;
import com.example.faroukjabberi.bankaccountkata.models.Operation;
import com.example.faroukjabberi.bankaccountkata.utils.Manager;
import com.example.faroukjabberi.bankaccountkata.utils.SharedPreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * Created by farouk.jabberi on 22/11/2017.
 */

public class OperationFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    @BindView(R.id.operation_spinner)
    Spinner operationSpinner;
    @BindView(R.id.amount_editext)
    EditText amount;
    @BindView(R.id.proceed_button)
    Button proceedButton;


    private ArrayList<String> operations;
    private ArrayAdapter<String> operationAdapter;
    private Realm realm;
    private int balance;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.operation_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Get a Realm instance for this thread
        realm = Realm.getDefaultInstance();
        //Spinner operationSpinner = (Spinner) getActivity().findViewById(R.id.operation_spinner);
        operations = new ArrayList<String>(Arrays.asList(getString(R.string.operation), getString(R.string.deposit), getString(R.string.withdrawal)));
        // Creating adapter for spinner
        operationAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, operations);
        // Drop down layout style - list view with radio button
        operationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        operationSpinner.setAdapter(operationAdapter);
        // Spinner click listener
        operationSpinner.setOnItemSelectedListener(this);
        proceedButton.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onClick(View view) {
    switch (operationSpinner.getSelectedItemPosition()){
        case 0 :
            Manager.showMessage(getActivity(),getString(R.string.select_an_operation_please));
            break;
        case 1:
            // deposit
            // new balance value
            balance = SharedPreferenceManager.getInstance(getActivity()).getIntValue("balance",0)+ Integer.valueOf(amount.getText().toString());
            // save balance
            SharedPreferenceManager.getInstance(getActivity()).setValue("balance",balance);
            // save data in realm db
            Manager.addAccountStatement(realm,amount.getText().toString(),new Date().toString(),String.valueOf(balance),String.valueOf( Operation.Deposit));
            // make the amount editext empty
            amount.setText(R.string.noting);
           //show success message
            Manager.showMessage(getActivity(),getString(R.string.your_new_balance_is)+String.valueOf(balance));
            Log.e("realm", Manager.getAccountStatements(realm).toString());
            break;
        case 2:
             // withdrawal
            if(SharedPreferenceManager.getInstance(getActivity()).getIntValue("balance",0)>Integer.valueOf(amount.getText().toString())){
                // new balance value
                balance = SharedPreferenceManager.getInstance(getActivity()).getIntValue("balance",0)- Integer.valueOf(amount.getText().toString());
                // save balance
                SharedPreferenceManager.getInstance(getActivity()).setValue("balance",balance);
                // save data in realm db
                Manager.addAccountStatement(realm,amount.getText().toString(),new Date().toString(),String.valueOf(balance),String.valueOf( Operation.Deposit));
                // make the amount editext empty
                amount.setText(R.string.noting);
                //show success message
                Manager.showMessage(getActivity(),getString(R.string.your_new_balance_is)+String.valueOf(balance));
                Log.e("realm", Manager.getAccountStatements(realm).toString());
            }else {
                // show  error message
                Manager.showMessage(getActivity(),getString(R.string.you_account_must_be_less_than)+SharedPreferenceManager.getInstance(getActivity()).getIntValue("balance",0));
                // make the amount editext empty
                amount.setText(R.string.noting);
            }
            break;
    }

    }
}
