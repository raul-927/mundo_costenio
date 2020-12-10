package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.TipoProducto;

public interface TipoProductoService {
	
	TipoProducto insert(TipoProducto tipoProducto);
	TipoProducto update(TipoProducto tipoProducto);
	int delete(int tipProdId);
	List<TipoProducto> selectTipoProducto(TipoProducto tipoProducto);

}
