package co.com.mundocostenio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true, mode= AdviceMode.PROXY)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication()
	    .withUser("user")
	    .password(passwordEncoder().encode("user"))
	    .roles("ADMIN","USER");
	}
	
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http
	    .csrf()
	    .and()
	    .authorizeRequests()
	      .antMatchers("/","/login","/logout.do", "/anon", "/health").permitAll()
	      .antMatchers("/**").authenticated()
	    .and()
	      .formLogin()
	        .loginProcessingUrl("/login.do")
	          .usernameParameter("username")
	          .passwordParameter("password")
	        .loginPage("/login")
	    .and()
	      .logout()
	      .logoutRequestMatcher(new AntPathRequestMatcher("/logout.do"));
	}
	
	
	
 	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
			authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/registration").permitAll()
				.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
				.authenticated().and().csrf().disable().formLogin()
				.loginPage("/login").failureUrl("/login?error=true")
				.defaultSuccessUrl("/admin/home")
				.usernameParameter("email")
				.passwordParameter("password")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
	*/
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
       http
       	.csrf().disable()
       		.authorizeRequests()
		        .antMatchers("/").permitAll()
		        .antMatchers(HttpMethod.POST,"/listaPreciosSearch").authenticated()
		        .antMatchers(HttpMethod.POST, "/login").permitAll()
		        .antMatchers(HttpMethod.POST,"/newuser/*").permitAll()
		        .antMatchers(HttpMethod.GET,"/master/*").permitAll()
		        .antMatchers(HttpMethod.GET,"/exploreCourse").permitAll()
		        .anyRequest().authenticated();
    }
}