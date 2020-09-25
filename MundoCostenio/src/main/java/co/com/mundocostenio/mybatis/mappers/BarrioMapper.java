package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import co.com.mundocostenio.domain.Barrio;
import co.com.mundocostenio.mybatis.sql.BarrioSqlProvider;


public interface BarrioMapper {
	
	
	@InsertProvider(type = BarrioSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="id") 
	void insertBarrio(List<Barrio> barrios, int idPersona);

}
