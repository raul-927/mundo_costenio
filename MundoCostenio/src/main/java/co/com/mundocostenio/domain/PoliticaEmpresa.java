package co.com.mundocostenio.domain;

import java.io.Serializable;

import co.com.mundocostenio.enumerator.TipoPromocionEnum;

public class PoliticaEmpresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 				polEmpresaId;
	private TipoPromocionEnum 	tipoPromocion;
	/**
	 * @return the polEmpresaId
	 */
	public int getPolEmpresaId() {
		return polEmpresaId;
	}
	/**
	 * @param polEmpresaId the polEmpresaId to set
	 */
	public void setPolEmpresaId(int polEmpresaId) {
		this.polEmpresaId = polEmpresaId;
	}
	/**
	 * @return the tipoPromocion
	 */
	public TipoPromocionEnum getTipoPromocion() {
		return tipoPromocion;
	}
	/**
	 * @param tipoPromocion the tipoPromocion to set
	 */
	public void setTipoPromocion(TipoPromocionEnum tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}


}
