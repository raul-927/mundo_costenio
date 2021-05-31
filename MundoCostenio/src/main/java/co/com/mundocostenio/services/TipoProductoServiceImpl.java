package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.TipoProducto;
import co.com.mundocostenio.mybatis.mappers.TipoProductoMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("tipoProductoService")
public class TipoProductoServiceImpl implements TipoProductoService {
	
	@Autowired
	private TipoProductoMapper tipoProductoMapper;
	
	@Autowired
	private AccesControlListService<TipoProducto> accesControlListService;

	@Override
	@Transactional
	@PreAuthorize(value ="hasRole('ROLE_MARKETING')")
	public TipoProducto insert(TipoProducto tipoProducto) {
		this.tipoProductoMapper.insert(tipoProducto);
		accesControlListService.insert(tipoProducto);
		
		return tipoProducto;
	}

	@Override
	@PreAuthorize("hasPermission(#tipoProducto, 'WRITE')")
	public TipoProducto update(@Param("tipoProducto") TipoProducto tipoProducto) {
		this.tipoProductoMapper.update(tipoProducto);
		return tipoProducto;
	}

	@Override
	@PreAuthorize("hasPermission(#tipProdId, 'DELETE')")
	public int delete(@Param("tipProdId") int tipProdId) {
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setTipProdId(tipProdId);
		this.accesControlListService.delete(tipoProducto);
		return this.tipoProductoMapper.delete(tipProdId);
	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<TipoProducto> selectTipoProducto(TipoProducto tipoProducto) {
		return this.tipoProductoMapper.selectTipoProducto(tipoProducto);
	}

}
