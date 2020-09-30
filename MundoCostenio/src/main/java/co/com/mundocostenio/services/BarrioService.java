package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.Barrio;

public interface BarrioService {
	Barrio insert( Barrio barrio);
	Barrio update( Barrio barrio);
	int delete( int barrioId);
	List<Barrio> select( Barrio barrio);
}
