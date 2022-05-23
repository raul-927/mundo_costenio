package co.com.mundocostenio.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.mundocostenio.annotations.Cedula;
import co.com.mundocostenio.jni.ControlCedulaJni;



public class ValidoCedula implements ConstraintValidator<Cedula, Integer>
{
	//@Autowired
	private ControlCedulaJni controlCedulaJni;
	
	@Override
	public void initialize(Cedula constraintAnnotation) {
		
	
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		
		int resultado = this.controlCedulaJni.controloCedula(value);
		System.out.println("resultado = " +resultado);
		boolean retorno = false;
		if(resultado == 1) {
			retorno = true;
		}
		else {
			retorno = false;
		}
		return retorno;
	}
	
	
}
