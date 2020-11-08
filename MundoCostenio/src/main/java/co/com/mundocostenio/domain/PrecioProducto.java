package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class PrecioProducto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer	 precioProdId;
	private Producto producto;
	private Integer 	 monto;
	private Long 	 objectIdIdentity;
	
	
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
		return precioProdId;
	}
	public void setPrecioProdId(Integer precioProdId) {
		this.precioProdId = precioProdId;
	}
	public Long getObjectIdIdentity() {
		return objectIdIdentity;
	}
	public void setObjectIdIdentity(Long objectIdIdentity) {
		this.objectIdIdentity = objectIdIdentity;
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
