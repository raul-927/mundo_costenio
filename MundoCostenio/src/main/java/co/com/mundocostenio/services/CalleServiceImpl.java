package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Calle;
import co.com.mundocostenio.mybatis.mappers.CalleMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("calleService")
public class CalleServiceImpl implements CalleService {
	
	@Autowired
	private AccesControlListService<Calle> accesControlListService;
	
	@Autowired
	private CalleMapper calleMapper;

	@Override
	@PreAuthorize(value ="hasRole('ROLE_CONFIG')")
	@Transactional
	public Calle insert(@Param("calle") Calle calle) {
		this.calleMapper.insert(calle);
		accesControlListService.insert(calle);
		return calle;
	}
	
	@Override
	public void insertDireccionCalles(int direccionId, List<Calle> calles) {
		this.calleMapper.insertDireccionCalles(direccionId, calles);
	}
	

	@Override
	@Transactional
	@PreAuthorize("hasPermission(#calle, 'WRITE')")
	public Calle update(@Param("calle") Calle calle) throws Exception {
		if(calle!=null && calle.getCalleId()!=null) {
			this.calleMapper.update(calle);
		}
		else {
			throw new Exception("calleId no debe ser null");
		}
		return calle;
	}

	@Override
	public void delete(Calle calle)throws Exception {
		if(calle!=null && calle.getCalleId()!=null) {
			this.calleMapper.delete(calle);
		}
		else {
			throw new Exception("calleId no debe ser null");
		}
		
	}

	@Override
	public List<Calle> select(Calle calle) {
		return this.calleMapper.select(calle);
	}
}
