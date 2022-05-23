package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import co.com.mundocostenio.enumerator.RolesEnum;

public class Rol implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer rolId;
	
	@NotNull(message="rol no debe ser null")
	private RolesEnum rol;
	
	public Rol() {}
	
	public Integer getId() {
		id = rolId;
		return id;
	}
	
	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rolId == null) ? 0 : rolId.hashCode());
		result += prime * result + ((rol == null) ? 0 : rol.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}

}
