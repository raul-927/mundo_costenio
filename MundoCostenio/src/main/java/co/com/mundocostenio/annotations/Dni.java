package co.com.mundocostenio.annotations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 


import javax.validation.Constraint;
import javax.validation.Payload;

import co.com.mundocostenio.validators.ValidoDni;



@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidoDni.class)
@Documented
public @interface Dni {
	
String message();
	
	Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

}
