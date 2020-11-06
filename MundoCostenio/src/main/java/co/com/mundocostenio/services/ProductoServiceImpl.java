package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.Producto;
import co.com.mundocostenio.enumerator.RolesEnum;
import co.com.mundocostenio.mybatis.mappers.ProductoMapper;


@Service("productoService")
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private MutableAclService mutableAclService;
	
	@Autowired
	private ProductoMapper productoMapper;

	@Override
	@PreAuthorize(value ="hasRole('ROLE_USER')")
	public Producto insert(Producto producto) {
		Integer id = Math.abs(producto.hashCode());
		System.out.println("id: " + id);
		ObjectIdentity objectIdentity = new ObjectIdentityImpl(Producto.class, id);
		MutableAcl mutableAcl = mutableAclService.createAcl(objectIdentity);
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("userName:" +user.getUsername());
        System.out.println("userPassword:" +user.getPassword());
        for(GrantedAuthority authority: user.getAuthorities()) {
        	System.out.println("userAuthority: " + authority.getAuthority());
        }
        mutableAcl.insertAce(0, BasePermission.ADMINISTRATION, new PrincipalSid(user.getUsername()), true);
        mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
        mutableAcl.insertAce(2, BasePermission.READ, new GrantedAuthoritySid(RolesEnum.USER.getDescripcion()), true);
		mutableAclService.updateAcl(mutableAcl);
		this.productoMapper.insert(producto);
		return producto;
	}

	@Override
	@PreAuthorize("hasPermission(#producto, 'ADMINISTRATION')")
	public Producto update(@Param("producto") Producto producto) {
		this.productoMapper.update(producto);
		return producto;
	}

	@Override
	@PreAuthorize("hasPermission(#prodId, 'DELETE')")
	public int delete(@Param("prodId") int prodId) {
		ObjectIdentity oid = new ObjectIdentityImpl(Producto.class, prodId);
		mutableAclService.deleteAcl(oid, true);
		return this.productoMapper.delete(prodId);
	}

	@Override
	@PostAuthorize("hasPermission(filterObject, 'READ')")
	public List<Producto> selectProducto(Producto producto) {
		return this.productoMapper.selectProducto(producto);
	}

}
