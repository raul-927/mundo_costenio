package co.com.mundocostenio.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Post;
import co.com.mundocostenio.mybatis.mappers.PostMapper;
import co.com.mundocostenio.security.acl.AccesControlListService;



@Service("forumService")
public class ForumServiceImpl implements ForumService {

	@Autowired
	private AccesControlListService<Post> accesControlListService;
	
	@Autowired
	private PostMapper postMapper;

	@Override
	@PreAuthorize(value ="hasRole('ROLE_USER')")
	@Transactional
	public Post createPost(@Param("post")Post post) {
		Integer id = accesControlListService.insert(post);
		post.setId(id);
		postMapper.insert(post);
		return post;
	}
	
	@Override
	//@PostAuthorize("hasPermission(filterObject, 'READ')")
	//@PreAuthorize("hasPermission(filterObject, 'READ')")
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Post> getPosts(){
		return this.postMapper.select();
	}
	
	
	@Override
	@Transactional
	//@PostFilter("hasPermission(filterObject, 'DELETE')")
	@PreAuthorize("hasPermission(#post, 'DELETE')")
	public void deletePost(@Param("post") Post post){
		this.accesControlListService.delete(post);
	}
}
