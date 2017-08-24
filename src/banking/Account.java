package banking;
import common.Customer;
import common.NotSufficientFundException;

public abstract class Account {
	private double balance;
	private Customer customer;
	
	//Constructor that only takes Customer.
	public Account(Customer c) {
		customer = c;
		
	}
	
	public Account(Customer c, double bal) throws Exception {
		customer = c;
		if(isValidAmt(bal)) {
			balance = bal;
		}else {
			throw new Exception("Not a valid balance..");
		}
	}
	
	private boolean isValidAmt(double val) {
		return (val >0 && val<1000000000);
	}
	
	public double get_balance() {
		return balance;
	}
	
	public String getCustomerName() {
		return customer.toString();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer cust) {
		customer = cust;
	}
	
	public double depositAmount(double amt) throws Exception {
		if(isValidAmt(amt)) {
			balance += amt;
			return balance;
		}else {
			throw new Exception("Not valid deposit amount!!");
		}
	}
	
	public double Withdraw(double Amount)throws NotSufficientFundException, Exception 
	{
		if (!isValidAmt(Amount))
		{
			throw new Exception("Not valid withdraw amount");
		}
		else if (Amount <= balance)
		{
			balance -= Amount;
			return balance;
		}
		else
		{
			throw new NotSufficientFundException("Insufficient fund: $" + balance);
		}
	}

	public double Transfer(double Amount, Account Acc)
	throws Exception{
		double sourceAcc = 0;
		double destAcc = 0;
		try
		{
			sourceAcc = this.balance;
			destAcc = Acc.get_balance();
			this.Withdraw(Amount);
			Acc.depositAmount(Amount);
			return this.balance;
		}	
		catch (Exception ex)
		{
			//rollback balances in case of failure 
			this.balance = sourceAcc;
			Acc.balance = destAcc;
			throw ex;
		}
	}

}


