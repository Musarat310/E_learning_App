package com.example.e_learningapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class takeTestActivity extends AppCompatActivity {
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_take_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RadioGroup question1Group = findViewById(R.id.question1Group);
        RadioGroup question2Group = findViewById(R.id.question2Group);
        Button submitButton = findViewById(R.id.submitButton);
        TextView resultText = findViewById(R.id.resultText);

        // Reset score on new test
        score = 0;

        // Submit button click listener
        submitButton.setOnClickListener(v -> {
            // Check answers for each question
            if (question1Group.getCheckedRadioButtonId() == R.id.q1_answer2) {
                score++;
            }
            if (question2Group.getCheckedRadioButtonId() == R.id.q2_answer1) {
                score++;
            }


            // Display result
            resultText.setText("Your score: " + score + "/3");

            // Disable the submit button after submission
            submitButton.setEnabled(false);
        });
    }
}