package co.com.mundocostenio.as.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.*;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
@Configuration
@EnableAuthorizationServer
//@CrossOrigin(origins = "*")
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Value("${jwt.key}")
	private String jwtKey;
	
	private static final String SCOPE_PASSWORD = "password";
	private static final String SCOPE_REFRESH_TOKEN ="refresh_token";
	private static final String SCOPE_AUTHORIZATION_CODE = "authorization_code";
	private static final String SCOPE_CLIENT_CREDENTIALS = "client_credentials";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .secret("secret")
                .authorizedGrantTypes(SCOPE_CLIENT_CREDENTIALS, SCOPE_AUTHORIZATION_CODE, SCOPE_PASSWORD, SCOPE_REFRESH_TOKEN)
               .scopes("read")
        .and()
                .withClient("resourceserver")
                .secret("resourceserversecret");
    }

    @Override
    @CrossOrigin(origins = "*")
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        endpoints.authenticationManager(authenticationManager)
        .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE)
        .tokenStore(tokenStore())
        .accessTokenConverter(
        		jwtAccessTokenConverter());
    }
    
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    	security.checkTokenAccess("isAuthenticated()");
    }
    
    @Bean
    public TokenStore tokenStore() {
	    return new JwtTokenStore(
	    		jwtAccessTokenConverter());
    }
    
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
	    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	    converter.setSigningKey(jwtKey);
	    return converter;
    }
}

