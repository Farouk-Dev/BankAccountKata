package com.example.faroukjabberi.bankaccountkata.application;

import android.app.Activity;
import android.app.Application;

import com.example.faroukjabberi.bankaccountkata.Activities.MainActivity;
import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * Created by farouk.jabberi on 22/11/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize Fresco
        Fresco.initialize(this);
        // Initialize Realm
        Realm.init(this);

    }
}