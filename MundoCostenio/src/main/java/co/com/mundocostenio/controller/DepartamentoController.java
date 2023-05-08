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

import co.com.mundocostenio.domain.Departamento;
import co.com.mundocostenio.exceptions.BindingResultException;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.DepartamentoService;

@RestController
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	@RequestMapping(
			value ="/departamento", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insert(@RequestBody @Valid Departamento departamento, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Departamento departamentoResult = this.departamentoService.insert(departamento);
		
		return new ResponseEntity<Departamento>(departamentoResult,headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/departamento", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Departamento departamento){
		HttpHeaders headers = new HttpHeaders();
		verificarDepartamento(departamento);
		if(departamento.getDepartamentoId()==null || departamento.getDepartamentoId() ==0) {
			throw new BindingResultException("departamentoId no debe ser null o cero");
		}
		Departamento departamentoResult = this.departamentoService.update(departamento);
		
		return new ResponseEntity<Departamento>(departamentoResult,headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/departamento", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody Departamento departamento){
		HttpHeaders headers = new HttpHeaders();
		verificarDepartamento(departamento);
		if(departamento.getDepartamentoId()==null || departamento.getDepartamentoId() ==0) {
			throw new BindingResultException("departamentoId no debe ser null o cero");
		}
		this.departamentoService.delete(departamento);
		
		return new ResponseEntity<Departamento>(null,headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/departamentos", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> select(@RequestBody Departamento departamento){
		HttpHeaders headers = new HttpHeaders();
		verificarDepartamento(departamento);
		List<Departamento> departamentoResult = this.departamentoService.select(departamento);
		
		return new ResponseEntity<List<Departamento>>(departamentoResult,headers, HttpStatus.OK);
	}
	
	private void verificarDepartamento(Departamento departamento) throws ResourceNotFoundException{
		String message ="";
		List<Departamento> departamentoResult = this.departamentoService.select(departamento);
		if(departamentoResult.isEmpty()) {
			if(departamento.getDepartamentoId()!= null || departamento.getId() != null || departamento.getNombreDepartamento()!=null) {
				if(departamento.getDepartamentoId()!= null && departamento.getDepartamentoId() > 0) {
					message = "Departamento con id: " +departamento.getDepartamentoId()+"  no encontrado";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Departamento no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "DEPARTAMENTO: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}
}
