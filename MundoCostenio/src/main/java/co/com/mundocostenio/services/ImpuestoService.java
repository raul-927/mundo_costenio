package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.model.Impuesto;

public interface ImpuestoService {
	Impuesto insert(Impuesto impuesto);
	Impuesto update(Impuesto impuesto);
	void delete(Impuesto impuesto);
	List<Impuesto> select(Impuesto impuesto);
}
