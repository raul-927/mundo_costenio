package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import co.com.mundocostenio.domain.Calle;
import co.com.mundocostenio.mybatis.sql.CalleSqlProvider;


public interface CalleMapper {
	
	
	@InsertProvider(type = CalleSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id") 
	void insertCalle(Calle calle);
	
	@UpdateProvider(type = CalleSqlProvider.class, method ="update")
	Calle updateCalle(Calle calle);
	
	@DeleteProvider(type = CalleSqlProvider.class, method ="delete")
	void deleteCalle(Calle calle);
	
	@SelectProvider(type = CalleSqlProvider.class, method = "showCalle")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.CalleMapper.CalleResult")
	List<Calle> showCalle(Calle calle);

}
