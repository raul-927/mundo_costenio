package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Component;

import co.com.mundocostenio.domain.Producto;
import co.com.mundocostenio.mybatis.sql.ProductoSqlProvider;


@Component("productoMapper")
public interface ProductoMapper {
	
	
	@InsertProvider(type = ProductoSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="prodId", keyColumn = "producto_id") 
	int insert(Producto producto);
	
	@UpdateProvider(type = ProductoSqlProvider.class, method ="update")
	int update(Producto producto);
	
	@DeleteProvider(type = ProductoSqlProvider.class, method ="delete")
	int delete(Producto producto);
	
	
	@SelectProvider(type = ProductoSqlProvider.class, method ="selectProducto")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.ProductoMapper.ProductoResult")
	List<Producto> selectProducto(@Param("producto") Producto producto);

}
