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

import co.com.mundocostenio.domain.Cuenta;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.CuentaService;


@RestController
public class CuentaController {
	
	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	
	@RequestMapping(
			value ="/cuenta", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insert(@RequestBody @Valid Cuenta cuenta, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Cuenta cuentaResult = this.cuentaService.insert(cuenta);
		
		return new ResponseEntity<Cuenta>(cuentaResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/cuenta", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Cuenta cuenta){
		HttpHeaders headers = new HttpHeaders();
		verificarCuenta(cuenta);
		Cuenta cuentaResult = this.cuentaService.update(cuenta);
		
		return new ResponseEntity<Cuenta>(cuentaResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/cuenta", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody Cuenta cuenta){
		HttpHeaders headers = new HttpHeaders();
		verificarCuenta(cuenta);
		this.cuentaService.delete(cuenta);
		
		return new ResponseEntity<Cuenta>(cuenta, headers, HttpStatus.OK);
	}
	
	
	private void verificarCuenta(Cuenta cuenta) {
		List<Cuenta> cuentaResult = this.cuentaService.select(cuenta);
		if(cuentaResult.size() == 0) {
			if(cuenta.getCuentaId()!= null || cuenta.getId() != null) {
				if(cuenta.getCuentaId()!= null && cuenta.getCuentaId() > 0) {
					throw new ResourceNotFoundException("Cuenta con id: " +cuenta.getCuentaId()+"  no encontrada");
				}
				else {
					throw new ResourceNotFoundException("Cuenta no encontrada");
				}
			}
			else {
				throw new ResourceNotFoundException("No existen registros en la tabla cuenta");
			}
		}
	}
}
