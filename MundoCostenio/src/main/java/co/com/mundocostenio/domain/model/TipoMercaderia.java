package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.mundocostenio.messageerror.CalleErrorMessage;
import co.com.mundocostenio.messageerror.TipoMercaderiaErrorMessage;

public class TipoMercaderia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer tipMercId;
	
	@NotNull(message=TipoMercaderiaErrorMessage.FORMA_CONTROL_NOT_NULL)
	private FormaControl formaControl;
	
	@Size(min=2, max=15, message=TipoMercaderiaErrorMessage.NOMBRE_SIZE)
	@NotNull(message=TipoMercaderiaErrorMessage.NOMBRE_NOT_NULL)
	private String nombre;
	
	public Integer getId() {
		id = tipMercId;
		return id;
	}
	public Integer getTipMercId() {
		return tipMercId;
	}
	public void setTipMercId(Integer tipMercId) {
		this.tipMercId = tipMercId;
	}
	public FormaControl getFormaControl() {
		return formaControl;
	}
	public void setFormaControl(FormaControl formaControl) {
		this.formaControl = formaControl;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipMercId == null) ? 0 : tipMercId.hashCode());
		result += prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result += prime * result + ((formaControl == null) ? 0 : formaControl.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
}
