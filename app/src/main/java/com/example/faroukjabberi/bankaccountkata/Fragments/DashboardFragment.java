package com.example.faroukjabberi.bankaccountkata.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.faroukjabberi.bankaccountkata.R;
import com.example.faroukjabberi.bankaccountkata.utils.SharedPreferenceManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by farouk.jabberi on 22/11/2017.
 */
public class DashboardFragment extends Fragment {
    /**
     * The Balance.
     */
    @BindView(R.id.balance_textview)
    TextView balance;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.dashboard_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // show the client balance
        balance.setText(balance.getText().toString() + String.valueOf(SharedPreferenceManager.getInstance(getActivity()).getIntValue("balance", 0)) + getString(R.string.euro));
    }

}
