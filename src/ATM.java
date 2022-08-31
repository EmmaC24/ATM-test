import java.util.HashMap;

public class ATM {
	private int id;
	private double balance;
	private HashMap <Integer, Double> accounts;
	
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
		if (!accounts.containsKey (accountID))
		{
			return 0.0;
		}
		else
		{
			return accounts.get (accountID);
		}
	}
	
	public boolean depositMoney (int accountID, double money)
	{
	
		if (accounts.containsKey (accountID))
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
		if (accounts.containsKey (accountID))
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
		ATM chaseBank = new ATM();
		
		chaseBank.openAccount(12, 5.0);
		System.out.println (chaseBank.checkBalance (12));
		chaseBank.withdrawMoney(12, 3.0);
		System.out.println (chaseBank.checkBalance (12));
		
		chaseBank.depositMoney(12, 100);
		System.out.println (chaseBank.checkBalance (12));
		
	}
}