package com;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizApp {
	public static void main(String[] args) 
	{   ArrayList<Quiz> quizzes = new ArrayList<>();
    
		Scanner scan=new Scanner(System.in);
		boolean a=true;
		while(a) 
		{
			System.out.println("-:Welcome to quiz App :-\n");
			System.out.println("MENU\n");

			System.out.println("1. Create a quiz");
			System.out.println("2. Add a question to a quiz");
			System.out.println("3. Take a quiz");
			System.out.println("4. Exit\n");
			System.out.print("Enter your choice: ");
			int choice=scan.nextInt();
			switch(choice) 
			{
			case 1:
				createQuiz();
				break;
			case 2:
				addQuestion();
				break;
			case 3:
				takeQuiz();
				break;
			case 4:
				System.out.println("Exiting the Quiz App. THANK YOU !");
				a = false;
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 4.");

			}
		} 

	}

	private static void createQuiz() {
		// TODO Auto-generated method stub
		
	}

	private static void takeQuiz() {
		// TODO Auto-generated method stub
		System.out.println("taking quiz");

	}

	private static void addQuestion()
	{
		
	
	}
	}
