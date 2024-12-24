package com.example.e_learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText loginemail, loginpassword;
    Button btn, btn1;
    TextView textViewpass;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Initialize FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // Check if user is already logged in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class); // Replace with your home activity
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginemail = findViewById(R.id.editTextTextPersonName);
        loginpassword = findViewById(R.id.editTextPassword);
        btn = findViewById(R.id.button);
        btn1 = findViewById(R.id.buttonreg);
        textViewpass = findViewById(R.id.textViewpassword);
        //textView = findViewById(R.id.textView2);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progress);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // Login button functionality
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String emailText = loginemail.getText().toString();
                String passwordText = loginpassword.getText().toString();

                // Input validation
                if (TextUtils.isEmpty(emailText)) {
                    loginemail.setError("Email is required!");
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                if (TextUtils.isEmpty(passwordText)) {
                    loginpassword.setError("Password is required!");
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                // Firebase login
                mAuth.signInWithEmailAndPassword(emailText, passwordText)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class); // Replace with your home activity
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Authentication Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
