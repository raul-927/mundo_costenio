package co.com.mundocostenio.enumerator;

public enum TipoMedioPagoEnum {
	EF(1,"Efectivo"),
	TC(2,"Targeta de Credito"),
	TD(3,"Targeta de Debito"), 
	DP(4,"Deposito Cuenta Bancaria"), 
	CE(5,"Credito Efectivo");
	
	private int id;
	private String descripcion;
	
	private TipoMedioPagoEnum(int id, String descripcion) {
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
