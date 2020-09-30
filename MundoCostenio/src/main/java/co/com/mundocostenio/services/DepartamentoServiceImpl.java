package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.Departamento;
import co.com.mundocostenio.mybatis.mappers.DepartamentoMapper;


@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	private DepartamentoMapper departamentoMapper;

	@Override
	public Departamento insert(Departamento departamento) {
		this.departamentoMapper.insert(departamento);
		return departamento;
	}

	@Override
	public Departamento update(Departamento departamento) {
		this.departamentoMapper.update(departamento);
		return departamento;
	}

	@Override
	public void delete(int departamentoId) {
		this.departamentoMapper.delete(departamentoId);

	}

	@Override
	public List<Departamento> select(Departamento departamento) {
		return this.departamentoMapper.select(departamento);
	}

}
