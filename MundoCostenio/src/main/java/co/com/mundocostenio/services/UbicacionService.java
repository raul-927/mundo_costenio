package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.model.Ubicacion;

public interface UbicacionService {
	
	Ubicacion insert(Ubicacion ubicacion);
	Ubicacion update(Ubicacion ubicacion);
	void delete(Ubicacion ubicacion);
	
	List<Ubicacion> select(Ubicacion ubicacion);

}
