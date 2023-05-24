package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.model.Asiento;
import co.com.mundocostenio.domain.model.Pago;
import co.com.mundocostenio.domain.model.Producto;

public interface AsientoService {
	
	List<Asiento> insert(Pago pago, Producto producto);
	Asiento update(Asiento asiento);
	List<Asiento> select(Asiento asiento);
	void ingresarAsientoContable(Pago pago);
}
