package co.com.mundocostenio.enumerator;

import java.io.Serializable;

public enum TipoCalleEnum implements Serializable{
	C(1, "CALLE"), 
	K(2,"CARRERA"),
	DG(3, "DIAGONAL"),
	CI(4, "CIRCUNVALAR"),
	AV(5, "AVENIDA"),
	V(6, "VIA"),
	TR(7, "TRANSVERSAL"),
	AK(8, "AVENIDA_CARRERA"),
	AC(9, "AVENIDA_CALLE");
	
	private int id;
	private String descripcion;
	
	
	private TipoCalleEnum(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}


	public int getId() {
		return id;
	}


	public String getDescripcion() {
		return descripcion;
	}
	
	
}
