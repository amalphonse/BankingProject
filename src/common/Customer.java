package common;

public class Customer {
	
	private String fName;
	private String lName;
	
	public Customer(String firstName, String lastName) throws Exception{
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public String getFirstName()
	{
		return fName;
	}
	
	public String getLastName()
	{
		return lName;
	}
	
	public void setLastName(String value) throws Exception
	{
		if(isValidName(value) == true) {
			lName = value;
		}
		else {
			throw new Exception("Value for last name is not valid.");
		}
	}
	
	public void setFirstName(String value) throws Exception{
		if(isValidName(value) == true) {
			fName = value;
		}
		else {
			throw new Exception("Value for first name is not valid.");
		}
	}
	
	private boolean isValidName(String val) {
		
		if(val.length() > 20) {
			return false;
		}
		
		//use regular expression to check if the val contains only 
    	//from 'a' to 'z' and from 'A' to 'Z'
        String regExpr = "[a-zA-Z]+";
        if (!val.matches(regExpr))
              return false;
        return true;
	}

	//overrides Object.toString() method
    public String toString(){
        return lName + ", " + fName; 
    }
	
}
