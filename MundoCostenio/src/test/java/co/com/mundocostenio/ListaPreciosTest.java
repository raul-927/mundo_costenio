package co.com.mundocostenio;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.com.mundocostenio.domain.FechaVigenciaListaPrecios;
import co.com.mundocostenio.domain.ListaPrecios;
import co.com.mundocostenio.domain.PrecioProducto;
import co.com.mundocostenio.domain.Producto;
import co.com.mundocostenio.domain.TipoProducto;
import co.com.mundocostenio.mybatis.mappers.ListaPreciosMapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@ExtendWith(SpringExtension.class)
//@MybatisTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class ListaPreciosTest {
	
	@Autowired
	private ListaPreciosMapper listaPreciosMapper;
	
	private static int LISTA_PRECIO_ID = 1;
	private static String DESCRIPCION_LISTA = "Lista de precios prueba 1";
	private static String FECHA_INI = "2020-08-04";
	private static String FECHA_FIN = "2020-09-04";
	private static int MONTO = 319000;
	private static int PROD_ID = 1;
	private static int TIP_PROD_ID = 1;
	private static String NOMBRE = "Pezcado";
	private static String DESCRIPCION ="Mercaderia Bruta";
	
	
	@Before
	void crearTabla() {
		
	}
	
	@Before
	void insertDatos() {
		
	}
	
	//@Test
	void insertListaPrecios() {
		ListaPrecios 				listaPrecios 	   = new ListaPrecios();
		FechaVigenciaListaPrecios 	fechaVigencia 	   = new FechaVigenciaListaPrecios();
		TipoProducto 				tipoProducto 	   = new TipoProducto();
		Producto 					producto 		   = new Producto();
		PrecioProducto 				precioProducto 	   = new PrecioProducto();
		List<PrecioProducto>		precioProductoList = new ArrayList<PrecioProducto>();
		
		LocalDate fechaIni =LocalDate.parse(FECHA_INI);
		LocalDate fechaFin =LocalDate.parse(FECHA_FIN);
		
		fechaVigencia.setFechaIni(fechaIni);
		fechaVigencia.setFechaFin(fechaFin);
		
		tipoProducto.setTipProdId(TIP_PROD_ID);
		tipoProducto.setDescTipoProducto(DESCRIPCION); 
		
		producto.setProdId(PROD_ID);
		producto.setNombre(NOMBRE);
		producto.setTipoProducto(tipoProducto);
		
		precioProducto.setProducto(producto);
		
		precioProductoList.add(precioProducto);
		
		listaPrecios.setDescripcionLista(DESCRIPCION_LISTA);
		listaPrecios.setFechaVigencia(fechaVigencia);
		listaPrecios.setPrecioProductoList(precioProductoList);
		
		listaPreciosMapper.insert(listaPrecios);
		
		assertThat(listaPrecios.getListaPrecioId()).isGreaterThan(0);
		assertThat(listaPrecios.getDescripcionLista()).isEqualTo(DESCRIPCION_LISTA);
	}
	
	@Test
	void selectListaPreciosById() {
		ListaPrecios listaPrecios = new ListaPrecios();
		listaPrecios.setListaPrecioId(LISTA_PRECIO_ID);
		List<ListaPrecios> listaPreciosResult = listaPreciosMapper.selectListaPrecios(listaPrecios);
		for(ListaPrecios listPrec: listaPreciosResult) {
			assertThat(listPrec.getDescripcionLista()).isEqualTo(DESCRIPCION_LISTA);
		}
	}
	
	@Test
	void selectListaPreciosByDescripcion() {
		ListaPrecios listaPrecios = new ListaPrecios();
		listaPrecios.setDescripcionLista(DESCRIPCION_LISTA);
		List<ListaPrecios> listaPreciosResult = listaPreciosMapper.selectListaPrecios(listaPrecios);
		for(ListaPrecios listPrec: listaPreciosResult) {
			assertThat(listPrec.getDescripcionLista()).isEqualTo(DESCRIPCION_LISTA);
		}
	}
	
	@Test
	void selectListaPreciosByFechaVigenciaFechaIni() {
		FechaVigenciaListaPrecios fechaVigencia = new FechaVigenciaListaPrecios();
		LocalDate fechaIni =LocalDate.parse(FECHA_INI);
		
		fechaVigencia.setFechaIni(fechaIni);
		ListaPrecios listaPrecios = new ListaPrecios();
		listaPrecios.setFechaVigencia(fechaVigencia);
		List<ListaPrecios> listaPreciosResult = listaPreciosMapper.selectListaPrecios(listaPrecios);
		for(ListaPrecios listPrec: listaPreciosResult) {
			assertThat(listPrec.getDescripcionLista()).isEqualTo(DESCRIPCION_LISTA);
		}
	}
	
	@Test
	void selectListaPreciosByFechaVigenciaFechaFin() {
		FechaVigenciaListaPrecios fechaVigencia = new FechaVigenciaListaPrecios();
		LocalDate fechaFin =LocalDate.parse(FECHA_FIN);
		
		fechaVigencia.setFechaFin(fechaFin);
		ListaPrecios listaPrecios = new ListaPrecios();
		listaPrecios.setFechaVigencia(fechaVigencia);
		List<ListaPrecios> listaPreciosResult = listaPreciosMapper.selectListaPrecios(listaPrecios);
		for(ListaPrecios listPrec: listaPreciosResult) {
			assertThat(listPrec.getDescripcionLista()).isEqualTo(DESCRIPCION_LISTA);
		}
	}
	
	@Test
	void selectListaPreciosByPrecioProductoMonto() {
		List<PrecioProducto>precioProductoList  = new ArrayList<PrecioProducto>();
		PrecioProducto precioProducto = new PrecioProducto();
		precioProducto.setMonto(MONTO);
		precioProductoList.add(precioProducto);
		
		ListaPrecios listaPrecios = new ListaPrecios();
		listaPrecios.setPrecioProductoList(precioProductoList);
		
		List<ListaPrecios> listaPreciosResult = listaPreciosMapper.selectListaPrecios(listaPrecios);
		for(ListaPrecios listPrec: listaPreciosResult) {
			assertThat(listPrec.getDescripcionLista()).isEqualTo(DESCRIPCION_LISTA);
		}
	}
	
	@Test
	void selectListaPreciosByProductoId() {
		List<PrecioProducto>precioProductoList  = new ArrayList<PrecioProducto>();
		PrecioProducto precioProducto = new PrecioProducto();
		Producto producto = new Producto();
		producto.setProdId(PROD_ID);
		precioProducto.setProducto(producto);
		precioProductoList.add(precioProducto);
		
		ListaPrecios listaPrecios = new ListaPrecios();
		listaPrecios.setPrecioProductoList(precioProductoList);
		
		List<ListaPrecios> listaPreciosResult = listaPreciosMapper.selectListaPrecios(listaPrecios);
		for(ListaPrecios listPrec: listaPreciosResult) {
			if(listPrec.getListaPrecioId() == 1) {
				assertThat(listPrec.getDescripcionLista()).isEqualTo(DESCRIPCION_LISTA);
			}
		}
	}
	
	@Test
	void selectListaPreciosByProductoNombre() {
		List<PrecioProducto>precioProductoList  = new ArrayList<PrecioProducto>();
		PrecioProducto precioProducto = new PrecioProducto();
		Producto producto = new Producto();
		producto.setNombre(NOMBRE);
		precioProducto.setProducto(producto);
		precioProductoList.add(precioProducto);
		
		ListaPrecios listaPrecios = new ListaPrecios();
		listaPrecios.setPrecioProductoList(precioProductoList);
		
		List<ListaPrecios> listaPreciosResult = listaPreciosMapper.selectListaPrecios(listaPrecios);
		for(ListaPrecios listPrec: listaPreciosResult) {
			if(listPrec.getListaPrecioId() == 1) {
				assertThat(listPrec.getDescripcionLista()).isEqualTo(DESCRIPCION_LISTA);
			}
		}
	}
	
	@Test
	void selectListaPreciosByTipoProductoDescripcion() {
		List<PrecioProducto>precioProductoList  = new ArrayList<PrecioProducto>();
		PrecioProducto precioProducto = new PrecioProducto();
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setDescTipoProducto(DESCRIPCION);
		Producto producto = new Producto();
		producto.setTipoProducto(tipoProducto);
		precioProducto.setProducto(producto);
		precioProductoList.add(precioProducto);
		
		ListaPrecios listaPrecios = new ListaPrecios();
		listaPrecios.setPrecioProductoList(precioProductoList);
		
		List<ListaPrecios> listaPreciosResult = listaPreciosMapper.selectListaPrecios(listaPrecios);
		for(ListaPrecios listPrec: listaPreciosResult) {
			if(listPrec.getListaPrecioId() == 1) {
				assertThat(listPrec.getDescripcionLista()).isEqualTo(DESCRIPCION_LISTA);
			}
		}
	}
	
	//@Test
		void updateListaPrecios() {
			ListaPrecios listaPrecios = new ListaPrecios();
			listaPrecios.setListaPrecioId(LISTA_PRECIO_ID);
			List<ListaPrecios> listaPreciosResult = listaPreciosMapper.selectListaPrecios(listaPrecios);
			for(ListaPrecios listPrec: listaPreciosResult) {
				assertThat(listPrec.getDescripcionLista()).isEqualTo(DESCRIPCION_LISTA);
			}
		}
		
		//@Test
		void deleteListaPrecios() {
			ListaPrecios listaPrecios = new ListaPrecios();
			listaPrecios.setListaPrecioId(LISTA_PRECIO_ID);
			List<ListaPrecios> listaPreciosResult = listaPreciosMapper.selectListaPrecios(listaPrecios);
			for(ListaPrecios listPrec: listaPreciosResult) {
				assertThat(listPrec.getDescripcionLista()).isEqualTo(DESCRIPCION_LISTA);
			}
		}
}
