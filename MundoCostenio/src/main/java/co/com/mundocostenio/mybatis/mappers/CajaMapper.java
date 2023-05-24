package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import co.com.mundocostenio.domain.model.Caja;
import co.com.mundocostenio.mybatis.sql.CajaSqlProvider;

public interface CajaMapper {
	
	
	@InsertProvider(type = CajaSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="barrioId", keyColumn = "barrio_id") 
	void insert(@Param("caja") Caja caja);
	
	@SelectProvider(type = CajaSqlProvider.class, method ="select")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.CajaMapper.CajaResult")
	List<Caja> select(@Param("caja") Caja caja);
	
	@SelectProvider(type = CajaSqlProvider.class, method = "cargoCajaActual")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.CajaMapper.CajaResult")
	Caja cargoCajaActual();

}
