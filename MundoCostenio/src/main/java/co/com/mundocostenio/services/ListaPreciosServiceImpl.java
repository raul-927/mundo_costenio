package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.ListaPrecios;
import co.com.mundocostenio.mybatis.mappers.FechaVigenciaListaPreciosMapper;
import co.com.mundocostenio.mybatis.mappers.ListaPreciosMapper;
import co.com.mundocostenio.mybatis.mappers.PrecioProductoMapper;

@Service("listaPreciosService")
public class ListaPreciosServiceImpl implements ListaPreciosService {
	
	@Autowired
	private ListaPreciosMapper listaPreciosMapper;
	
	@Autowired
	private PrecioProductoMapper precioProductoMapper;
	
	@Autowired
	private FechaVigenciaListaPreciosMapper fechaVigenciaMapper;

	@Override
	public ListaPrecios insert(ListaPrecios listaPrecios) {
		this.fechaVigenciaMapper.insert(listaPrecios.getFechaVigencia());
		this.precioProductoMapper.insert(listaPrecios.getPrecioProductoList());
		this.listaPreciosMapper.insert(listaPrecios);
		this.precioProductoMapper.insertListaAndPrecioProducto(listaPrecios.getListaPrecioId(), listaPrecios.getPrecioProductoList());
		return listaPrecios;
	}

	@Override
	public List<ListaPrecios> selectListaPrecios(ListaPrecios listaPrecios) {
		return this.listaPreciosMapper.selectListaPrecios(listaPrecios);
	}

}
