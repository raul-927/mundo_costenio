package co.com.mundocostenio.enumerator;

import java.io.Serializable;

public enum TipoGrupoCuentaEnum implements Serializable{
	VENTA(1,"Venta"), 
	IMPOSITIVO(2, "Impositivo"), 
	PRODUCTO(3,"Producto"),
	RETIRO(4, "Retiro"),
	GASTOS(5, "Gastos"),
	INGRESO(6, "Ingreso Ganancias"),
	DEUDAS(7, "Deudas Prestamos"),
	PATRIMONIO(8,"Patrimonio"),
	EGRESO(9,"Egreso");
	
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
