package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import co.com.mundocostenio.domain.Calle;
import co.com.mundocostenio.mybatis.sql.CalleSqlProvider;


public interface CalleMapper {
	
	
	@InsertProvider(type = CalleSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="calleId", keyColumn = "calle_id") 
	void insert(@Param("calle") Calle calle);
	
	@InsertProvider(type = CalleSqlProvider.class, method ="insertDireccionCalles")
	void insertDireccionCalles(@Param("direccionId") int direccionId, @Param("calles") List<Calle>calles);
	
	@UpdateProvider(type = CalleSqlProvider.class, method ="update")
	Calle update(@Param("calle") Calle calle);
	
	@DeleteProvider(type = CalleSqlProvider.class, method ="delete")
	void delete(int calleId);
	
	@SelectProvider(type = CalleSqlProvider.class, method = "select")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.CalleMapper.CalleResult")
	List<Calle> select(@Param("calle") Calle calle);

}
