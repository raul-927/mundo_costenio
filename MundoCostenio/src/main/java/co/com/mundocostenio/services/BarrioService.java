package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.model.Barrio;

public interface BarrioService {
	Barrio insert( Barrio barrio);
	Barrio update( Barrio barrio);
	void delete( Barrio barrio);
	List<Barrio> select( Barrio barrio);
}
