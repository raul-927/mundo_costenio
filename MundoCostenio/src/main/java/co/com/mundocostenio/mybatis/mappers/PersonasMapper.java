package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import co.com.mundocostenio.domain.Persona;
import co.com.mundocostenio.mybatis.sql.PersonasSqlProvider;


public interface PersonasMapper {
	
	@InsertProvider(type = PersonasSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="id")
	void insertPersonas(Persona personas);
	
	@SelectProvider(type = PersonasSqlProvider.class,method ="showPersonas")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.PersonasMapper.PersonasResult")
	List<Persona> showPersonas(Persona personas);
	
	@SelectProvider(type = PersonasSqlProvider.class,method ="showAllPersonas")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.PersonasMapper.PersonasResult")
	List<Persona> showAllPersonas();
	
	

}
