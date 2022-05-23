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
	
	private Integer			 id;
	private Integer 		 impuestoId;
	private String 			 impuestoDesc;
	private String 			 impuestoDescAbrv;
	private BigDecimal 		 impuestoValor;
	private TipoImpuestoEnum tipoImpuesto;
	private Cuenta 			 cuentaImpuesto;
	
	public Integer getId() {
		id = impuestoId;
		return id;
	}
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
		
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
	public Cuenta getCuentaImpuesto() {
		return cuentaImpuesto;
	}
	public void setCuentaImpuesto(Cuenta cuentaImpuesto) {
		this.cuentaImpuesto = cuentaImpuesto;
	}
	
}
