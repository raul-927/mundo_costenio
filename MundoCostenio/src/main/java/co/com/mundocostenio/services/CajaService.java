package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.Caja;

public interface CajaService {
	
	Caja insert(Caja caja);
	Caja update(Caja caja);
	int delete(Caja caja);
	List<Caja> select(Caja caja);

}
