package co.com.mundocostenio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.mundocostenio.domain.Cuenta;
import co.com.mundocostenio.exceptions.BindingResultException;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.CuentaService;


@RestController
@CrossOrigin(origins = "*")
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
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.BAD_REQUEST);
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
		if(cuenta.getCuentaId() == null || cuenta.getCuentaId() ==0) {
			throw new BindingResultException("cuentaId no debe ser null o cero");
		}
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
		if(cuenta.getCuentaId() == null || cuenta.getCuentaId() ==0) {
			throw new BindingResultException("cuentaId no debe ser null o cero");
		}
		this.cuentaService.delete(cuenta);
		
		return new ResponseEntity<Cuenta>(cuenta, headers, HttpStatus.OK);
	}
	
	
	@RequestMapping(
			value ="/cuentas", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> select(@RequestBody Cuenta cuenta){ 
		HttpHeaders headers = new HttpHeaders();
		verificarCuenta(cuenta);
		List<Cuenta> cuentaResult = this.cuentaService.select(cuenta);
		
		return new ResponseEntity<List<Cuenta>>(cuentaResult, headers, HttpStatus.OK);
	}
	
	
	private void verificarCuenta(Cuenta cuenta) throws ResourceNotFoundException{
		String message ="";
		List<Cuenta> cuentaResult = this.cuentaService.select(cuenta);
		if(cuentaResult.size() == 0) {
			if(cuenta.getCuentaId()!= null || cuenta.getId() != null) {
				if(cuenta.getCuentaId()!= null && cuenta.getCuentaId() > 0) {
					message = "Cuenta con id: " +cuenta.getCuentaId()+"  no encontrada";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Cuenta no encontrada";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message ="No existen registros en la tabla cuenta";
				throw new ResourceNotFoundException(message);
			}
		}
	}
}
