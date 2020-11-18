package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.GrupoCuenta;
import co.com.mundocostenio.mybatis.mappers.GrupoCuentaMapper;

@Service("grupoCuentaService")
public class GrupoCuentaServiceImpl implements GrupoCuentaService {
	
	@Autowired
	private GrupoCuentaMapper grupoCuentaMapper;

	@Override
	public GrupoCuenta insert(GrupoCuenta grupoCuenta) {
		this.grupoCuentaMapper.insert(grupoCuenta);
		return grupoCuenta;
	}

	@Override
	public GrupoCuenta update(GrupoCuenta grupoCuenta) {
		this.grupoCuentaMapper.update(grupoCuenta);
		return grupoCuenta;
	}

	@Override
	public void delete(GrupoCuenta grupoCuenta) {
		this.grupoCuentaMapper.delete(grupoCuenta);
	}

	@Override
	public List<GrupoCuenta> select(GrupoCuenta grupoCuenta) {
		
		return this.grupoCuentaMapper.select(grupoCuenta);
	}

}
