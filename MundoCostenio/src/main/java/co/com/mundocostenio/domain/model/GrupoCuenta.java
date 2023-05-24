package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.com.mundocostenio.enumerator.TipoGrupoCuentaEnum;
import co.com.mundocostenio.messageerror.GrupoCuentaErrorMessage;

public class GrupoCuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	private Integer				id;
	private Integer 			grupoCuentaId;
	
	@NotNull(message = GrupoCuentaErrorMessage.TIPO_CUENTA_NULL)
	private	TipoGrupoCuentaEnum tipoGrupoCuenta;
	
	@NotNull(message = GrupoCuentaErrorMessage.DESCRIPCION_NULL)
	@Size(min = 3, max = 15, message = GrupoCuentaErrorMessage.DESCRIPCION_LENGHT)
	private String 				grupoCuentaDesc;
	
	public Integer getId() {
		id = grupoCuentaId;
		return id;
	}
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
