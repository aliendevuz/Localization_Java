package com.example.localizationjava.manager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;

import java.util.LinkedHashSet;
import java.util.Locale;

public class LocaleManager {

    Context context;
    PreferencesManager preferences;
    String language;

    public LocaleManager(Context context) {
        this.context = context;
        this.preferences = PreferencesManager.getInstance(context);
        this.language = (preferences.loadData(LANGUAGE_KEY).equals("null")) ? LANGUAGE_UZBEK : preferences.loadData(LANGUAGE_KEY);
    }

    public static String LANGUAGE_CHINESE = "zh";
    public static String LANGUAGE_KOREAN = "ko";
    public static String LANGUAGE_JAPAN = "ja";
    public static String LANGUAGE_UZBEK = "uz";
    static String LANGUAGE_KEY = "language";

    static Boolean isAtLeastVersion(Integer version) {
        return Build.VERSION.SDK_INT >= version;
    }

    void persistLanguage(String language) {
        preferences.saveData(LANGUAGE_KEY, language);
    }

    public void setLocale(Context context) {
        update(context, language);
    }

    void update(Context context, String language) {
        updateResources(context, language);
        Context appContext = context.getApplicationContext();
        if (context != appContext)
            updateResources(appContext, language);
    }

    public void setNewLocale(Context context, String language) {
        persistLanguage(language);
        update(context, language);
    }

    void updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (isAtLeastVersion(Build.VERSION_CODES.N))
            setLocaleForApi24(config, locale);
        else if (isAtLeastVersion(Build.VERSION_CODES.JELLY_BEAN_MR1))
            config.setLocale(locale);
        else
            config.locale = locale;
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

    void setLocaleForApi24(Configuration config, Locale locale) {
        LinkedHashSet<Locale> set = new LinkedHashSet<>();
        set.add(locale);
        LocaleList all = LocaleList.getDefault();
        for (int i = 0; i < all.size(); i++) set.add(all.get(i));
        Locale[] locales = set.toArray(new Locale[0]);
        config.setLocales(new LocaleList(locales));
    }
}
