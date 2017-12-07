package com.example.faroukjabberi.bankaccountkata.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.faroukjabberi.bankaccountkata.R;
import com.example.faroukjabberi.bankaccountkata.holders.AccountStatementHolder;
import com.example.faroukjabberi.bankaccountkata.models.AccountStatement;

import java.util.ArrayList;

import io.realm.RealmResults;


/**
 * The type Event adapter.
 */
public class AccountHistoryAdapter extends RecyclerView.Adapter<AccountStatementHolder> {

    private RealmResults<AccountStatement> accountStatements;
    private Context mContext;


    /**
     * Instantiates a new Event adapter.
     *  @param accountStatements             the events
     * @param mContext                     the m context
     */
    public AccountHistoryAdapter(RealmResults<AccountStatement> accountStatements, Context mContext) {
        this.accountStatements = accountStatements;
        this.mContext = mContext;
    }

    /**
     * Gets visible objects.
     *
     * @return the visible objects
     */
    public RealmResults<AccountStatement> getVisibleObjects() {
        return accountStatements;
    }

    @Override
    public AccountStatementHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history_recycler, parent, false);
        return new AccountStatementHolder(itemView, mContext);
    }


    @Override
    public void onBindViewHolder(final AccountStatementHolder holder, final int position) {
        holder.bindViewData(accountStatements.get(position));
    }
    @Override
    public int getItemCount() {
        return accountStatements.size();
    }

}
