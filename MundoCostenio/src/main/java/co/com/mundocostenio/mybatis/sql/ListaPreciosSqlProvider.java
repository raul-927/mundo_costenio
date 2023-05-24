package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.model.ListaPrecios;
import co.com.mundocostenio.domain.model.PrecioProducto;

public class ListaPreciosSqlProvider {

	public String insert(ListaPrecios insert) {
		
		return new SQL() {{
			INSERT_INTO("lista_precios");
			if(insert.getDescripcionLista()!= null) {
				VALUES("descripcion_lista", "'".concat(String.valueOf(insert.getDescripcionLista())).concat("'"));
			}
			if(insert.getFechaVigencia() != null) {
				VALUES("fecha_vigencia_id", String.valueOf(insert.getFechaVigencia().getFechaVigenciaId()));
			}
		}}.toString();
	}
	
	public String update(ListaPrecios update) {
		return new SQL() {{
			UPDATE("lista_precios");
			if(update.getDescripcionLista()!= null) {
				SET("descripcion_lista", "'".concat(String.valueOf(update.getDescripcionLista())).concat("'"));
			}
			if(update.getFechaVigencia() != null) {
				SET("fecha_vigencia_id", String.valueOf(update.getFechaVigencia().getFechaVigenciaId()));
			}
		}}.toString();
	}
	
	public String delete(int id) {
		return new SQL() {{}}.toString();
	}

	public String selectListaPrecios(ListaPrecios listaPrecios) {
		return new SQL() {{
			SELECT("l.lista_precio_id, l.descripcion_lista");
			SELECT("f.fecha_vigencia_id, f.fecha_ini,f.fecha_fin");
			SELECT("pre.precio_producto_id, pre.monto");
			SELECT("pro.producto_id, pro.nombre");
			SELECT("t.tipo_producto_id, t.desc_tipo_producto");
			
			FROM("lista_precios l");
			FROM("fecha_vigencia_lista_precios f");
			FROM("precio_producto pre");
			FROM("producto pro");
			FROM("tipo_producto t");
			FROM("list_prod_and_prec_prod ls");
			
			WHERE("l.fecha_vigencia_id = f.fecha_vigencia_id"); 
			WHERE("l.lista_precio_id = ls.lista_precio_id"); 
			WHERE("ls.precio_producto_id = pre.precio_producto_id"); 
			WHERE("pre.producto_id = pro.producto_id"); 
			WHERE("pro.tipo_producto_id = t.tipo_producto_id");
			
			if(listaPrecios != null) {
				if(listaPrecios.getListaPrecioId()!= null && listaPrecios.getListaPrecioId() > 0) {
					WHERE("l.lista_precio_id = "  + String.valueOf(listaPrecios.getListaPrecioId()));
				} else {
					if(listaPrecios.getDescripcionLista()!= null && listaPrecios.getDescripcionLista() != "") {
						WHERE("l.descripcion_lista LIKE '%"  + listaPrecios.getDescripcionLista() + "%'");
					}else
					if(listaPrecios.getFechaVigencia() != null) {
						if(listaPrecios.getFechaVigencia().getFechaVigenciaId() > 0) {
							WHERE("f.fecha_vigencia_id = " + String.valueOf(listaPrecios.getFechaVigencia().getFechaVigenciaId()));
						}else {
							if(listaPrecios.getFechaVigencia().getFechaIni() != null) {
								WHERE("f.fecha_ini = '" + String.valueOf(listaPrecios.getFechaVigencia().getFechaIni()) + "'");
							}
							if(listaPrecios.getFechaVigencia().getFechaFin() != null) {
								WHERE("f.fecha_fin = '" + String.valueOf(listaPrecios.getFechaVigencia().getFechaFin()) + "'");
							}
						}
					}
					if(listaPrecios.getPrecioProductoList() != null && listaPrecios.getPrecioProductoList().size() > 0) {
						for(PrecioProducto precProd: listaPrecios.getPrecioProductoList()) {
							if(precProd.getMonto() > 0) {
								WHERE("pre.monto = " + precProd.getMonto());
							}
							if(precProd.getProducto()!= null) {
								if(precProd.getProducto().getNombre()!= null && precProd.getProducto().getNombre()!="") {
									WHERE("pro.nombre = " + "'".concat(precProd.getProducto().getNombre()).concat("'"));
								}
								if(precProd.getProducto().getTipoProducto()!= null) {
									if(precProd.getProducto().getTipoProducto().getDescTipoProducto()!=null && precProd.getProducto().getTipoProducto().getDescTipoProducto()!= "") {
										WHERE("t.desc_tipo_producto = " + "'".concat(precProd.getProducto().getTipoProducto().getDescTipoProducto()).concat("'"));
									}
								}
							}
						}
					}
				}
			}
		}}.toString();
	}
	
