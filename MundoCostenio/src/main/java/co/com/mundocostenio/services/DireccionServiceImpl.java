package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.model.Direccion;
import co.com.mundocostenio.mybatis.mappers.CalleMapper;
import co.com.mundocostenio.mybatis.mappers.DireccionMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("direccionService")
public class DireccionServiceImpl implements DireccionService {
	
	@Autowired
	private AccesControlListService<Direccion> accesControlListService;
	
	@Autowired
	private DireccionMapper direccionMapper;
	
	@Autowired
	private CalleMapper calleMapper;

	@Override
	@PreAuthorize(value ="hasRole('ROLE_RRHH')")
	@Transactional
	public List<Direccion> insert(List<Direccion> direcciones) {
		List<Direccion> direccionesResult = null;
		if(direcciones!= null && direcciones.size() > 0) {
			direccionesResult = this.ejutarInsert(direcciones);
			for(Direccion dir: direccionesResult) {
				this.accesControlListService.insert(dir);
			}
		}
		
		return direccionesResult;
	}

	@Transactional
	@Override
	public void insertPersonaDirecciones(int personaId, List<Direccion> direcciones) {
		if(direcciones !=null && direcciones.size() > 0) {
			this.direccionMapper.insertPersonaDirecciones(personaId, direcciones);
		}
		

	}
	
	private List<Direccion>ejutarInsert(List<Direccion> direcciones){
		this.direccionMapper.insert(direcciones);
		for(Direccion direccion: direcciones) {
			this.calleMapper.insertDireccionCalles(direccion.getDireccionId(), direccion.getCalles());
		}
		
		return direcciones;
	}

}
