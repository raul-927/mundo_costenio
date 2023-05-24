package co.com.mundocostenio.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.mundocostenio.domain.model.Barrio;
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
	
	
	@PostMapping(
			value ="/barrio",
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>insert(@RequestBody @Valid Barrio barrio, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Barrio barrioResult = this.barrioService.insert(barrio);
		
		return new ResponseEntity<>(barrioResult, headers, HttpStatus.OK);
	}
	
	@PutMapping(
			value ="/barrio",
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Barrio>update(@RequestBody Barrio barrio) throws ResourceNotFoundException{ 
		HttpHeaders headers = new HttpHeaders();
		verificarBarrio(barrio);
		if(barrio.getBarrioId()==null || barrio.getBarrioId() ==0) {
			throw new BindingResultException("barrioId no debe ser null o cero");
		}
		Barrio barrioResult = this.barrioService.update(barrio);
		
		return new ResponseEntity<>(barrioResult, headers, HttpStatus.OK);
	}
	
	@DeleteMapping(
			value ="/barrio",
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Barrio>delete(@RequestBody Barrio barrio) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		verificarBarrio(barrio);
		if(barrio.getBarrioId()==null || barrio.getBarrioId() ==0) {
			throw new BindingResultException("barrioId no debe ser null o cero");
		}
		this.barrioService.delete(barrio);
		
		return new ResponseEntity<>(null, headers, HttpStatus.OK);
	}
	
	@PostMapping(
			value ="/barrios",
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<List<Barrio>>select(@RequestBody Barrio barrio) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		verificarBarrio(barrio);
		List<Barrio> barrioResult = this.barrioService.select(barrio);
		
		return new ResponseEntity<>(barrioResult, headers, HttpStatus.OK);
	}
	
	private void verificarBarrio(Barrio barrio) throws ResourceNotFoundException{
		String message ="";
		List<Barrio> barrioResult = this.barrioService.select(barrio);
		if(barrioResult.isEmpty()) {
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
				message = "BARRIO: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}

}