	public String selectActualListaPrecios() {
		return 
		 new SQL() {{
			SELECT("l.lista_precio_id, l.descripcion_lista");
			SELECT("f.fecha_vigencia_id, f.fecha_ini,f.fecha_fin");
			SELECT("pre.precio_producto_id, pre.monto");
			SELECT("pro.producto_id, pro.nombre");
			SELECT("t.tipo_producto_id, t.desc_tipo_producto");
			
			FROM("lista_precios l");
			FROM("fecha_vigencia_lista_precios f");
			FROM("precio_producto pre");
			FROM("producto pro");
			FROM("tipo_producto t");
			FROM("list_prod_and_prec_prod ls");
			
			WHERE("l.fecha_vigencia_id = f.fecha_vigencia_id"); 
			WHERE("l.lista_precio_id = ls.lista_precio_id"); 
			WHERE("ls.precio_producto_id = pre.precio_producto_id"); 
			WHERE("pre.producto_id = pro.producto_id"); 
			WHERE("pro.tipo_producto_id = t.tipo_producto_id");
			WHERE("CURRENT_DATE() BETWEEN f.fecha_ini AND f.fecha_fin");
			OR();
			WHERE("CURRENT_DATE() > f.fecha_ini");
			WHERE("f.fecha_fin = '3030-01-01'");
		}}.toString();
	}
	
	public String selectNuevoProducto() {
		String query = 
		 new SQL() {{
			 SELECT("p.producto_id, p.nombre");
			 SELECT("t.tipo_producto_id, t.desc_tipo_producto");
			 SELECT("ct.cuenta_id, ct.cuenta_desc, ct.tipo_cuenta, ct.cuenta_fecha, ct.cuenta_hora, ct.cuenta_usuario");
			 SELECT("gct.grupo_cuenta_id, gct.tipo_grupo_cuenta, gct.grupo_cuenta_desc");
			 SELECT("i.impuesto_id, i.impuesto_desc, i.impuesto_desc_abrv, i.impuesto_valor, i.tipo_impuesto");
			 SELECT("ci.cuenta_id, ci.cuenta_desc, ci.tipo_cuenta, ci.cuenta_fecha, ci.cuenta_hora, ci.cuenta_usuario");
			 SELECT("gci.grupo_cuenta_id, gci.tipo_grupo_cuenta, gci.grupo_cuenta_desc");
				
			 FROM("producto p");
			 FROM("tipo_producto t");
			 FROM("cuenta ct");
			 FROM("grupo_cuenta gct");
			 FROM("impuesto i");
			 FROM("cuenta ci");
			 FROM("grupo_cuenta gci");
				
			 WHERE("p.tipo_producto_id = t.tipo_producto_id");
			 WHERE("t.cuenta_id = ct.cuenta_id");
			 WHERE("ct.grupo_cuenta_id = gct.grupo_cuenta_id");
			 WHERE("p.impuesto_id = i.impuesto_id");
			 WHERE("i.cuenta_id = ci.cuenta_id");
			 WHERE("ci.grupo_cuenta_id = gci.grupo_cuenta_id");
			 WHERE("p.producto_id NOT IN (" + verificarProductoExistenteEnListaActual() + ")");
		}}.toString();
		System.out.print(query);
		return query;
	}
	
	private String verificarProductoExistenteEnListaActual() {
		return new SQL() {{
			SELECT("pro.producto_id");
			
			FROM("producto pro");
			FROM("lista_precios l");
			FROM("fecha_vigencia_lista_precios f");
			FROM("precio_producto pre");
			
			FROM("tipo_producto t");
			FROM("list_prod_and_prec_prod ls");
			
			WHERE("l.fecha_vigencia_id = f.fecha_vigencia_id"); 
			WHERE("l.lista_precio_id = ls.lista_precio_id"); 
			WHERE("ls.precio_producto_id = pre.precio_producto_id"); 
			WHERE("pre.producto_id = pro.producto_id"); 
			WHERE("pro.tipo_producto_id = t.tipo_producto_id");
			WHERE("CURRENT_DATE() BETWEEN f.fecha_ini AND f.fecha_fin");
			OR();
			WHERE("CURRENT_DATE() > f.fecha_ini");
			WHERE("f.fecha_fin = '3030-01-01'");
		}}.toString();
	}
	
}