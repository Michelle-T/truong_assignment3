import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	public static int x;
	static SecureRandom rand = new SecureRandom();
	static int rand_int1 = rand.nextInt(10);
	static int rand_int2 = rand.nextInt(10);
	static int userStringInt;
	static int min = 1;
	static int max = 4;
	
	public static void quiz()
	{
		x = rand_int1 * rand_int2;
		askQuestion();
	}
	
	public static void askQuestion()
	{
		System.out.println("How much is " + rand_int1 + " times " + rand_int2 + "?");
		readResponse();
	}
	
	public static void readResponse()
	{
		Scanner in = new Scanner(System.in);
		String userString = in.nextLine();
		userStringInt = Integer.parseInt(userString);
		isAnswerCorrect();
	}
	
	public static void isAnswerCorrect()
	{
		if (x == userStringInt)
		{
			displayCorrectResponse();
		}
		else
		{
			displayIncorrectResponse();
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
		askQuestion();
	}
	
	public static void main(String[] args) 
	{
		quiz();
	}
}