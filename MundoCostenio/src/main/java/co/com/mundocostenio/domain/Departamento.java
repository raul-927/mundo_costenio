package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Departamento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer		id;
	private Integer 	departamentoId;
	private String 		nombreDepartamento;

	public Departamento() {};
	
	public Departamento(int departamentoId, String nombreDepartamento) {
		this.departamentoId = departamentoId;
		this.nombreDepartamento = nombreDepartamento;
		
	}
	
	public Integer getId() {
		id = departamentoId;
		return id;
	}
	public Integer getDepartamentoId() {
		return departamentoId;
	}
	public void setDepartamentoId(Integer departamentoId) {
		this.departamentoId = departamentoId;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departamentoId == null) ? 0 : departamentoId.hashCode());
		result += prime * result + ((nombreDepartamento == null) ? 0 : nombreDepartamento.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}

}
