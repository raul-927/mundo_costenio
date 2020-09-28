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

import co.com.mundocostenio.domain.TipoProducto;
import co.com.mundocostenio.services.TipoProductoService;

@RestController
public class TipoProductoController {
	
	@Autowired
	private TipoProductoService tipoProductoService;
	
	
	@RequestMapping(
			value ="/tipoProducto", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insert(@RequestBody @Valid TipoProducto tipoProducto, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.NOT_ACCEPTABLE);
		}
		TipoProducto result = this.tipoProductoService.insert(tipoProducto);
		
		return new ResponseEntity<TipoProducto>(result, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/tipoProducto", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody @Valid TipoProducto tipoProducto, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.NOT_ACCEPTABLE);
		}
		TipoProducto result = this.tipoProductoService.update(tipoProducto);
		
		return new ResponseEntity<TipoProducto>(result, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/tipoProducto/{tipProdId}", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable int tipProdId){
		HttpHeaders headers = new HttpHeaders();
		int result = this.tipoProductoService.delete(tipProdId);
		
		return new ResponseEntity<Integer>(result, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/tipoProductoSearch", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectTipoProducto(@RequestBody @Valid TipoProducto tipoProducto, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.NOT_ACCEPTABLE);
		}
		TipoProducto result = this.tipoProductoService.selectTipoProducto(tipoProducto);
		
		return new ResponseEntity<TipoProducto>(result, headers, HttpStatus.OK);
	}

}
