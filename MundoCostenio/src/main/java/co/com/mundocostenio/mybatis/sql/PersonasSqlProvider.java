package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.model.Calle;
import co.com.mundocostenio.domain.model.Direccion;
import co.com.mundocostenio.domain.model.Persona;
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
			if(persona.getUser() != null) {
				if(persona.getUser().getUserId()!=null && persona.getUser().getUserId() > 0) {
					VALUES("user_id", String.valueOf(persona.getUser().getUserId()));
				}
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
			if(persona.getUser() != null) {
				if(persona.getUser().getUserId()!=null && persona.getUser().getUserId() > 0) {
					SET("user_id = "+ String.valueOf(persona.getUser().getUserId()));
				}
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
			SELECT("p.persona_id, p.nombre, p.apellido, p.cedula");
			SELECT("dir.direccion_id, dir.nro_puerta, dir.geo_localizacion");
			SELECT("b.barrio_id, b.nombre_barrio");
			SELECT("c.calle_id, c.tipo_calle, c.nombre_calle");
			SELECT("dep.departamento_id, dep.nombre_departamento");
			SELECT("usr.user_id, usr.nic, usr.password, usr.enabled");
			
			FROM("persona p");
			FROM("direccion dir");
			FROM("departamento dep");
			FROM("calle c");
			FROM("barrio b");
			FROM("persona_direcciones perdir");
			FROM("direccion_calles dirca");
			FROM("user usr");
			
			WHERE("p.persona_id = perdir.persona_id");
			WHERE("perdir.direccion_id = dir.direccion_id");
			WHERE("dir.direccion_id = dirca.direccion_id");
			WHERE("dirca.calle_id = c.calle_id");
			WHERE("dir.barrio_id = b.barrio_id");
			WHERE("b.departamento_id = dep.departamento_id");
			WHERE("p.user_id = usr.user_id");
			
			if(persona != null) {
				if(persona.getPersonaId()!= null && persona.getPersonaId() > 0) {
					WHERE("p.persona_id = " + String.valueOf(persona.getPersonaId()));
				}
				else if(persona.getCedula()!=null && persona.getCedula() > 0) {
					WHERE("p.cedula = " + String.valueOf(persona.getCedula()));
				}else {
					if(persona.getNombre()!=null && persona.getNombre()!="") {
						WHERE("p.nombre LIKE '%" + persona.getNombre() + "%'");
					}
					if(persona.getApellido()!=null && persona.getApellido()!="") {
						WHERE("p.apellido LIKE '%" + persona.getApellido() + "%'");
					}
					
					if(persona.getDirecciones() != null && persona.getDirecciones().size() > 0) {
						for(Direccion direccion: persona.getDirecciones()) {
							if(direccion.getNroPuerta() > 0) {
								WHERE("d.nro_puerta = " + String.valueOf(direccion.getNroPuerta()));
							}
							if(direccion.getBarrio()!=null) {
								if(direccion.getBarrio().getNombreBarrio()!=null && direccion.getBarrio().getNombreBarrio()!="") {
									WHERE("b.nombre_barrio LIKE " + "'%".concat(direccion.getBarrio().getNombreBarrio()).concat("%'"));
								}
							}
							if(direccion.getCalles()!=null && direccion.getCalles().size() > 0) {
								for(Calle calle: direccion.getCalles()) {
									if(calle.getNombreCalle()!= null && calle.getNombreCalle()!="") {
										WHERE("c.nombre_calle LIKE " + "'%".concat(calle.getNombreCalle()).concat("%'"));
									}
									if(calle.getTipoCalle()!=null) {
										WHERE("c.tipo_calle = " + "'".concat(calle.getTipoCalle().name()).concat("'"));
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