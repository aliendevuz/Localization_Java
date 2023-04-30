package com.example.localizationjava.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {

    Context context;
    SharedPreferences preferences;

    PreferencesManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
    }

    @SuppressLint("StaticFieldLeak")
    static PreferencesManager preferencesManager = null;
    public static PreferencesManager getInstance(Context context) {
        if (preferencesManager == null)
            preferencesManager = new PreferencesManager(context);
        return preferencesManager;
    }

    public void saveData(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String loadData(String key) {
        return preferences.getString(key, "null");
    }
}
