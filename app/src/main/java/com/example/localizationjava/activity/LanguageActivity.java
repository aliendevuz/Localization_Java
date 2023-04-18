package com.example.localizationjava.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import com.example.localizationjava.R;
import com.example.localizationjava.databinding.ActivityLanguageBinding;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;

public class LanguageActivity extends AppCompatActivity {

    ActivityLanguageBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    void init() {
        CircularProgressButton buttonChinese = binding.buttonChinese;
        CircularProgressButton buttonKorean = binding.buttonKorean;
        CircularProgressButton buttonJapanese = binding.buttonJapanese;
        CircularProgressButton buttonUzbek = binding.buttonUzbek;

        buttonChinese.setOnClickListener(v -> {
            buttonChinese.startAnimation();
            new Handler().postDelayed(() -> {
                buttonChinese.revertAnimation();
                buttonChinese.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape));
                setLocale("zh");
            }, 400L);
        });

        buttonKorean.setOnClickListener(v -> {
            buttonKorean.startAnimation();
            new Handler().postDelayed(() -> {
                buttonKorean.revertAnimation();
                buttonKorean.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape));
                setLocale("ko");
            }, 400L);
        });

        buttonJapanese.setOnClickListener(v -> {
            buttonJapanese.startAnimation();
            new Handler().postDelayed(() -> {
                buttonJapanese.revertAnimation();
                buttonJapanese.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape));
                setLocale("ja");
            }, 400L);
        });

        buttonUzbek.setOnClickListener(v -> {
            buttonUzbek.startAnimation();
            new Handler().postDelayed(() -> {
                buttonUzbek.revertAnimation();
                buttonUzbek.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape));
                setLocale("uz");
            }, 400L);
        });
    }

    void setLocale(String lan) {
        LocaleListCompat appLocale = LocaleListCompat.forLanguageTags(lan);
        AppCompatDelegate.setApplicationLocales(appLocale);
        finish();
    }
}
