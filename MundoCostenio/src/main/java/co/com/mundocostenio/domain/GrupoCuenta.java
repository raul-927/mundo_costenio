package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import co.com.mundocostenio.enumerator.TipoGrupoCuentaEnum;

public class GrupoCuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer 			grupoCuentaId;
	private	TipoGrupoCuentaEnum tipoGrupoCuenta;
	private String 				grupoCuentaDesc;
	private Long 				objectIdIdentity;
	
	
	public Integer getGrupoCuentaId() {
		return grupoCuentaId;
	}
	public void setGrupoCuentaId(Integer grupoCuentaId) {
		this.grupoCuentaId = grupoCuentaId;
	}
	
	public String getGrupoCuentaDesc() {
		return grupoCuentaDesc;
	}
	public void setGrupoCuentaDesc(String grupoCuentaDesc) {
		this.grupoCuentaDesc = grupoCuentaDesc;
	}
	public TipoGrupoCuentaEnum getTipoGrupoCuenta() {
		return tipoGrupoCuenta;
	}
	public void setTipoGrupoCuenta(TipoGrupoCuentaEnum tipoGrupoCuenta) {
		this.tipoGrupoCuenta = tipoGrupoCuenta;
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
		result =  prime * result + ((grupoCuentaId == null) ? 0 : grupoCuentaId.hashCode());
		result += prime * result + ((tipoGrupoCuenta == null) ? 0 : tipoGrupoCuenta.hashCode());
		result += prime * result + ((grupoCuentaDesc == null) ? 0 : grupoCuentaDesc.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}

}
