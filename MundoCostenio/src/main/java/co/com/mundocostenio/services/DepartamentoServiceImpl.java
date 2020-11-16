package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Departamento;
import co.com.mundocostenio.mybatis.mappers.DepartamentoMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	private AccesControlListService<Departamento> accesControlListService;
	
	@Autowired
	private DepartamentoMapper departamentoMapper;

	@Override
	@PreAuthorize(value ="hasRole('ROLE_CONFIG')")
	@Transactional
	public Departamento insert(@Param("departamento")Departamento departamento) {
		this.departamentoMapper.insert(departamento);
		accesControlListService.insert(departamento);
		return departamento;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission(#barrio, 'WRITE')")
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
