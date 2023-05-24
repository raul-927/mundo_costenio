package co.com.mundocostenio.domain.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import co.com.mundocostenio.enumerator.TipoMedioPagoEnum;

public class MedioDePago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer 		  id;
	private Integer 		  medPagoId;
	
	@NotNull(message="Descripcion no puede ser null")
	private	String 			  medPagoDescripcion;
	
	@NotNull(message="Abreviacion no puede ser null")
	private String 			  medPagoAbreviacion;
	
	@NotNull(message="Tipo medio de pago no puede ser null")
	private TipoMedioPagoEnum tipoMedioPago;
	
	@NotNull(message="Cuenta no puede ser null")
	private Cuenta			  cuenta;
	
	public Integer getId() {
		id = medPagoId;
		return id;
	}
	
	public Integer getMedPagoId() {
		return medPagoId;
	}
	public void setMedPagoId(Integer medPagoId) {
		this.medPagoId = medPagoId;
	}
	public String getMedPagoDescripcion() {
		return medPagoDescripcion;
	}
	public void setMedPagoDescripcion(String medPagoDescripcion) {
		this.medPagoDescripcion = medPagoDescripcion;
	}
	public String getMedPagoAbreviacion() {
		return medPagoAbreviacion;
	}
	public void setMedPagoAbreviacion(String medPagoAbreviacion) {
		this.medPagoAbreviacion = medPagoAbreviacion;
	}
	public TipoMedioPagoEnum getTipoMedioPago() {
		return tipoMedioPago;
	}
	public void setTipoMedioPago(TipoMedioPagoEnum tipoMedioPago) {
		this.tipoMedioPago = tipoMedioPago;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}
