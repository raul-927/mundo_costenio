package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer    id;
	private Integer    pagoId;
	private Integer    cuotas;
	private BigDecimal importe;
	private String	   descripcion;
	
	private Cuenta     cuenta;
	private Tarjeta    tarjeta;
	private Persona    persona;
	//private Asiento    asiento;
	private Caja 	   caja;
	private Producto   producto;
	
	
	
	public Integer getPagoId() {
		return pagoId;
	}
	public void setPagoId(Integer pagoId) {
		this.pagoId = pagoId;
	}
	public Cuenta getCuenta() {
		if(tarjeta !=null && tarjeta.getCuenta()!=null) {
			cuenta = tarjeta.getCuenta();
		}
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/*
	 * public Asiento getAsiento() { return asiento; } public void
	 * setAsiento(Asiento asiento) { this.asiento = asiento; }
	 */
	public Caja getCaja() {
		return caja;
	}
	public void setCaja(Caja caja) {
		this.caja = caja;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCuotas() {
		return cuotas;
	}
	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}
	public Integer getId() {
		id = pagoId;
		return id;
	}
}
