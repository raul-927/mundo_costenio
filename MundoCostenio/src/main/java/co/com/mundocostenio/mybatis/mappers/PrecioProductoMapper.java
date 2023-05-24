package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import co.com.mundocostenio.domain.model.PrecioProducto;
import co.com.mundocostenio.mybatis.sql.PrecioProductoSqlProvider;

public interface PrecioProductoMapper {
	
	
	@InsertProvider(type = PrecioProductoSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="precioProdId", keyColumn = "precio_prod_id") 
	int insert(@Param("precioProductoList") List<PrecioProducto> precioProductoList);
	
	
	@InsertProvider(type = PrecioProductoSqlProvider.class, method ="insertListaAndPrecioProducto")
	@Options(useGeneratedKeys=true, keyProperty="precioProductoList.precioProdId", keyColumn = "precio_prod_id") 
	int insertListaAndPrecioProducto(@Param("listaId") int listaId, @Param("precioProductoList") List<PrecioProducto> precioProductoList);
	
	
	@SelectProvider(type = PrecioProductoSqlProvider.class, method ="selectPrecioProductoByListId")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.PrecioProductoMapper.PrecioProductoResult")
	List<PrecioProducto> selectPrecioProductoByListId(int id);
	
	
	/*
	 * @InsertProvider(type = PrecioProductoSqlProvider.class, method
	 * ="insertPrecioProducto")
	 * 
	 * @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id") int
	 * insertPrecioProducto(@Param("precioProductoList") List<PrecioProducto>
	 * precioProductoList);
	 */
}
