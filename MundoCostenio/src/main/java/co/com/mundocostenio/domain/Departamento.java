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
	private Barrio barrio;
	
	public Departamento() {};
	
	public Departamento(int departamentoId, String nombreDepartamento, Barrio barrio) {
		this.departamentoId = departamentoId;
		this.nombreDepartamento = nombreDepartamento;
	}
	
	public Departamento(String string) {
		if(string != null){
			String[] parts = string.split("-");
			if(parts.length>0) this.departamentoId=Integer.parseInt(parts[0]);
			if(parts.length>1) this.nombreDepartamento=parts[1];
			}
	}
	
	public String getAsString() {
		String result =null;
		result = this.departamentoId+"-"+this.nombreDepartamento;
		return result;
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

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
}
