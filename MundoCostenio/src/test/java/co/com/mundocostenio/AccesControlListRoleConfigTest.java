package co.com.mundocostenio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;

import co.com.mundocostenio.domain.Calle;
import co.com.mundocostenio.enumerator.TipoCalleEnum;
import co.com.mundocostenio.services.CalleService;


@SpringBootTest
//@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY,connection = EmbeddedDatabaseConnection.H2)
public class AccesControlListRoleConfigTest {
	
	@Autowired
	private CalleService calleService;
	
	private static final String ACCES_IS_DENIED = "Access is denied";
	private static final String NOMBRE_CALLE="PRUEBA";
	private static final String NOMBRE_CALLE_UPDATE="PRUEBA-UPDATE";
	
	@Test
	@WithMockUser(username = "sofia", roles="CONFIG")
	public void 
	  insertCalle(){
		Calle calle = new Calle();
		calle.setNombreCalle(NOMBRE_CALLE);
		calle.setTipoCalle(TipoCalleEnum.DG);
	    Calle calleResult = calleService.insert(calle);
	    assertNotNull(calleResult);
	    assertEquals("PRUEBA", calleResult.getNombreCalle());
	}
	
	
	@Test
	@WithMockUser(username = "jhon", roles="CONFIG")
	public void 
	  updateCalleWithUserNotOwner(){
		AccessDeniedException thrown = Assertions.assertThrows(AccessDeniedException.class, () -> {
			Calle calle = new Calle();
			calle.setCalleId(1);
			calle.setNombreCalle(NOMBRE_CALLE_UPDATE);
			calle.setTipoCalle(TipoCalleEnum.K);
		    Calle calleResult = calleService.update(calle);
		    assertNotNull(calleResult);
		    assertEquals("PRUEBA-UPDATE", calleResult.getNombreCalle());
		});

	  Assertions.assertEquals(ACCES_IS_DENIED, thrown.getMessage());
	}
	
	@Test
	@WithMockUser(username = "sofia", roles="CONFIG")
	public void 
	  updateCalleWithUserOwner(){
		Calle calle = new Calle();
		calle.setCalleId(1);
		calle.setNombreCalle(NOMBRE_CALLE_UPDATE);
		calle.setTipoCalle(TipoCalleEnum.K);
		Calle calleResult = calleService.update(calle);
		assertNotNull(calleResult);
		assertEquals("PRUEBA-UPDATE", calleResult.getNombreCalle());
	  
	}
	
	
	@Test
	@WithMockUser(roles = "CONFIG")
	public void 
	  selectCalleWithRoleConfig(){
		Calle calle = new Calle();
		calle.setCalleId(1);
	    List<Calle> details = calleService.select(calle);
	    assertNotNull(details);
	    assertEquals(1,details.size());
	}
	
	@Test
	@WithMockUser(username = "sofia", roles="CONFIG")
	public void 
	  selectCalleWithUserName(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("NAME: "+authentication.getName());
		System.out.println("CREDENTIALS: "+authentication.getCredentials());
		authentication.getAuthorities().stream().forEach(a ->{
			System.out.println("AUTHORITY: "+a.getAuthority());
		});
		Calle calle = new Calle();
		calle.setCalleId(1);
	    List<Calle> details = calleService.select(calle);
	    assertNotNull(details);
	    assertEquals(1,details.size());
	}
	
	
	@Test
	@WithMockUser(roles = "MARKETING")
	public void 
	  selectCalleWithRoleMarketing(){
		Calle calle = new Calle();
		calle.setCalleId(1);
	    List<Calle> details = calleService.select(calle);
	    assertNotNull(details);
	    assertEquals(0,details.size());
	}
	
	@Test
	@WithMockUser(roles = "MARKETING")
	public void 
	  deleteCalleWithRoleMarketing(){
		AccessDeniedException thrown = Assertions.assertThrows(AccessDeniedException.class, () -> {
			Calle calle = new Calle();
			calle.setCalleId(2);
		    calleService.delete(calle);
		    List<Calle> details = calleService.select(calle); 
		});

	  Assertions.assertEquals(ACCES_IS_DENIED, thrown.getMessage());
	}
	
	@Test
	@WithMockUser(roles = "CONFIG")
	public void 
	  deleteCalleWithRoleConfig(){
		AccessDeniedException thrown = Assertions.assertThrows(AccessDeniedException.class, () -> {
			Calle calle = new Calle();
			calle.setCalleId(2);
		    calleService.delete(calle);
		    List<Calle> details = calleService.select(calle); 
		});

	  Assertions.assertEquals(ACCES_IS_DENIED, thrown.getMessage());
	}
	
	@Test
	@WithMockUser(roles = "ADMIN")
	public void 
	  deleteCalleWithRoleAdmin(){
		Calle calle = new Calle();
		calle.setNombreCalle(NOMBRE_CALLE);
		List<Calle> calles = calleService.select(calle);
		calleService.delete(calles.get(0));
		List<Calle> details = calleService.select(calle); 
	  Assertions.assertEquals(0, details.size());
	}

}
