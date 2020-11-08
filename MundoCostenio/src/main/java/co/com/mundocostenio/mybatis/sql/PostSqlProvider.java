package co.com.mundocostenio.mybatis.sql;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Calle;
import co.com.mundocostenio.domain.Post;

public class PostSqlProvider {
	
	public String insert(Post post) {
		return new SQL() {{
			INSERT_INTO("post");
			if(post.getId() > 0) {
				VALUES("id", String.valueOf(post.getId()));
			}
			if(post.getContent()!=null && post.getContent()!="") {
				VALUES("content", "'".concat(post.getContent()).concat("'"));
			}
			if(post.getCalle()!=null && post.getCalle().getCalleId() >0) {
				VALUES("calle_id", String.valueOf(post.getCalle().getCalleId()));
			}
		}}.toString();
	}
	
	public String update(Post post) {
		return new SQL() {{
			UPDATE("post");
			if(post.getContent()!=null && post.getContent()!="") {
				SET("content = "+ "'".concat(post.getContent()).concat("'"));
			}
			if(post.getCalle()!=null && post.getCalle().getCalleId() >0) {
				SET("calle_id = "+ String.valueOf(post.getCalle().getCalleId()));
			}
			WHERE("id = " + String.valueOf(post.getId()));
		}}.toString();
	}
	
	public String select() {
		return new SQL() {{
			SELECT("p.id, p.content");
			SELECT("c.calle_id, c.nombre_calle, c.tipo_calle");
			FROM("post p");
			FROM("calle c");
			WHERE("p.calle_id = c.calle_id");
			
		}}.toString();
	}
	
	public String delete(int id) {
		return new SQL() {{
			DELETE_FROM("post");
			WHERE("id = " + String.valueOf(id));
		}}.toString();
	}
}