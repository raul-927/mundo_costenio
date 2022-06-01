package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

public class Documento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer 				documentoId;
	private String 					descripcion;
	private List<TipoInscripcion> 	tiposInscripcion;
	
	public Integer getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<TipoInscripcion> getTiposInscripcion() {
		return tiposInscripcion;
	}
	public void setTiposInscripcion(List<TipoInscripcion> tiposInscripcion) {
		this.tiposInscripcion = tiposInscripcion;
	}
	

}
