package com.example.e_learningapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KotlinActivity extends AppCompatActivity {
    Button btnkot;
    TextView txtkot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kotlin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtkot = findViewById(R.id.youtubeLink);
        btnkot = findViewById(R.id.backButton);
        btnkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(KotlinActivity.this, DevelopingActivity.class);
                startActivity(next);
            }
        });

        txtkot = findViewById(R.id.youtubeLink);
        txtkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/playlist?list=PLRKyZvuMYSIMW3-rSOGCkPlO1z_IYJy3G&si=QsoGjq5Awq3j-bwk"));
                startActivity(intent);
            }
        });

    }
}