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
import org.springframework.web.server.ResponseStatusException;

import co.com.mundocostenio.domain.Barrio;
import co.com.mundocostenio.exceptions.BindingResultException;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.BarrioService;

@RestController
public class BarrioController {
	
	@Autowired
	private BarrioService barrioService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	
	@RequestMapping(
			value ="/barrio", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>insert(@RequestBody @Valid Barrio barrio, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Barrio barrioResult = this.barrioService.insert(barrio);
		
		return new ResponseEntity<Barrio>(barrioResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/barrio", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>update(@RequestBody Barrio barrio) throws ResourceNotFoundException{ 
		HttpHeaders headers = new HttpHeaders();
		verificarBarrio(barrio);
		if(barrio.getBarrioId()==null || barrio.getBarrioId() ==0) {
			throw new BindingResultException("barrioId no debe ser null o cero");
		}
		Barrio barrioResult = this.barrioService.update(barrio);
		
		return new ResponseEntity<Barrio>(barrioResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/barrio", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>delete(@RequestBody Barrio barrio) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		verificarBarrio(barrio);
		if(barrio.getBarrioId()==null || barrio.getBarrioId() ==0) {
			throw new BindingResultException("barrioId no debe ser null o cero");
		}
		this.barrioService.delete(barrio);
		
		return new ResponseEntity<Integer>(null, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/barrios", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>select(@RequestBody Barrio barrio) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		verificarBarrio(barrio);
		List<Barrio> barrioResult = this.barrioService.select(barrio);
		
		return new ResponseEntity<List<Barrio>>(barrioResult, headers, HttpStatus.OK);
	}
	
	private void verificarBarrio(Barrio barrio) throws ResourceNotFoundException{
		String message ="";
		List<Barrio> barrioResult = this.barrioService.select(barrio);
		if(barrioResult.size() == 0) {
			if(barrio.getBarrioId()!= null || barrio.getId() != null || barrio.getNombreBarrio()!=null) {
				if(barrio.getBarrioId()!= null && barrio.getBarrioId() > 0) {
					message = "Barrio con id: " +barrio.getBarrioId()+"  no encontrado";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Barrio no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "No existen registros en la tabla barrio";
				throw new ResourceNotFoundException(message);
			}
		}
	}

}
