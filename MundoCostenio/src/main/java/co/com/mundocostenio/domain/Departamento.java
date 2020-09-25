package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

public class Departamento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombreDepartamento;
	private Barrio barrio;
	
	public Departamento() {};
	
	public Departamento(int id, String nombreDepartamento, Barrio barrio) {
		this.id = id;
		this.nombreDepartamento = nombreDepartamento;
	}
	
	public Departamento(String string) {
		if(string != null){
			String[] parts = string.split("-");
			if(parts.length>0) this.id=Integer.parseInt(parts[0]);
			if(parts.length>1) this.nombreDepartamento=parts[1];
			}
	}
	
	public String getAsString() {
		String result =null;
		result = this.id+"-"+this.nombreDepartamento;
		return result;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
