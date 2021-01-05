package com.example.mathsmadness;

import java.util.ArrayList;
import java.util.List;

public class QuizSubtraction {

    private List<Question> question;
    private int amountCorrect;
    private int amountIncorrect;
    private int totalQuest;
    private int score;
    private Question currentQuestion;


    //sets start variables
    public QuizSubtraction() {

        amountCorrect = 0;
        amountIncorrect = 0;
        totalQuest = 0;
        score = 0;
        currentQuestion = new Question(15);
        question = new ArrayList<Question>();

    }

    //generates a new question
    public void NewQuestion() {

        currentQuestion = new Question(totalQuest * 2 + 5);
        totalQuest++;
        question.add(currentQuestion);
    }

    //validates correct answer selected and adjust scores
    public boolean checkAnswer(int selectedAnswer) {

        boolean isCorrect;
        if (currentQuestion.getAnswer() == selectedAnswer) {
            amountCorrect++;
            isCorrect=true;
        }
        else {
            amountIncorrect++;
            isCorrect=false;
        }

        score = amountCorrect * 10 - amountIncorrect * 20;
        return isCorrect;
    }


    //Getter and Setter

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public int getAmountCorrect() {
        return amountCorrect;
    }

    public void setAmountCorrect(int amountCorrect) {
        this.amountCorrect = amountCorrect;
    }

    public int getAmountIncorrect() {
        return amountIncorrect;
    }

    public void setAmountIncorrect(int amountIncorrect) {
        this.amountIncorrect = amountIncorrect;
    }

    public int getTotalQuest() {
        return totalQuest;
    }

    public void setTotalQuest(int totalQuest) {
        this.totalQuest = totalQuest;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

}
