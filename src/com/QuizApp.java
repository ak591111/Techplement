package com;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizApp {
	static ArrayList<Quiz> quizzes=new ArrayList<Quiz>();
	static  Scanner scan=new Scanner(System.in);
	public static void main(String[] args) 
	{   



		System.out.println("-:Welcome to quiz App :-\n");
		System.out.println("MENU\n");
		boolean a=true;
		try {
			while(a) {
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
					a=false;
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 4.");

				}
			}
		} catch (Exception e) {
			System.out.println("Invalid choice. Please enter a number between 1 and 4.");
		}


	}

	private static void createQuiz() {
		System.out.println("Please Enter the Topic !");
		String topic = scan.next();
		Quiz quiz =new Quiz(topic);
		quizzes.add(quiz);
		System.out.println("Quiz created successfully!");

	}
	private static void addQuestion() {
		if(quizzes.isEmpty()) {
			System.out.println("No quizzes Found !");
			return;
		}
		System.out.println("Select a quiz to add a question to:");
		for (int i = 0; i < quizzes.size(); i++) {
			System.out.println(i + 1 + ": " + quizzes.get(i).getTopic());
		}
		int quizIndex = scan.nextInt();
		if (quizIndex < 1 || quizIndex > quizzes.size()) {
			System.out.println("Invalid choice. Please enter a number between 1 and " + quizzes.size());
			return;
		}
		scan.nextLine(); // Consume newline

		System.out.println("Enter the question:");
		String questiontext = scan.nextLine();

		ArrayList<String> options = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			System.out.println("Enter option " + (i + 1) + ":");
			options.add(scan.nextLine());
		}

		System.out.println("Enter the index of the correct answer (0-3):");
		int correctAnswerIndex = scan.nextInt();

		quizzes.get(quizIndex - 1).addQuestion(questiontext, options, correctAnswerIndex);
		System.out.println("Question added successfully to the quiz!");
	}


	private static void takeQuiz() {
		if (quizzes.isEmpty()) {
			System.out.println("No quizzes available. Please create a quiz first.");
			return;
		}

		// Display available quizzes
		System.out.println("Select a quiz to take:");
		for (int i = 0; i < quizzes.size(); i++) {
			System.out.println((i + 1) + ": " + quizzes.get(i).getTopic());
		}
		int quizIndex = scan.nextInt();
		if (quizIndex < 1 || quizIndex > quizzes.size()) {
			System.out.println("Invalid choice. Please enter a number between 1 and " + quizzes.size());
			return;
		}
		scan.nextLine(); // Consume newline

		Quiz quiz = quizzes.get(quizIndex - 1);
		int score = 0;

		System.out.println("You are taking the quiz on '" + quiz.getTopic() + "'.");
		for (int i = 0; i < quiz.getQuestions().size(); i++) {
			Question question = quiz.getQuestions().get(i);
			System.out.println("\nQuestion " + (i + 1) + ": " + question.getQuestionText());

			// Display options
			ArrayList<String> options = question.getOptions();
			for (int j = 0; j < options.size(); j++) {
				System.out.println((j + 1) + ": " + options.get(j));
			}

			// Accept user's answer
			System.out.print("Your answer: ");
			int userAnswerIndex = scan.nextInt();
			if (userAnswerIndex < 1 || userAnswerIndex > options.size()) {
				System.out.println("Invalid answer index. Please select a valid option.");
				i--; // Repeat the same question
				continue;
			}

			// Check if the answer is correct
			if (question.isCorrect(userAnswerIndex - 1)) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Incorrect!");
			}
		}

		// Display final score
		System.out.println("\nQuiz completed! Your score: " + score + "/" + quiz.getQuestions().size());
	}


}
