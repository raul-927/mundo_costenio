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

	@Override
	@Transactional
	public void insertPersonas(Persona personas) {
		personasMapper.insertPersonas(personas);

	}

	@Override
	public List<Persona> showPersonas(Persona personas) {
		
		return personasMapper.showPersonas(personas);
	}

	@Override
	public List<Persona> showAllPersonas() {
		return personasMapper.showAllPersonas();
	}

}
