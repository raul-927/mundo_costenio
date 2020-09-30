package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import co.com.mundocostenio.domain.Ubicacion;
import co.com.mundocostenio.mybatis.sql.UbicacionSqlProvider;


public interface UbicacionMapper {
	
	
	@InsertProvider(type = UbicacionSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="ubicacionId", keyColumn = "ubicacion_id") 
	void insert(@Param("ubicacion") Ubicacion ubicacion);
	
	@UpdateProvider(type = UbicacionSqlProvider.class, method ="update")
	void update(@Param("ubicacion") Ubicacion ubicacion);
	
	@DeleteProvider(type = UbicacionSqlProvider.class, method ="delete")
	int delete(@Param("ubicacionId")int ubicacionId);
	
	@SelectProvider(type = UbicacionSqlProvider.class, method ="select")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.UbicacionMapper.UbicacionResult")
	List<Ubicacion> select(@Param("ubicacion") Ubicacion ubicacion);

}
