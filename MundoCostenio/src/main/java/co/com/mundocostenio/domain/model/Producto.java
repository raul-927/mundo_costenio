package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.com.mundocostenio.messageerror.ProductoErrorMessage;

public class Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer 		prodId;
	
	@NotNull(message = ProductoErrorMessage.NOMBRE_NULL)
	@Size(min = 3, max = 15, message = ProductoErrorMessage.NOMBRE_LENGTH)
	private String 			nombre;
	
	@NotNull(message = ProductoErrorMessage.TIPO_PRODUCTO_NULL)
	private TipoProducto 	tipoProducto;
	
	@NotNull(message = ProductoErrorMessage.IMPUESTO_NOT_NULL)
	private Impuesto 		impuesto;
	
	
	public Producto() {}
	public Producto(Integer prodId, String nombre, Impuesto impuesto) {
		this.prodId = prodId;
		this.nombre = nombre;
		this.impuesto = impuesto;
		this.id = prodId;
	}

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
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	
	public Integer getId() {
		this.id = prodId;
		return id;
	}
	public Impuesto getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}

	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prodId == null) ? 0 : prodId.hashCode());
		result += prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result += prime * result + ((tipoProducto == null) ? 0 : tipoProducto.hashCode());
		result += prime * result + ((impuesto == null) ? 0 : impuesto.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
	
}
