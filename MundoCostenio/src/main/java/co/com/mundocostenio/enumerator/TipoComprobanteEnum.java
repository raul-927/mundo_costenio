package co.com.mundocostenio.enumerator;

public enum TipoComprobanteEnum {
	
	FACTURA_CONTADO(1, "Factura contado"),
	NOTA_CREDITO(2,"Nota de crédito"),
	NOTA_DEBITO(3,"Nota de débito"),
	RECIBO(4, "Recibo");
	
	private int 	id;
	private String 	descripcion;
	
	private TipoComprobanteEnum(int id, String descripcion) {
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
