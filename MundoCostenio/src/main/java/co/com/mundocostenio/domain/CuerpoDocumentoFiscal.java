package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CuerpoDocumentoFiscal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer 		id;
	private Integer 		cuDocFiscalId;
	private BigDecimal 		subTotal;
	private List<Impuesto>	impuestos;
	private BigDecimal 		total;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCuDocFiscalId() {
		return cuDocFiscalId;
	}
	public void setCuDocFiscalId(Integer cuDocFiscalId) {
		this.cuDocFiscalId = cuDocFiscalId;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	public List<Impuesto> getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(List<Impuesto> impuestos) {
		this.impuestos = impuestos;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	

}
