package co.com.mundocostenio.mybatis.mappers;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

import co.com.mundocostenio.domain.Producto;
import co.com.mundocostenio.mybatis.sql.ProductoSqlProvider;


@Component("productoMapper")
public interface ProductoMapper {
	
	
	@InsertProvider(type = ProductoSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="prodId", keyColumn = "prod_id") 
	int insert(Producto producto);

}
