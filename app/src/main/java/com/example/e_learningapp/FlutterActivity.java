package com.example.e_learningapp;

import android.annotation.SuppressLint;
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

public class FlutterActivity extends AppCompatActivity {
    Button backButton;
    TextView youtubeLink;
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_flutter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        backButton = findViewById(R.id.backButton);
        youtubeLink = findViewById(R.id.youtubeLink);

        // Set up click listener to go back to DevelopingActivity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlutterActivity.this, DevelopingActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Set YouTube playlist link
        youtubeLink.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/playlist?list=PLjVLYmrlmjGfGLShoW0vVX_tcyT8u1Y3E&si=K9nj8uADG1YRWN8R"));
            startActivity(intent);
        });
    }
}