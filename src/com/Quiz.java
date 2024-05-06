package com;

import java.util.ArrayList;

public class Quiz {
	private String topic;
	private ArrayList<Question>questions;
	public Quiz(String topic) 
	{
		this.topic = topic;
		this.questions = new ArrayList<Question>();
	}
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	public void addQuestion(Question question)
	{
		questions.add(question);
	}
	
	
}
