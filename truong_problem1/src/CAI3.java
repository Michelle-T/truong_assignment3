import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	public static int x;
	static SecureRandom rand = new SecureRandom();
	static int rand_int1;
	static int rand_int2;
	static int userString;
	static int min = 1;
	static int max = 4;
	static float correct = 0;
	static float incorrect = 0;
	static int userDifficulty;
	
	public static void quiz()
	{
		correct = 0;
		incorrect = 0;

		askQuestion();
		displayCompletionMessage();
	}
	
	public static void askQuestion()
	{
		//int i;
		for (int i = 1; i < 11; i++)
		{
			rand_int1 = rand.nextInt(10);
			rand_int2 = rand.nextInt(10);
			x = rand_int1 * rand_int2;
			System.out.println("Question: " + i);
			System.out.println("How much is " + rand_int1 + " times " + rand_int2 + "?");
			readResponse();
		}
	}
	
	public static void readResponse()
	{
		Scanner in = new Scanner(System.in);
		userString = in.nextInt();
		isAnswerCorrect();
	}
	
	public static void isAnswerCorrect()
	{
		if (x == userString)
		{
			displayCorrectResponse();
			correct ++;
		}
		else
		{
			displayIncorrectResponse();
			incorrect ++;
		}
	}
	
	public static void displayCorrectResponse()
	{
		String correctResponse;
		switch (rand.nextInt((max - min) + min) + 1)
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
		case 4:
			correctResponse = "Keep up the good work!";
			break;
		default:
			correctResponse = "Very good!";
			break;
		}
		System.out.println(correctResponse);
		//quiz();
	}
	
	public static void displayIncorrectResponse()
	{
		String incorrectResponse;
		switch (rand.nextInt((max - min) + min) + 1)
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
		case 4:
			incorrectResponse = "No. Keep trying.";
			break;
		default:
			incorrectResponse = "No. Please try again.";
		}
		System.out.println(incorrectResponse);
		//quiz();
	}
	
	public static void displayCompletionMessage()
	{
		float result = (correct/10);
		result = result * 100;
		
		String userRestart = null;
		
		if (result <= 74.0)
		{
			System.out.println("Your result is: " + result + "%");
			System.out.println("Please ask your teacher for extra help.");
			System.out.println("Would you like to restart the quiz?");
			Scanner in1 = new Scanner(System.in);
			userRestart = in1.nextLine();
		}
		else if (result >= 75.0)
		{
			System.out.println("Your result is: " + result + "%");
			System.out.println("Congratulations, you are ready to go to the next level!");
			System.out.println("Would you like to restart the quiz?");
			Scanner in1 = new Scanner(System.in);
			userRestart = in1.nextLine();
		}
		if (userRestart.equals("No") || userRestart.equals("n"))
		{
			System.exit(0);
		}
		else if (userRestart.equals("Yes") || userRestart.equals("y"))
		{
			quiz();
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		quiz();
	}
}