package co.com.mundocostenio.domain.model;

import java.io.Serializable;

public class Telefono implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 	id;
	private String 	signoPrefijo;
	private int 	prefijo;
	private int 	numero;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSignoPrefijo() {
		return signoPrefijo;
	}
	public void setSignoPrefijo(String signoPrefijo) {
		this.signoPrefijo = signoPrefijo;
	}
	public int getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(int prefijo) {
		this.prefijo = prefijo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
