package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Barrio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombreBarrio;
	private Ubicacion ubicacion;
	
	public Barrio() {};
	
	public Barrio(int id, String nombreBarrio, Ubicacion ubicacion) {
		this.id = id;
		this.nombreBarrio = nombreBarrio;
		this.ubicacion = ubicacion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreBarrio() {
		return nombreBarrio;
	}
	public void setNombreBarrio(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
}
