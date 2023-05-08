package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.com.mundocostenio.enumerator.TipoCalleEnum;
import co.com.mundocostenio.messageerror.CalleErrorMessage;

public class Calle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Integer id;
	
	private Integer calleId;
	
	@NotNull(message=CalleErrorMessage.TIPO_CALLE_NOT_NULL)
	private TipoCalleEnum tipoCalle;
	
	@NotNull(message=CalleErrorMessage.NOMBRE_CALLE_NOT_NULL)
	@Size(min=2, max=15, message=CalleErrorMessage.NOMBRE_CALLE_SIZE)
	private String nombreCalle;
	
	public Calle() {}
	
	public Calle(Integer calleId, String nombreCalle) {
		this.calleId = calleId;
		this.nombreCalle = nombreCalle;
		this.id = calleId;
		
	}
	
	
	public Integer getCalleId() {
		id = calleId;
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
		result += prime * result + ((tipoCalle == null) ? 0 : tipoCalle.hashCode());
		result += prime * result + ((nombreCalle == null) ? 0 : nombreCalle.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
	public Integer getId() {
		id = calleId;
		return id;
	}
}
