package co.com.mundocostenio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.FechaVigenciaListaPrecios;
import co.com.mundocostenio.mybatis.mappers.FechaVigenciaListaPreciosMapper;

@Service("fechaVigenciaListaPreciosService")
public class FechaVigenciaListaPreciosServiceImpl implements FechaVigenciaListaPreciosService {

	@Autowired
	private FechaVigenciaListaPreciosMapper fechaVigenciaListaPreciosMapper;

	@Override
	public FechaVigenciaListaPrecios insert(FechaVigenciaListaPrecios fechaVigenciaListaPrecios) {
		this.fechaVigenciaListaPreciosMapper.insert(fechaVigenciaListaPrecios);
		return fechaVigenciaListaPrecios;
	}

}
