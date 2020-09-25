package co.com.mundocostenio.domain;

import java.io.Serializable;

import co.com.mundocostenio.enumerator.TipoCalleEnum;

public class Calle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private TipoCalleEnum tipoCalle;
	private String nombre;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
