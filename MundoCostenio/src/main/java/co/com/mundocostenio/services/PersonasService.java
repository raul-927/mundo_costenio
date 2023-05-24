package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.model.Persona;

public interface PersonasService {
	
	Persona insert(Persona persona);
	Persona update(Persona persona);
	void delete(int personaId);
	List<Persona>select(Persona persona);
	
	
	
	

}
