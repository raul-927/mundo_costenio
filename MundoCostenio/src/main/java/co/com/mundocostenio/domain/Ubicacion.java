package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

public class Ubicacion implements Serializable{
	private static final long serialVersionUID = 1L;
	private int ubicacionId;
	private List<Calle> calles;
	private int nroPuerta;
	private String geoLocalizacion;
	
	public int getUbicacionId() {
		return ubicacionId;
	}
	public void setUbicacionId(int ubicacionId) {
		this.ubicacionId = ubicacionId;
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

}
