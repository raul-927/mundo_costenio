package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.GrupoCuenta;

public interface GrupoCuentaService {
	GrupoCuenta insert(GrupoCuenta grupoCuenta);
	GrupoCuenta update(GrupoCuenta grupoCuenta);
	void delete(GrupoCuenta grupoCuenta);
	List<GrupoCuenta> select(GrupoCuenta grupoCuenta);
}
