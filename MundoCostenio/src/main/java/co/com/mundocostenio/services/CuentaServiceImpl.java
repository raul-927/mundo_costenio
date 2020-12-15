package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Cuenta;
import co.com.mundocostenio.mybatis.mappers.CuentaMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("cuentaService")
public class CuentaServiceImpl implements CuentaService {
	
	@Autowired
	private CuentaMapper cuentaMapper;
	
	@Autowired
	private AccesControlListService<Cuenta> accesControlListService;

	@Override
	@PreAuthorize(value ="hasRole('ROLE_COUNTER')")
	@Transactional
	public Cuenta insert(@Param("cuenta") Cuenta cuenta) {
		this.cuentaMapper.insert(cuenta);
		this.accesControlListService.insert(cuenta);
		return cuenta;
	}

	@Override
	@Transactional
	@PreAuthorize(value="hasPermission(#cuenta, 'WRITE')")
	public Cuenta update(@Param("cuenta") Cuenta cuenta) {
		this.cuentaMapper.update(cuenta);
		return cuenta;
	}

	@Override
	@Transactional
	@PreAuthorize(value="hasPermission(#cuenta, 'DELETE')")
	public void delete(@Param("cuenta") Cuenta cuenta) {
		this.cuentaMapper.delete(cuenta);

	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Cuenta> select(@Param("cuenta") Cuenta cuenta) {
		return this.cuentaMapper.select(cuenta);
	}

}
