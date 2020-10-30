package co.com.mundocostenio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.acls.AclEntryVoter;
import org.springframework.security.acls.AclPermissionEvaluator;
import org.springframework.security.acls.domain.AclAuthorizationStrategy;
import org.springframework.security.acls.domain.AclAuthorizationStrategyImpl;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ConsoleAuditLogger;
import org.springframework.security.acls.domain.DefaultPermissionGrantingStrategy;
import org.springframework.security.acls.domain.EhCacheBasedAclCache;
import org.springframework.security.acls.jdbc.BasicLookupStrategy;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.acls.jdbc.LookupStrategy;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.PermissionGrantingStrategy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.context.annotation.AdviceMode;

import co.com.mundocostenio.domain.Post;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true, mode= AdviceMode.PROXY)
public class AclMethodSecurityConfiguration extends GlobalMethodSecurityConfiguration{
	
	private static final String className 	="com.mysql.cj.jdbc.Driver";
	private static final String url 		= "jdbc:mysql://localhost/mundocostenio_db?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String userName 	="root";
	private static final String passWord 	="";
	
	@Autowired
    MethodSecurityExpressionHandler 
      defaultMethodSecurityExpressionHandler;
	
	@Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return defaultMethodSecurityExpressionHandler;
    }
	
	@Bean
	public DriverManagerDataSource dataSource2() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(className);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(userName);
		driverManagerDataSource.setPassword(passWord);
		return driverManagerDataSource;
	}
	
	@Bean
	public MethodSecurityExpressionHandler 
	  defaultMethodSecurityExpressionHandler() {
	    DefaultMethodSecurityExpressionHandler expressionHandler
	      = new DefaultMethodSecurityExpressionHandler();
	    AclPermissionEvaluator permissionEvaluator 
	      = new AclPermissionEvaluator(aclService());
	    expressionHandler.setPermissionEvaluator(permissionEvaluator);
	    return expressionHandler;
	}
	
	@Bean 
	public JdbcMutableAclService aclService() { 
	    return new JdbcMutableAclService(
	      dataSource2(), lookupStrategy(), aclCache()); 
	}

	@Bean
	public AclAuthorizationStrategy aclAuthorizationStrategy() {
	    return new AclAuthorizationStrategyImpl(
	      new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"));
	}
	
	@Bean
	public PermissionGrantingStrategy permissionGrantingStrategy() {
	    return new DefaultPermissionGrantingStrategy(
	      new ConsoleAuditLogger());
	}
	
	@Bean
	public EhCacheBasedAclCache aclCache() {
	    return new EhCacheBasedAclCache(
	      aclEhCacheFactoryBean().getObject(), 
	      permissionGrantingStrategy(), 
	      aclAuthorizationStrategy()
	    );
	}
	
	@Bean
	public EhCacheFactoryBean aclEhCacheFactoryBean() {
	    EhCacheFactoryBean ehCacheFactoryBean = new EhCacheFactoryBean();
	    ehCacheFactoryBean.setCacheManager(aclCacheManager().getObject());
	    ehCacheFactoryBean.setCacheName("aclCache");
	    return ehCacheFactoryBean;
	}
	 
	@Bean
	public EhCacheManagerFactoryBean aclCacheManager() {
	    return new EhCacheManagerFactoryBean();
	}
	
	@Bean 
	public LookupStrategy lookupStrategy() { 
	    return new BasicLookupStrategy(
	      dataSource2(), 
	      aclCache(), 
	      aclAuthorizationStrategy(), 
	      new ConsoleAuditLogger()
	    ); 
	}
	
	@Bean
	public AclEntryVoter aclDeletePostVoter() {
		Permission[] requirePermission = {BasePermission.DELETE};
		AclEntryVoter aclEntryVoter = new AclEntryVoter(aclService(),"ACL_POST_DELETE",requirePermission);
		aclEntryVoter.setProcessDomainObjectClass(Post.class);
		return aclEntryVoter;
	}
	
	@Bean
	public AclEntryVoter aclUpdatePostVoter() {
		Permission[] requirePermission = {BasePermission.ADMINISTRATION};
		AclEntryVoter aclEntryVoter = new AclEntryVoter(aclService(),"ACL_POST_UPDATE",requirePermission);
		aclEntryVoter.setProcessDomainObjectClass(Post.class);
		return aclEntryVoter;
	}
	
	@Bean
	public AclEntryVoter aclReadPostVoter() {
		Permission[] requirePermission = {BasePermission.READ};
		AclEntryVoter aclEntryVoter = new AclEntryVoter(aclService(),"ACL_POST_READ",requirePermission);
		aclEntryVoter.setProcessDomainObjectClass(Post.class);
		return aclEntryVoter;
	}
}
