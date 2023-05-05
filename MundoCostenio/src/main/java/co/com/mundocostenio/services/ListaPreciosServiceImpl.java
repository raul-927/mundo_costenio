package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.ListaPrecios;
import co.com.mundocostenio.domain.Producto;
import co.com.mundocostenio.mybatis.mappers.FechaVigenciaListaPreciosMapper;
import co.com.mundocostenio.mybatis.mappers.ListaPreciosMapper;
import co.com.mundocostenio.mybatis.mappers.PrecioProductoMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;

@Service("listaPreciosService")
public class ListaPreciosServiceImpl implements ListaPreciosService {
	
	@Autowired
	private ListaPreciosMapper listaPreciosMapper;
	
	@Autowired
	private PrecioProductoMapper precioProductoMapper;
	
	@Autowired
	private FechaVigenciaListaPreciosMapper fechaVigenciaMapper;
	
	@Autowired
	private AccesControlListService<ListaPrecios> accesControlListService;

	@Override
	@Transactional
	@PreAuthorize("hasRole('ROLE_SALES')")
	public ListaPrecios insert(ListaPrecios listaPrecios) {
		this.fechaVigenciaMapper.insert(listaPrecios.getFechaVigencia());
		this.precioProductoMapper.insert(listaPrecios.getPrecioProductoList());
		this.listaPreciosMapper.insert(listaPrecios);
		this.precioProductoMapper.insertListaAndPrecioProducto(listaPrecios.getListaPrecioId(), listaPrecios.getPrecioProductoList());
		Integer id = this.accesControlListService.insert(listaPrecios);
		return listaPrecios;
	}
	
	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<ListaPrecios> selectListaPrecios(ListaPrecios listaPrecios) {
		List<ListaPrecios> listaPrecioResult =  this.listaPreciosMapper.selectListaPrecios(listaPrecios);
		return listaPrecioResult;
	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public ListaPrecios selectActualListaPrecios() {
		return this.listaPreciosMapper.selectActualListaPrecios();
		
	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Producto> selectNuevoProducto() {
		return this.listaPreciosMapper.selectNuevoProducto();
	}
}
