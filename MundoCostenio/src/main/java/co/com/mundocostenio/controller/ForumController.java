package co.com.mundocostenio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.mundocostenio.domain.Departamento;
import co.com.mundocostenio.domain.Post;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.ForumService;

@RestController
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	
	
	@RequestMapping(
			value ="/forum", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> createPost(@RequestBody Post post){
		HttpHeaders header = new HttpHeaders();
		Post postResult = forumService.createPost(post);
		return new ResponseEntity<Post>(postResult, header, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/forum", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> updatePost(@RequestBody Post post){
		HttpHeaders header = new HttpHeaders();
		
		Post postResult = forumService.updatePost(post);
		return new ResponseEntity<Post>(postResult, header, HttpStatus.OK);
	}

	@RequestMapping(
			value ="/forum", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> showForm(){
		HttpHeaders header = new HttpHeaders();
		List<Post> postList = forumService.getPosts();
		
		return new ResponseEntity<List<Post>>(postList, header, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/forum", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> deletePost(@RequestBody Post post){
		HttpHeaders header = new HttpHeaders();
		forumService.deletePost(post);
		return new ResponseEntity<Post>(post, header, HttpStatus.OK);
	}
}
