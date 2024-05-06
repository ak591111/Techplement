package com;

import java.util.ArrayList;

public class Question {
	private String questionText;
    private ArrayList<String> options;
    private int correctAnswerIndex;

    public Question(String questionText, ArrayList<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Getter methods

    public boolean isCorrect(int userAnswerIndex) {
        return userAnswerIndex == correctAnswerIndex;
    }

}
