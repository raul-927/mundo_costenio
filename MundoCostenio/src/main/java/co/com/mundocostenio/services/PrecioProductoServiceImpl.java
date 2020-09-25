package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.PrecioProducto;
import co.com.mundocostenio.mybatis.mappers.PrecioProductoMapper;


@Service("precioProductoService")
public class PrecioProductoServiceImpl implements PrecioProductoService {
	
	@Autowired
	private PrecioProductoMapper precioProductoMapper;

	@Transactional
	@Override
	public List<PrecioProducto> insert(List<PrecioProducto> precioProductoList) {
			this.precioProductoMapper.insert(precioProductoList);
		return precioProductoList;
	}
	
	@Transactional
	@Override
	public int insertListaAndPrecioProducto(int listaId, List<PrecioProducto> precioProductoList) {
		
		this.precioProductoMapper.insertListaAndPrecioProducto(listaId, precioProductoList);
		
		return 0;
	}

	@Override
	public List<PrecioProducto> selectPrecioProductoByListId(int listId) {
		List<PrecioProducto> precioProductoResult = this.precioProductoMapper.selectPrecioProductoByListId(listId);
		return precioProductoResult;
	}
	
}
