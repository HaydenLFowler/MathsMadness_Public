package com.example.mathsmadness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextView textView_Timer, textView_Score, textView_Quest, textViewMessage;
    Button btn_start, btn_answer_1, btn_answer_2, btn_answer_3, btn_answer_4;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_answer_1 = findViewById(R.id.btn_answer_1);
        btn_answer_2 = findViewById(R.id.btn_answer_2);
        btn_answer_3 = findViewById(R.id.btn_answer_3);
        btn_answer_4 = findViewById(R.id.btn_answer_4);

        textView_Score = findViewById(R.id.textView_Score);
        textView_Quest = findViewById(R.id.textView_Quest);
        textView_Timer = findViewById(R.id.textView_Timer);
        textViewMessage = findViewById(R.id.textViewMessage);

        progressBar = findViewById(R.id.progressBar);

        textView_Score.setText("0 pts");
        textView_Quest.setText("");
        textView_Timer.setText("0 Sec");
        textViewMessage.setText("Press Start");

    }

}