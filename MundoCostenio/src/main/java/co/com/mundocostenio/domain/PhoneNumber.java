package co.com.mundocostenio.domain;

import java.io.Serializable;

public class PhoneNumber implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String countryCode;
	private String stateCode;
	private String number;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

}
