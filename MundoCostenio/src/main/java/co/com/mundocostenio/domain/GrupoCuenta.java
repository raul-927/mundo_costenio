package co.com.mundocostenio.domain;

import java.io.Serializable;

import co.com.mundocostenio.enumerator.TipoGrupoCuentaEnum;

public class GrupoCuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int 				grupoCuentaId;
	private	TipoGrupoCuentaEnum tipoGrupoCuenta;
	private String 				grupoCuentaDesc;
	
	
	public int getGrupoCuentaId() {
		return grupoCuentaId;
	}
	public void setGrupoCuentaId(int grupoCuentaId) {
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

}
