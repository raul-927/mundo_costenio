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

import co.com.mundocostenio.domain.Impuesto;
import co.com.mundocostenio.exceptions.BindingResultException;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.ImpuestoService;


@RestController
public class ImpuestoController {
	
	@Autowired
	private ImpuestoService impuestoService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	
	@RequestMapping(
			value ="/impuesto", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>insert(@RequestBody @Valid Impuesto impuesto, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Impuesto impuestoResult = this.impuestoService.insert(impuesto);
		
		return new ResponseEntity<Impuesto>(impuestoResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/impuesto", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>update(@RequestBody Impuesto impuesto){
		HttpHeaders headers = new HttpHeaders();
		verificarImpuesto(impuesto);
		if(impuesto.getImpuestoId() ==null || impuesto.getImpuestoId() ==0) {
			throw new BindingResultException("impuestoId no debe ser null o cero");
		}
		Impuesto impuestoResult = this.impuestoService.update(impuesto);
		
		return new ResponseEntity<Impuesto>(impuestoResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/impuesto", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>delete(@RequestBody Impuesto impuesto){
		HttpHeaders headers = new HttpHeaders();
		verificarImpuesto(impuesto);
		if(impuesto.getImpuestoId() ==null || impuesto.getImpuestoId() ==0) {
			throw new BindingResultException("impuestoId no debe ser null o cero");
		}
		this.impuestoService.delete(impuesto);
		
		return new ResponseEntity<Impuesto>(impuesto, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/impuestos", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?>select(@RequestBody Impuesto impuesto){
		HttpHeaders headers = new HttpHeaders();
		verificarImpuesto(impuesto);
		List<Impuesto> impuestoList = this.impuestoService.select(impuesto);
		
		return new ResponseEntity<List<Impuesto>>(impuestoList, headers, HttpStatus.OK);
	}
	
	private void verificarImpuesto(Impuesto impuesto) throws ResourceNotFoundException{
		String message = "";
		List<Impuesto> impuestoResult = this.impuestoService.select(impuesto);
		if(impuestoResult == null || impuestoResult.size() ==0) {
			if(impuesto.getImpuestoId()!= null || impuesto.getId() != null) {
				if(impuesto.getImpuestoId()!= null && impuesto.getImpuestoId() > 0) {
					message = "Impuesto con id: " +impuesto.getImpuestoId()+"  no encontrado";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Impuesto no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "No existen registros en la tabla impuesto";
				throw new ResourceNotFoundException(message);
			}
		}
	}
}
