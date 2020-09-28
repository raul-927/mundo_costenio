package co.com.mundocostenio.services;

import java.util.List;

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

	@Override
	public Producto update(Producto producto) {
		this.productoMapper.update(producto);
		return producto;
	}

	@Override
	public int delete(int prodId) {
		return this.productoMapper.delete(prodId);
	}

	@Override
	public List<Producto> selectProducto(Producto producto) {
		return this.productoMapper.selectProducto(producto);
	}

}
