package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.model.Producto;

public interface ProductoService {
	Producto insert(Producto producto);
	Producto update(Producto producto);
	int delete(Producto producto);
	List<Producto> selectProducto(Producto producto);
}
