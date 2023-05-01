package com.example.localizationjava.model;

import androidx.annotation.NonNull;

public class Member {

    public String fullname;
    public int age;

    public Member(String fullname, int age) {
        this.fullname = fullname;
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return "Member{" +
                "fullname='" + fullname + '\'' +
                ", age=" + age +
                '}';
    }
}
