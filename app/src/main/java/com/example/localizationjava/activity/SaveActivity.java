package com.example.localizationjava.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.localizationjava.databinding.ActivitySaveBinding;
import com.example.localizationjava.manager.PreferencesManager;

public class SaveActivity extends AppCompatActivity {

    Context context = this;
    ActivitySaveBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    void init() {
        PreferencesManager preferences = PreferencesManager.getInstance(context);
        EditText editTextLong = binding.editTextLong;
        Switch switchBoolean = binding.switchBoolean;
        EditText editTextInteger = binding.editTextInteger;
        EditText editTextDouble = binding.editTextDouble;
        Button buttonSaveData = binding.buttonSaveData;
        TextView textViewData = binding.textViewData;
        Button buttonLoadData = binding.buttonLoadData;

        String keyLong = "data of Long type";
        String keyBoolean = "data of Boolean type";
        String keyInteger = "data of Integer type";
        String keyDouble = "data of Double type";

        buttonSaveData.setOnClickListener(v -> {
            try {
                preferences.saveLong(keyLong, Long.parseLong(editTextLong.getText().toString()));
            } catch (Exception ignored) {}
            preferences.saveBoolean(keyBoolean, switchBoolean.isChecked());
            try {
                preferences.saveInteger(keyInteger, Integer.parseInt(editTextInteger.getText().toString()));
            } catch (Exception ignored) {}
            try {
                preferences.saveDouble(keyDouble, Double.parseDouble(editTextDouble.getText().toString()));
            } catch (Exception ignored) {}
        });

        buttonLoadData.setOnClickListener(v -> {
            String getData = "Long:\t\t\t\t" + preferences.loadLong(keyLong).toString() + "L\n"
                    + "Boolean:\t\t" + preferences.loadBoolean(keyBoolean).toString() + "\n"
                    + "Integer:\t\t" + preferences.loadInteger(keyInteger).toString() + "\n"
                    + "Double:\t\t" + preferences.loadDouble(keyDouble).toString();
            textViewData.setText(getData);
        });
    }
}
