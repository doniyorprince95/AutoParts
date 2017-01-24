package com.mobapplic.autoparts;

import android.app.Application;

import com.google.firebase.analytics.FirebaseAnalytics;


public class App extends Application {

    private static App sInstance;
    private FirebaseAnalytics mFirebaseAnalytics;

    public static App getContext() {
        return sInstance;
    }

    public App() {
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }
}
