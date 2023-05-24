package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.model.Departamento;
import co.com.mundocostenio.mybatis.mappers.DepartamentoMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	private AccesControlListService<Departamento> accesControlListService;
	
	@Autowired
	private DepartamentoMapper departamentoMapper;

	@Override
	@Transactional
	@PreAuthorize(value ="hasRole('ROLE_CONFIG')")
	public Departamento insert(Departamento departamento) {
		this.departamentoMapper.insert(departamento);
		accesControlListService.insert(departamento);
		return departamento;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission(#departamento, 'WRITE')")
	public Departamento update(Departamento departamento) {
		this.departamentoMapper.update(departamento);
		return departamento;
	}

	@Override
	@PreAuthorize("hasPermission(#departamento, 'DELETE')")
	public void delete(Departamento departamento) {
		this.departamentoMapper.delete(departamento);
		this.accesControlListService.delete(departamento);

	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Departamento> select(Departamento departamento) {
		return this.departamentoMapper.select(departamento);
	}

}
