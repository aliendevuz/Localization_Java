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

    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void saveLong(String key, Long value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public void saveBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void saveInteger(String key, Integer value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void saveDouble(String key, Double value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value.toString());
        editor.apply();
    }

    public String loadString(String key) {
        return preferences.getString(key, "null");
    }

    public Long loadLong(String key) {
        return preferences.getLong(key, 0L);
    }

    public Boolean loadBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public Integer loadInteger(String key) {
        return preferences.getInt(key, 0);
    }

    public Double loadDouble(String key) {
        return Double.parseDouble(preferences.getString(key, "0.0"));
    }
}
