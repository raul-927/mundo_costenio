package co.com.mundocostenio.enumerator;

import java.io.Serializable;

public enum RolesEnum implements Serializable{
	ADMIN(1, "ROLE_ADMIN"),
	USER(2, "ROLE_USER"),
	COUNTER(3, "ROLE_COUNTER"),
	SALES(4, "ROLE_SALES"),
	GUESS(5,"ROLE_GUESS"),
	ANONIMOUS(6,"ROLE_ANONIMOUS");
	
	private int rolId;
	private String descripcion;
	
	
	private RolesEnum(int rolId, String descripcion) {
		this.rolId = rolId;
		this.descripcion = descripcion;
	}
	
	
	public int getRolId() {
		return this.rolId;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}


	public String getAsString() {
		return this.rolId+"-"+this.descripcion;
	}

}
