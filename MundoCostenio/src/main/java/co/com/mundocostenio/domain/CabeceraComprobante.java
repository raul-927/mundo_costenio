package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.sql.Blob;

public class CabeceraComprobante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 	cabeceraComprobanteId;
	private String 	nit;
	private String 	direccion;
	private Blob 	logo;
	private String 	codBarra;
	private Blob 	codBarraImg;
	private boolean consumoFinal;
	private Persona persona;
	
	public int getCabeceraComprobanteId() {
		return cabeceraComprobanteId;
	}
	public void setCabeceraComprobanteId(int cabeceraComprobanteId) {
		this.cabeceraComprobanteId = cabeceraComprobanteId;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Blob getLogo() {
		return logo;
	}
	public void setLogo(Blob logo) {
		this.logo = logo;
	}
	public String getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	public Blob getCodBarraImg() {
		return codBarraImg;
	}
	public void setCodBarraImg(Blob codBarraImg) {
		this.codBarraImg = codBarraImg;
	}
	public boolean isConsumoFinal() {
		return consumoFinal;
	}
	public void setConsumoFinal(boolean consumoFinal) {
		this.consumoFinal = consumoFinal;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	

}
