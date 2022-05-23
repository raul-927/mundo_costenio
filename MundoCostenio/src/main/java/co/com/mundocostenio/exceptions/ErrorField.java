package co.com.mundocostenio.exceptions;

import java.io.Serializable;

public class ErrorField implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String defaultMessage;
	private String field;
	public String getDefaultMessage() {
		return defaultMessage;
	}
	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

}
