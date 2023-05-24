package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import co.com.mundocostenio.domain.model.Persona;
import co.com.mundocostenio.mybatis.sql.PersonasSqlProvider;


public interface PersonasMapper {
	
	@InsertProvider(type = PersonasSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="personaId", keyColumn = "persona_id")
	void insert(@Param("persona") Persona persona);
	
	@UpdateProvider(type = PersonasSqlProvider.class, method ="update")
	void update(@Param("persona") Persona persona);
	
	@DeleteProvider(type = PersonasSqlProvider.class, method ="delete")
	void delete(@Param("personaId") int personaId);
	
	@SelectProvider(type = PersonasSqlProvider.class,method ="select")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.PersonasMapper.PersonasResult")
	List<Persona> select(@Param("persona") Persona persona);
	
	
	

}
