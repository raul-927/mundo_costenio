package co.com.mundocostenio.domain;

import java.io.Serializable;

public class Direccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int direccionId;
	private Departamento departamento;
	
	public Direccion() {};
	
	public Direccion(int direccionId, Departamento departamento) {
		this.direccionId = direccionId;
		this.departamento = departamento;
	}
	
	public int getDireccionId() {
		return direccionId;
	}
	public void setDireccionId(int direccionId) {
		this.direccionId = direccionId;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setBarrio(Departamento departamento) {
		this.departamento = departamento;
	}
}
