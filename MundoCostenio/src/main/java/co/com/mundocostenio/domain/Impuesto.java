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
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result =  prime * result + ((impuestoId == null) ? 0 : impuestoId.hashCode());
		result += prime * result + ((impuestoDesc == null) ? 0 : impuestoDesc.hashCode());
		result += prime * result + ((impuestoDescAbrv == null) ? 0 : impuestoDescAbrv.hashCode());
		result += prime * result + ((impuestoValor == null) ? 0 : impuestoValor.hashCode());
		result += prime * result + ((tipoImpuesto == null) ? 0 : tipoImpuesto.hashCode());
		result += prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
	
}
