package co.com.mundocostenio.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.mundocostenio.messageerror.ProductoErrorMessage;

public class Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 			prodId;
	
	@NotNull(message = ProductoErrorMessage.NOMBRE_NULL)
	@Size(min = 3, max = 15, message = ProductoErrorMessage.NOMBRE_LENGTH)
	private String 			nombre;
	
	@NotNull(message = ProductoErrorMessage.TIPO_PRODUCTO_NULL)
	private TipoProducto 	tipoProducto;
	private Impuesto 		impuesto;
	private Long			objectIdIdentity;
	
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public Impuesto getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}
	public Long getObjectIdIdentity() {
		return objectIdIdentity;
	}
	public void setObjectIdIdentity(Long objectIdIdentity) {
		this.objectIdIdentity = objectIdIdentity;
	}
	

}
