import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	public static int x;
	static int rand_int1;
	static int rand_int2;
	static int userStringInt;
	
	public static void quiz()
	{
		SecureRandom rand = new SecureRandom();
		
		rand_int1 = rand.nextInt(10);
		rand_int2 = rand.nextInt(10);
		
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
		System.out.println("Very good!");
	}
	
	public static void displayIncorrectResponse()
	{
		System.out.println("No. Please try again.");
		askQuestion();
	}
	
	
	public static void main(String[] args) 
	{
		quiz();
	}
}
