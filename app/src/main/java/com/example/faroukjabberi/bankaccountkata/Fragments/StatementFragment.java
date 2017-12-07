package com.example.faroukjabberi.bankaccountkata.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.faroukjabberi.bankaccountkata.R;
import com.example.faroukjabberi.bankaccountkata.models.AccountStatement;
import com.example.faroukjabberi.bankaccountkata.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by farouk.jabberi on 22/11/2017.
 */

public class StatementFragment extends Fragment {
    @BindView(R.id.title_textview)
    TextView title;
    @BindView(R.id.date_textview)
    TextView date;
    @BindView(R.id.operation_textview)
    TextView operation;
    @BindView(R.id.amount_textview)
    TextView amount;
    @BindView(R.id.balance_textview)
    TextView balance;

    // statement frgent instance
    public static StatementFragment newInstance(AccountStatement accountStatement) {
        Bundle args = new Bundle();
        args.putParcelable(Constants.ACCOUNT_STATEMENT, accountStatement);
        StatementFragment fragment = new StatementFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.statement_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get data from fragment  instance
        if (getArguments()!=null && getArguments().getParcelable(Constants.ACCOUNT_STATEMENT)!=null){
            // show data *********
            AccountStatement statementPrinting = getArguments().getParcelable(Constants.ACCOUNT_STATEMENT);
            date.setText(getString(R.string.date_) +getString(R.string.noting)+ (statementPrinting.getDate()!=null? statementPrinting.getDate():getString(R.string.noting)));
            operation.setText(getString(R.string.operation_) +getString(R.string.noting)+ (statementPrinting.getOperation()!=null? statementPrinting.getOperation():getString(R.string.noting)));
            amount.setText(getString(R.string.amount_) +getString(R.string.noting)+ (statementPrinting.getAmount()!=null? statementPrinting.getAmount() + getString(R.string.euro):getString(R.string.noting)));
            balance.setText(getString(R.string.balance_) +getString(R.string.noting)+ (statementPrinting.getBalance()!=null? statementPrinting.getBalance() + getString(R.string.euro):getString(R.string.noting)));
           // *********************
        }
    }
}
