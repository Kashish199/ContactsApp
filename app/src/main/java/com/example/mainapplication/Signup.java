package com.example.mainapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.mainapplication.R.id.btnregister;

public class Signup extends AppCompatActivity {
    EditText txtEmail, txtPassword,txtConfirmPassword;
    Button btn_register;
    ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;

    protected void  onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("Signup");

        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        txtConfirmPassword=(EditText)findViewById(R.id.txtconfirmpassword);
        btn_register=(Button)findViewById(btnregister);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);


        firebaseAuth = FirebaseAuth.getInstance();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String confirmpassword = txtConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Signup.this, "Pleae enter email", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Signup.this, "Pleae enter password", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(confirmpassword)) {
                    Toast.makeText(Signup.this, "Pleae enter confirmpassword", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {

                    Toast.makeText(Signup.this, "Password too short", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.VISIBLE);

                if (password.equals(confirmpassword)) {

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                      startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        Toast.makeText(Signup.this, "Registration Complete", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(Signup.this, "Authentication failed", Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });
                }

            }

        });

    }

}



