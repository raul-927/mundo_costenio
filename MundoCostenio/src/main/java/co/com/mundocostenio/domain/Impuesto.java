package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import co.com.mundocostenio.enumerator.TipoImpuestoEnum;
public class Impuesto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int 			 impuestoId;
	private String 			 impuestoDesc;
	private String 			 impuestoDescAbrv;
	private BigDecimal 		 impuestoValor;
	private TipoImpuestoEnum tipoImpuesto;
	private Cuenta 			 cuenta;
	
	public int getImpuestoId() {
		return impuestoId;
	}
	public void setImpuestoId(int impuestoId) {
		this.impuestoId = impuestoId;
	}
	public String getImpuestoDesc() {
		return impuestoDesc;
	}
	public void setImpuestoDesc(String impuestoDesc) {
		this.impuestoDesc = impuestoDesc;
	}
	public String getImpuestoDescAbrv() {
		return impuestoDescAbrv;
	}
	public void setImpuestoDescAbrv(String impuestoDescAbrv) {
		this.impuestoDescAbrv = impuestoDescAbrv;
	}
	public BigDecimal getImpuestoValor() {
		return impuestoValor;
	}
	public void setImpuestoValor(BigDecimal impuestoValor) {
		this.impuestoValor = impuestoValor;
	}
	
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public TipoImpuestoEnum getTipoImpuesto() {
		return tipoImpuesto;
	}
	public void setTipoImpuesto(TipoImpuestoEnum tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
	}
	
	
}
