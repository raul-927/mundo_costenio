package co.com.mundocostenio.services;

import java.util.List;
import java.util.Map;

import co.com.mundocostenio.domain.Post;

public interface ForumService {
	Post createPost(Post post);
	List<Post> getPosts();
	void deletePost(Post post);
}
