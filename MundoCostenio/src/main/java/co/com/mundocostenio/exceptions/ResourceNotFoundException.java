package co.com.mundocostenio.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private Throwable cause;
	
	public ResourceNotFoundException() {}
	public ResourceNotFoundException(String message) {
		super(message);
		this.message = message;
		System.out.println("message: "+this.getMessage());
	}
	public ResourceNotFoundException(String message, Throwable cause) {
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
