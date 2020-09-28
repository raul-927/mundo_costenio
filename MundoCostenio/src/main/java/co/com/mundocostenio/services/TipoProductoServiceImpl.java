package co.com.mundocostenio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.TipoProducto;
import co.com.mundocostenio.mybatis.mappers.TipoProductoMapper;


@Service("tipoProductoService")
public class TipoProductoServiceImpl implements TipoProductoService {
	
	@Autowired
	private TipoProductoMapper tipoProductoMapper;

	@Override
	public TipoProducto insert(TipoProducto tipoProducto) {
		this.tipoProductoMapper.insert(tipoProducto);
		return tipoProducto;
	}

	@Override
	public TipoProducto update(TipoProducto tipoProducto) {
		this.tipoProductoMapper.update(tipoProducto);
		return tipoProducto;
	}

	@Override
	public int delete(int tipProdId) {
		
		return this.tipoProductoMapper.delete(tipProdId);
	}

	@Override
	public TipoProducto selectTipoProducto(TipoProducto tipoProducto) {
		
		return this.tipoProductoMapper.selectTipoProducto(tipoProducto);
	}

}
