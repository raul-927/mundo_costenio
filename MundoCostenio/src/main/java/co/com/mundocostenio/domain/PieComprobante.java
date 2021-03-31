package co.com.mundocostenio.domain;

import java.io.Serializable;

public class PieComprobante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int pieComprobanteId;
	private int nroConstancia;
	private String observaciones;
	
	public int getPieComprobanteId() {
		return pieComprobanteId;
	}
	public void setPieComprobanteId(int pieComprobanteId) {
		this.pieComprobanteId = pieComprobanteId;
	}
	public int getNroConstancia() {
		return nroConstancia;
	}
	public void setNroConstancia(int nroConstancia) {
		this.nroConstancia = nroConstancia;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	

}
