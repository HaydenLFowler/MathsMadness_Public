package com.example.mathsmadness;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivitySubtraction extends AppCompatActivity {

    TextView textView_Timer, textView_Score, textView_Quest_Sub, textViewMessage;
    Button btn_start, btn_answer_5, btn_answer_6, btn_answer_7, btn_answer_8;
    ProgressBar progressBar;
    QuizSubtraction gameS = new QuizSubtraction();

    int secondsLeft = 45;

    CountDownTimer timer = new CountDownTimer(45000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

            secondsLeft--;
            textView_Timer.setText(Integer.toString(secondsLeft) + "sec");
            progressBar.setProgress(45 - secondsLeft);

        }

        @Override
        public void onFinish() {

            btn_answer_5.setEnabled(false);
            btn_answer_5.setVisibility(View.INVISIBLE);
            btn_answer_6.setEnabled(false);
            btn_answer_6.setVisibility(View.INVISIBLE);
            btn_answer_7.setEnabled(false);
            btn_answer_7.setVisibility(View.INVISIBLE);
            btn_answer_8.setEnabled(false);
            btn_answer_8.setVisibility(View.INVISIBLE);
            textViewMessage.setText("Times Up! " + gameS.getAmountCorrect() + "/" + (gameS.getTotalQuest()-1));

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setVisibility(View.VISIBLE);
                }
            }, 5000);


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_subtraction);

        btn_start = findViewById(R.id.btn_start);
        btn_answer_5 = findViewById(R.id.btn_answer_5);
        btn_answer_6 = findViewById(R.id.btn_answer_6);
        btn_answer_7 = findViewById(R.id.btn_answer_7);
        btn_answer_8 = findViewById(R.id.btn_answer_8);

        textView_Score = findViewById(R.id.textView_Score);
        textView_Quest_Sub = findViewById(R.id.textView_Quest_Sub);
        textView_Timer = findViewById(R.id.textView_Timer);
        textViewMessage = findViewById(R.id.textViewMessage);

        progressBar = findViewById(R.id.progressBar);

        textView_Score.setText("0 pts");
        textView_Quest_Sub.setText("");
        textView_Timer.setText("0 Sec");
        textViewMessage.setText("Press Start");

        View.OnClickListener startButtonCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button start_button = (Button) v;
                start_button.setVisibility(View.INVISIBLE);
                secondsLeft = 45;
                gameS = new QuizSubtraction();
                startQuiz();
                timer.start();
            }
        };

        View.OnClickListener answerBtnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button buttonClicked = (Button) v;
                int answerChosen = Integer.parseInt(buttonClicked.getText().toString());

                gameS.checkAnswer(answerChosen);
                textView_Score.setText(Integer.toString(gameS.getScore()) + " Pts");
                startQuiz();

            }
        };


        btn_start.setOnClickListener(startButtonCL);

        btn_answer_5.setOnClickListener(answerBtnClickListner);
        btn_answer_6.setOnClickListener(answerBtnClickListner);
        btn_answer_7.setOnClickListener(answerBtnClickListner);
        btn_answer_8.setOnClickListener(answerBtnClickListner);

    }

    private void startQuiz() {
        gameS.NewQuestion();
        int [] answer = gameS.getCurrentQuestion().getAnswerArray();

        btn_answer_5.setText(Integer.toString(answer[0]));
        btn_answer_6.setText(Integer.toString(answer[1]));
        btn_answer_7.setText(Integer.toString(answer[2]));
        btn_answer_8.setText(Integer.toString(answer[3]));

        btn_answer_5.setEnabled(true);
        btn_answer_5.setVisibility(View.VISIBLE);
        btn_answer_6.setEnabled(true);
        btn_answer_6.setVisibility(View.VISIBLE);
        btn_answer_7.setEnabled(true);
        btn_answer_7.setVisibility(View.VISIBLE);
        btn_answer_8.setEnabled(true);
        btn_answer_8.setVisibility(View.VISIBLE);

        textView_Quest_Sub.setText(gameS.getCurrentQuestion().getQuestionAsked());

        textViewMessage.setText(gameS.getAmountCorrect() + "/" + (gameS.getTotalQuest()-1));

    }

}