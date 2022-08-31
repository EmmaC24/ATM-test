import java.util.HashMap;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class ATM {
	private int id;
	private double balance;
	private HashMap <Integer, Double> accounts;
	NumberFormat roundy = new DecimalFormat ("0.00");
	
	public ATM()
	{
		accounts = new HashMap <Integer, Double>();
	}
	
	public void openAccount(int accountID)
	{
		id = accountID;
		balance = 0.0;
		if (!accounts.containsKey (id))
		{
			accounts.put (id, balance);
		}
	}
	
	public void openAccount(int accountID, double money)
	{
		id = accountID;
		balance = money;
		if (!accounts.containsKey(id)) 
		{
			accounts.put (id, balance);
		}
	}
	
	public void closeAccount(int accountID)
	{
		if (accounts.containsKey (accountID) && accounts.get(accountID) == 0.0)
			accounts.remove (accountID);
	}
	
	public double checkBalance(int accountID)
	{
		double currentBalance = 0.0;
		if (accounts.containsKey (accountID))
		{
			currentBalance = accounts.get(accountID);
		}
		
		if (accounts.containsKey (accountID))
		{
			currentBalance = Double.parseDouble(roundy.format(currentBalance));
			return currentBalance;
		}
		else
		{
			return 0.0;
		}
	}
	
	public boolean depositMoney (int accountID, double money)
	{
		if (accounts.containsKey (accountID) && money >= 0)
		{
			accounts.replace (accountID, accounts.get(accountID) + money);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean withdrawMoney (int accountID, double money)
	{
		if (accounts.containsKey (accountID) && money >= 0 && accounts.get(accountID) - money >= 0)
		{
			accounts.replace (accountID, (accounts.get(accountID) - money));
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main (String [] args)
	{
		//ATM chaseBank = new ATM();
		
		//chaseBank.openAccount(12, 5.0);
		//System.out.println (chaseBank.checkBalance (12));
		//chaseBank.withdrawMoney(12, 3.0);
		//System.out.println (chaseBank.checkBalance (12));
		
		//chaseBank.depositMoney(12, 100);
		//System.out.println (chaseBank.checkBalance (12));
		
		
		ATM chase = new ATM();
		
		chase.openAccount(00001);
		chase.openAccount(00002, 2500.0);
		
		chase.depositMoney(00001, 433.45);
		chase.depositMoney(00001, 434.77);
		chase.depositMoney(00001, 424.91);
		chase.depositMoney(00001, 474.10);
		chase.depositMoney(00002, 154.30);
		System.out.println(chase.checkBalance(00001)); // Should be 1767.23
		System.out.println(chase.checkBalance(00002)); // Should be 2654.30
		chase.withdrawMoney(00001, 100.00);
		chase.withdrawMoney(00001, 1000.00);
		System.out.println(chase.checkBalance(00001)); // Should be 667.23
		// Test Invalid Deposits
		chase.depositMoney(00003, -433.45);
		chase.depositMoney(00004, 32434.77);
		chase.depositMoney(01337, 128537424.91);
		chase.depositMoney(21504, 2343474.10);
		System.out.println(chase.checkBalance(00003)); // Should be 0.0
		System.out.println(chase.checkBalance(00004)); // Should be 0.0
		System.out.println(chase.checkBalance(01337)); // Should be 0.0
		System.out.println(chase.checkBalance(21504)); // Should be 0.0
		// Test Invalid Withdrawals
		chase.withdrawMoney(00001, -433.45);
		chase.withdrawMoney(00001, 32434.77);
		chase.withdrawMoney(01337, 128537424.91);
		chase.withdrawMoney(21504, -2343474.10);
		System.out.println(chase.checkBalance(00001)); // Should be 667.23
		System.out.println(chase.checkBalance(00001)); // Should be 667.23
		System.out.println(chase.checkBalance(01337)); // Should be 0.0
		System.out.println(chase.checkBalance(21504)); // Should be 0.0
		// Test other issues
		chase.withdrawMoney(00002, 2020.2);
		System.out.println(chase.checkBalance(00002)); // Should be 634.1 and 
		//not a fraction more!
		
		// Tests account close
		ATM bankOfAmerica = new ATM();
		
		bankOfAmerica.openAccount(002, 50.0);
		System.out.println(bankOfAmerica.checkBalance(002)); //should be 50.0
		bankOfAmerica.withdrawMoney(002, 50); 
		System.out.println(bankOfAmerica.checkBalance(002)); //should be 0.0
		bankOfAmerica.closeAccount(002);
		System.out.println (bankOfAmerica.withdrawMoney (002, 40.0)); //should be false
		

	}
}
