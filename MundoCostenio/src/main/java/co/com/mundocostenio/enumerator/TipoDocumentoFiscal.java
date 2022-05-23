package co.com.mundocostenio.enumerator;

public enum TipoDocumentoFiscal {
	FACTURA_CONTADO(1, "Factura contado"),
	FACTURA_CREDITO(2,"Factura credito"),
	NOTA_CREDITO(3, "Nota de credito"),
	NOTA_DEBITO(4, "Nota de debito"),
	RECIBO(5, "Recibo");
	
	private int id;
	private String descripcion;
	
	private TipoDocumentoFiscal(int id, String descripcion) {
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
