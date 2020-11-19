package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import co.com.mundocostenio.enumerator.TipoCalleEnum;
import co.com.mundocostenio.messageerror.CalleErrorMessage;
import co.com.mundocostenio.messageerror.PersonasErrorMessage;

public class Calle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = CalleErrorMessage.CALLE_ID_NULL)
	private Integer calleId;
	
	//@NotNull(message = PersonasErrorMessage.NOMBRE_NULL)
	private Integer id;
	
	private TipoCalleEnum tipoCalle;
	private String nombreCalle;
	
	public Integer getCalleId() {
		return calleId;
	}
	public void setCalleId(Integer calleId) {
		this.calleId = calleId;
	}
	public TipoCalleEnum getTipoCalle() {
		return tipoCalle;
	}
	public void setTipoCalle(TipoCalleEnum tipoCalle) {
		this.tipoCalle = tipoCalle;
	}
	public String getNombreCalle() {
		return nombreCalle;
	}
	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calleId == null) ? 0 : calleId.hashCode());
		result += prime * result + ((tipoCalle == null) ? 0 : tipoCalle.hashCode());
		result += prime * result + ((nombreCalle == null) ? 0 : nombreCalle.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
	public Integer getId() {
		id = calleId;
		return id;
	}
	public void setId(Integer id) {
		this.id = calleId;
	}
	
}
