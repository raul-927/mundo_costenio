package co.com.mundocostenio.mybatis.mappers;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import co.com.mundocostenio.domain.FechaVigenciaListaPrecios;
import co.com.mundocostenio.mybatis.sql.FechaVigenciaListaPreciosSqlProvider;


public interface FechaVigenciaListaPreciosMapper {
	
	
	@InsertProvider(type = FechaVigenciaListaPreciosSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="fechaVigenciaId", keyColumn = "fecha_vigencia_id") 
	int insert(FechaVigenciaListaPrecios fechaVigenciaListaPrecios);
	
	
	@SelectProvider(type = FechaVigenciaListaPreciosSqlProvider.class, method ="selectFechaVigenciaById")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.FechaVigenciaListaPreciosMapper.FechaVigenciaListaPreciosResult")
	FechaVigenciaListaPrecios selectFechaVigenciaById(int id);

}
