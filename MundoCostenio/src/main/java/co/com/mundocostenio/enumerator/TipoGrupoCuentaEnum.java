package co.com.mundocostenio.enumerator;

import java.io.Serializable;

public enum TipoGrupoCuentaEnum implements Serializable{
	ECONOMICO(1,"Economico"),
	PERSONAS(2,"Personas");
	
	private int id;
	private String descripcion;
	
	private TipoGrupoCuentaEnum(int id, String descripcion) {
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
