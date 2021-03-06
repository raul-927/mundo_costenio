package co.com.mundocostenio.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.mundocostenio.domain.Barrio;

//import com.nimbusds.oauth2.sdk.http.HTTPResponse;

import co.com.mundocostenio.domain.Persona;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.PersonasService;

@RestController
public class PersonasController {
	
	@Autowired
	private PersonasService personasService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	@RequestMapping(
			value ="/persona", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>insert(@RequestBody @Valid Persona persona, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Persona personaResult =this.personasService.insert(persona);
		
		return new ResponseEntity<Persona>(personaResult, headers,HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/persona", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>update(@RequestBody @Valid Persona persona, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		this.verificarPersonas(persona);
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Persona personaResult = this.personasService.update(persona);
		
		return new ResponseEntity<Persona>(personaResult, headers,HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/persona", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>delete(@RequestBody @Valid Persona persona, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		this.verificarPersonas(persona);
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.personasService.delete(persona.getPersonaId());
		
		return new ResponseEntity<Persona>(persona, headers,HttpStatus.OK);
	}
	
	
	@RequestMapping(
			value ="/personas", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Persona>>select(@RequestBody Persona persona){
		HttpHeaders headers = new HttpHeaders();
		this.verificarPersonas(persona);
		List<Persona> personasList = this.personasService.select(persona);
		
		return new ResponseEntity<List<Persona>>(personasList, headers,HttpStatus.OK);
	}
	
	private void verificarPersonas(Persona persona) {
		List<Persona> personaResult = this.personasService.select(persona);
		if(personaResult.size() == 0) {
			if(persona.getPersonaId()!= null || persona.getId() != null || persona.getNombre()!=null) {
				if(persona.getPersonaId()!= null && persona.getPersonaId() > 0) {
					throw new ResourceNotFoundException("Persona con id: " +persona.getPersonaId()+"  no encontrada");
				}
				else {
					throw new ResourceNotFoundException("Persona no encontrada");
				}
			}
			else {
				throw new ResourceNotFoundException("No existen registros en la tabla persona");
			}
		}
	}
}
