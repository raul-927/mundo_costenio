package co.com.mundocostenio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.mundocostenio.domain.Ubicacion;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.UbicacionService;

@RestController
public class UbicacionController {
	
	@Autowired
	private UbicacionService ubicacionService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	@RequestMapping(
			value ="/ubicacion", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insert(@RequestBody @Valid Ubicacion ubicacion, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Ubicacion ubicacionResult = this.ubicacionService.insert(ubicacion);
		
		return new ResponseEntity<Ubicacion>(ubicacionResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/ubicacion", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Ubicacion ubicacion) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		verificar(ubicacion);
		Ubicacion ubicacionResult = this.ubicacionService.update(ubicacion);
		
		return new ResponseEntity<Ubicacion>(ubicacionResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/ubicacion", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody Ubicacion ubicacion) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		verificar(ubicacion);
		this.ubicacionService.delete(ubicacion);
		
		return new ResponseEntity<Ubicacion>(ubicacion, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/ubicacionSearch", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> select(@RequestBody Ubicacion ubicacion) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		verificar(ubicacion);
		List<Ubicacion> ubicacionResult = this.ubicacionService.select(ubicacion);
		
		return new ResponseEntity<List<Ubicacion>>(ubicacionResult, headers, HttpStatus.OK);
	}
	
	private void verificar(Ubicacion ubicacion) throws ResourceNotFoundException{
		String message ="";
		List<Ubicacion> ubicacionResult = this.ubicacionService.select(ubicacion);
		if(ubicacionResult.size() == 0) {
			if(ubicacion.getUbicacionId()!= null || ubicacion.getNroPuerta()!=null || ubicacion.getGeoLocalizacion()!=null) {
				if(ubicacion.getUbicacionId()!= null && ubicacion.getUbicacionId() > 0) {
					message = "Ubicacion con id: " +ubicacion.getUbicacionId()+"  no encontrada";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Ubicacion no encontrada";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "No existen registros en la tabla ubicacion";
				throw new ResourceNotFoundException(message);
			}
		}
	}
}
