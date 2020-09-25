package co.com.mundocostenio.domain;

import java.io.Serializable;

public class Rol implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	
	public Rol() {}
	
	public Rol(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Rol(String string) {
		if(string !=null) {
			String[] parts = string.split("-");
			if(parts.length>0) this.id=Integer.parseInt(parts[0]);
			if(parts.length>1) this.nombre=parts[1];
		}
	}
	
	
	public String getAsString() {
		String result =null;
		result = this.id+"-"+this.nombre;
		return result;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
