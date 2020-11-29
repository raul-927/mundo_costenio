package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import co.com.mundocostenio.domain.Asiento;
import co.com.mundocostenio.mybatis.sql.AsientoSqlProvider;


public interface AsientoMapper {
	
	@InsertProvider(type = AsientoSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="asientoId", keyColumn = "asiento_id") 
	void insert(@Param("asiento") Asiento asiento);
	
	@UpdateProvider(type = AsientoSqlProvider.class, method ="update")
	void update(@Param("asiento") Asiento asiento);
	
	@SelectProvider(type = AsientoSqlProvider.class, method ="select")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.AsientoMapper.AsientoResult")
	List<Asiento> select(@Param("asiento") Asiento asiento);
	
	@SelectProvider(type = AsientoSqlProvider.class, method ="selectMaxNroAsiento")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.AsientoMapper.MaxAsientoNroResult")
	Integer selectMaxNroAsiento();

}
