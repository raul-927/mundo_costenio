package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.model.ListaPrecios;
import co.com.mundocostenio.domain.model.Producto;

public interface ListaPreciosService {
	ListaPrecios insert(ListaPrecios listaPrecios);
	
	List<ListaPrecios> selectListaPrecios(ListaPrecios listaPrecios);
	ListaPrecios selectActualListaPrecios();
	List<Producto> selectNuevoProducto();
}
