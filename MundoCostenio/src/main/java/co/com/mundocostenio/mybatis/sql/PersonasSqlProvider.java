package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Barrio;
import co.com.mundocostenio.domain.Direccion;
import co.com.mundocostenio.domain.Persona;
public class PersonasSqlProvider {

	
	public String insert(Persona persona) {
		return new SQL() {{
			INSERT_INTO("persona");
			if(persona.getCedula() > 0) {
				VALUES("cedula", String.valueOf(persona.getCedula()));
			}
			if(persona.getNombre() !=null && persona.getNombre() !="") {
				VALUES("nombre", "'".concat(persona.getNombre()).concat("'"));
			}
			if(persona.getApellido() !=null && persona.getApellido()!="") {
				VALUES("apellido", "'".concat(persona.getApellido()).concat("'"));
			}
			if(persona.getRol()!=null) {
				VALUES("rol", "'".concat(persona.getRol().name()).concat("'"));
			}
		}}.toString();
	}
	
	public String update(Persona persona) {
		return new SQL() {{
			UPDATE("persona");
			if(persona.getCedula() > 0) {
				SET("cedula", String.valueOf(persona.getCedula()));
			}
			if(persona.getNombre() !=null && persona.getNombre() !="") {
				SET("nombre", "'".concat(persona.getNombre()).concat("'"));
			}
			if(persona.getApellido() !=null && persona.getApellido()!="") {
				SET("apellido", "'".concat(persona.getApellido()).concat("'"));
			}
			if(persona.getRol()!=null) {
				SET("rol", "'".concat(persona.getRol().name()).concat("'"));
			}
		}}.toString();
	}
	
	public String delete(int personaId) {
		return new SQL() {{
			if(personaId > 0) {
				DELETE_FROM("persona");
				WHERE("persona_id = " + String.valueOf(personaId));
			}
			
		}}.toString();
	}

	public String select(Persona persona) {
		
		return new SQL() {{
			SELECT("p.persona_id, p.nombre, p.apellido, p.cedula, p.rol");
			SELECT("dir.direccion_id");
			SELECT("dep.departamento_id, dep.nombre_departamento");
			SELECT("b.barrio_id, b.nombre_barrio");
			SELECT("u.ubicacion_id, u.nro_puerta, u.geo_localizacion");
			SELECT("c.calle_id, c.tipo_calle, c.nombre_calle");
			
			FROM("persona p");
			FROM("direccion dir");
			FROM("departamento dep");
			FROM("barrio b");
			FROM("ubicacion u");
			FROM("calle c");
			FROM("departamento_barrio depb");
			FROM("direccion_personas dp");
			FROM("ubicacion_calle ubc");
			
			WHERE("p.persona_id = dp.persona_id");
			WHERE("dp.direccion_id = dir.direccion_id");
			WHERE("dir.departamento_id = dep.departamento_id");
			WHERE("dep.departamento_id = depb.departamento_id");
			WHERE("depb.barrio_id = b.barrio_id");
			WHERE("b.ubicacion_id = u.ubicacion_id");
			WHERE("u.ubicacion_id= ubc.ubicacion_id");
			WHERE("ubc.calle_id = c.calle_id");
			
			if(persona != null) {
				if(persona.getPersonaId() > 0) {
					WHERE("p.persona_id = " + String.valueOf(persona.getPersonaId()));
				}
				else if(persona.getCedula() > 0) {
					WHERE("p.cedula = " + String.valueOf(persona.getCedula()));
				}else {
					if(persona.getNombre()!=null && persona.getNombre()!="") {
						WHERE("p.nombre LIKE '%" + persona.getNombre() + "%'");
					}
					if(persona.getApellido()!=null && persona.getApellido()!="") {
						WHERE("p.apellido LIKE '%" + persona.getApellido() + "%'");
					}
					if(persona.getRol()!=null) {
						WHERE("p.rol = " + "'".concat(persona.getRol().name()).concat("'"));
					}
					if(persona.getDirecciones() != null && persona.getDirecciones().size() > 0) {
						for(Direccion direccion: persona.getDirecciones()) {
							if(direccion.getDepartamento()!=null) {
								if(direccion.getDepartamento().getNombreDepartamento()!=null && direccion.getDepartamento().getNombreDepartamento()!="") {
									WHERE("dep.nombre_departamento = " + "'".concat(direccion.getDepartamento().getNombreDepartamento()).concat("'"));
								}
								if(direccion.getDepartamento().getBarrios() != null && direccion.getDepartamento().getBarrios().size() > 0) {
									for(Barrio barrio: direccion.getDepartamento().getBarrios()) {
										if(barrio.getNombreBarrio()!= null && barrio.getNombreBarrio()!="") {
											WHERE("b.nombre_barrio = " + "'".concat(barrio.getNombreBarrio()).concat("'"));
										}
										if(barrio.getUbicacion()!= null) {
											if(barrio.getUbicacion().getGeoLocalizacion()!=null && barrio.getUbicacion().getGeoLocalizacion()!="") {
												WHERE("u.geo_localizacion = " + "'".concat(barrio.getUbicacion().getGeoLocalizacion()).concat("'"));
											}
											if(barrio.getUbicacion().getNroPuerta() > 0) {
												WHERE ("u.nro_puerta = " + String.valueOf(barrio.getUbicacion().getNroPuerta()));
											}
											if(barrio.getUbicacion().getCalles()!=null && barrio.getUbicacion().getCalles().size() > 0) {
												
												if(barrio.getUbicacion().getCalles().get(0).getNombreCalle()!= null && barrio.getUbicacion().getCalles().get(0).getNombreCalle() !="") {
													WHERE("c.nombre_calle = " + "'".concat(barrio.getUbicacion().getCalles().get(0).getNombreCalle()).concat("'"));
												}
												if(barrio.getUbicacion().getCalles().get(1).getNombreCalle()!= null && barrio.getUbicacion().getCalles().get(1).getNombreCalle() !="") {
													WHERE("c.nombre_calle = " + "'".concat(barrio.getUbicacion().getCalles().get(1).getNombreCalle()).concat("'"));
												}	
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}}.toString();
	}
}