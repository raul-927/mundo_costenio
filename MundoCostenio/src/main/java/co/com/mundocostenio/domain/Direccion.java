package co.com.mundocostenio.domain;

import java.io.Serializable;

public class Direccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Departamento departamento;
	
	public Direccion() {};
	
	public Direccion(int id, Departamento departamento) {
		this.id = id;
		this.departamento = departamento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setBarrio(Departamento departamento) {
		this.departamento = departamento;
	}
}
