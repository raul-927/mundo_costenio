package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Barrio;
import co.com.mundocostenio.domain.Post;
import co.com.mundocostenio.mybatis.mappers.BarrioMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("barrioService")
public class BarrioServiceImpl implements BarrioService {
	
	@Autowired
	private AccesControlListService<Barrio> accesControlListService;
	
	@Autowired
	private BarrioMapper barrioMapper;

	@Override
	@PreAuthorize(value ="hasRole('ROLE_CONFIG')")
	@Transactional
	public Barrio insert(Barrio barrio) {
		this.barrioMapper.insert(barrio);
		this.accesControlListService.insert(barrio);
		return barrio;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission(#barrio, 'WRITE')")
	public Barrio update(Barrio barrio) {
		this.barrioMapper.update(barrio);
		return barrio;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission(#barrioId, 'DELETE')")
	public int delete(int barrioId) {
		return this.barrioMapper.delete(barrioId);
	}

	@Override
	@PostAuthorize("hasPermission(filterObject,'READ')")
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Barrio> select(Barrio barrio) {
		return this.barrioMapper.select(barrio);
	}

}
