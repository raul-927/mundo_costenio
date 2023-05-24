package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import co.com.mundocostenio.enumerator.TipoControlEnum;

public class FormaControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer 		id;
	private Integer 		formControlId;
	private TipoControlEnum tipoControl;
	private Integer 		cantidad;
	
	public Integer getId() {
		id = formControlId;
		return id;
	}
	public Integer getFormControlId() {
		return formControlId;
	}
	public void setFormControlId(Integer formControlId) {
		this.formControlId = formControlId;
	}

	public TipoControlEnum getTipoControl() {
		return tipoControl;
	}
	public void setTipoControl(TipoControlEnum tipoControl) {
		this.tipoControl = tipoControl;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formControlId == null) ? 0 : formControlId.hashCode());
		result += prime * result + ((tipoControl == null) ? 0 : tipoControl.hashCode());
		result += prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
	
}
