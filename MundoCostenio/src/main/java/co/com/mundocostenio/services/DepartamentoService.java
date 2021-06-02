package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.Departamento;

public interface DepartamentoService {
	Departamento insert(Departamento departamento);
	Departamento update(Departamento departamento);
	void delete(Departamento departamento);
	List<Departamento> select(Departamento departamento);

}
