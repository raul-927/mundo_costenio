package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import co.com.mundocostenio.domain.Departamento;
import co.com.mundocostenio.mybatis.sql.DepartamentoSqlProvider;


public interface DepartamentoMapper {
	
	
	@InsertProvider(type = DepartamentoSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="departamentoId", keyColumn = "departamento_id") 
	void insert(@Param("departamento") Departamento departamento);
	
	@InsertProvider(type = DepartamentoSqlProvider.class, method ="update") 
	void update(@Param("departamento") Departamento departamento);
	
	@InsertProvider(type = DepartamentoSqlProvider.class, method ="delete")
	void delete(@Param("departamentoId") int departamentoId);
	
	
	@SelectProvider(type = DepartamentoSqlProvider.class, method ="select")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.DepartamentoMapper.DepartamentoResult")
	List<Departamento> select(@Param("departamento") Departamento departamento);

}
