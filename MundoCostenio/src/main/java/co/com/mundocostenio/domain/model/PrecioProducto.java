package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PrecioProducto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer  id;
	private Integer	 precioProdId;
	private Producto producto;
	private Integer  monto;
	
	public Integer getId() {
		return id;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	public Integer getPrecioProdId() {
		id = precioProdId;
		return precioProdId;
	}
	public void setPrecioProdId(Integer precioProdId) {
		this.precioProdId = precioProdId;
	}
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((precioProdId == null) ? 0 : precioProdId.hashCode());
		result += prime * result + ((producto == null) ? 0 : producto.hashCode());
		result += prime * result + ((monto == null) ? 0 : monto.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
}
