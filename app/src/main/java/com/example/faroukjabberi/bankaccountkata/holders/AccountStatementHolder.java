package com.example.faroukjabberi.bankaccountkata.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.faroukjabberi.bankaccountkata.Activities.MainActivity;
import com.example.faroukjabberi.bankaccountkata.Fragments.StatementFragment;
import com.example.faroukjabberi.bankaccountkata.R;
import com.example.faroukjabberi.bankaccountkata.models.AccountStatement;
import com.example.faroukjabberi.bankaccountkata.utils.Manager;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AccountStatementHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    // binding views
    @BindView(R.id.item)
    RelativeLayout item;
    @BindView(R.id.operation_textview)
    TextView operation;
    @BindView(R.id.amount_textview)
    TextView amount;
    @BindView(R.id.balance_textview)
    TextView balance;
    @BindView(R.id.date_textview)
    TextView date;


    private Context context;
    private AccountStatement accountStatement;

    /**
     * Instantiates a new  Account Statement Holder.
     *
     * @param itemView the item view
     * @param context  the context
     */
    public AccountStatementHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;

    }

    /**
     * Bind view data.
     *
     * @param accountStatement the accountStatement
     */
    public void bindViewData(AccountStatement accountStatement) {
        this.accountStatement = accountStatement;
        if (accountStatement != null) {
            operation.setText(operation.getText().toString() + context.getString(R.string.space) + (accountStatement.getOperation() != null ? accountStatement.getOperation() : context.getString(R.string.noting)));
            amount.setText(amount.getText().toString() + context.getString(R.string.space) + (accountStatement.getAmount() != null ? accountStatement.getAmount()+ context.getString(R.string.euro) : context.getString(R.string.noting)));
            balance.setText(balance.getText().toString() + context.getString(R.string.space) + (accountStatement.getBalance() != null ? accountStatement.getBalance()  + context.getString(R.string.euro): context.getString(R.string.noting)));
            date.setText(date.getText().toString() + context.getString(R.string.space) + (accountStatement.getDate() != null ? accountStatement.getDate() : context.getString(R.string.noting)));

        }

        item.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Manager.replaceFragment((MainActivity)context,StatementFragment.newInstance(accountStatement));
    }

}
