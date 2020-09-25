package co.com.mundocostenio.validators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.mundocostenio.annotations.CedulaExistente;
import co.com.mundocostenio.domain.Persona;
import co.com.mundocostenio.dto.NroVerifCedula;
import co.com.mundocostenio.services.PersonasService;



public class ValidoCedulaExistente extends NroVerifCedula implements ConstraintValidator<CedulaExistente, Integer>{
	
	@Autowired
	private PersonasService personasService;
	
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context){
		boolean control = true;
		boolean NroVerif = this.nroCedula(value);
		if(NroVerif){
			int cedula = value;
			Persona p = new Persona();
			p.setCedula(cedula);
			List<Persona> personas = personasService.showPersonas(p);
			try{
				if(personas.size() > 0){
					control=false;
				}
					
			}
			catch(NullPointerException e){
				control = true;
			}
		}
		return control;
	}	
	@Override
	public void initialize(CedulaExistente constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}
}
