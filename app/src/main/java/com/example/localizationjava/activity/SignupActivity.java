package com.example.localizationjava.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.localizationjava.databinding.ActivitySignupBinding;
import com.example.localizationjava.manager.PreferencesManager;

public class SignupActivity extends AppCompatActivity {

    Context context = this;
    ActivitySignupBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    void init() {
        PreferencesManager preferences = PreferencesManager.getInstance(context);
        EditText editTextFullname = binding.editTextFullname;
        EditText editTextEmail = binding.editTextEmail;
        EditText editTextPassword = binding.editTextPassword;
        EditText editTextConfirmPassword = binding.editTextConfirmPassword;
        Button buttonSaveUser = binding.buttonSaveUser;
        TextView textViewUser = binding.textViewUser;
        Button buttonShowUser = binding.buttonShowUser;

        String keyFullname = "data of fullname";
        String keyEmail = "data of email";
        String keyPassword = "data of password";

        buttonSaveUser.setOnClickListener(v -> {
            if (editTextFullname.getText().toString().isEmpty() || editTextEmail.getText().toString().isEmpty() ||
                    editTextPassword.getText().toString().isEmpty() || editTextConfirmPassword.getText().toString().isEmpty()) {
                textViewUser.setText("Biror maydon bo'sh\nqolmaganligiga ishonch\nhosil qiling!");
            } else if (editTextPassword.getText().toString().equals(editTextConfirmPassword.getText().toString())) {
                preferences.saveString(keyFullname, editTextFullname.getText().toString().trim());
                preferences.saveString(keyEmail, editTextEmail.getText().toString().trim());
                preferences.saveString(keyPassword, editTextPassword.getText().toString().trim());
                Toast.makeText(context, "Ma'lumotlar saqlandi :)", Toast.LENGTH_SHORT).show();
            } else
                textViewUser.setText("Confirm passwordga yozilgan parol,\nPasswordga yozilgan parol\nbilan bir xil bo'lishi kerak!");
        });

        buttonShowUser.setOnClickListener(v -> {
            String getData = "Fullname:\t\t" + preferences.loadString(keyFullname) +
                    "\nEmail:\t\t\t\t" + preferences.loadString(keyEmail) +
                    "\nPassword:\t\t" + preferences.loadString(keyPassword);
            textViewUser.setText(getData);
        });
    }
}
