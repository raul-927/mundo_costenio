package co.com.mundocostenio.domain;

import java.io.Serializable;

public class Ubicacion implements Serializable{
	private static final long serialVersionUID = 1L;
	private int ubicacionId;
	private Calle calle1;
	private Calle calle2;
	private int nroPuerta;
	private String geoLocalizacion;
	
	public int getUbicacionId() {
		return ubicacionId;
	}
	public void setUbicacionId(int ubicacionId) {
		this.ubicacionId = ubicacionId;
	}
	public Calle getCalle1() {
		return calle1;
	}
	public void setCalle1(Calle calle1) {
		this.calle1 = calle1;
	}
	public Calle getCalle2() {
		return calle2;
	}
	public void setCalle2(Calle calle2) {
		this.calle2 = calle2;
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

}
