package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.GrupoCuenta;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.mybatis.mappers.GrupoCuentaMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;

@Service("grupoCuentaService")
public class GrupoCuentaServiceImpl implements GrupoCuentaService {
	
	@Autowired
	private GrupoCuentaMapper grupoCuentaMapper;
	
	@Autowired
	private AccesControlListService<GrupoCuenta> accesControlListService;

	@Override
	@PreAuthorize(value ="hasRole('ROLE_COUNTER')")
	@Transactional
	public GrupoCuenta insert(GrupoCuenta grupoCuenta) {
		this.grupoCuentaMapper.insert(grupoCuenta);
		this.accesControlListService.insert(grupoCuenta);
		return grupoCuenta;
	}

	@Override
	@Transactional
	@PreAuthorize(value="hasPermission(#grupoCuenta, 'WRITE')")
	public GrupoCuenta update(GrupoCuenta grupoCuenta) {
		this.select(grupoCuenta);
		this.grupoCuentaMapper.update(grupoCuenta);
		return grupoCuenta;
	}

	@Override
	@PreAuthorize(value="hasPermission(#grupoCuenta, 'DELETE')")
	public void delete(GrupoCuenta grupoCuenta) {
		this.select(grupoCuenta);
		this.grupoCuentaMapper.delete(grupoCuenta);
		this.accesControlListService.delete(grupoCuenta);
	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<GrupoCuenta> select(GrupoCuenta grupoCuenta) {
		List<GrupoCuenta>grupoCuentaResult = this.grupoCuentaMapper.select(grupoCuenta);
		return grupoCuentaResult;
	}
}
