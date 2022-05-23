package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.Cuenta;

public interface CuentaService {
	
	Cuenta insert(Cuenta cuenta);
	Cuenta update(Cuenta cuenta);
	void delete(Cuenta cuenta);
	List<Cuenta> select(Cuenta cuenta);
}
