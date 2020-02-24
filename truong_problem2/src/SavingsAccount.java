
public class SavingsAccount {

	private static double annualInterestRate = 0;
	private static double savingsBalance = 0;
	
	public SavingsAccount(double savingsBalance1) {
		// TODO Auto-generated constructor stub
		savingsBalance = savingsBalance1;
	}

	public double calculateMonthlyInterest()
	{
		return savingsBalance = savingsBalance + ((savingsBalance * annualInterestRate) / 12);
	}
	
	public static void modifyInterestRate(double interestRate)
	{
		annualInterestRate = interestRate;	
	}
}
