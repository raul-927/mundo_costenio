package co.com.mundocostenio.enumerator;

import java.io.Serializable;

public enum RolesEnum implements Serializable{
	ADMIN(1, "Administrador"),
	USER(2, "Usuario"),
	STAF(3, "Staf personal de trabajo"),
	CLIENT(3, "Cliente");
	
	private int id;
	private String descripcion;
	
	
	private RolesEnum(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}


	public String getAsString() {
		return this.id+"-"+this.descripcion;
	}

}
