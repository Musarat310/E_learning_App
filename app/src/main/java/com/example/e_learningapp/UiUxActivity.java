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

public class UiUxActivity extends AppCompatActivity {
    Button btnui;
    TextView txtui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ui_ux);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtui = findViewById(R.id.youtubeLink);
        btnui = findViewById(R.id.backButton);
        btnui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(UiUxActivity.this, DevelopingActivity.class);
                startActivity(next);
            }
        });

        txtui = findViewById(R.id.youtubeLink);
        txtui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/playlist?list=PLpKyNBYcYNJec4bUTVZUqxBQF5ezd96RT&si=Y2KWZ9xLzp88v5Gk"));
                startActivity(intent);
            }
        });
    }
}