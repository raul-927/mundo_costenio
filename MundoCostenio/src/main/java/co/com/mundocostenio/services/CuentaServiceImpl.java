package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.model.Cuenta;
import co.com.mundocostenio.mybatis.mappers.CuentaMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("cuentaService")
public class CuentaServiceImpl implements CuentaService {
	
	@Autowired
	private CuentaMapper cuentaMapper;
	
	@Autowired
	private AccesControlListService<Cuenta> accesControlListService;

	@Override
	@Transactional
	@PreAuthorize(value ="hasRole('ROLE_COUNTER')")
	public Cuenta insert(Cuenta cuenta) {
		this.cuentaMapper.insert(cuenta);
		this.accesControlListService.insert(cuenta);
		return cuenta;
	}

	@Override
	@Transactional
	@PreAuthorize(value="hasPermission(#cuenta, 'WRITE')")
	public Cuenta update(@Param("cuenta") Cuenta cuenta) {
		List<Cuenta> cuentas = this.select(cuenta);
		if(!cuentas.isEmpty()) {
			this.cuentaMapper.update(cuenta);
		}
		
		return cuenta;
	}

	@Override
	@Transactional
	@PreAuthorize(value="hasPermission(#cuenta, 'DELETE')")
	public void delete(@Param("cuenta") Cuenta cuenta) {
		this.select(cuenta);
		this.cuentaMapper.delete(cuenta);
		this.accesControlListService.delete(cuenta);
	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Cuenta> select(Cuenta cuenta) {
		List<Cuenta> cuentaResult = this.cuentaMapper.select(cuenta);
		return cuentaResult;
	}
}