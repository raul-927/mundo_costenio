package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.model.Direccion;

public interface DireccionService {
	List<Direccion> insert( List<Direccion> direcciones);
	void insertPersonaDirecciones(int personaId, List<Direccion> direcciones);
}
