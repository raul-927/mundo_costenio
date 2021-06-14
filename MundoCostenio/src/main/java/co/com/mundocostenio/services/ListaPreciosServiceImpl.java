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
import co.com.mundocostenio.enumerator.RolesEnum;
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
		Integer id = this.accesControlListService.insert(listaPrecios);
		listaPrecios.setListaPrecioId(id);
		this.fechaVigenciaMapper.insert(listaPrecios.getFechaVigencia());
		this.precioProductoMapper.insert(listaPrecios.getPrecioProductoList());
		this.listaPreciosMapper.insert(listaPrecios);
		this.precioProductoMapper.insertListaAndPrecioProducto(listaPrecios.getListaPrecioId(), listaPrecios.getPrecioProductoList());
		return listaPrecios;
	}
	@Override
	@PostFilter("hasPermission(#listaPrecios, 'READ')")
	public List<ListaPrecios> selectListaPrecios(ListaPrecios listaPrecios) {
		return this.listaPreciosMapper.selectListaPrecios(listaPrecios);
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
