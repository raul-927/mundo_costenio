package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.model.Impuesto;
import co.com.mundocostenio.mybatis.mappers.ImpuestoMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;

@Service("impustoService")
public class ImpuestoServiceImpl implements ImpuestoService {
	
	@Autowired
	private ImpuestoMapper impuestoMapper;
	
	@Autowired
	private AccesControlListService<Impuesto> accesControlListService;

	@Override
	@PreAuthorize(value ="hasRole('ROLE_COUNTER')")
	@Transactional
	public Impuesto insert(@Param("impuesto") Impuesto impuesto) {
		this.impuestoMapper.insert(impuesto);
		this.accesControlListService.insert(impuesto);
		return impuesto;
	}

	@Override
	@Transactional
	@PreAuthorize(value="hasPermission(#impuesto, 'WRITE')")
	public Impuesto update(@Param("impuesto") Impuesto impuesto) {
		this.impuestoMapper.update(impuesto);
		return impuesto;
	}

	@Override
	@Transactional
	@PreAuthorize(value="hasPermission(#impuesto, 'DELETE')")
	public void delete(@Param("impuesto") Impuesto impuesto) {
		this.impuestoMapper.delete(impuesto);
		this.accesControlListService.delete(impuesto);
	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Impuesto> select(@Param("impuesto") Impuesto impuesto) {
		return this.impuestoMapper.select(impuesto);
	}

}
