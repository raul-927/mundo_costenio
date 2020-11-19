package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Caja;
import co.com.mundocostenio.mybatis.mappers.CajaMapper;

@Service("cajaService")
public class CajaServiceImpl implements CajaService {
	
	@Autowired
	private CajaMapper cajaMapper;

	@Override
	@Transactional
	public Caja insert(Caja caja) {
		this.cajaMapper.insert(caja);
		return caja;
	}

	@Override
	@Transactional
	public Caja update(Caja caja) {
		this.cajaMapper.update(caja);
		return caja;
	}

	@Override
	@Transactional
	public int delete(Caja caja) {
		return this.cajaMapper.delete(caja);
	}

	@Override
	public List<Caja> select(Caja caja) {
		return this.cajaMapper.select(caja);
	}
}