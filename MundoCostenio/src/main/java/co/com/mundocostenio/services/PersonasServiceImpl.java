package co.com.mundocostenio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Persona;
import co.com.mundocostenio.mybatis.mappers.PersonasMapper;


@Service("personasService")
public class PersonasServiceImpl implements PersonasService {
	
	@Autowired
	PersonasMapper personasMapper;

	@Transactional
	@Override
	public Persona insert(Persona persona) {
		this.personasMapper.insert(persona);
		return persona;
	}
	@Transactional
	@Override
	public Persona update(Persona persona) {
		this.personasMapper.update(persona);
		return persona;
	}

	@Override
	public void delete(int personaId) {
		this.personasMapper.delete(personaId);
		
	}

	@Override
	public List<Persona> select(Persona persona) {
		
		return this.personasMapper.select(persona);
	}

	
}
