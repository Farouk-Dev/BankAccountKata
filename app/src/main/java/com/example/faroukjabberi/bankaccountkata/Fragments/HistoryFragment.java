package com.example.faroukjabberi.bankaccountkata.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.faroukjabberi.bankaccountkata.R;
import com.example.faroukjabberi.bankaccountkata.adapters.AccountHistoryAdapter;
import com.example.faroukjabberi.bankaccountkata.models.AccountStatement;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * Created by farouk.jabberi on 22/11/2017.
 */
public class HistoryFragment extends Fragment {

    /**
     * The History recycler.
     */
    @BindView(R.id.history_recycler)
    RecyclerView historyRecycler;
    private Realm realm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.history_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Get a Realm instance for this thread
        realm = Realm.getDefaultInstance();
        // attach an adapter to the  recyclerView********************
        historyRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        AccountHistoryAdapter accountHistoryAdapter = new AccountHistoryAdapter(realm.where(AccountStatement.class).findAll(), getActivity());
        historyRecycler.setAdapter(accountHistoryAdapter);
        //****************************************
    }
}
