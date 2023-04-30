package com.example.localizationjava.activity;

import static com.example.localizationjava.MyApplication.localeManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.localizationjava.R;
import com.example.localizationjava.databinding.ActivityLanguageBinding;
import com.example.localizationjava.manager.LocaleManager;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;

public class LanguageActivity extends AppCompatActivity {

    Context context = this;
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
                localeManager.setNewLocale(context, LocaleManager.LANGUAGE_CHINESE);
                finish();
            }, 400L);
        });

        buttonKorean.setOnClickListener(v -> {
            buttonKorean.startAnimation();
            new Handler().postDelayed(() -> {
                buttonKorean.revertAnimation();
                buttonKorean.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape));
                localeManager.setNewLocale(context, LocaleManager.LANGUAGE_KOREAN);
                finish();
            }, 400L);
        });

        buttonJapanese.setOnClickListener(v -> {
            buttonJapanese.startAnimation();
            new Handler().postDelayed(() -> {
                buttonJapanese.revertAnimation();
                buttonJapanese.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape));
                localeManager.setNewLocale(context, LocaleManager.LANGUAGE_JAPAN);
                finish();
            }, 400L);
        });

        buttonUzbek.setOnClickListener(v -> {
            buttonUzbek.startAnimation();
            new Handler().postDelayed(() -> {
                buttonUzbek.revertAnimation();
                buttonUzbek.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape));
                localeManager.setNewLocale(context, LocaleManager.LANGUAGE_UZBEK);
                finish();
            }, 400L);
        });
    }
}
