package co.com.mundocostenio.enumerator;

import java.io.Serializable;

public enum TipoCuentaEnum implements Serializable{
	VENTA(1,"Venta"), 
	IMPOSITIVO(2, "Impositivo"), 
	PRODUCTO(3,"Producto"),
	RETIRO(4, "Retiro"),
	GASTOS(5, "Gastos"),
	INGRESO(6, "Ingreso Ganancias"),
	DEUDAS(7, "Deudas Prestamos"),
	PATRIMONIO(8,"Patrimonio"),
	EGRESO(9,"Egreso");
	
	private int codigo;
	private String descripcion;
	
	TipoCuentaEnum(int codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getCodigo(){
		return this.codigo;
	}
}
