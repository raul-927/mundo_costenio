package co.com.mundocostenio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@SuppressWarnings("deprecation")
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
    @Autowired
    private DataSource dataSource;
    
   @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(tokenStore()).authenticationEntryPoint(authenticationEntryPoint);
    }

    @Bean
    public TokenStore tokenStore() {
    	JdbcTokenStore jdb =  new JdbcTokenStore(dataSource);
    	System.out.println("jdb: "+jdb.toString());
        return jdb;
    }
}
