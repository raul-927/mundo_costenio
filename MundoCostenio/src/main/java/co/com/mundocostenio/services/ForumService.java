package co.com.mundocostenio.services;

import java.util.List;
import co.com.mundocostenio.domain.Post;

public interface ForumService {
	Post createPost(Post post);
	Post updatePost(Post post);
	List<Post> getPosts();
	void deletePost(Post post);
}
