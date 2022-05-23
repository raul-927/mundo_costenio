package co.com.mundocostenio.enumerator;

public enum EstadoCajaEnum {
	OPEN(1, "Abierto"),
	CLOSED(2, "Cerrado");
	
	
	private int id;
	private String desc;
	
	
	private EstadoCajaEnum(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDesc() {
		return this.desc;
	}

}
