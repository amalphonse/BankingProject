package client;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import common.Customer;

import banking.*;
public class ClientBanking {
	private final static String FIRSTNAME_ONE = "Enter first name of Customer 1";
	private final static String LASTNAME_ONE = "Enter last name of Customer 1";
	private final static String FIRSTNAME_TWO = "Enter first name of Customer 2";
	private final static String LASTNAME_TWO = "Enter last name of Customer 2";
	private final static String CHEKCING_BALANCE = "Enter initial checking balance";
	private final static String SAVING_BALANCE = "Enter initial saving balance";
	private final static String DEPOSIT = "Enter amount of deposit";
	private final static String WITHDRAW = "Enter amount of withdraw";
	private final static String TRANSFER = "Enter amount of transfer";	

	public static void main(String[] args) {
		Checking chkAcc;
		Saving savAcc;
		String firstName1 = getUserInput(FIRSTNAME_ONE);
		String lastName1 = getUserInput(LASTNAME_ONE);
		String firstName2 = getUserInput(FIRSTNAME_TWO);
		String lastName2 = getUserInput(LASTNAME_TWO);
		double checkBal = 0;
		double savBal = 0;
		double deposit = 0;
		double withdraw = 0;
		double transfer = 0;
		boolean retry = false;

		do{
			try {
				checkBal = Double.parseDouble(getUserInput(CHEKCING_BALANCE));
				savBal = Double.parseDouble(getUserInput(SAVING_BALANCE));
				deposit = Double.parseDouble(getUserInput(DEPOSIT));
				withdraw = Double.parseDouble(getUserInput(WITHDRAW));
				transfer = Double.parseDouble(getUserInput(TRANSFER));		
				retry = true;
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Invalid value!");
				//System.exit(0);
			}	
		}while (retry == false);

		DecimalFormat df = new DecimalFormat("#.##");
		try{
			chkAcc = new Checking(new Customer(firstName1,lastName1),checkBal);
			savAcc = new Saving(new Customer(firstName2,lastName2),savBal);
			try{
				chkAcc.depositAmount(deposit);
				savAcc.Withdraw(withdraw);

				StringBuffer output = new StringBuffer();
				output.append("Customer with checking account: "+chkAcc.getCustomerName());
				output.append("\nCustomer with saving account: "+savAcc.getCustomerName());
				output.append("\nBalance on Checking before transfer: "+chkAcc.get_balance());
				output.append("\nBalance on Saving before transfer: "+savAcc.get_balance());

				JOptionPane.showMessageDialog(null, output.toString());
				chkAcc.Transfer(transfer, savAcc);
				output = new StringBuffer();
				output.append("Balance on Checking after transfer: "+df.format(chkAcc.get_balance()));
				output.append("\nBalance on Saving after transfer: "+savAcc.get_balance());
				JOptionPane.showMessageDialog(null, output.toString());				
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null,ex.getMessage() + "\nThe application will terminate.");
				System.exit(0);
			}							
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}		
	}
	
	private static String getUserInput(String message){
		String input = JOptionPane.showInputDialog(null,message);
		if (input == null)
			System.exit(0);
		return input;
	}
}
