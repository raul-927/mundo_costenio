package co.com.mundocostenio.domain;

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
	
	private Integer listStockId;
	private String descripcion;
	private LocalDate fecha;
	private LocalTime hora;
	private List<Stock>stockList;
	
	public Integer getId() {
		id = listStockId;
		return id;
	}
	
	public Integer getListStockId() {
		return listStockId;
	}
	public void setListStockId(Integer listStockId) {
		this.listStockId = listStockId;
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
}
