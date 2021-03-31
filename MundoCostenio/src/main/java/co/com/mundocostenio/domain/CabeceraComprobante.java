package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.sql.Blob;

public class CabeceraComprobante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cabeceraComprobanteId;
	private String nit;
	private String direccion;
	private Blob logo;
	private String codBarra;
	private Blob codBarraImg;
	private boolean consumoFinal;
	private Persona persona;
	

}
