package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mercaderia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer 		merId;
	private TipoMercaderia 	tipoMercaderia;
	
	public int getMerId() {
		return merId;
	}
	public void setMerId(int merId) {
		this.merId = merId;
	}
	public TipoMercaderia getTipoMercaderia() {
		return tipoMercaderia;
	}
	public void setTipoMercaderia(TipoMercaderia tipoMercaderia) {
		this.tipoMercaderia = tipoMercaderia;
	}
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result =  prime * result + ((merId == null) ? 0 : merId.hashCode());
		result += prime * result + ((tipoMercaderia == null) ? 0 : tipoMercaderia.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
}
