package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.com.mundocostenio.messageerror.BarrioErrorMessage;

public class Barrio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Integer		  id;
	
	private Integer 	  barrioId;
	
	@NotNull(message = BarrioErrorMessage.NOMBRE_BARRIO_NOT_NULL)
	@Size(min =3, max = 20, message =BarrioErrorMessage.NOMBRE_SIZE)
	private String 		  nombreBarrio;
	
	@NotNull(message = BarrioErrorMessage.DEPARTAMENTO_NOT_NULL)
	private Departamento  departamento;
	
	public Barrio() {};
	
	public Barrio(Integer barrioId, String nombreBarrio, Ubicacion ubicacion) {
		this.barrioId = barrioId;
		this.nombreBarrio = nombreBarrio;
		
	}
	
	public Integer getId() {
		id = barrioId;
		return id;
	}
	public Integer getBarrioId() {
		return barrioId;
	}
	public void setBarrioId(Integer barrioId) {
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
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barrioId == null) ? 0 : barrioId.hashCode());
		result += prime * result + ((nombreBarrio == null) ? 0 : nombreBarrio.hashCode());
		result += prime * result + ((departamento == null) ? 0 : departamento.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
}
