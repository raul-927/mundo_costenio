package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;
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
		}}.toString();
	}

	public String showPersonas(Persona persona) {
		
		return new SQL() {{
			SELECT("*");
			FROM("persona");
			if(persona.getPersonaId() > 0) {
				WHERE("id = "+"'".concat(String.valueOf(persona.getPersonaId())).concat("'"));
			}
			if(persona.getCedula() > 0) {
				WHERE("cedula = "+"'".concat(String.valueOf(persona.getCedula())).concat("'"));
			}else {
				if(persona.getNombre() != null) {
					WHERE("nombre = "+"'".concat(persona.getNombre()).concat("'"));
				}
				if(persona.getApellido() != null) {
					WHERE("apellido = "+"'".concat(persona.getApellido()).concat("'"));
				}
				if(persona.getRol() != null) {
					WHERE("rol = "+  "'".concat(String.valueOf(persona.getRol())).concat("'"));
				}
			}
			
		}}.toString();
	}
	
	public String showAllPersonas() {
		
		return new SQL() {{
			SELECT("*");
			FROM("persona");
		}}.toString();
	}
}
