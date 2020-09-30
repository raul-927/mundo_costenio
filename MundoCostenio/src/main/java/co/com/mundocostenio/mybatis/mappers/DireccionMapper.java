package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import co.com.mundocostenio.domain.Direccion;
import co.com.mundocostenio.mybatis.sql.DireccionSqlProvider;


public interface DireccionMapper {
	
	
	@InsertProvider(type = DireccionSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="direccionId", keyColumn = "direccion_id") 
	void insertDireccion(List<Direccion> direcciones, int idPersona);

}
