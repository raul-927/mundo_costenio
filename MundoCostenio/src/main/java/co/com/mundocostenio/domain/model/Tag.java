package co.com.mundocostenio.domain.model;

import java.io.Serializable;

public class Tag implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tagId;
	private String nombreTag;
	
	
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	
	public String getNombreTag() {
		return nombreTag;
	}
	public void setNombreTag(String nombreTag) {
		this.nombreTag = nombreTag;
	}
	

}
