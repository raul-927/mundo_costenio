package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import co.com.mundocostenio.domain.model.Cuenta;
import co.com.mundocostenio.mybatis.sql.CuentaSqlProvider;


public interface CuentaMapper {
	
	
	@InsertProvider(type = CuentaSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="cuentaId", keyColumn = "cuenta_id") 
	void insert(@Param("cuenta") Cuenta cuenta);
	
	@UpdateProvider(type = CuentaSqlProvider.class, method ="update")
	void update(@Param("cuenta") Cuenta cuenta);
	
	@DeleteProvider(type = CuentaSqlProvider.class, method ="delete")
	int delete(@Param("cuenta") Cuenta cuenta);
	
	@SelectProvider(type = CuentaSqlProvider.class, method ="select")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.CuentaMapper.CuentaResult")
	List<Cuenta> select(@Param("cuenta") Cuenta cuenta);

}
