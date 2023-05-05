package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ListaPrecios implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Integer 					id;
	private Integer 					listaPrecioId;
	private String 						descripcionLista;
	private FechaVigenciaListaPrecios 	fechaVigencia;
	private List<PrecioProducto> 		precioProductoList;
	
	
	
	public Integer getListaPrecioId() {
		id = listaPrecioId;
		return listaPrecioId;
	}
	public void setListaPrecioId(Integer listaPrecioId) {
		this.listaPrecioId = listaPrecioId;
	}
	
	public Integer getId() {
		this.id = listaPrecioId;
		return id;
	}
	
	public String getDescripcionLista() {
		return descripcionLista;
	}
	public void setDescripcionLista(String descripcionLista) {
		this.descripcionLista = descripcionLista;
	}
	public FechaVigenciaListaPrecios getFechaVigencia() {
		return fechaVigencia;
	}
	public void setFechaVigencia(FechaVigenciaListaPrecios fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}
	public List<PrecioProducto> getPrecioProductoList() {
		return precioProductoList;
	}
	public void setPrecioProductoList(List<PrecioProducto> precioProductoList) {
		this.precioProductoList = precioProductoList;
	}
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcionLista == null) ? 0 : descripcionLista.hashCode());
		result += prime * result + ((listaPrecioId == null) ? 0 : listaPrecioId.hashCode());
		result += prime * result + ((fechaVigencia == null) ? 0 : fechaVigencia.hashCode());
		result += prime * result + ((precioProductoList == null) ? 0 : precioProductoList.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
	
}
