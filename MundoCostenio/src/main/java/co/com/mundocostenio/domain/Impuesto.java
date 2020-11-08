package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import co.com.mundocostenio.enumerator.TipoImpuestoEnum;
public class Impuesto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer 		 impuestoId;
	private String 			 impuestoDesc;
	private String 			 impuestoDescAbrv;
	private BigDecimal 		 impuestoValor;
	private TipoImpuestoEnum tipoImpuesto;
	private Cuenta 			 cuenta;
	private Long 			 objectIdIdentity;
	
	public Integer getImpuestoId() {
		return impuestoId;
	}
	public void setImpuestoId(Integer impuestoId) {
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
	public Long getObjectIdIdentity() {
		return objectIdIdentity;
	}
	public void setObjectIdIdentity(Long objectIdIdentity) {
		this.objectIdIdentity = objectIdIdentity;
	}
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((impuestoDesc == null) ? 0 : impuestoDesc.hashCode());
		result += prime * result + ((impuestoId == null) ? 0 : impuestoId.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
	
}
