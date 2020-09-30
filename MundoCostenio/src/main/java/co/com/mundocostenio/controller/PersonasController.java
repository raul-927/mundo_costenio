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

//import com.nimbusds.oauth2.sdk.http.HTTPResponse;

import co.com.mundocostenio.domain.Persona;
import co.com.mundocostenio.services.PersonasService;

@RestController
public class PersonasController {
	
	@Autowired
	private PersonasService personasService;
	
	@RequestMapping(
			value ="/persona", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>insert(@RequestBody @Valid Persona persona, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {

			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.INTERNAL_SERVER_ERROR);
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
		List<Persona> personasList = this.personasService.select(persona);
		
		return new ResponseEntity<List<Persona>>(personasList, headers,HttpStatus.OK);
	}

}
