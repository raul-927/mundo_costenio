package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ListaStock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	private Integer id;
	
	private Integer 	listaStockId;
	private String 		descripcion;
	private LocalDate 	fecha;
	private LocalTime 	hora;
	private List<Stock>	stockList;
	
	public Integer getId() {
		id = listaStockId;
		return id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public List<Stock> getStockList() {
		return stockList;
	}
	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	public Integer getListaStockId() {
		return listaStockId;
	}

	public void setListaStockId(Integer listaStockId) {
		this.listaStockId = listaStockId;
	}
}
