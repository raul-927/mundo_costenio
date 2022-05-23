package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.com.mundocostenio.enumerator.EstadoCajaEnum;

public class Caja implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	private int				id;
	
	private int 			cajaId;
	private EstadoCajaEnum 	estado;
	private LocalDate 		cajaFecha;
	private LocalTime 		cajaHora;
	private String 			cajaUsr;
	
	public int getId() {
		id = cajaId;
		return id;
	}
	public int getCajaId() {
		return cajaId;
	}
	public void setCajaId(int cajaId) {
		this.cajaId = cajaId;
	}
	
	public String getCajaUsr() {
		return cajaUsr;
	}
	public void setCajaUsr(String cajaUsr) {
		this.cajaUsr = cajaUsr;
	}
	public EstadoCajaEnum getEstado() {
		return estado;
	}
	public void setEstado(EstadoCajaEnum estado) {
		this.estado = estado;
	}
	public LocalDate getCajaFecha() {
		return cajaFecha;
	}
	public void setCajaFecha(LocalDate cajaFecha) {
		this.cajaFecha = cajaFecha;
	}
	public LocalTime getCajaHora() {
		return cajaHora;
	}
	public void setCajaHora(LocalTime cajaHora) {
		this.cajaHora = cajaHora;
	}
}
