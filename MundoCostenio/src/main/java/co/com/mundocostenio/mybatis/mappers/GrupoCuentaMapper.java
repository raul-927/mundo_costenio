package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import co.com.mundocostenio.domain.model.GrupoCuenta;
import co.com.mundocostenio.mybatis.sql.GrupoCuentaSqlProvider;


public interface GrupoCuentaMapper {
	
	
	@InsertProvider(type = GrupoCuentaSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="grupoCuentaId", keyColumn = "grupo_cuenta_id") 
	void insert(@Param("grupoCuenta") GrupoCuenta grupoCuenta);
	
	@UpdateProvider(type = GrupoCuentaSqlProvider.class, method ="update")
	void update(@Param("grupoCuenta") GrupoCuenta grupoCuenta);
	
	@DeleteProvider(type = GrupoCuentaSqlProvider.class, method ="delete")
	int delete(@Param("grupoCuenta") GrupoCuenta grupoCuenta);
	
	@SelectProvider(type = GrupoCuentaSqlProvider.class, method ="select")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.GrupoCuentaMapper.GrupoCuentaResult")
	List<GrupoCuenta> select(@Param("grupoCuenta") GrupoCuenta grupoCuenta);

}
