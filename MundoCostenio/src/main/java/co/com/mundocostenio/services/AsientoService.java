package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.Asiento;

public interface AsientoService {
	
	Asiento insert(Asiento asiento);
	Asiento update(Asiento asiento);
	List<Asiento> select(Asiento asiento);
}
