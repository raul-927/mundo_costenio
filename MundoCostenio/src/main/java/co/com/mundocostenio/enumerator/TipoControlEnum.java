package co.com.mundocostenio.enumerator;

public enum TipoControlEnum {
	
	KG(1, "1000 gr"), LB(2, "500 gr"), UNIDAD(3, "1"), MANO(4, "4");
	
	private int id;
	private String nombre;
	
	
	private TipoControlEnum(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}

}
