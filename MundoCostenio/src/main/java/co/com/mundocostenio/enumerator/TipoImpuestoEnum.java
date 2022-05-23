package co.com.mundocostenio.enumerator;

import java.io.Serializable;

public enum TipoImpuestoEnum implements Serializable{
	ECONOMICO(1, "Economico"),
	PERSONAS(2, "Personas");
	
	private int codigo;
	private String descripcion;
	
	TipoImpuestoEnum(int codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
