package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Calle;
import co.com.mundocostenio.mybatis.mappers.CalleMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;
import co.com.mundocostenio.statemachine.Events;
import co.com.mundocostenio.statemachine.States;


@Service("calleService")
public class CalleServiceImpl implements CalleService {
	
	@Autowired
	private AccesControlListService<Calle> accesControlListService;
	
	@Autowired
	private CalleMapper calleMapper;
	
	@Autowired
	private StateMachine<States, Events> stateMachine;

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
		stateMachine.sendEvent(Events.EVENT1);
	}
	

	@Override
	@Transactional
	@PreAuthorize(value="hasPermission(#calle, 'WRITE')")
	public Calle update(Calle calle){
		this.calleMapper.update(calle);
		return calle;
	}

	@Override
	@Transactional
	@PreAuthorize(value="hasPermission(#calle, 'DELETE')")
	public void delete(Calle calle){
		this.calleMapper.delete(calle);
		this.accesControlListService.delete(calle);
	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Calle> select(Calle calle) {
		return this.calleMapper.select(calle);
	}
}
