package co.com.mundocostenio.domain;

public class CabeceraDocumentoFiscal {
	private Integer id;
	
	private Integer cabDocFisId;
	
	private int nroConstancia;
	private int rut;
	private String razonSocial;
	private String direccion;
	public Integer getCabDocFisId() {
		return cabDocFisId;
	}
	public void setCabDocFisId(Integer cabDocFisId) {
		this.cabDocFisId = cabDocFisId;
	}
	public int getNroConstancia() {
		return nroConstancia;
	}
	public void setNroConstancia(int nroConstancia) {
		this.nroConstancia = nroConstancia;
	}
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getId() {
		id = cabDocFisId;
		return id;
	}
	
	
	
}
