package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
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
	
	private Integer id;
	private Integer personaId;
	@NotNull(message = PersonasErrorMessage.NOMBRE_NULL)
	@Size(min = 3, max = 15, message = PersonasErrorMessage.NOMBRE_LENGTH)
	private String nombre;
	
	@NotNull(message = PersonasErrorMessage.APPELLIDO_NULL)
	@Size(min = 3, max = 15, message = PersonasErrorMessage.APELLIDO_LENGHT)
	private String apellido;
	
	@Cedula(message = PersonasErrorMessage.CEDULA_INVALIDA)
	@CedulaExistente(message=PersonasErrorMessage.CEDULA_INEXISTENTE)
	private Integer cedula;
	
	private RolesEnum rol;
	
	private List<Direccion> direcciones;
	
	public Persona() {};
	
	public Persona(Integer personaId, String nombre, String apellido, Integer cedula,
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
	public Integer getId() {
		id = personaId;
		return id;
	}
	public Integer getPersonaId() {
		return personaId;
	}
	public void setPersonaId(Integer personaId) {
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
	
	@Override
	public int hashCode() {
		LocalDateTime localDateTime = LocalDateTime.now();
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personaId == null) ? 0 : personaId.hashCode());
		result += prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result += prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result += prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		result += prime * result + ((rol == null) ? 0 : rol.hashCode());
		result += prime * result + ((direcciones == null) ? 0 : direcciones.hashCode());
		result += prime * result + ((localDateTime ==null)? 0:localDateTime.hashCode());
		return result;
	}
	

}
