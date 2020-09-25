package co.com.mundocostenio.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.mundocostenio.messageerror.TipoProductoErrorMessage;

public class TipoProducto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tipProdId;
	@NotNull(message =TipoProductoErrorMessage.DESCRIPCION_NULL)
	@Size(min = 3, max = 30, message = TipoProductoErrorMessage.DESCRIPCION_LENGTH)
	private String descripcion;
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getTipProdId() {
		return tipProdId;
	}
	public void setTipProdId(int tipProdId) {
		this.tipProdId = tipProdId;
	}
}
