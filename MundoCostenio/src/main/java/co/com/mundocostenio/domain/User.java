package co.com.mundocostenio.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int 	userId;
	@NotNull(message="nic no debe ser null")
	private String 	nic;
	
	@NotNull(message ="password no debe ser null")
	private String 	password;
	private boolean enabled;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getId() {
		id = userId;
		return id;
	}

}
