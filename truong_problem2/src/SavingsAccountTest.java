
public class SavingsAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount.modifyInterestRate(0.04);
		
		//arrays to hold the values of the interest'ed balances
		double savings1[] = new double[13];
		double savings2[] = new double[13];
		int month = 1;
		
		//String format for table
		System.out.println(String.format("%s %10s %16s", "Month", "Saver1", "Saver 2"));
		
		//first for loop for saver1
		for (int i = 0; i < 12; i++)
		{
			savings1[i] = saver1.calculateMonthlyInterest();
		}
		
		//calculate saver1 balance with interest of 5%
		SavingsAccount.modifyInterestRate(0.05);
		savings1[12] = saver1.calculateMonthlyInterest();
		
		//saver2 with interest of 4% with for loop
		SavingsAccount saver2 = new SavingsAccount(3000);
		SavingsAccount.modifyInterestRate(0.04);
		for (int a = 0; a < 12; a++)
		{
			savings2[a] = saver2.calculateMonthlyInterest();
		}
		
		//saver2 with interest of 5%
		SavingsAccount.modifyInterestRate(0.05);
		savings2[12] = saver2.calculateMonthlyInterest();
		
		//prints out the first 9 months for both in a table
		for (int x = 0; x < 9; x++)
		{
			System.out.println(String.format("%s %15s %15s", month, String.format("%.2f", savings1[x]), String.format("%.2f", savings2[x])));
			month++;
		}		
		
		//prints out the last 3 months in a table
		for (int x = 9; x < 13; x++)
		{
			System.out.println(String.format("%s %14s %15s", month, String.format("%.2f", savings1[x]), String.format("%.2f", savings2[x])));
			month++;
		}
	}

}
