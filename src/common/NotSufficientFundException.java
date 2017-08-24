package common;

public class NotSufficientFundException extends Exception{
	private final static String  defaultMessage = "Not sufficient funds";
	//constructor with no params
	public NotSufficientFundException() {
		super(defaultMessage);
	}
	
	//constructor with 1 parameter
	public NotSufficientFundException(String message) {
		super(message);
	}
}
