package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.model.Caja;

public interface CajaService {
	
	Caja insert(Caja caja);
	List<Caja> select(Caja caja);

}
