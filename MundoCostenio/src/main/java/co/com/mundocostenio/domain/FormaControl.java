package co.com.mundocostenio.domain;

import java.io.Serializable;

import co.com.mundocostenio.enumerator.TipoControlEnum;

public class FormaControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private TipoControlEnum tipoControl;
	private int cantidad;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoControlEnum getTipoControl() {
		return tipoControl;
	}
	public void setTipoControl(TipoControlEnum tipoControl) {
		this.tipoControl = tipoControl;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

}
