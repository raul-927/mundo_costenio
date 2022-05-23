package co.com.mundocostenio.exceptions;

public class AccountingEntryNotMatchException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AccountingEntryNotMatchException() {}
	public AccountingEntryNotMatchException(String message) {
		super(message);
	}
	public AccountingEntryNotMatchException(String message, Throwable cause) {
		super(message, cause);
	}

}
