package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

public class Comprobante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 							comprobanteId;
	private CabeceraComprobante 			cabeceraComprobante;
	private List<LineaContenidoComprobante>	lineas;
	
	public int getComprobanteId() {
		return comprobanteId;
	}
	public void setComprobanteId(int comprobanteId) {
		this.comprobanteId = comprobanteId;
	}
	public CabeceraComprobante getCabeceraComprobante() {
		return cabeceraComprobante;
	}
	public void setCabeceraComprobante(CabeceraComprobante cabeceraComprobante) {
		this.cabeceraComprobante = cabeceraComprobante;
	}
	public List<LineaContenidoComprobante> getLineas() {
		return lineas;
	}
	public void setLineas(List<LineaContenidoComprobante> lineas) {
		this.lineas = lineas;
	}
	
	

}
