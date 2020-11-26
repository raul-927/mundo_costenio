package co.com.mundocostenio.controller;

import java.util.ArrayList;
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

import co.com.mundocostenio.domain.Calle;
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
	
	
	@RequestMapping(
			value ="/calle", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insertCalle(@RequestBody @Valid Calle calle, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Calle calleResult = this.calleService.insert(calle);
		
		return new ResponseEntity<Calle>(calleResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/calle", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> updateCalle(@RequestBody Calle calle)throws Exception{
		HttpHeaders headers = new HttpHeaders();
		verificarCalle(calle);
		try {
			this.calleService.update(calle);
		}
		catch(Exception e) {
			FieldError fieldError = new FieldError("co.com.mundocostenio.domain.Calle", "calleId", e.getMessage());
			return new ResponseEntity<FieldError>(fieldError, headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Calle>(calle, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/calle", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> deleteCalle(@RequestBody Calle calle) throws Exception{
		HttpHeaders headers = new HttpHeaders();
		verificarCalle(calle);
		try {
			this.calleService.delete(calle);
		}
		catch(Exception e) {
			FieldError fieldError = new FieldError("co.com.mundocostenio.domain.Calle", "calleId", e.getMessage());
			return new ResponseEntity<FieldError>(fieldError, headers, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Calle>(calle, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/calles", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> showCalle(@RequestBody Calle calle){
		HttpHeaders headers = new HttpHeaders();
		verificarCalle(calle);
		List<Calle> calles = this.calleService.select(calle);
		
		return new ResponseEntity<List<Calle>>(calles, headers, HttpStatus.OK);
	}
	
	private void verificarCalle(Calle calle) {
		List<Calle> calleResult = this.calleService.select(calle);
		if(calleResult.size() == 0) {
			if(calle.getCalleId()!= null || calle.getId() != null || calle.getNombreCalle()!=null || calle.getTipoCalle()!=null) {
				if(calle.getCalleId()!= null && calle.getCalleId() > 0) {
					throw new ResourceNotFoundException("Calle con id: " +calle.getCalleId()+"  no encontrada");
				}
				else {
					throw new ResourceNotFoundException("Calle no encontrada");
				}
			}
			else {
				throw new ResourceNotFoundException("No existen registros en la tabla calle");
			}
		}
	}
}
