package co.com.mundocostenio.as.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@CrossOrigin(origins = "*")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.authorities-query}")
	private String authoritiesQuery;
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
        // add http.cors()
    	//http.cors().and().csrf().disable();
        http.cors().and().csrf().disable().authorizeRequests()
                //.antMatchers("/login/**").permitAll()
                .anyRequest().permitAll(); // Authenticate users with HTTP basic authentication

        // REST is stateless
        //http.sessionManagement()
          //     .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
	
	@Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring()
        .antMatchers(HttpMethod.OPTIONS);
    }
	
    @Bean
    public UserDetailsService userDetailsService(DriverManagerDataSource dataSource) {
    	JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
	    userDetailsManager.setUsersByUsernameQuery(usersQuery);
	    userDetailsManager.setAuthoritiesByUsernameQuery(authoritiesQuery);
    return userDetailsManager;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
