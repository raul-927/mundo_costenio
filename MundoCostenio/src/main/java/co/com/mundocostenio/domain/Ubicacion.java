package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

public class Ubicacion implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer 	ubicacionId;
	private Integer 	nroPuerta;
	private String 	geoLocalizacion;
	
	public Integer getUbicacionId() {
		return ubicacionId;
	}
	public void setUbicacionId(Integer ubicacionId) {
		this.ubicacionId = ubicacionId;
	}
	
	public Integer getNroPuerta() {
		return nroPuerta;
	}
	public void setNroPuerta(Integer nroPuerta) {
		this.nroPuerta = nroPuerta;
	}
	public String getGeoLocalizacion() {
		return geoLocalizacion;
	}
	public void setGeoLocalizacion(String geoLocalizacion) {
		this.geoLocalizacion = geoLocalizacion;
	}
	
}
