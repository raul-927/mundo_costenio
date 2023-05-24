package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import co.com.mundocostenio.domain.model.Direccion;
import co.com.mundocostenio.mybatis.sql.DireccionSqlProvider;


public interface DireccionMapper {
	
	
	@InsertProvider(type = DireccionSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="direcciones.direccionId", keyColumn = "direccion_id") 
	void insert(@Param("direcciones") List<Direccion> direcciones);
	
	@InsertProvider(type = DireccionSqlProvider.class, method ="insertPersonaDirecciones")
	void insertPersonaDirecciones(@Param("personaId") int personaId, @Param("direcciones") List<Direccion> direcciones);

}
