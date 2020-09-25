package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.PrecioProducto;

public interface PrecioProductoService {
	
	List<PrecioProducto> insert(List<PrecioProducto> precioProductoList);
	
	int insertListaAndPrecioProducto(int listaId, List<PrecioProducto> precioProductoList);
	
	List<PrecioProducto> selectPrecioProductoByListId(int listId);
	
	//int insertPrecioProducto(List<PrecioProducto> precioProductoList);

}
