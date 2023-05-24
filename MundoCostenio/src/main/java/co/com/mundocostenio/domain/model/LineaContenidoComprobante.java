package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LineaContenidoComprobante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 			linContComprId;
	private int 			nroLinea;
	private String 			codigo;
	private String 			descripcion;
	private BigDecimal 		precioUnitario;
	private int 			cantidad;
	private BigDecimal 		subTotal;
	private PoliticaEmpresa politicaEmpresa;
	private BigDecimal 		total;
	
	public int getLinContComprId() {
		return linContComprId;
	}
	public void setLinContComprId(int linContComprId) {
		this.linContComprId = linContComprId;
	}
	public int getNroLinea() {
		return nroLinea;
	}
	public void setNroLinea(int nroLinea) {
		this.nroLinea = nroLinea;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	public PoliticaEmpresa getPoliticaEmpresa() {
		return politicaEmpresa;
	}
	public void setPoliticaEmpresa(PoliticaEmpresa politicaEmpresa) {
		this.politicaEmpresa = politicaEmpresa;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	

}
