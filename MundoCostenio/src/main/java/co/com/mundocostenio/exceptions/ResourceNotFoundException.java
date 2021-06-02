package co.com.mundocostenio.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {}
	public ResourceNotFoundException(String message) {
		super(message);
		System.out.println("message: "+this.getMessage());
	}
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause)
		;System.out.println("message: "+this.getMessage());
		System.out.println("cause: "+this.getCause());
	}
	

}
