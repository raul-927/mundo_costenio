package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.mundocostenio.annotations.Cedula;
import co.com.mundocostenio.annotations.CedulaExistente;
import co.com.mundocostenio.enumerator.RolesEnum;
import co.com.mundocostenio.messageerror.PersonasErrorMessage;

public class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int personaId;
	@NotNull(message = PersonasErrorMessage.NOMBRE_NULL)
	@Size(min = 3, max = 15, message = PersonasErrorMessage.NOMBRE_LENGTH)
	private String nombre;
	
	@NotNull(message = PersonasErrorMessage.APPELLIDO_NULL)
	@Size(min = 3, max = 15, message = PersonasErrorMessage.APELLIDO_LENGHT)
	private String apellido;
	
	
	@Cedula(message = PersonasErrorMessage.CEDULA_INVALIDA)
	@CedulaExistente(message=PersonasErrorMessage.CEDULA_INEXISTENTE)
	private int cedula;
	
	private List<Direccion> direcciones;
	private RolesEnum rol;
	
	
	public Persona() {};
	
	public Persona(int personaId, String nombre, String apellido, int cedula,
			List<Direccion> direcciones, RolesEnum rol) {
		this.personaId = personaId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.rol  = rol;
		this.direcciones = direcciones;
		
	}
	
	public Persona(String string) {
		if(string != null){
			String[] parts = string.split("-");
			if(parts.length>0) this.personaId=Integer.parseInt(parts[0]);
			if(parts.length>1) this.nombre = parts[1];
			if(parts.length>2) this.apellido =parts[2];
			if(parts.length>3) this.cedula =Integer.parseInt(parts[3]);
			if(parts.length>4) this.apellido =parts[4];
			if(parts.length>5) {
				//List<Direccion> direcciones = new ArrayList<Direccion>();
				
			}
		}
	}
	
	/*
	public String getAsString() {
		
		String result = null;
		
		return result;
	}
	*/
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	
	public RolesEnum getRol() {
		return rol;
	}
	public void setRol(RolesEnum rol) {
		this.rol = rol;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	

}
