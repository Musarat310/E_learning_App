package com.example.e_learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SeeallActivity extends AppCompatActivity {
    Button btn;

    private ListView listView;
    private String[] items = {
            "Android Development",
            "Flutter Development",
            "UI/UX Design",
            "Machine Learning",
            "Artificial Intelligence"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeall);

        listView = findViewById(R.id.lView);
        btn = findViewById(R.id.backButton);

        // Create and set the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, // Built-in layout for list items
                items
        );
        listView.setAdapter(adapter);

        // Set click listener for list items
        listView.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            String selectedItem = items[position];
            Toast.makeText(this, "Clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeeallActivity.this, IntroActivity.class);
                startActivity(intent);
            }
        });
    }
}
