package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.Barrio;
import co.com.mundocostenio.mybatis.mappers.BarrioMapper;


@Service("barrioService")
public class BarrioServiceImpl implements BarrioService {
	
	@Autowired
	private BarrioMapper barrioMapper;

	@Override
	public Barrio insert(Barrio barrio) {
		this.barrioMapper.insert(barrio);
		return barrio;
	}

	@Override
	public Barrio update(Barrio barrio) {
		this.barrioMapper.update(barrio);
		return barrio;
	}

	@Override
	public int delete(int barrioId) {
		return this.barrioMapper.delete(barrioId);
	}

	@Override
	public List<Barrio> select(Barrio barrio) {
		return this.barrioMapper.select(barrio);
	}

}
