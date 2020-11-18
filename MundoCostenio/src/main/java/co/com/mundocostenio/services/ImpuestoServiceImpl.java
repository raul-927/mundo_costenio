package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.Impuesto;
import co.com.mundocostenio.mybatis.mappers.ImpuestoMapper;

@Service("impustoService")
public class ImpuestoServiceImpl implements ImpuestoService {
	
	@Autowired
	private ImpuestoMapper impuestoMapper;

	@Override
	public Impuesto insert(Impuesto impuesto) {
		this.impuestoMapper.insert(impuesto);
		return impuesto;
	}

	@Override
	public Impuesto update(Impuesto impuesto) {
		this.impuestoMapper.update(impuesto);
		return impuesto;
	}

	@Override
	public void delete(Impuesto impuesto) {
		this.impuestoMapper.delete(impuesto);
	}

	@Override
	public List<Impuesto> select(Impuesto impuesto) {
		return this.impuestoMapper.select(impuesto);
	}

}
