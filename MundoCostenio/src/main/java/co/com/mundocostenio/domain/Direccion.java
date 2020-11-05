package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

public class Direccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 		direccionId;
	private Barrio 		barrio;
	private String 		geoLocalizacion;
	private int 		nroPuerta;
	private List<Calle> calles;
	private Long 		objectIdIdentity;
	
	public Direccion() {};
	
	public Direccion(int direccionId) {
		this.direccionId = direccionId;
	}
	
	public int getDireccionId() {
		return direccionId;
	}
	public void setDireccionId(int direccionId) {
		this.direccionId = direccionId;
	}
	
	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	public int getNroPuerta() {
		return nroPuerta;
	}

	public void setNroPuerta(int nroPuerta) {
		this.nroPuerta = nroPuerta;
	}

	public String getGeoLocalizacion() {
		return geoLocalizacion;
	}

	public void setGeoLocalizacion(String geoLocalizacion) {
		this.geoLocalizacion = geoLocalizacion;
	}

	public List<Calle> getCalles() {
		return calles;
	}

	public void setCalles(List<Calle> calles) {
		this.calles = calles;
	}

	public Long getObjectIdIdentity() {
		return objectIdIdentity;
	}

	public void setObjectIdIdentity(Long objectIdIdentity) {
		this.objectIdIdentity = objectIdIdentity;
	}
}
