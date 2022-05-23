package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Direccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer		id;
	private Integer 	direccionId;
	private Barrio 		barrio;
	private String 		geoLocalizacion;
	private Integer 	nroPuerta;
	private List<Calle> calles;
	
	public Direccion() {};
	
	public Direccion(Integer direccionId) {
		this.direccionId = direccionId;
	}
	
	public Integer getId() {
		id = direccionId;
		return id;
	}
	public Integer getDireccionId() {
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

	public List<Calle> getCalles() {
		return calles;
	}

	public void setCalles(List<Calle> calles) {
		this.calles = calles;
	}
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result =  prime * result + ((direccionId == null) ? 0 : direccionId.hashCode());
		result += prime * result + ((barrio == null) ? 0 : barrio.hashCode());
		result += prime * result + ((geoLocalizacion == null) ? 0 : geoLocalizacion.hashCode());
		result += prime * result + ((nroPuerta == null) ? 0 : nroPuerta.hashCode());
		result += prime * result + ((calles == null) ? 0 : calles.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}

}
