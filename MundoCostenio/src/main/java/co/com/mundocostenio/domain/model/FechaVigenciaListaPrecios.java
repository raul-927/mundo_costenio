package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FechaVigenciaListaPrecios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer 	id;
	private Integer 	fechaVigenciaId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate  	fechaIni;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate  	fechaFin;
	
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
	public Integer getFechaVigenciaId() {
		id = fechaVigenciaId;
		return fechaVigenciaId;
	}
	public void setFechaVigenciaId(Integer fechaVigenciaId) {
		this.fechaVigenciaId = fechaVigenciaId;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaVigenciaId == null) ? 0 : fechaVigenciaId.hashCode());
		result += prime * result + ((fechaIni == null) ? 0 : fechaIni.hashCode());
		result += prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
}
