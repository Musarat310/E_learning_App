package com.example.e_learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DevelopingActivity extends AppCompatActivity {

    Button btnjava, btnkotlin, btntest, btnui, btnflutter, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_developing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnjava = findViewById(R.id.javaButton);
        btnflutter = findViewById(R.id.FlutterButton);
        btnkotlin = findViewById(R.id.KotlinButton);
        btntest = findViewById(R.id.takeTestButton);
        btnui = findViewById(R.id.UiUxButton);
        home = findViewById(R.id.bthome);

        btnjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(DevelopingActivity.this, JavaActivity.class);
                startActivity(next);
            }
        });

        btnflutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(DevelopingActivity.this, FlutterActivity.class);
                startActivity(next);
            }
        });

        btnkotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(DevelopingActivity.this, KotlinActivity.class);
                startActivity(next);
            }
        });

        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(DevelopingActivity.this, takeTestActivity.class);
                startActivity(next);
            }
        });
        btnui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(DevelopingActivity.this, UiUxActivity.class);
                startActivity(next);

            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(DevelopingActivity.this, IntroActivity.class);
                startActivity(next);

            }
        });

    }
}