package co.com.mundocostenio.exceptions;


public class BindingResultException extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	private String message;
	private Throwable cause;
	
	public BindingResultException() {}
	public BindingResultException(String message) {
		super(message);
		this.message = message;
		System.out.println("message: "+this.getMessage());
	}
	public BindingResultException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.cause = cause;
		System.out.println("message: "+this.getMessage());
		System.out.println("cause: "+this.getCause());
	}
	public String getMessage() {
		return message;
	}
	/**
	 * @return the cause
	 */
	public Throwable getCause() {
		return cause;
	}
	

}
