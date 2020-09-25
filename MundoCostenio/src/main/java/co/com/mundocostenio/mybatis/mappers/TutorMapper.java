package co.com.mundocostenio.mybatis.mappers;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import co.com.mundocostenio.domain.Tutor;
import co.com.mundocostenio.mybatis.sql.TutorSqlProvider;

public interface TutorMapper {
	
	
	@SelectProvider(type=TutorSqlProvider.class, method="selectTutorById")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.TutorMapper.TutorResult")
	Tutor selectTutorById(int tutorId);

}
