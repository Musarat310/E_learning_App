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

public class JavaActivity extends AppCompatActivity {
    Button btnjav;
    TextView txtjav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtjav = findViewById(R.id.youtubeLink);
        btnjav = findViewById(R.id.backButton);
        btnjav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(JavaActivity.this, DevelopingActivity.class);
                startActivity(next);
            }
        });

        txtjav = findViewById(R.id.youtubeLink);
        txtjav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/playlist?list=PL_c9BZzLwBRJLm0QETVj_XcN4jRsV4LkR&si=ocVnO_MN662i5sa4"));
                startActivity(intent);
            }
        });
    }
}