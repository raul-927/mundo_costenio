package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import co.com.mundocostenio.domain.TipoProducto;
import co.com.mundocostenio.mybatis.sql.TipoProductoSqlProvider;

public interface TipoProductoMapper {
	
	@InsertProvider(type = TipoProductoSqlProvider.class, method = "insert")
	@Options(useGeneratedKeys=true, keyProperty="tipProdId", keyColumn = "tip_prod_id") 
	int insert(TipoProducto tipoProducto);
	
	@UpdateProvider(type = TipoProductoSqlProvider.class, method = "update")
	int update(TipoProducto tipoProducto);
	
	@DeleteProvider(type = TipoProductoSqlProvider.class, method = "delete")
	int delete(int tipProdId);
	
	@SelectProvider(type = TipoProductoSqlProvider.class, method ="selectTipoProducto")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.TipoProductoMapper.TipoProductoResult")
	List<TipoProducto> selectTipoProducto(@Param("tipoProducto") TipoProducto tipoProducto);

}
