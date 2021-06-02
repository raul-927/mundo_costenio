package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.PrecioProducto;
import co.com.mundocostenio.domain.TipoProducto;
import co.com.mundocostenio.mybatis.mappers.PrecioProductoMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("precioProductoService")
public class PrecioProductoServiceImpl implements PrecioProductoService {
	
	@Autowired
	private PrecioProductoMapper precioProductoMapper;
	

	@Autowired
	private AccesControlListService<PrecioProducto> accesControlListService;

	
	@Override
	@Transactional
	@PreAuthorize(value ="hasRole('ROLE_SALES')")
	public List<PrecioProducto> insert(List<PrecioProducto> precioProductoList) {
			this.precioProductoMapper.insert(precioProductoList);
			for(PrecioProducto precP: precioProductoList) {
				this.accesControlListService.insert(precP);
			}
		return precioProductoList;
	}
	
	@Override
	@Transactional
	@PreAuthorize(value ="hasRole('ROLE_SALES')")
	public int insertListaAndPrecioProducto(int listaId, List<PrecioProducto> precioProductoList) {
		
		this.precioProductoMapper.insertListaAndPrecioProducto(listaId, precioProductoList);
		
		return 0;
	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<PrecioProducto> selectPrecioProductoByListId(int listId) {
		List<PrecioProducto> precioProductoResult = this.precioProductoMapper.selectPrecioProductoByListId(listId);
		return precioProductoResult;
	}
	
}
