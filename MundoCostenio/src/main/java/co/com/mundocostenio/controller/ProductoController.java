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

import co.com.mundocostenio.domain.Producto;
import co.com.mundocostenio.exceptions.BindingResultException;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.ProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	@RequestMapping(
			value ="/producto", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insert(@RequestBody @Valid Producto producto, BindingResult bindingResult) {
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.NOT_ACCEPTABLE);
		}
		
		Producto productoResult = this.productoService.insert(producto);
		
		return new ResponseEntity<Producto>(productoResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/producto", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Producto producto){
		HttpHeaders headers = new HttpHeaders();
		this.verificarProducto(producto);
		if(producto.getProdId() ==null || producto.getProdId() == 0) {
			throw new BindingResultException("prodId no debe ser null o cero");
		}
		Producto productoResult = this.productoService.update(producto);
		
		return new ResponseEntity<Producto>(productoResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/producto", method =RequestMethod.DELETE,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody Producto producto){
		HttpHeaders headers = new HttpHeaders();
		this.verificarProducto(producto);
		if(producto.getProdId() ==null || producto.getProdId() == 0) {
			throw new BindingResultException("prodId no debe ser null o cero");
		}
		int result = this.productoService.delete(producto);
		
		return new ResponseEntity<Integer>(result, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/productos", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> select(@RequestBody Producto producto) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		verificarProducto(producto);
		
		List<Producto> productoResult = this.productoService.selectProducto(producto);
		return new ResponseEntity<List<Producto>>(productoResult, headers, HttpStatus.OK);
	}
	
	protected void verificarProducto(Producto producto) throws ResourceNotFoundException{
		String message ="";
		List<Producto>productoResult = this.productoService.selectProducto(producto);
		if(productoResult.size() == 0) {
			if(producto.getProdId()!= null || producto.getId() != null || producto.getNombre()!=null) {
				if(producto.getProdId()!= null && producto.getProdId() > 0) {
					message = "Producto con id: " +producto.getProdId()+"  no encontrado";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Producto no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "No existe ningún Producto registrado";
				throw new ResourceNotFoundException(message);
			}
		}
	}

}
