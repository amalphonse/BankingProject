package banking;

import common.Customer;
import common.NotSufficientFundException;


public class Saving extends Account {
	private double withdrawFee = 1.0;
	
	public Saving(Customer cust)
	{
		super(cust);
	}
	
	public Saving(Customer cust, double balance) throws Exception {
		super(cust,balance);
		
	}
	
	public Saving(Customer cust, double balance, double fee)
			throws Exception {
				super(cust, balance);
				if(isValidFee(fee))
					withdrawFee = fee;
				else
					throw new Exception("Invalid withdraw fee value");
			}
	
	public double Withdraw(double Amount) throws NotSufficientFundException, Exception{
		super.Withdraw(Amount+withdrawFee);
		return super.get_balance();
	}
	
	public double getWithdrawFee() {
		return withdrawFee;
	}
	
	public void setWithdrawFee(double withdrawFee) throws Exception {
		if(isValidFee(withdrawFee) == true) {
			this.withdrawFee = withdrawFee;
			
		}
		else {
			throw new Exception("Invalid withdraw fee value");
		}
	}
	
	private boolean isValidFee(double val) {
		return(val >0 && val <100);
	}

}
