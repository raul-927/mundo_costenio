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

import co.com.mundocostenio.domain.Calle;
import co.com.mundocostenio.services.CalleService;

@RestController
public class CalleController {
	
	@Autowired
	private CalleService calleService;
	
	
	@RequestMapping(
			value ="/calle", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insertCalle(@RequestBody @Valid Calle calle, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Calle calleResult = this.calleService.insertCalle(calle);
		
		return new ResponseEntity<Calle>(calleResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/callese", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> updateCalle(@RequestBody @Valid Calle calle, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.calleService.updateCalle(calle);
		
		return new ResponseEntity<Calle>(calle, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/calle", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> deleteCalle(@RequestBody @Valid Calle calle, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.calleService.deleteCalle(calle);
		
		return new ResponseEntity<Calle>(calle, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/calles", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> showCalle(@RequestBody @Valid Calle calle, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		List<Calle> calles = this.calleService.showCalle(calle);
		
		return new ResponseEntity<List<Calle>>(calles, headers, HttpStatus.OK);
	}

}
