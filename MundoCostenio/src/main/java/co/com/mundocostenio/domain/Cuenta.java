package co.com.mundocostenio.domain;

import java.io.Serializable;

import co.com.mundocostenio.enumerator.TipoCuentaEnum;

public class Cuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int 			cuentaId;
	private String 			cuentaDesc;
	private TipoCuentaEnum	tipoCuenta;
	private String 			cuentaFecha;
	private String 			cuentaHora;
	private String			cuentaUsuario;
	private GrupoCuenta		grupoCuenta;
	private Long 			objectIdIdentity;
	
	
	public int getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(int cuentaId) {
		this.cuentaId = cuentaId;
	}
	public GrupoCuenta getGrupoCuenta() {
		return grupoCuenta;
	}
	public void setGrupoCuenta(GrupoCuenta grupoCuenta) {
		this.grupoCuenta = grupoCuenta;
	}
	public String getCuentaDesc() {
		return cuentaDesc;
	}
	public void setCuentaDesc(String cuentaDesc) {
		this.cuentaDesc = cuentaDesc;
	}

	public String getCuentaFecha() {
		return cuentaFecha;
	}
	public void setCuentaFecha(String cuentaFecha) {
		this.cuentaFecha = cuentaFecha;
	}
	public String getCuentaHora() {
		return cuentaHora;
	}
	public void setCuentaHora(String cuentaHora) {
		this.cuentaHora = cuentaHora;
	}
	public String getCuentaUsuario() {
		return cuentaUsuario;
	}
	public void setCuentaUsuario(String cuentaUsuario) {
		this.cuentaUsuario = cuentaUsuario;
	}
	public TipoCuentaEnum getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(TipoCuentaEnum tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public Long getObjectIdIdentity() {
		return objectIdIdentity;
	}
	public void setObjectIdIdentity(Long objectIdIdentity) {
		this.objectIdIdentity = objectIdIdentity;
	}

}
