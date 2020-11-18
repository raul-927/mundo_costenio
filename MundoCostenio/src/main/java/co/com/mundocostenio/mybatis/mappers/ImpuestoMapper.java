package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import co.com.mundocostenio.domain.Impuesto;
import co.com.mundocostenio.mybatis.sql.ImpuestoSqlProvider;


public interface ImpuestoMapper {
	
	
	@InsertProvider(type = ImpuestoSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="impuestoId", keyColumn = "impuesto_id") 
	void insert(@Param("impuesto") Impuesto impuesto);
	
	@UpdateProvider(type = ImpuestoSqlProvider.class, method ="update")
	void update(@Param("impuesto") Impuesto impuesto);
	
	@DeleteProvider(type = ImpuestoSqlProvider.class, method ="delete")
	int delete(@Param("impuesto") Impuesto impuesto);
	
	@SelectProvider(type = ImpuestoSqlProvider.class, method ="select")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.ImpuestoMapper.ImpuestoResult")
	List<Impuesto> select(@Param("impuesto") Impuesto impuesto);

}
