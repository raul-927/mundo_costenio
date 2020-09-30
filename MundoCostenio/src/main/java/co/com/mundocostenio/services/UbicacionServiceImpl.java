package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.Ubicacion;
import co.com.mundocostenio.mybatis.mappers.UbicacionMapper;


@Service("ubicacionService")
public class UbicacionServiceImpl implements UbicacionService {
	
	@Autowired
	private UbicacionMapper ubicacionMapper;

	@Override
	public Ubicacion insert(Ubicacion ubicacion) {
		this.ubicacionMapper.insert(ubicacion);
		return ubicacion;
	}

	@Override
	public Ubicacion update(Ubicacion ubicacion) {
		this.ubicacionMapper.update(ubicacion);
		return ubicacion;
	}
	
	@Override
	public int delete(int ubicacionId) {
		return this.ubicacionMapper.delete(ubicacionId);
	}

	@Override
	public List<Ubicacion> select(Ubicacion ubicacion) {
		List<Ubicacion> ubicacionResult = this.ubicacionMapper.select(ubicacion);
		return ubicacionResult;
	}

}
