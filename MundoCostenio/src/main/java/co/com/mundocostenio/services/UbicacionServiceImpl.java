package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Ubicacion;
import co.com.mundocostenio.mybatis.mappers.UbicacionMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("ubicacionService")
public class UbicacionServiceImpl implements UbicacionService {
	
	@Autowired
	private UbicacionMapper ubicacionMapper;
	
	@Autowired
	private AccesControlListService<Ubicacion> accesControlListService;

	@Override
	@Transactional
	@PreAuthorize(value ="hasRole('ROLE_CONFIG')")
	public Ubicacion insert(Ubicacion ubicacion) {
		this.ubicacionMapper.insert(ubicacion);
		this.accesControlListService.insert(ubicacion);
		return ubicacion;
	}

	@Override
	@PreAuthorize("hasPermission(#ubicacion, 'WRITE')")
	public Ubicacion update(Ubicacion ubicacion) {
		this.ubicacionMapper.update(ubicacion);
		return ubicacion;
	}
	
	@Override
	@PreAuthorize("hasPermission(#ubicacion, 'DELETE')")
	public void delete(Ubicacion ubicacion) {
		this.ubicacionMapper.delete(ubicacion);
		this.accesControlListService.delete(ubicacion);
	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Ubicacion> select(Ubicacion ubicacion) {
		List<Ubicacion> ubicacionResult = this.ubicacionMapper.select(ubicacion);
		return ubicacionResult;
	}

}
