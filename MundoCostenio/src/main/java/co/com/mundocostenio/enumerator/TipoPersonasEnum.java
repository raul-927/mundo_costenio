package co.com.mundocostenio.enumerator;

public enum TipoPersonasEnum {
	ADMIN(1, "Administrador"),
	CEO(2, "Gerente"),
	STAF(3, "Staf personal de trabajo"),
	CLIENT(3, "Cliente");
	
	private int id;
	private String nombre;
	
	private TipoPersonasEnum(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
