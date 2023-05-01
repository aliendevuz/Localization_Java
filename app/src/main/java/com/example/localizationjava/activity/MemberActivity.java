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

import com.example.localizationjava.databinding.ActivityMemberBinding;
import com.example.localizationjava.manager.PreferencesManager;
import com.example.localizationjava.model.Member;
import com.google.gson.Gson;

public class MemberActivity extends AppCompatActivity {

    Context context = this;
    ActivityMemberBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    @SuppressLint({"UseSwitchCompatOrMaterialCode", "SetTextI18n"})
    void init() {
        PreferencesManager preferences = PreferencesManager.getInstance(context);

        EditText editTextFullnameOfMember = binding.editTextFullnameOfMember;
        EditText editTextAgeOfMember = binding.editTextAgeOfMember;
        Button buttonSaveMember = binding.buttonSaveMember;
        TextView textViewMember = binding.textViewMember;
        Button buttonLoadMember = binding.buttonLoadMember;

        String keyMember = "data of member";

        buttonSaveMember.setOnClickListener(v -> {
            try {
                Member member = new Member(editTextFullnameOfMember.getText().toString().trim(), Integer.parseInt(editTextAgeOfMember.getText().toString().trim()));
                preferences.saveString(keyMember, new Gson().toJson(member));
                Toast.makeText(context, "Obyekt yaratildi", Toast.LENGTH_SHORT).show();
            } catch (Exception ignored) {
                textViewMember.setText("Yoshni kiritishda xatoga yo'l qo'ygan ko'rinasiz!");
            }
        });

        buttonLoadMember.setOnClickListener(v -> {
            Gson gson = new Gson();
            String json = preferences.loadString(keyMember);
            String getData = "Object:\n";
            try {
                 getData += gson.fromJson(json, Member.class).toString();
            } catch (Exception ignored) {
                getData += "null";
            }
            textViewMember.setText(getData);
        });
    }
}
