package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.model.Persona;
import co.com.mundocostenio.mybatis.mappers.PersonasMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;


@Service("personasService")
public class PersonasServiceImpl implements PersonasService {
	
	@Autowired
	private PersonasMapper personasMapper;
	
	@Autowired
	private DireccionService direccionService;
	
	@Autowired
	private AccesControlListService<Persona> accesControlListService;

	@Override
	@PreAuthorize(value ="hasRole('ROLE_RRHH')")
	@Transactional
	public Persona insert(@Param("persona")Persona persona) {
		this.personasMapper.insert(persona);
		this.direccionService.insert(persona.getDirecciones());
		this.direccionService.insertPersonaDirecciones(persona.getPersonaId(), persona.getDirecciones());
		this.accesControlListService.insert(persona);
		return persona;
	}
	@Override
	@Transactional
	@PreAuthorize("hasPermission(#persona, 'WRITE')")
	public Persona update(Persona persona) {
		this.personasMapper.update(persona);
		return persona;
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission(#personaId, 'DELETE')")
	public void delete(int personaId) {
		this.personasMapper.delete(personaId);
		
	}

	@Override
	//@PostAuthorize("hasPermission(filterObject,'READ')")
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Persona> select(Persona persona) {
		
		return this.personasMapper.select(persona);
	}

	
}
