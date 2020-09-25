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
	
	@Transactional
	@Override
	public Calle insertCalle(Calle calle) {
		this.calleMapper.insertCalle(calle);
		return calle;
	}
	
	@Transactional
	@Override
	public Calle updateCalle(Calle calle) {
		return this.calleMapper.updateCalle(calle);
	}

	@Override
	public void deleteCalle(Calle calle) {
		this.calleMapper.deleteCalle(calle);
	}

	@Override
	public List<Calle> showCalle(Calle calle) {
		return this.calleMapper.showCalle(calle);
	}

}
