package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Direccion;
import co.com.mundocostenio.mybatis.mappers.CalleMapper;
import co.com.mundocostenio.mybatis.mappers.DireccionMapper;


@Service("direccionService")
public class DireccionServiceImpl implements DireccionService {
	
	@Autowired
	private DireccionMapper direccionMapper;
	
	@Autowired
	private CalleMapper calleMapper;

	@Transactional
	@Override
	public List<Direccion> insert(List<Direccion> direcciones) {
		
		return this.ejutarInsert(direcciones);
	}

	@Transactional
	@Override
	public void insertPersonaDirecciones(int personaId, List<Direccion> direcciones) {
		this.direccionMapper.insertPersonaDirecciones(personaId, direcciones);

	}
	
	private List<Direccion>ejutarInsert(List<Direccion> direcciones){
		this.direccionMapper.insert(direcciones);
		for(Direccion direccion: direcciones) {
			this.calleMapper.insertDireccionCalles(direccion.getDireccionId(), direccion.getCalles());
		}
		
		return direcciones;
	}

}
