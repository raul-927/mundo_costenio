package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.util.List;

public class Formulario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int formId;
	private String nombreFormulario;
	private List<Documento> documentos;
	
	
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
	}
	public String getNombreFormulario() {
		return nombreFormulario;
	}
	public void setNombreFormulario(String nombreFormulario) {
		this.nombreFormulario = nombreFormulario;
	}
	public List<Documento> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

}
