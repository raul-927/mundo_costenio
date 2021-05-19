package co.com.mundocostenio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.AuthenticationEntryPoint;

//@Configuration
//@EnableWebSecurity
//@Import(value = { AclMethodSecurityConfiguration.class })
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	//@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {//
		/*
		 * auth
		 * 
		 * // .jdbcAuthentication() // .usersByUsernameQuery(usersQuery) //
		 * .groupAuthoritiesByUsername(rolesQuery) //
		 * .passwordEncoder(passwordEncoder()) // .and() // .eraseCredentials(false);
		 * .inMemoryAuthentication()
		 * .withUser("car").password(passwordEncoder().encode("scarvarez")).roles(
		 * "USER") .and()
		 * .withUser("car2").password(passwordEncoder().encode("scarvarez")).roles(
		 * "USER") .and()
		 * .withUser("mon").password(passwordEncoder().encode("scarvarez")).roles(
		 * "ADMIN") .and()
		 * .withUser("bea").password(passwordEncoder().encode("scarvarez")).roles(
		 * "MARKETING") .and()
		 * .withUser("sales").password(passwordEncoder().encode("scarvarez")).roles(
		 * "SALES") .and()
		 * .withUser("counter").password(passwordEncoder().encode("scarvarez")).roles(
		 * "COUNTER") .and()
		 * .withUser("guess").password(passwordEncoder().encode("scarvarez")).roles(
		 * "GUESS") .and()
		 * .withUser("anonimous").password(passwordEncoder().encode("scarvarez")).roles(
		 * "ANONIMOUS") .and()
		 * .withUser("config").password(passwordEncoder().encode("scarvarez")).roles(
		 * "CONFIG") .and()
		 * .withUser("rrhh").password(passwordEncoder().encode("scarvarez")).roles(
		 * "RRHH");
		 */
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .csrf() .and() .authorizeRequests() .antMatchers("/","/login","/logout.do",
	 * "/anon", "/health").permitAll() .antMatchers("/**").authenticated() .and()
	 * .formLogin() .loginProcessingUrl("/login.do") .usernameParameter("username")
	 * .passwordParameter("password") .loginPage("/login") .and() .logout()
	 * .logoutRequestMatcher(new AntPathRequestMatcher("/logout.do")); }
	 * 
	 * 
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http. authorizeRequests() .antMatchers("/").permitAll()
	 * .antMatchers("/login").permitAll() .antMatchers("/registration").permitAll()
	 * .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
	 * .authenticated().and().csrf().disable().formLogin()
	 * .loginPage("/login").failureUrl("/login?error=true")
	 * .defaultSuccessUrl("/admin/home") .usernameParameter("email")
	 * .passwordParameter("password") .and().logout() .logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout"))
	 * .logoutSuccessUrl("/").and().exceptionHandling()
	 * .accessDeniedPage("/access-denied"); }
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		/*
		 * http .httpBasic() .authenticationEntryPoint(authEntryPoint);
		 * 
		 * http .csrf().disable() .authorizeRequests()
		 * .antMatchers(HttpMethod.POST,"/listaPreciosSearch").authenticated()
		 * .antMatchers(HttpMethod.POST, "/login").permitAll()
		 * .antMatchers(HttpMethod.GET,"/forum").authenticated()
		 * .antMatchers(HttpMethod.POST,"/forum").authenticated()
		 * .antMatchers(HttpMethod.GET,"/grupoCuenta").permitAll()
		 * .antMatchers(HttpMethod.POST,"/grupoCuenta").permitAll()
		 * .antMatchers(HttpMethod.PUT,"/grupoCuenta").permitAll()
		 * .antMatchers(HttpMethod.DELETE,"/grupoCuenta").permitAll()
		 * .antMatchers(HttpMethod.POST,"/grupoCuentaSearch").permitAll()
		 * 
		 * .antMatchers(HttpMethod.PUT,"/cuenta").permitAll()
		 * .antMatchers(HttpMethod.DELETE,"/cuenta").permitAll()
		 * .antMatchers(HttpMethod.GET,"/cuenta").permitAll()
		 * .antMatchers(HttpMethod.POST,"/cuenta").permitAll()
		 * .antMatchers(HttpMethod.POST,"/cuentas").permitAll()
		 * 
		 * .antMatchers(HttpMethod.POST,"/tipoProducto").permitAll()
		 * .antMatchers(HttpMethod.PUT,"/tipoProducto").permitAll()
		 * .antMatchers(HttpMethod.DELETE,"/tipoProducto").permitAll()
		 * .antMatchers(HttpMethod.GET,"/tipoProducto").permitAll()
		 * .antMatchers(HttpMethod.POST,"/tipoProductoSearch").permitAll()
		 * .anyRequest().permitAll();
		 */
	}

	
	 
	 
}