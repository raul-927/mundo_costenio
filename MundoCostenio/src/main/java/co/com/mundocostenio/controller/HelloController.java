package co.com.mundocostenio.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
    	Authentication user = (Authentication)SecurityContextHolder.getContext().getAuthentication();
    	System.out.println("user nombre: "+user.getName());
    	System.out.println("user roles: "+user.getAuthorities());
    	System.out.println("Nombre: "+SecurityContextHolder.getContext().getAuthentication().getName());
    	System.out.println("Roles: "+SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    	//System.out.println("nombre: "+user.getUsername());
    	//System.out.println("rol: "+user.getAuthorities());
        return "Hello!";
    }
}
