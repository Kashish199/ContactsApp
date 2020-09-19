package com.example.mainapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText txtEmail, txtPassword;
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login Form");
txtEmail =(EditText)findViewById(R.id.txtEmail);
txtPassword =(EditText)findViewById(R.id.txtPasswoerd);
btn_login =(Button)findViewById(R.id.btn_login);

btn_login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
    }

    public void btn_signupForm(View view) {

        startActivity(new Intent(getApplicationContext(),Signup.class));

    }
}