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


@Service("tipoProductoService")
public class TipoProductoServiceImpl implements TipoProductoService {
	
	@Autowired
	private MutableAclService mutableAclService;
	
	@Autowired
	private TipoProductoMapper tipoProductoMapper;

	@Override
	@Transactional
	public TipoProducto insert(TipoProducto tipoProducto) {
		Integer id = Math.abs(tipoProducto.hashCode());
		System.out.println("id: " + id);
		ObjectIdentity objectIdentity = new ObjectIdentityImpl(TipoProducto.class, id);
		MutableAcl mutableAcl = mutableAclService.createAcl(objectIdentity);
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
        mutableAcl.insertAce(0, BasePermission.ADMINISTRATION, new PrincipalSid(user.getUsername()), true);
        mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid("ROLE_ADMIN"), true);
        mutableAcl.insertAce(2, BasePermission.READ, new GrantedAuthoritySid("ROLE_USER"), true);
		mutableAclService.updateAcl(mutableAcl);
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
