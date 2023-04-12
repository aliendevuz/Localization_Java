package com.example.localizationjava.activity;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.localizationjava.databinding.ActivityLanguageBinding;

import java.util.Locale;

import timber.log.Timber;

public class LanguageActivity extends AppCompatActivity {

    ActivityLanguageBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    void init() {
        binding.buttonChinese.setOnClickListener(v -> setLocale("zh"));
        binding.buttonKorean.setOnClickListener(v -> setLocale("ko"));
        binding.buttonJapanese.setOnClickListener(v -> setLocale("ja"));
        binding.buttonUzbek.setOnClickListener(v -> setLocale("uz"));
        Timber.d("Salom");
    }

    void setLocale(String lan) {
        Locale locale = new Locale(lan);
        Locale.setDefault(locale);
        Configuration config = getResources().getConfiguration();
        config.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        finish();
    }
}
