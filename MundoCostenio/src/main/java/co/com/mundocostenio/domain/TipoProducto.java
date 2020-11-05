package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.mundocostenio.messageerror.TipoProductoErrorMessage;

public class TipoProducto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer tipProdId;
	@NotNull(message =TipoProductoErrorMessage.DESCRIPCION_NULL)
	@Size(min = 3, max = 30, message = TipoProductoErrorMessage.DESCRIPCION_LENGTH)
	private String descTipoProducto;
	
	
	
	public Integer getTipProdId() {
		return tipProdId;
	}
	public void setTipProdId(Integer tipProdId) {
		this.tipProdId = tipProdId;
	}
	public String getDescTipoProducto() {
		return descTipoProducto;
	}
	public void setDescTipoProducto(String descTipoProducto) {
		this.descTipoProducto = descTipoProducto;
	}
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descTipoProducto == null) ? 0 : descTipoProducto.hashCode());
		result = prime * result + ((tipProdId == null) ? 0 : tipProdId.hashCode());
		result = prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoProducto other = (TipoProducto) obj;
		if (descTipoProducto == null) {
			if (other.descTipoProducto != null)
				return false;
		} else if (!descTipoProducto.equals(other.descTipoProducto))
			return false;
		if (tipProdId == null) {
			if (other.tipProdId != null)
				return false;
		} else if (!tipProdId.equals(other.tipProdId))
			return false;
		return true;
	}
}
