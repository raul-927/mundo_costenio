package co.com.mundocostenio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.Producto;
import co.com.mundocostenio.mybatis.mappers.ProductoMapper;


@Service("productoService")
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoMapper productoMapper;

	@Override
	public Producto insert(Producto producto) {
		this.productoMapper.insert(producto);
		return producto;
	}

}
