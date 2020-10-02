package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Calle;
import co.com.mundocostenio.mybatis.mappers.CalleMapper;


@Service("calleService")
public class CalleServiceImpl implements CalleService {
	@Autowired
	private CalleMapper calleMapper;

	@Override
	public Calle insert(Calle calle) {
		this.calleMapper.insert(calle);
		return calle;
	}
	
	@Override
	public void insertDireccionCalles(int direccionId, List<Calle> calles) {
		this.calleMapper.insertDireccionCalles(direccionId, calles);
	}
	

	@Override
	public Calle update(Calle calle) {
		this.calleMapper.update(calle);
		return calle;
	}

	@Override
	public void delete(Calle calle) {
		this.calleMapper.delete(calle.getCalleId());
		
	}

	@Override
	public List<Calle> select(Calle calle) {
		
		return this.calleMapper.select(calle);
	}

	
	
}
