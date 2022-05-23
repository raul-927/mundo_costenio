package co.com.mundocostenio.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class CustomInMemoryUserDetailsManager implements UserDetailsService {

	
	  private Map<String, User> users = new HashMap<>();
	  
	  public CustomInMemoryUserDetailsManager(Collection<User> users) { 
		  for (User user : users) { 
			  this.users.put(user.getUsername().toLowerCase(), user); 
		  } 
	  }
	  
	  @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{ 
		  User user = users.get(username.toLowerCase());
	  
		  if (user == null) { 
			  throw new UsernameNotFoundException(username); 
		  } return new User(user.getUsername(), user.getPassword(), user.getAuthorities(), user.getLastname(), user.getAge()); 
	}
}
