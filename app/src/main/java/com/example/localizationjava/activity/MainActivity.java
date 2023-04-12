package com.example.localizationjava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localizationjava.databinding.ActivityMainBinding;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Timber.plant(new Timber.DebugTree());
        init();
    }

    void init() {
        Button buttonOpen = binding.buttonOpen;
        buttonOpen.setOnClickListener(v -> {
            Intent intent = new Intent(context, LanguageActivity.class);
            startActivity(intent);
        });
    }
}