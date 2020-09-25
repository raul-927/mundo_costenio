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

import co.com.mundocostenio.domain.Producto;
import co.com.mundocostenio.services.ProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@RequestMapping(
			value ="/producto", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insertProducto(@RequestBody @Valid Producto producto, BindingResult bindingResult) {
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<List<FieldError>>(bindingResult.getFieldErrors(), headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Producto productoResult = this.productoService.insert(producto);
		
		return new ResponseEntity<Producto>(productoResult, headers, HttpStatus.OK);
	}

}
