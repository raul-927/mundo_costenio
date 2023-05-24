package co.com.mundocostenio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import co.com.mundocostenio.domain.model.Calle;
import co.com.mundocostenio.exceptions.BindingResultException;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.CalleService;

@RestController
public class CalleController {
	
	@Autowired
	private CalleService calleService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	private String message;
	
	
	@PostMapping(
            value = "/calle",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insertCalle(@RequestBody @Valid Calle calle, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.BAD_REQUEST);
		}
		Calle calleResult = this.calleService.insert(calle);
		
		return new ResponseEntity<Calle>(calleResult, headers, HttpStatus.OK);
	}
	
	@PutMapping(
            value = "/calle",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> updateCalle(@RequestBody Calle calle)throws Exception{
		HttpHeaders headers = new HttpHeaders();
		verificarCalle(calle);
		if(calle.getCalleId() ==null || calle.getCalleId() == 0) {
			throw new BindingResultException("calleId no debe ser null o cero");
		}
		this.calleService.update(calle);
		
		return new ResponseEntity<Calle>(calle, headers, HttpStatus.OK);
	}
	
	@DeleteMapping(
            value = "/calle",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> deleteCalle(@RequestBody Calle calle) throws Exception{
		HttpHeaders headers = new HttpHeaders();
		verificarCalle(calle);
		if(calle.getCalleId() ==null || calle.getCalleId() == 0) {
			throw new BindingResultException("calleId no debe ser null o cero");
		}
		this.calleService.delete(calle);
		
		return new ResponseEntity<Calle>(calle, headers, HttpStatus.OK);
	}
	
	@PostMapping(
            value = "/calles",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> showCalle(@RequestBody Calle calle) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		verificarCalle(calle);
		List<Calle> calles = this.calleService.select(calle);
		
		return new ResponseEntity<List<Calle>>(calles, headers, HttpStatus.OK);
	}
	
	private void verificarCalle(Calle calle){
		List<Calle> calleResult = this.calleService.select(calle);
		if(calleResult.isEmpty()) {
			if(calle.getCalleId()!= null || calle.getId() != null || calle.getNombreCalle()!=null || calle.getTipoCalle()!=null) {
				if(calle.getCalleId()!= null && calle.getCalleId() > 0) {
					message = "Calle con id: " +calle.getCalleId()+"  no encontrada";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Calle no encontrada";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "CALLE: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}
}
