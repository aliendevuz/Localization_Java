package com.example.localizationjava.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localizationjava.R;
import com.example.localizationjava.databinding.ActivityMainBinding;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;
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

    @SuppressLint("UseCompatLoadingForDrawables")
    void init() {
        CircularProgressButton buttonOpen = binding.buttonOpen;
        buttonOpen.setOnClickListener(v -> {
            buttonOpen.startAnimation();
            new Handler().postDelayed( () -> {
                buttonOpen.revertAnimation();
                buttonOpen.setBackgroundDrawable(getDrawable(R.drawable.circular_border_shape));
                Intent intent = new Intent(context, LanguageActivity.class);
                startActivity(intent);
            }, 1400L);
        });
    }
}