package co.com.mundocostenio.domain.model;

import java.io.Serializable;
import java.util.List;

public class TipoInscripcion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tipInscId;
	private String tipo;
	private List<Tag> tags;
	
	public int getTipInscId() {
		return tipInscId;
	}
	public void setTipInscId(int tipInscId) {
		this.tipInscId = tipInscId;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
