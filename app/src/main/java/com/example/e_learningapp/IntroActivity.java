package com.example.e_learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntroActivity extends AppCompatActivity {

    Button btndev, btndes, btnal, btnex, btnsee;
    ImageView pfbtn, ctbtn, setbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btndev = findViewById(R.id.buttondeveloping);
        btndes = findViewById(R.id.buttondesigning);
        btnal = findViewById(R.id.buttonalml);
        btnex = findViewById(R.id.buttonexplore);
        btnsee = findViewById(R.id.seeall);
        pfbtn = findViewById(R.id.imageViewbtn2);
        ctbtn = findViewById(R.id.imageViewbtn3);
        setbtn = findViewById(R.id.imageViewbtn4);

        btndev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(IntroActivity.this, DevelopingActivity.class);
                startActivity(next);
            }
        });

        btndes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(IntroActivity.this, DesignActivity.class);
                startActivity(next);
            }
        });

        btnal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(IntroActivity.this, AiandMlActivity.class);
                startActivity(next);
            }
        });
        btnex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(IntroActivity.this, ExploreActivity.class);
                startActivity(next);
            }
        });
        pfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        ctbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });
        setbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        btnsee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(IntroActivity.this, SeeallActivity.class);
                startActivity(next);
            }
        });
    }
}