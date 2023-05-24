package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.model.User;

public class LoginSqlProvider {
	
	
	public String selectUser(User user) {
		return new SQL() {{
			SELECT("nic, password, enabled");
			FROM("users");
			WHERE("nic = " +"'".concat(user.getNic()).concat("'"));
			WHERE("enalbled = 1");
		}}.toString();
	}
	
	public String selectCredentials(User user) {
		return new SQL() {{
			SELECT("d.nic NIC, r.rol_name ROL");
			
			FROM("user d");
			FROM("rol r");
			FROM("user_rol u");
			
			WHERE("d.nic = " +"'".concat(user.getNic()).concat("'"));
			WHERE("d.enabled = 1");
			WHERE("d.user_id = u.user_id");
			WHERE("u.rol_id = r.rol_id");
		}}.toString();
	}

}
