package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.Ubicacion;

public interface UbicacionService {
	
	Ubicacion insert(Ubicacion ubicacion);
	Ubicacion update(Ubicacion ubicacion);
	int delete(int ubicacionId);
	
	List<Ubicacion> select(Ubicacion ubicacion);

}
