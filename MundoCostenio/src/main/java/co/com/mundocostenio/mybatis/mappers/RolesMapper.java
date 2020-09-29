package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import co.com.mundocostenio.enumerator.RolesEnum;
import co.com.mundocostenio.mybatis.sql.RolesSqlProvider;



public interface RolesMapper {
	
	@InsertProvider(type = RolesSqlProvider.class, method ="insert")
	@Options(useGeneratedKeys=true, keyProperty="rol_persona_id")
	void insertRol(List<RolesEnum> rolesEnum, int idPersona);
}
