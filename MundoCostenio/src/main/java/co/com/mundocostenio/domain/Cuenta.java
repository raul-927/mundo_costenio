package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.com.mundocostenio.enumerator.TipoCuentaEnum;

public class Cuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	private Integer			id;
	
	@NotNull(message="cuentaId no debe ser Null")
	private Integer 		cuentaId;
	
	@NotNull(message=" cuentaDesc no debe ser null")
	@Size(min=3, max=30, message="cuentaDesc debe contener entre 3 y 30 caracteres")
	private String 			cuentaDesc;
	
	@NotNull(message="tipoCuenta no debe ser null")
	private TipoCuentaEnum	tipoCuenta;
	private LocalDate 		cuentaFecha;
	private LocalTime 		cuentaHora;
	private String			cuentaUsuario;
	
	@NotNull(message="grupoCuenta no debe ser null")
	private GrupoCuenta		grupoCuenta;
	
	public Integer getId() {
		id = cuentaId;
		return id;
	}
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

	public LocalDate getCuentaFecha() {
		return cuentaFecha;
	}
	public void setCuentaFecha(LocalDate cuentaFecha) {
		this.cuentaFecha = cuentaFecha;
	}
	public LocalTime getCuentaHora() {
		return cuentaHora;
	}
	public void setCuentaHora(LocalTime cuentaHora) {
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
