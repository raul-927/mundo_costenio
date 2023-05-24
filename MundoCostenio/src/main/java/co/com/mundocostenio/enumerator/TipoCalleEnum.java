package co.com.mundocostenio.enumerator;

import java.io.Serializable;

import javax.persistence.Enumerated;

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
	
	private int tipoCalleId;
	private String descripcion;
	
	
	private TipoCalleEnum(int tipoCalleId, String descripcion) {
		this.tipoCalleId = tipoCalleId;
		this.descripcion = descripcion;
	}


	public int getTipoCalleId() {
		return tipoCalleId;
	}


	public String getDescripcion() {
		return descripcion;
	}
	
	public static TipoCalleEnum getTipoCalleById(int id) {
		try {
			return TipoCalleEnum.valueOf(String.valueOf(id));
		}catch(IllegalArgumentException ex) {
			throw new RuntimeException("Valor no valido: "+id+". Error: "+ex);
		}
	}
	
	public static TipoCalleEnum getTipoCalleByDescripcion(String descripcion) {
		try {
			return TipoCalleEnum.valueOf(descripcion);
		}catch(IllegalArgumentException ex) {
			throw new RuntimeException("Tipo de calle inválido:"+descripcion+". Error: "+ex);
		}
	}
	
	
}
