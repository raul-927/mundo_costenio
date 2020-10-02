package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Barrio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 		  barrioId;
	private String 		  nombreBarrio;
	private Departamento  departamento;
	
	public Barrio() {};
	
	public Barrio(int barrioId, String nombreBarrio, Ubicacion ubicacion) {
		this.barrioId = barrioId;
		this.nombreBarrio = nombreBarrio;
		
	}
	
	public int getBarrioId() {
		return barrioId;
	}
	public void setBarrioId(int barrioId) {
		this.barrioId = barrioId;
	}
	public String getNombreBarrio() {
		return nombreBarrio;
	}
	public void setNombreBarrio(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
