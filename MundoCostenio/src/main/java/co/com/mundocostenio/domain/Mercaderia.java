package co.com.mundocostenio.domain;

import java.io.Serializable;

public class Mercaderia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int 			merId;
	private TipoMercaderia 	tipoMercaderia;
	private Long 			objectIdIdentity;
	
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
	public Long getObjectIdIdentity() {
		return objectIdIdentity;
	}
	public void setObjectIdIdentity(Long objectIdIdentity) {
		this.objectIdIdentity = objectIdIdentity;
	}
}
