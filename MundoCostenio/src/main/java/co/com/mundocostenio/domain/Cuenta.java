package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import co.com.mundocostenio.enumerator.TipoCuentaEnum;

public class Cuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer 		cuentaId;
	private String 			cuentaDesc;
	private TipoCuentaEnum	tipoCuenta;
	private String 			cuentaFecha;
	private String 			cuentaHora;
	private String			cuentaUsuario;
	private GrupoCuenta		grupoCuenta;
	
	public Integer getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(Integer cuentaId) {
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
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result =  prime * result + ((cuentaId == null) ? 0 : cuentaId.hashCode());
		result += prime * result + ((cuentaDesc == null) ? 0 : cuentaDesc.hashCode());
		result += prime * result + ((tipoCuenta == null) ? 0 : tipoCuenta.hashCode());
		result += prime * result + ((cuentaFecha == null) ? 0 : cuentaFecha.hashCode());
		result += prime * result + ((cuentaHora == null) ? 0 : cuentaHora.hashCode());
		result += prime * result + ((cuentaUsuario == null) ? 0 : cuentaUsuario.hashCode());
		result += prime * result + ((grupoCuenta == null) ? 0 : grupoCuenta.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}

}
