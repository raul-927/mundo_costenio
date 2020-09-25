package co.com.mundocostenio.mybatis.mappers;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import co.com.mundocostenio.domain.TipoProducto;
import co.com.mundocostenio.mybatis.sql.TipoProductoSqlProvider;

public interface TipoProductoMapper {
	
	@InsertProvider(type = TipoProductoSqlProvider.class, method = "insert")
	@Options(useGeneratedKeys=true, keyProperty="tipProdId", keyColumn = "tip_prod_id") 
	int insert(TipoProducto tipoProducto);

}
