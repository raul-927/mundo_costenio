package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.Persona;

public interface PersonasService {
	
	void insertPersonas(Persona personas);
	
	List<Persona> showPersonas(Persona personas);
	
	List<Persona> showAllPersonas();

}
