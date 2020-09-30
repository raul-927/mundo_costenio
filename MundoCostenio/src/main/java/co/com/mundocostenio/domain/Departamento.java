package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

public class Departamento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int departamentoId;
	private String nombreDepartamento;
	private List<Barrio> barrios;
	
	public Departamento() {};
	
	public Departamento(int departamentoId, String nombreDepartamento, List<Barrio> barrios) {
		this.departamentoId = departamentoId;
		this.nombreDepartamento = nombreDepartamento;
		this.barrios = barrios;
	}
	
	
	public int getDepartamentoId() {
		return departamentoId;
	}
	public void setDepartamentoId(int departamentoId) {
		this.departamentoId = departamentoId;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public List<Barrio> getBarrios() {
		return barrios;
	}

	public void setBarrio(List<Barrio> barrios) {
		this.barrios = barrios;
	}
}
