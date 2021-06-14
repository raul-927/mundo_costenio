package co.com.mundocostenio.security.acl;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.stereotype.Component;

import co.com.mundocostenio.domain.Barrio;
import co.com.mundocostenio.domain.Calle;
import co.com.mundocostenio.domain.Cuenta;
import co.com.mundocostenio.domain.Departamento;
import co.com.mundocostenio.domain.Direccion;
import co.com.mundocostenio.domain.GrupoCuenta;
import co.com.mundocostenio.domain.Impuesto;
import co.com.mundocostenio.domain.ListaPrecios;
import co.com.mundocostenio.domain.Persona;
import co.com.mundocostenio.domain.Post;
import co.com.mundocostenio.domain.PrecioProducto;
import co.com.mundocostenio.domain.Producto;
import co.com.mundocostenio.domain.Rol;
import co.com.mundocostenio.domain.TipoProducto;
import co.com.mundocostenio.enumerator.RolesEnum;

@Component
public class AccesControlListService<T> {
	
	@Autowired
	private MutableAclService mutableAclService;
	
	public int insert(T object) {
		
		Integer id = Math.abs(object.hashCode());
		//User users = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Authentication user = (Authentication)SecurityContextHolder.getContext().getAuthentication();
		ObjectIdentity objectIdentity  = null;
		MutableAcl mutableAcl = null;

		if(object instanceof Post) {
			objectIdentity = new ObjectIdentityImpl(Post.class, id);
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
		    mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
		    mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
		    mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.USER.getDescripcion()), true);
		}else if(object instanceof Direccion) {
			objectIdentity = new ObjectIdentityImpl(Direccion.class, ((Direccion)object).getDireccionId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.CONFIG.getDescripcion()), true);
		}else if(object instanceof Calle) {
			objectIdentity = new ObjectIdentityImpl(Calle.class, ((Calle)object).getCalleId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.CONFIG.getDescripcion()), true);	
		}else if(object instanceof Departamento) {
			objectIdentity = new ObjectIdentityImpl(Departamento.class, ((Departamento)object).getDepartamentoId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.CONFIG.getDescripcion()), true);
		}else if(object instanceof ListaPrecios) {
			objectIdentity = new ObjectIdentityImpl(ListaPrecios.class, ((ListaPrecios)object).getListaPrecioId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.SALES.getDescripcion()), true);	
		}else if(object instanceof Impuesto) {
			objectIdentity = new ObjectIdentityImpl(Impuesto.class, ((Impuesto)object).getImpuestoId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.COUNTER.getDescripcion()), true);
		}else if(object instanceof Cuenta) {
			objectIdentity = new ObjectIdentityImpl(Cuenta.class, ((Cuenta)object).getCuentaId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.COUNTER.getDescripcion()), true);
		}else if(object instanceof GrupoCuenta) {
			objectIdentity = new ObjectIdentityImpl(GrupoCuenta.class, ((GrupoCuenta)object).getGrupoCuentaId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.COUNTER.getDescripcion()), true);
		}else if(object instanceof Producto) {
			objectIdentity = new ObjectIdentityImpl(Producto.class, ((Producto)object).getProdId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.MARKETING.getDescripcion()), true);
		}else if(object instanceof TipoProducto) {
			objectIdentity = new ObjectIdentityImpl(TipoProducto.class, ((TipoProducto)object).getTipProdId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.MARKETING.getDescripcion()), true);
		}else if(object instanceof Barrio) {
			objectIdentity = new ObjectIdentityImpl(Barrio.class, ((Barrio)object).getBarrioId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.CONFIG.getDescripcion()), true);
		}else if(object instanceof Persona) {
			objectIdentity = new ObjectIdentityImpl(Persona.class, ((Persona)object).getPersonaId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.RRHH.getDescripcion()), true);
		}else if(object instanceof co.com.mundocostenio.domain.User) {
			objectIdentity = new ObjectIdentityImpl(co.com.mundocostenio.domain.User.class, ((co.com.mundocostenio.domain.User)object).getUserId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.RRHH.getDescripcion()), true);
		}else if(object instanceof Rol) {
			objectIdentity = new ObjectIdentityImpl(Rol.class, ((Rol)object).getRolId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.RRHH.getDescripcion()), true);
		}else if(object instanceof PrecioProducto) {
			objectIdentity = new ObjectIdentityImpl(PrecioProducto.class, ((PrecioProducto)object).getPrecioProdId());
			mutableAcl  = mutableAclService.createAcl(objectIdentity);
			mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
			mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
			mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.SALES.getDescripcion()), true);
		}
		if(mutableAcl!=null) {
			mutableAclService.updateAcl(mutableAcl);
		}
		return id;
	}

	public void delete(T object) {
		ObjectIdentity oid = null;
		if(object instanceof Post) {
			oid = new ObjectIdentityImpl(Post.class, ((Post) object).getId());
		}else if(object instanceof ListaPrecios) {
			oid = new ObjectIdentityImpl(ListaPrecios.class, ((ListaPrecios) object).getListaPrecioId());
		}else if(object instanceof Impuesto) {
			oid = new ObjectIdentityImpl(Impuesto.class, ((Impuesto) object).getImpuestoId());
		}else if(object instanceof Cuenta) {
			oid = new ObjectIdentityImpl(Cuenta.class, ((Cuenta) object).getCuentaId());
		}else if(object instanceof GrupoCuenta) {
			oid = new ObjectIdentityImpl(GrupoCuenta.class, ((GrupoCuenta) object).getGrupoCuentaId());
		}else if(object instanceof Producto) {
			oid = new ObjectIdentityImpl(Producto.class, ((Producto) object).getProdId());
		}else if(object instanceof TipoProducto) {
			oid = new ObjectIdentityImpl(TipoProducto.class, ((TipoProducto) object).getTipProdId());
		}else if(object instanceof Barrio) {
			oid = new ObjectIdentityImpl(Barrio.class, ((Barrio) object).getBarrioId());
		}else if(object instanceof Calle) {
			oid = new ObjectIdentityImpl(Calle.class, ((Calle) object).getCalleId());
		}else if(object instanceof Persona) {
			oid = new ObjectIdentityImpl(Persona.class, ((Persona) object).getPersonaId());
		}else if(object instanceof co.com.mundocostenio.domain.User) {
			oid = new ObjectIdentityImpl(co.com.mundocostenio.domain.User.class, ((co.com.mundocostenio.domain.User) object).getUserId());
		}else if(object instanceof Rol) {
			oid = new ObjectIdentityImpl(Rol.class, ((Rol) object).getRolId());
		}else if(object instanceof Departamento) {
			oid = new ObjectIdentityImpl(Departamento.class, ((Departamento) object).getDepartamentoId());
		}else if(object instanceof PrecioProducto) {
			oid = new ObjectIdentityImpl(PrecioProducto.class, ((PrecioProducto) object).getPrecioProdId());
		}
		mutableAclService.deleteAcl(oid, true);
	}
	
	public void setMutableAclService(MutableAclService mutableAclService) {
		this.mutableAclService = mutableAclService;
	}
}
