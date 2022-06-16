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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.mundocostenio.domain.GrupoCuenta;
import co.com.mundocostenio.exceptions.BindingResultException;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.GrupoCuentaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@Api(value = "/grupoCuenta", description="End point para trabajar con los grupos de cuenta")
public class GrupoCuentaController {
	
	@Autowired
	private GrupoCuentaService grupoCuentaService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	@ApiOperation(value = "Ingresa nuevo grupo de cuenta",
		    response = GrupoCuenta.class)
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
	
	@RequestMapping(
			value ="/grupoCuenta", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody GrupoCuenta grupoCuenta){
		HttpHeaders headers = new HttpHeaders();
		this.verificarGrupoCuenta(grupoCuenta);
		if(grupoCuenta.getGrupoCuentaId() ==null || grupoCuenta.getGrupoCuentaId() ==0) {
			throw new BindingResultException("grupoCuentaId no debe ser null o cero");
		}
		GrupoCuenta grupoCuentaResult = this.grupoCuentaService.update(grupoCuenta);
		return new ResponseEntity<GrupoCuenta>(grupoCuentaResult, headers, HttpStatus.OK);
	}
	@RequestMapping(
			value ="/grupoCuenta/{grupoCuentaId}", method =RequestMethod.DELETE,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable int grupoCuentaId) throws ResourceNotFoundException{
		GrupoCuenta gp = new GrupoCuenta();
		gp.setGrupoCuentaId(grupoCuentaId);
		HttpHeaders headers = new HttpHeaders();
		this.verificarGrupoCuenta(gp);
		if(gp.getGrupoCuentaId() ==null || gp.getGrupoCuentaId() ==0) {
			throw new BindingResultException("grupoCuentaId no debe ser null o cero");
		}
		this.grupoCuentaService.delete(gp);
		return new ResponseEntity<GrupoCuenta>(null, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/grupoCuenta", method =RequestMethod.GET,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> select(@RequestBody GrupoCuenta grupoCuenta) throws ResourceNotFoundException{ 
		HttpHeaders headers = new HttpHeaders();
		if(grupoCuenta == null) {
			grupoCuenta = new GrupoCuenta();
		}
		verificarGrupoCuenta(grupoCuenta);
		List<GrupoCuenta> grupoCuentaResult = this.grupoCuentaService.select(grupoCuenta);
		return new ResponseEntity<List<GrupoCuenta>>(grupoCuentaResult, headers, HttpStatus.OK);
	}
	
	private void verificarGrupoCuenta(GrupoCuenta grupoCuenta) throws ResourceNotFoundException {
		String message ="";
		List<GrupoCuenta> grupoCuentaResult = this.grupoCuentaService.select(grupoCuenta);
		if(grupoCuentaResult.size() == 0) {
			if(grupoCuenta.getGrupoCuentaId()!= null || grupoCuenta.getId() != null) {
				if(grupoCuenta.getGrupoCuentaId()!= null && grupoCuenta.getGrupoCuentaId() > 0) {
					message = "GrupoCuenta con id: " +grupoCuenta.getGrupoCuentaId()+"  no encontrada";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "GrupoCuenta no encontrada";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "No existe ningún Grupo de Cuentas registrado";
				throw new ResourceNotFoundException(message);
			}
		}
	}
	
	@RequestMapping(
			value ="/grupoCuentas", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> findAll(){
		HttpHeaders headers = new HttpHeaders();
		List<GrupoCuenta> grupoCuentaResult = this.grupoCuentaService.select(new GrupoCuenta());
		return new ResponseEntity<List<GrupoCuenta>>(grupoCuentaResult, headers, HttpStatus.OK);
	}
}
