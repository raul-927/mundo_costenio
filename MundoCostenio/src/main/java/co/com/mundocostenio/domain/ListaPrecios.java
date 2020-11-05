package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaPrecios implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer listaPrecioId;
	private String descripcionLista;
	private FechaVigenciaListaPrecios fechaVigencia;
	private List<PrecioProducto> precioProductoList;
	
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
	public int getListaPrecioId() {
		return listaPrecioId;
	}
	public void setListaPrecioId(Integer listaPrecioId) {
		this.listaPrecioId = listaPrecioId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcionLista == null) ? 0 : descripcionLista.hashCode());
		result = prime * result + ((listaPrecioId == null) ? 0 : listaPrecioId.hashCode());
		result = prime * result + ((fechaVigencia == null) ? 0 : fechaVigencia.hashCode());
		result = prime * result + ((precioProductoList == null) ? 0 : precioProductoList.hashCode());
		return result;
	}
	
}
