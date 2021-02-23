package co.com.mundocostenio.domain;

import java.io.Serializable;

public class Tag implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idTag;
	private String nombreTag;
	
	
	public int getIdTag() {
		return idTag;
	}
	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}
	public String getNombreTag() {
		return nombreTag;
	}
	public void setNombreTag(String nombreTag) {
		this.nombreTag = nombreTag;
	}

}
