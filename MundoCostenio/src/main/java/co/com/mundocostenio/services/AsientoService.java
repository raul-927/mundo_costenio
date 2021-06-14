package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.Asiento;
import co.com.mundocostenio.domain.Pago;
import co.com.mundocostenio.domain.Producto;

public interface AsientoService {
	
	List<Asiento> insert(Pago pago, Producto producto);
	Asiento update(Asiento asiento);
	List<Asiento> select(Asiento asiento);
}
