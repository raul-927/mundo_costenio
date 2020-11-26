package co.com.mundocostenio.enumerator;

public enum TipoControlEnum {
	
	KG(1, 1000,"KiloGramo"), 
	LB(2, 500,"Libra"), 
	UNIDAD(3, 1, "Unidad"), 
	MANO(4, 4, "Mano");
	
	private int id;
	private int cantidad;
	private String nombre;
	
	
	private TipoControlEnum(int id, int cantidad, String nombre) {
		this.id = id;
		this.cantidad = cantidad;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public String getNombre() {
		return nombre;
	}

}
