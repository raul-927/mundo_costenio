package co.com.mundocostenio.mybatis.mappers;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;

import co.com.mundocostenio.domain.Ubicacion;
import co.com.mundocostenio.mybatis.sql.UbicacionSqlProvider;


public interface UbicacionMapper {
	
	
	@InsertProvider(type = UbicacionSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="id") 
	void insertBarrio(Ubicacion ubicacion);
	
	@UpdateProvider(type = UbicacionSqlProvider.class, method ="update")
	@Options(useGeneratedKeys=true, keyProperty="id") 
	void updateUbicacion(Ubicacion ubicacion);
	
	@UpdateProvider(type = UbicacionSqlProvider.class, method ="delete")
	@Options(useGeneratedKeys=true, keyProperty="id") 
	void deleteUbicacion(Ubicacion ubicacion);

}
