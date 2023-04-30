package com.example.localizationjava;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.example.localizationjava.manager.LocaleManager;

public class MyApplication extends Application {

    Context context = this;
    @SuppressLint("StaticFieldLeak")
    public static LocaleManager localeManager;

    @Override
    public void onCreate() {
        super.onCreate();
        localeManager = new LocaleManager(context);
        localeManager.setLocale(context);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localeManager.setLocale(context);
    }
}
