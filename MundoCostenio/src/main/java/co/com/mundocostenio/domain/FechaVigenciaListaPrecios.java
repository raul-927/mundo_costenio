package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FechaVigenciaListaPrecios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fechaVigenciaId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate  fechaIni;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate  fechaFin;
	
	private Long objectIdIdentity;
	
	public LocalDate  getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(LocalDate  fechaIni) {
		this.fechaIni = fechaIni;
	}
	public LocalDate  getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate  fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getFechaVigenciaId() {
		return fechaVigenciaId;
	}
	public void setFechaVigenciaId(int fechaVigenciaId) {
		this.fechaVigenciaId = fechaVigenciaId;
	}
	public Long getObjectIdIdentity() {
		return objectIdIdentity;
	}
	public void setObjectIdIdentity(Long objectIdIdentity) {
		this.objectIdIdentity = objectIdIdentity;
	}
}
