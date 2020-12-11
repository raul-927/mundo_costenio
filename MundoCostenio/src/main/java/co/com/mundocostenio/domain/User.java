package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private Integer userId;
	@NotNull(message="nic no debe ser null")
	private String 	nic;
	
	@NotNull(message ="password no debe ser null")
	private String 	password;
	private boolean enabled;
	
	
	@NotNull(message ="roles no debe ser null")
	private List<Rol> roles;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
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
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

}
