package co.com.mundocostenio.dto;

import java.io.Serializable;

public class RolesDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int rolId;
	private int personaId;
	
	public RolesDTO() {}
	
	public RolesDTO(int id, int rolId, int personaId) {
		this.id = id;
		this.rolId = rolId;
		this.personaId = personaId;
	}
	
	
	public RolesDTO(String string) {
		if(string != null){
			String[] parts = string.split("-");
			if(parts.length>0) this.id=Integer.parseInt(parts[0]);
			if(parts.length>1) this.rolId = Integer.parseInt(parts[1]);
			if(parts.length>2) this.personaId =Integer.parseInt(parts[2]);
		}
	}
	
	
	public String getAsString() {
		String resultado = this.id+"-"+this.rolId+"-"+this.personaId;
		
		return resultado ;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRolId() {
		return rolId;
	}
	public void setRolId(int rolId) {
		this.rolId = rolId;
	}
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	
	

}
