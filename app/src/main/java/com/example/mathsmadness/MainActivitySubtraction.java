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

    TextView textView_Timer, textView_Score, textView_Quest, textViewMessage;
    Button btn_start, btn_answer_1, btn_answer_2, btn_answer_3, btn_answer_4;
    ProgressBar progressBar;
    Quiz game = new Quiz();

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

            btn_answer_1.setEnabled(false);
            btn_answer_1.setVisibility(View.INVISIBLE);
            btn_answer_2.setEnabled(false);
            btn_answer_2.setVisibility(View.INVISIBLE);
            btn_answer_3.setEnabled(false);
            btn_answer_3.setVisibility(View.INVISIBLE);
            btn_answer_4.setEnabled(false);
            btn_answer_4.setVisibility(View.INVISIBLE);
            textViewMessage.setText("Times Up! " + game.getAmountCorrect() + "/" + (game.getTotalQuest()-1));

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

        View.OnClickListener startButtonCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button start_button = (Button) v;
                start_button.setVisibility(View.INVISIBLE);
                secondsLeft = 45;
                game = new Quiz();
                startQuiz();
                timer.start();
            }
        };

        View.OnClickListener answerBtnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button buttonClicked = (Button) v;
                int answerChosen = Integer.parseInt(buttonClicked.getText().toString());

                game.checkAnswer(answerChosen);
                textView_Score.setText(Integer.toString(game.getScore()) + " Pts");
                startQuiz();

            }
        };


        btn_start.setOnClickListener(startButtonCL);

        btn_answer_1.setOnClickListener(answerBtnClickListner);
        btn_answer_2.setOnClickListener(answerBtnClickListner);
        btn_answer_3.setOnClickListener(answerBtnClickListner);
        btn_answer_4.setOnClickListener(answerBtnClickListner);

    }

    private void startQuiz() {
        game.NewQuestion();
        int [] answer = game.getCurrentQuestion().getAnswerArray();

        btn_answer_1.setText(Integer.toString(answer[0]));
        btn_answer_2.setText(Integer.toString(answer[1]));
        btn_answer_3.setText(Integer.toString(answer[2]));
        btn_answer_4.setText(Integer.toString(answer[3]));

        btn_answer_1.setEnabled(true);
        btn_answer_1.setVisibility(View.VISIBLE);
        btn_answer_2.setEnabled(true);
        btn_answer_2.setVisibility(View.VISIBLE);
        btn_answer_3.setEnabled(true);
        btn_answer_3.setVisibility(View.VISIBLE);
        btn_answer_4.setEnabled(true);
        btn_answer_4.setVisibility(View.VISIBLE);

        textView_Quest.setText(game.getCurrentQuestion().getQuestionAsked());

        textViewMessage.setText(game.getAmountCorrect() + "/" + (game.getTotalQuest()-1));

    }

}