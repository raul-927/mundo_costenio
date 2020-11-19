package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Asiento;
import co.com.mundocostenio.mybatis.mappers.AsientoMapper;

@Service("asientoService")
public class AsientoServiceImpl implements AsientoService {
	
	@Autowired
	private AsientoMapper asientoMapper;

	@Override
	@Transactional
	public Asiento insert(Asiento asiento) {
		this.asientoMapper.insert(asiento);
		return asiento;
	}

	@Override
	@Transactional
	public Asiento update(Asiento asiento) {
		this.asientoMapper.update(asiento);
		return asiento;
	}

	@Override
	public List<Asiento> select(Asiento asiento) {
		return this.asientoMapper.select(asiento);
	}
}