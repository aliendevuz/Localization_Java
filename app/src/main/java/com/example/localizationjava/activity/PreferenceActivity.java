package com.example.localizationjava.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.localizationjava.databinding.ActivityPreferenceBinding;
import com.example.localizationjava.manager.PreferencesManager;

public class PreferenceActivity extends AppCompatActivity {

    Context context = this;
    ActivityPreferenceBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPreferenceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    void init() {
        EditText editTextEmail = binding.editTextEmail;
        Button buttonSave = binding.buttonSave;
        Button buttonLoad = binding.buttonLoad;
        TextView textViewEmail = binding.textViewEmail;

        buttonSave.setOnClickListener(v -> {
            String stringEmail = editTextEmail.getText().toString().trim();
            PreferencesManager.getInstance(context).saveString("email", stringEmail);
        });

        buttonLoad.setOnClickListener(v -> textViewEmail.setText(PreferencesManager.getInstance(context).loadString("email")));
    }
}
