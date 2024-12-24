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

public class SignUpActivity extends AppCompatActivity {
    EditText signupname, signupemail, signuppassword;
    TextView login;
    Button btnsignup;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and redirect to MainActivity.
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signupname = findViewById(R.id.editTextTextPersonName);
        signupemail = findViewById(R.id.editTextTextEmail);
        signuppassword = findViewById(R.id.editTextPassword);
        btnsignup = findViewById(R.id.button2);
        progressBar = findViewById(R.id.progress);
        login = findViewById(R.id.rtxtlogin);
        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
        btnsignup.setOnClickListener(view -> {
            String emailid = signupemail.getText().toString();
            String passwardid = signuppassword.getText().toString();

            if (TextUtils.isEmpty(emailid)) {
                Toast.makeText(SignUpActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(passwardid)) {
                Toast.makeText(SignUpActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                return;
            }
            progressBar.setVisibility(View.VISIBLE);

            mAuth.createUserWithEmailAndPassword(emailid, passwardid)
                    .addOnCompleteListener(task -> {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                            finish();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });
    }
}
