package co.com.mundocostenio.domain;

import java.io.Serializable;

import co.com.mundocostenio.enumerator.TipoCalleEnum;

public class Calle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int calleId;
	private TipoCalleEnum tipoCalle;
	private String nombre;
	
	
	
	public int getCalleId() {
		return calleId;
	}
	public void setCalleId(int calleId) {
		this.calleId = calleId;
	}
	public TipoCalleEnum getTipoCalle() {
		return tipoCalle;
	}
	public void setTipoCalle(TipoCalleEnum tipoCalle) {
		this.tipoCalle = tipoCalle;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
