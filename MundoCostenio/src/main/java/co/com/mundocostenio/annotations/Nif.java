package co.com.mundocostenio.annotations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 


import javax.validation.Constraint;
import javax.validation.Payload;

import co.com.mundocostenio.validators.NifValidator;


 
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = NifValidator.class)
@Documented
public @interface Nif 
{
 
    String message() default "{uy.com.cvaucher.constraints.nif}";
 
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
     
}
