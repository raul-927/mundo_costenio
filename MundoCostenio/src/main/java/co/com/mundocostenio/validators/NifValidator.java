package co.com.mundocostenio.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.com.mundocostenio.annotations.Nif;


 
public class NifValidator implements ConstraintValidator<Nif, String> {
 
    private Pattern mask =  Pattern.compile("[0-9]{8,8}[A-Z]");
     
    @Override
    public void initialize(Nif constraintAnnotation) {
    }
 
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
 
        final Matcher matcher = mask.matcher(value);
 
        if(!matcher.matches()){
            return false;
        }
         
        final String dni = value.substring(0,8);
        final String control = value.substring(8,9);
        final String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        final int position = Integer.parseInt(dni)%23;
 
        final String controlCalculated = letters.substring(position,position+1);
 
        if(!control.equalsIgnoreCase(controlCalculated)){
            return false;
        }
        return true;
    }
}
