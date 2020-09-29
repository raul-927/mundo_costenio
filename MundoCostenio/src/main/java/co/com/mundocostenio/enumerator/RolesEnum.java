package co.com.mundocostenio.enumerator;

import java.io.Serializable;

public enum RolesEnum implements Serializable{
	ADMIN(1, "Administrador"),
	USER(2, "Usuario"),
	STAF(3, "Staf personal de trabajo"),
	CLIENT(3, "Cliente");
	
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
