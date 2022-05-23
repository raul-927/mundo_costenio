package co.com.mundocostenio.mybatis.sql;


import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.enumerator.RolesEnum;

public class RolesSqlProvider {
	
	
	public String insert(List<RolesEnum> rolesEnum, int id) {
		
		return new SQL() {{
			
			INSERT_INTO("roles_personas");
			INTO_COLUMNS("rol_id","persona_id");
			for(RolesEnum r :rolesEnum) {
				INTO_VALUES(String.valueOf(r.getRolId()), String.valueOf(id));
				ADD_ROW();
			}
			
		}}.toString();
	}

}
