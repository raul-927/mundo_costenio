package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.Cuenta;
import co.com.mundocostenio.mybatis.mappers.CuentaMapper;


@Service("cuentaService")
public class CuentaServiceImpl implements CuentaService {
	
	@Autowired
	private CuentaMapper cuentaMapper;

	@Override
	public Cuenta insert(Cuenta cuenta) {
		this.cuentaMapper.insert(cuenta);
		return cuenta;
	}

	@Override
	public Cuenta update(Cuenta cuenta) {
		this.cuentaMapper.update(cuenta);
		return cuenta;
	}

	@Override
	public void delete(Cuenta cuenta) {
		this.cuentaMapper.delete(cuenta);

	}

	@Override
	public List<Cuenta> select(Cuenta cuenta) {
		return this.cuentaMapper.select(cuenta);
	}

}
