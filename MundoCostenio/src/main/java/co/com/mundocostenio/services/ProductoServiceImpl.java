package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
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
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("productoService")
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private AccesControlListService<Producto> accesControlListService;
	
	@Autowired
	private ProductoMapper productoMapper;

	@Override
	@PreAuthorize(value ="hasRole('ROLE_MARKETING')")
	public Producto insert(Producto producto) {
		Integer id = this.accesControlListService.insert(producto);
		producto.setProdId(id);
		this.productoMapper.insert(producto);
		return producto;
	}

	@Override
	@PreAuthorize("hasPermission(#producto, 'WRITE')")
	public Producto update(@Param("producto") Producto producto) {
		this.productoMapper.update(producto);
		return producto;
	}

	@Override
	@PreAuthorize("hasPermission(#prodId, 'DELETE')")
	public int delete(@Param("prodId") int prodId) {
		Producto producto = new Producto();
		producto.setProdId(prodId);
		this.accesControlListService.delete(producto);
		return this.productoMapper.delete(prodId);
	}

	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Producto> selectProducto(Producto producto) {
		return this.productoMapper.selectProducto(producto);
	}

}
