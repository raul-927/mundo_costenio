package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import co.com.mundocostenio.domain.Barrio;
import co.com.mundocostenio.mybatis.sql.BarrioSqlProvider;


public interface BarrioMapper {
	
	
	@InsertProvider(type = BarrioSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="barrioId", keyColumn = "barrio_id") 
	void insert(@Param("barrio") Barrio barrio);
	
	@UpdateProvider(type = BarrioSqlProvider.class, method ="update")
	void update(@Param("barrio") Barrio barrio);
	
	@DeleteProvider(type = BarrioSqlProvider.class, method ="delete")
	int delete(@Param("barrioId") int barrioId);
	
	@SelectProvider(type = BarrioSqlProvider.class, method ="select")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.BarrioMapper.BarrioResult")
	List<Barrio> select(@Param("barrio") Barrio barrio);

}
