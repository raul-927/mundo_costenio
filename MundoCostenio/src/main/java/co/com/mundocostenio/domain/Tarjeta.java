package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Tarjeta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer   id;
	private Integer   tarjId;
	private Integer	  nroVerif;
	private Long	  nroTarj;
	private String	  nombre;
	private LocalDate fechaVencimiento;
	private Cuenta	  cuenta;
	private Persona	  persona;
	
	public Integer getTarjId() {
		return tarjId;
	}
	public void setTarjId(Integer tarjId) {
		this.tarjId = tarjId;
	}
	public Integer getNroVerif() {
		return nroVerif;
	}
	public void setNroVerif(Integer nroVerif) {
		this.nroVerif = nroVerif;
	}
	public Long getNroTarj() {
		return nroTarj;
	}
	public void setNroTarj(Long nroTarj) {
		this.nroTarj = nroTarj;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public Integer getId() {
		id = tarjId;
		return id;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
