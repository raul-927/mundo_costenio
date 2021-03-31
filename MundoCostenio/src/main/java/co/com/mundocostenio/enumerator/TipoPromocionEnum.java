package co.com.mundocostenio.enumerator;

public enum TipoPromocionEnum {
	PORCENTAJE_DESCUENTO(1, "Porcentaje de descuento"),
	POR_CANTIDAD_VENDIDO(2,"Por cantidad vendido");
	
	
	
	private int id;
	private String descripcion;
	
	
	private TipoPromocionEnum(int id, String descripcion) {
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
