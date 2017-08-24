package banking;

import common.Customer;

public class Checking extends Account {
	public Checking(Customer cust)
	{
		//delegate construction to the parent
		super(cust);
	}

	public Checking(Customer cust, double bal)
	throws Exception {
		//delegate construction to the parent
		super(cust, bal);
	}
}
