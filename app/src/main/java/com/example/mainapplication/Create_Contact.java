package com.example.mainapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Create_Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__contact);
        getSupportActionBar().setTitle("CreateContact Page");
    }
}