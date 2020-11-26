package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Asiento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Integer		id;
	
	private Integer 	asientoId;
	private String		descripcion;
	private Cuenta		cuentaDebe;
	private BigDecimal 	montoDebe;
	private Cuenta		cuentaHaber;
	private BigDecimal 	montoHaber;
	private Caja		caja;
	private LocalDate	fecha;
	private LocalTime	hora;
	
	public Integer getId() {
		id = asientoId;
		return id;
	}
	public Integer getAsientoId() {
		return asientoId;
	}
	public void setAsientoId(Integer asientoId) {
		this.asientoId = asientoId;
	}
	
	public Cuenta getCuentaDebe() {
		return cuentaDebe;
	}
	public void setCuentaDebe(Cuenta cuentaDebe) {
		this.cuentaDebe = cuentaDebe;
	}
	public Cuenta getCuentaHaber() {
		return cuentaHaber;
	}
	public void setCuentaHaber(Cuenta cuentaHaber) {
		this.cuentaHaber = cuentaHaber;
	}
	public Caja getCaja() {
		return caja;
	}
	public void setCaja(Caja caja) {
		this.caja = caja;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public BigDecimal getMontoDebe() {
		return montoDebe;
	}
	public void setMontoDebe(BigDecimal montoDebe) {
		this.montoDebe = montoDebe;
	}
	public BigDecimal getMontoHaber() {
		return montoHaber;
	}
	public void setMontoHaber(BigDecimal montoHaber) {
		this.montoHaber = montoHaber;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
