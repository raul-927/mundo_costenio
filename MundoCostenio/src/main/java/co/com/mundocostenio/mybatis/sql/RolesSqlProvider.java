package co.com.mundocostenio.mybatis.sql;


import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.enumerator.RolesEnum;

public class RolesSqlProvider {
	
	
	public String insert(List<RolesEnum> rolesEnum, int id) {
		
		return new SQL() {{
			
			INSERT_INTO("roles_personas");
			for(RolesEnum r :rolesEnum) {
				VALUES("rol_id",String.valueOf(r.getId()));
				VALUES("persona_id", String.valueOf(id));
			}
			
			
			
		}}.toString();
	}

}
