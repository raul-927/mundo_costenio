package co.com.mundocostenio.enumerator;

public enum TipoMovimientoEnum {
	PASIVO(1, "Pasivo"),
	ACTIVO(2,"Activo");
	
	
	private int tipMovId;
	private String desc;
	
	private TipoMovimientoEnum(int tipMovId, String desc) {
		this.tipMovId = tipMovId;
		this.desc = desc;
	}
	
	public int getTipMovId() {
		return tipMovId;
	}
	
	public String getDesc() {
		return desc;
	}
}
