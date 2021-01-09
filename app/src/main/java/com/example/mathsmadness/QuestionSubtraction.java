package com.example.mathsmadness;

import java.util.Random;

public class QuestionSubtraction {

    private int firstNumber;
    private int secondNumber;
    private int answer;

    //Answer options and the option chosen
    private int [] answerArray;
    private int answerPos;

    //Limits the first or second number to a certain value - difficulty level
    private int upperLimit;

    //written question
    private String questionAsked;

    //creates random question
    public QuestionSubtraction(int upperLimit){
        this.upperLimit = upperLimit;
        Random randomNumber = new Random();

        this.firstNumber = randomNumber.nextInt(upperLimit);
        this.secondNumber = randomNumber.nextInt(upperLimit);


        //Makes sure the question and answer always produce a positive answer
        if(this.firstNumber < this.secondNumber){
            this.answer = this.secondNumber - this.firstNumber;
            this.questionAsked = secondNumber + "-" + firstNumber + "=";
        }
        else {this.answer = this.firstNumber - this.secondNumber;
        this.questionAsked = firstNumber + "-" + secondNumber + "=";}

        this.answerPos = randomNumber.nextInt(4);
        this.answerArray = new int[] {0,1,2,3};

        this.answerArray[0] = answer + 1;
        this.answerArray[0] = answer + 3;
        this.answerArray[0] = answer - 2;
        this.answerArray[0] = answer - 1;

        this.answerArray = shuffleArray(this.answerArray);

        answerArray [answerPos] = answer;
    }

    //shuffles answers to random positions
    private int [] shuffleArray(int[] array){
        int index, temp;
        Random randomNumberGen = new Random();

        for(int i = array.length - 1; i > 0; i--){
            index = randomNumberGen.nextInt(i +1);
            temp = array[index];
            array[index] =array[i];
            array[i] = temp;
        }
        return array;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPos() {
        return answerPos;
    }

    public void setAnswerPos(int answerPos) {
        this.answerPos = answerPos;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionAsked() {
        return questionAsked;
    }

    public void setQuestionAsked(String questionAsked) {
        this.questionAsked = questionAsked;
    }
}
