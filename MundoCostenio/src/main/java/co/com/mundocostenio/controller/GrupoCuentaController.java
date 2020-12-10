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

import co.com.mundocostenio.domain.Departamento;
import co.com.mundocostenio.domain.GrupoCuenta;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.GrupoCuentaService;


@RestController
public class GrupoCuentaController {
	
	@Autowired
	private GrupoCuentaService grupoCuentaService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	
	@RequestMapping(
			value ="/grupoCuenta", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insert(@RequestBody @Valid GrupoCuenta grupoCuenta, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		GrupoCuenta grupoCuentaResult = this.grupoCuentaService.insert(grupoCuenta);
		return new ResponseEntity<GrupoCuenta>(grupoCuentaResult, headers, HttpStatus.OK);
	}
	
	private void verificarGrupoCuenta(GrupoCuenta grupoCuenta) {
		List<GrupoCuenta> grupoCuentaResult = this.grupoCuentaService.select(grupoCuenta);
		if(grupoCuentaResult.size() == 0) {
			if(grupoCuenta.getGrupoCuentaId()!= null || grupoCuenta.getId() != null) {
				if(grupoCuenta.getGrupoCuentaId()!= null && grupoCuenta.getGrupoCuentaId() > 0) {
					throw new ResourceNotFoundException("Grupo Cuenta con id: " +grupoCuenta.getGrupoCuentaId()+"  no encontrado");
				}
				else {
					throw new ResourceNotFoundException("Grupo Cuenta no encontrado");
				}
			}
			else {
				throw new ResourceNotFoundException("No existen registros en la tabla grupo_cuenta");
			}
		}
	}

}