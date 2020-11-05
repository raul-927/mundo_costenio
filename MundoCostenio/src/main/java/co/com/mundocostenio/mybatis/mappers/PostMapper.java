package co.com.mundocostenio.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import co.com.mundocostenio.domain.Post;
import co.com.mundocostenio.mybatis.sql.PostSqlProvider;


public interface PostMapper {
	
	
	@InsertProvider(type = PostSqlProvider.class, method ="insert")
	//@Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id") 
	void insert(@Param("post") Post post);
	
	@SelectProvider(type = PostSqlProvider.class, method = "select")
	@ResultMap("co.com.mundocostenio.mybatis.mappers.PostMapper.PostResult")
	List<Post> select();

}
