package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

public class PrecioProducto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int precioProdId;
	private Producto producto;
	private int monto;
	
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public int getPrecioProdId() {
		return precioProdId;
	}
	public void setPrecioProdId(int precioProdId) {
		this.precioProdId = precioProdId;
	}
	
	
}
