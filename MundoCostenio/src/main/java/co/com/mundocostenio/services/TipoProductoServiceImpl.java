package co.com.mundocostenio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Post;
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
	public TipoProducto insert(TipoProducto tipoProducto) {
		Integer id = accesControlListService.insert(tipoProducto);
		tipoProducto.setTipProdId(id);
		this.tipoProductoMapper.insert(tipoProducto);
		return tipoProducto;
	}

	@Override
	public TipoProducto update(TipoProducto tipoProducto) {
		this.tipoProductoMapper.update(tipoProducto);
		return tipoProducto;
	}

	@Override
	public int delete(int tipProdId) {
		
		return this.tipoProductoMapper.delete(tipProdId);
	}

	@Override
	public TipoProducto selectTipoProducto(TipoProducto tipoProducto) {
		
		return this.tipoProductoMapper.selectTipoProducto(tipoProducto);
	}

}
