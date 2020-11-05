package co.com.mundocostenio.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mundocostenio.domain.Post;
import co.com.mundocostenio.enumerator.RolesEnum;
import co.com.mundocostenio.mybatis.mappers.PostMapper;

import org.springframework.security.core.userdetails.User;



@Service("forumService")
public class ForumServiceImpl implements ForumService {
	@Autowired
	private MutableAclService mutableAclService;
	
	@Autowired
	private PostMapper postMapper;

	@Override
	@PreAuthorize("hasRole('ROLE_USER')")
	@Transactional
	public Post createPost(@Param("post")Post post) {
		Integer id = Math.abs(post.hashCode());
		System.out.println("id: " + id);
		ObjectIdentity objectIdentity = new ObjectIdentityImpl(Post.class, id);
		MutableAcl mutableAcl = mutableAclService.createAcl(objectIdentity);
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("userName:" +user.getUsername());
        System.out.println("userPassword:" +user.getPassword());
        for(GrantedAuthority authority: user.getAuthorities()) {
        	System.out.println("userAuthority: " + authority.getAuthority());
        }
        mutableAcl.insertAce(0, BasePermission.ADMINISTRATION, new PrincipalSid(user.getUsername()), true);
        mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
        mutableAcl.insertAce(2, BasePermission.READ, new GrantedAuthoritySid(RolesEnum.USER.getDescripcion()), true);
		mutableAclService.updateAcl(mutableAcl);
		post.setId(id);
		postMapper.insert(post);
		return post;
	}
	
	@Override
	@PostFilter("hasPermission(filterObject, 'READ')")
	public List<Post> getPosts(){
		return this.postMapper.select();
	}
	
	public void setMutableAclService(MutableAclService mutableAclService) {
		this.mutableAclService = mutableAclService;
	}
	@Override
	@Transactional
	@PostFilter("hasPermission(filterObject, 'DELETE')")
	public void deletePost(Post post){
		ObjectIdentity oid = new ObjectIdentityImpl(Post.class, post.getId());
		mutableAclService.deleteAcl(oid, true);
	}
}
