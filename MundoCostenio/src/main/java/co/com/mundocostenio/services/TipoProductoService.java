package co.com.mundocostenio.services;

import co.com.mundocostenio.domain.TipoProducto;

public interface TipoProductoService {
	
	TipoProducto insert(TipoProducto tipoProducto);
	TipoProducto update(TipoProducto tipoProducto);
	int delete(int tipProdId);
	TipoProducto selectTipoProducto(TipoProducto tipoProducto);

}
