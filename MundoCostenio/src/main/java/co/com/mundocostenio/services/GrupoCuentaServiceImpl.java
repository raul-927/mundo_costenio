package co.com.mundocostenio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.GrupoCuenta;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
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
		this.select(grupoCuenta);
		this.grupoCuentaMapper.update(grupoCuenta);
		return grupoCuenta;
	}

	@Override
	public void delete(GrupoCuenta grupoCuenta) {
		this.select(grupoCuenta);
		this.grupoCuentaMapper.delete(grupoCuenta);
	}

	@Override
	public List<GrupoCuenta> select(GrupoCuenta grupoCuenta) {
		List<GrupoCuenta>grupoCuentaResult = this.grupoCuentaMapper.select(grupoCuenta);
		
		verificarGrupoCuenta(grupoCuentaResult,grupoCuenta);
		
		return grupoCuentaResult;
	}
	
	private void verificarGrupoCuenta(List<GrupoCuenta>grupoCuentaResult, GrupoCuenta grupoCuenta) {
		
		if(grupoCuentaResult.size() == 0) {
			if(grupoCuenta.getGrupoCuentaId()!= null || grupoCuenta.getId() != null) {
				if(grupoCuenta.getGrupoCuentaId()!= null && grupoCuenta.getGrupoCuentaId() > 0) {
					throw new ResourceNotFoundException("Grupo Cuenta con id: " +grupoCuenta.getGrupoCuentaId()+"  no encontrado");
				}
				else {
					throw new ResourceNotFoundException("Grupo Cuenta no encontrado");
				}
			}
			else {
				throw new ResourceNotFoundException("No existen registros en la tabla grupo_cuenta");
			}
		}
	}

}
