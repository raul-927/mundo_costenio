package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

public class DatosPersonales implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer 			id;
	private Integer 			datosPersonalesId;
	private List<Telefono> 		telefonos;
	private List<RededSocial>	redesSociales;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDatosPersonalesId() {
		return datosPersonalesId;
	}
	public void setDatosPersonalesId(Integer datosPersonalesId) {
		this.datosPersonalesId = datosPersonalesId;
	}
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	public List<RededSocial> getRedesSociales() {
		return redesSociales;
	}
	public void setRedesSociales(List<RededSocial> redesSociales) {
		this.redesSociales = redesSociales;
	}
	
	

}
