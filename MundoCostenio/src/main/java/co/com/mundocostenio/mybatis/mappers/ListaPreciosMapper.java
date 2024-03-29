package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import co.com.mundocostenio.domain.model.ListaPrecios;
import co.com.mundocostenio.domain.model.Producto;
import co.com.mundocostenio.mybatis.sql.ListaPreciosSqlProvider;

@Mapper
public interface ListaPreciosMapper {
	
	
	@InsertProvider(type = ListaPreciosSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="listaPrecioId", keyColumn = "lista_precio_id") 
	int insert(ListaPrecios listaPrecios);
	
	@SelectProvider(type = ListaPreciosSqlProvider.class, method ="selectListaPrecios")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.ListaPreciosMapper.ListaPreciosResult")
	List<ListaPrecios> selectListaPrecios(@Param("listaPrecios") ListaPrecios listaPrecios);
	
	@SelectProvider(type = ListaPreciosSqlProvider.class, method ="selectActualListaPrecios")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.ListaPreciosMapper.ListaPreciosResult")
	ListaPrecios selectActualListaPrecios();
	
	@SelectProvider(type = ListaPreciosSqlProvider.class, method ="selectNuevoProducto")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.ProductoMapper.ProductoResult")
	List<Producto> selectNuevoProducto();
	
}
