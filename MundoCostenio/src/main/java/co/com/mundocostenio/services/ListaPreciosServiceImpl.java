package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.ListaPrecios;
import co.com.mundocostenio.domain.LoggedUser;
import co.com.mundocostenio.domain.Post;
import co.com.mundocostenio.domain.Producto;
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
	
	@Autowired
	private MutableAclService mutableAclService;

	@Override
	@Transactional
	public ListaPrecios insert(ListaPrecios listaPrecios) {
		
		Integer id = Math.abs(listaPrecios.hashCode());
		System.out.println("id: " + id);
		ObjectIdentity objectIdentity = new ObjectIdentityImpl(ListaPrecios.class, id);
		MutableAcl mutableAcl = mutableAclService.createAcl(objectIdentity);
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mutableAcl.insertAce(0, BasePermission.ADMINISTRATION, new PrincipalSid(user.getUsername()), true);
        mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid("ROLE_ADMIN"), true);
        mutableAcl.insertAce(2, BasePermission.READ, new GrantedAuthoritySid("ROLE_USER"), true);
		mutableAclService.updateAcl(mutableAcl);
		listaPrecios.setListaPrecioId(id);
		this.fechaVigenciaMapper.insert(listaPrecios.getFechaVigencia());
		this.precioProductoMapper.insert(listaPrecios.getPrecioProductoList());
		this.listaPreciosMapper.insert(listaPrecios);
		this.precioProductoMapper.insertListaAndPrecioProducto(listaPrecios.getListaPrecioId(), listaPrecios.getPrecioProductoList());
		return listaPrecios;
	}
	//@PostFilter("hasPermission(filterObject, 'READ')")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	//@Secured("hasRole('ROLE_ADMIN')")
	@Override
	public List<ListaPrecios> selectListaPrecios(ListaPrecios listaPrecios) {
		Authentication userDetails = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		System.out.println("User has authorities: " + userDetails.getAuthorities());
		System.out.println("User has Name: " + userDetails.getName());
		System.out.println("User has Credentials: " + userDetails.getCredentials());

		return this.listaPreciosMapper.selectListaPrecios(listaPrecios);
	}

	@Override
	public ListaPrecios selectActualListaPrecios() {
		return this.listaPreciosMapper.selectActualListaPrecios();
		
	}

	@Override
	public List<Producto> selectNuevoProducto() {
		return this.listaPreciosMapper.selectNuevoProducto();
		
	}

}
