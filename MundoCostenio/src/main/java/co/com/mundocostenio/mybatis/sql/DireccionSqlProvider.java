package co.com.mundocostenio.mybatis.sql;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.model.Calle;
import co.com.mundocostenio.domain.model.Direccion;

public class DireccionSqlProvider {
	
	public String insert( List<Direccion> direcciones) {
		return new SQL() {{
			if(direcciones != null && direcciones.size() > 0) {
				INSERT_INTO("direccion");
				INTO_COLUMNS(
						"nro_puerta", 
						"geo_localizacion", 
						"barrio_id");
				for(Direccion direccion: direcciones) {
					INTO_VALUES(
							String.valueOf(direccion.getNroPuerta()), 
							"'".concat(direccion.getGeoLocalizacion()).concat("'"), 
							String.valueOf(direccion.getBarrio()!=null ? direccion.getBarrio().getBarrioId():0));
					ADD_ROW();
				}
			}
		}}.toString();
	}
	
	public String insertPersonaDirecciones(int personaId, List<Direccion> direcciones) {
		return new SQL() {{
			INSERT_INTO("persona_direcciones");
			INTO_COLUMNS("persona_id", "direccion_id");
			for(Direccion direccion: direcciones) {
				INTO_VALUES(String.valueOf(personaId),String.valueOf(direccion.getDireccionId()));
				ADD_ROW();
			}
		}}.toString();
	}
	
	/*
	 * public String insertDireccionCalles(int direccionId, List<Calle> calles) {
	 * return new SQL() {{ INSERT_INTO("direccion_calles");
	 * INTO_COLUMNS("direccion_id", "calle_id"); for(Calle calle: calles) {
	 * INTO_VALUES(String.valueOf(direccionId), String.valueOf(calle.getCalleId()));
	 * ADD_ROW(); } }}.toString(); }
	 */
	
	public String update(Direccion direccion) {
		return new SQL() {{
			if(direccion !=null) {
				if(direccion.getDireccionId() > 0) {
					UPDATE("direccion");
					if(direccion.getNroPuerta() > 0) {
						SET("nro_puerta", String.valueOf(direccion.getNroPuerta()));
					}
					if(direccion.getGeoLocalizacion()!=null && direccion.getGeoLocalizacion()!="") {
						SET("geo_localizacion", "'".concat(direccion.getGeoLocalizacion()).concat("'"));
					}
					if(direccion.getBarrio()!=null && direccion.getBarrio().getBarrioId() > 0) {
						SET("barrio_id", String.valueOf(direccion.getBarrio().getBarrioId()));
					}
					WHERE("direccion_id = "+"'".concat(String.valueOf(direccion.getDireccionId())).concat("'"));
				}
			}
			
		}}.toString();
	}
	
	public String delete(int id) {
		return new SQL() {{
			DELETE_FROM("direccion");
			WHERE("direccion_id = "+String.valueOf(id));
		}}.toString();
	}
	
	public String select(Direccion direccion) {
		return new SQL() {{
			SELECT("d.direccion_id, d.nro_puerta, d.geo_localizacion");
			SELECT("b.barrio_id, b.nombre_barrio");
			SELECT("dep.departamento_id, dep.nombre_departamento");
			SELECT("c.calle_id, c.tipo_calle, c.nombre_calle");
			
			FROM("direccion d");
			FROM("barrio b");
			FROM("depaertamento dep");
			FROM("calle c");
			FROM("direccion_calles dc");
			
			WHERE("d.barrio_id = b.barrio_id");
			WHERE("d.direccion_id = dc.direccion_id");
			WHERE("dc.calle_id = c.calle_id");
			if(direccion.getDireccionId() >0) {
				WHERE("id ="+direccion.getDireccionId());
			}else {
				if(direccion.getNroPuerta() > 0) {
					WHERE("d.nro_puerta = " + String.valueOf(direccion.getNroPuerta()));
				}
				if(direccion.getGeoLocalizacion()!=null && direccion.getGeoLocalizacion()!="") {
					WHERE("d.geo_localizacion = " + "'".concat(direccion.getGeoLocalizacion()).concat("'"));
				}
				if(direccion.getBarrio()!=null) {
					if(direccion.getBarrio().getNombreBarrio()!=null && direccion.getBarrio().getNombreBarrio()!="") {
						WHERE("b.nombre_barrio LIKE " + "'%".concat(direccion.getBarrio().getNombreBarrio()).concat("%'"));
					}
				}
				if(direccion.getCalles()!=null && direccion.getCalles().size() > 0) {
					for(Calle calle: direccion.getCalles()) {
						if(calle.getNombreCalle()!=null && calle.getNombreCalle()!="") {
							WHERE("c.nombre_calle LIKE " + "'%".concat(calle.getNombreCalle()).concat("%'"));
						}if(calle.getTipoCalle()!=null) {
							WHERE("c.tipo_calle = " + "'".concat(calle.getTipoCalle().name()).concat("'"));
						}
					}
				}
			}
		}}.toString();
	}
}
