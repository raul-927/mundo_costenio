package co.com.mundocostenio.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.com.mundocostenio.annotations.Cedula;
import co.com.mundocostenio.dto.NroVerifCedula;



public class ValidoCedula extends NroVerifCedula implements ConstraintValidator<Cedula, Integer>
{
	
	@Override
	public void initialize(Cedula constraintAnnotation) {
		
	
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		
		return this.nroCedula(value);
	}
	
	
}
