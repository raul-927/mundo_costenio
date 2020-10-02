package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.Calle;

public interface CalleService {
	Calle insert(Calle calle);
	
	void insertDireccionCalles(int direccionId, List<Calle>calles);
	Calle update(Calle calle);
	void delete(Calle calle);
	List<Calle> select(Calle calle);
}
