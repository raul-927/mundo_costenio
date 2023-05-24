package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.com.mundocostenio.enumerator.TipoCuentaEnum;
import co.com.mundocostenio.messageerror.AsientoErrorMessage;

public class Asiento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Integer		id;
	
	private Integer 	asientoId;
	
	@NotNull(message =AsientoErrorMessage.NRO_ASIENTO_NOT_NULL)
	private Integer		asientoNro;
	
	@NotNull(message = AsientoErrorMessage.DESCRIPCION_NOT_NULL)
	@Size(min = 3, max = 20, message = AsientoErrorMessage.NOMBRE_SIZE)
	private String		descripcion;
	
	@NotNull(message = AsientoErrorMessage.CUENTA_DEBE_NOT_NULL)
	private Cuenta		cuentaDebe;
	
	@NotNull(message = AsientoErrorMessage.MONTO_DEBE_NOT_NULL)
	private BigDecimal 	montoDebe;
	
	@NotNull(message = AsientoErrorMessage.CUENTA_HABER_NOT_NULL)
	private Cuenta		cuentaHaber;
	
	@NotNull(message = AsientoErrorMessage.MONTO_HABER_NOT_NULL)
	private BigDecimal 	montoHaber;
	
	@NotNull(message =AsientoErrorMessage.CAJA_NOT_NULL)
	private Caja		caja;
	
	@NotNull(message =AsientoErrorMessage.FECHA_NOT_NULL)
	private LocalDate	fecha;
	
	@NotNull(message = AsientoErrorMessage.HORA_NOT_NULL)
	private LocalTime	hora;
	
	@NotNull(message = AsientoErrorMessage.TIPO_CUENTA_NOT_NULL)
	private TipoCuentaEnum tipoCuenta;
	
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
	public TipoCuentaEnum getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(TipoCuentaEnum tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public Integer getAsientoNro() {
		return asientoNro;
	}
	public void setAsientoNro(Integer asientoNro) {
		this.asientoNro = asientoNro;
	}

}
