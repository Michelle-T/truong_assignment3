import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	static int x[] = new int[10];
	static SecureRandom rand = new SecureRandom();
	static int rand_int1[] = new int[10];
	static int rand_int2[] = new int[10];
	static int userString;
	//static int min = 1;
	//static int max = 4;
	static float correct = 0;
	static float incorrect = 0;
	static int userDifficulty;
	static int userArithmetic;
	static String typeOfProblem[] = new String[10];
	static int b = 0;
	static int rand_operation;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		quiz();
	}
	
	//quiz method that handles the order of tasks
	public static void quiz()
	{
		readDifficulty();
		generateQuestionArgument();
		readProblemType();
		askQuestion();
		displayCompletionMessage();
	}
	
	//reads user difficulty setting
	public static void readDifficulty()
	{
		System.out.println("What difficulty level would you like to do? (Ex. 1, 2, 3, or 4?)");
		Scanner in = new Scanner(System.in);
		userDifficulty = in.nextInt();
	}
	
	//read what kind of problems the user wants to do and makes array of the answers
	public static void readProblemType()
	{
		System.out.println("What arithmetic problems would you like to study?");
		System.out.println("1 = Addition, 2 = Multiplication, 3 = Subtraction, 4 = Division, and 5 = Random Mixture");
		Scanner in = new Scanner(System.in);
		userArithmetic = in.nextInt();
		if (userArithmetic == 1)
		{
			for (int i = 0; i < 10; i++)
			{
				typeOfProblem[i] = " plus ";
				x[i] = rand_int1[i] + rand_int2[i];
			}
		}
		else if (userArithmetic == 2)
		{
			for (int i = 0; i < 10; i++)
			{
				typeOfProblem[i] = " times ";
				x[i] = rand_int1[i] * rand_int2[i];
			}
		}
		else if (userArithmetic == 3)
		{
			for (int i = 0; i < 10; i++)
			{
				typeOfProblem[i] = " minus ";
				x[i] = rand_int1[i] - rand_int2[i];
			}
		}
		else if (userArithmetic == 4)
		{
			for (int i = 0; i < 10; i++)
			{
				typeOfProblem[i] = " divided by ";
				
				//exception handling
				try 
				{
					x[i] = rand_int1[i] / rand_int2[i];
				}
				catch(ArithmeticException e)
				{
					//System.out.println("exception / zero");
				}  
			}
		}
		else if (userArithmetic == 5)
		{
			//tried to use a switch statement, if works better for me
			for (int i = 0; i < 10; i++)
			{
				rand_operation = (rand.nextInt(4));
				/*switch (rand.nextInt((max - min) + min) + 1)
				{
				case 1:*/
				if (rand_operation == 0)
				{
					
					typeOfProblem[i] = " plus ";
					x[i] = rand_int1[i] + rand_int2[i];
				}
				
				//case 2:
				else if (rand_operation == 1)
				{
					typeOfProblem[i] = " times ";
					x[i] = rand_int1[i] * rand_int2[i];
				}
				//case 3:
				else if (rand_operation == 2)
				{
					typeOfProblem[i] = " minus ";
					x[i] = rand_int1[i] - rand_int2[i];
				}
				//case 4:
				else if (rand_operation == 3)
				{
					typeOfProblem[i] = " divided by ";
					
					//exception handling
					try 
					{
						x[i] = rand_int1[i] / rand_int2[i];
					}
					catch(ArithmeticException e)
					{
						//System.out.println("exception / zero");
					}  
				}
			}
		}
	}
	
	//creates random ints depending on what difficulty the user wanted
	public static void generateQuestionArgument()
	{
		if (userDifficulty == 1)
		{
			for (int i = 0; i < 10; i++)
			{
			rand_int1[i] = rand.nextInt(10);
			rand_int2[i] = rand.nextInt(10);
			}
			//askQuestion();
		}
		else if (userDifficulty == 2)
		{
			for (int i = 0; i < 10; i++)
			{
			rand_int1[i] = rand.nextInt(100);
			rand_int2[i] = rand.nextInt(100);
			}
			//askQuestion();
		}
		else if (userDifficulty == 3)
		{
			for (int i = 0; i < 10; i++)
			{
			rand_int1[i] = rand.nextInt(1000);
			rand_int2[i] = rand.nextInt(1000);
			}
			//askQuestion();
		}
		else if (userDifficulty == 4)
		{
			for (int i = 0; i < 10; i++)
			{
			rand_int1[i] = rand.nextInt(10000);
			rand_int2[i] = rand.nextInt(10000);
			}
			//askQuestion();
		}
	}
	
	//asks the questions from the array of ints
	public static void askQuestion()
	{
		int n = 0;
		for (int i = 0; i < 10; i++)
		{
			n++;
			//x = rand_int1[i] * rand_int2[i];
			System.out.println("\nQuestion " + n + ":");
			System.out.println("How much is " + rand_int1[i] + typeOfProblem[i] + rand_int2[i] + "?");
			//quick answers to bugtest
			//System.out.println("The result is: " + x[i]);
			readResponse();
		}
	}
	
	//reads the users responses
	public static void readResponse()
	{
		Scanner in = new Scanner(System.in);
		userString = in.nextInt();
		isAnswerCorrect();
	}
	
	//compares the users responses to the correct answer from the array of answers
	public static void isAnswerCorrect()
	{
		if (x[b] == userString)
		{
			correct ++;
			b++;
			displayCorrectResponse();
		}
		else
		{
			incorrect ++;
			b++;
			displayIncorrectResponse();
		}
	}
	
	//displays positive response if correct
	public static void displayCorrectResponse()
	{
		String correctResponse;
		switch (rand.nextInt(3))
		{
		case 1:
			correctResponse = "Very good!";
			break;
		case 2:
			correctResponse = "Excellent!";
			break;
		case 3:
			correctResponse = "Nice work!";
			break;
		default:
			correctResponse = "Keep up the good work!";
			break;
		}
		System.out.println(correctResponse);
	}
	
	//displays incorrect response if incorrect
	public static void displayIncorrectResponse()
	{
		String incorrectResponse;
		switch (rand.nextInt(3))
		{
		case 1:
			incorrectResponse = "No. Please try again.";
			break;
		case 2:
			incorrectResponse = "Wrong. Try once more.";
			break;
		case 3:
			incorrectResponse = "Don't give up!";
			break;
		default:
			incorrectResponse = "No. Keep trying.";
			break;
		}
		System.out.println(incorrectResponse);
	}
	
	//when user reaches the end of the array, user gets the number correct, 
	//appropriate choices are given and user given choice to restart quiz or not
	//arrays and values are reset if the user wishes to restart
	public static void displayCompletionMessage()
	{
		float result = (correct/10);
		result = result * 100;
		
		String userRestart = null;
		
		if (result <= 74.0)
		{
			System.out.println("\nYour result is: " + result + "%");
			System.out.println("Please ask your teacher for extra help.");
			System.out.println("Would you like to restart the quiz?");
			Scanner in1 = new Scanner(System.in);
			userRestart = in1.nextLine();
		}
		else if (result >= 75.0)
		{
			System.out.println("\nYour result is: " + result + "%");
			System.out.println("Congratulations, you are ready to go to the next level!");
			System.out.println("Would you like to restart the quiz? (y/n)");
			Scanner in1 = new Scanner(System.in);
			userRestart = in1.nextLine();
		}
		//system exits if the users says no
		if (userRestart.equals("No") || userRestart.equals("n"))
		{
			System.exit(0);
		}
		//arrays and values are reset if the user wishes to restart
		else if (userRestart.equals("Yes") || userRestart.equals("y"))
		{
			correct = 0;
			incorrect = 0;
			b = 0;
			int x[] = new int[10];
			int rand_int1[] = new int[10];
			int rand_int2[] = new int[10];
			String typeOfProblem[] = new String[10];
			quiz();
		}
	}
}