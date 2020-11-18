package co.com.mundocostenio.domain;

import java.io.Serializable;

public class Caja implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 	cajaId;
	private String 	cajaEstado;
	
	private String 	cajaFecha;
	
	private String 	cajaHora;
	private String 	cajaUsr;
	
	public int getCajaId() {
		return cajaId;
	}
	public void setCajaId(int cajaId) {
		this.cajaId = cajaId;
	}
	public String getCajaEstado() {
		return cajaEstado;
	}
	public void setCajaEstado(String cajaEstado) {
		this.cajaEstado = cajaEstado;
	}
	public String getCajaFecha() {
		return cajaFecha;
	}
	public void setCajaFecha(String cajaFecha) {
		this.cajaFecha = cajaFecha;
	}
	public String getCajaHora() {
		return cajaHora;
	}
	public void setCajaHora(String cajaHora) {
		this.cajaHora = cajaHora;
	}
	public String getCajaUsr() {
		return cajaUsr;
	}
	public void setCajaUsr(String cajaUsr) {
		this.cajaUsr = cajaUsr;
	}
}
