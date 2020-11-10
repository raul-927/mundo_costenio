package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TipoMercaderia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer tipMercId;
	private FormaControl formaControl;
	private String nombre;
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
