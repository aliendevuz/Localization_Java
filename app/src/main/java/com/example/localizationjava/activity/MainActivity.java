package com.example.localizationjava.activity;

import static com.example.localizationjava.MyApplication.localeManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localizationjava.databinding.ActivityMainBinding;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        localeManager.setLocale(context);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        localeManager.setLocale(context);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    void init() {
        CircularProgressButton buttonOpen = binding.buttonOpen;
        buttonOpen.setOnClickListener(v -> openActivity() );
    }

    void openActivity() {
        Intent intent = new Intent(context, LanguageActivity.class);
        startActivity(intent);
    }
}