package co.com.mundocostenio.services;

import java.util.List;

import co.com.mundocostenio.domain.ListaPrecios;

public interface ListaPreciosService {
	ListaPrecios insert(ListaPrecios listaPrecios);
	
	List<ListaPrecios> selectListaPrecios(ListaPrecios listaPrecios);
	ListaPrecios selectActualListaPrecios();
}
