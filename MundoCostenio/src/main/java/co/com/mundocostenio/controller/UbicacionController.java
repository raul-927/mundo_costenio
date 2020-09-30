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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.mundocostenio.domain.Ubicacion;
import co.com.mundocostenio.services.UbicacionService;

@RestController
public class UbicacionController {
	
	@Autowired
	private UbicacionService ubicacionService;
	
	
	@RequestMapping(
			value ="/ubicacion", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insert(@RequestBody @Valid Ubicacion ubicacion, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Ubicacion ubicacionResult = this.ubicacionService.insert(ubicacion);
		
		return new ResponseEntity<Ubicacion>(ubicacionResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/ubicacion", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody @Valid Ubicacion ubicacion, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Ubicacion ubicacionResult = this.ubicacionService.update(ubicacion);
		
		return new ResponseEntity<Ubicacion>(ubicacionResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/ubicacion", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody Ubicacion ubicacion){
		HttpHeaders headers = new HttpHeaders();
		int ubicacionResult = this.ubicacionService.delete(ubicacion.getUbicacionId());
		
		return new ResponseEntity<Integer>(ubicacionResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/ubicacionSearch", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> select(@RequestBody @Valid Ubicacion ubicacion, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		List<Ubicacion> ubicacionResult = this.ubicacionService.select(ubicacion);
		
		return new ResponseEntity<List<Ubicacion>>(ubicacionResult, headers, HttpStatus.OK);
	}
}
