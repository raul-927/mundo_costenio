package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaPrecios implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int listaPrecioId;
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
	public void setListaPrecioId(int listaPrecioId) {
		this.listaPrecioId = listaPrecioId;
	}
	
	
	
}
