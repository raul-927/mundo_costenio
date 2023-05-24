package co.com.mundocostenio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import co.com.mundocostenio.domain.model.ListaPrecios;
import co.com.mundocostenio.domain.model.Producto;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.ListaPreciosService;

@RestController
public class ListaPreciosController {
	
	@Autowired
	private ListaPreciosService listaPreciosService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	
	@PostMapping(
            value = "/listaPrecios",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insertListaPrecios(@RequestBody @Valid ListaPrecios listaPrecios, 
												BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(listaPrecios == null) {
			System.out.println("ES NULL");
		}else {
			System.out.println("NO ES NULL");
		}
		ListaPrecios listaPreciosResult = this.listaPreciosService.insert(listaPrecios);
		return new ResponseEntity<ListaPrecios>(listaPreciosResult, headers, HttpStatus.OK);
	}
	
	@PostMapping(
            value = "/listaPreciosSearch",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectListaPrecios(@RequestBody ListaPrecios listaPrecios){ //@PathVariable int id
		HttpHeaders headers = new HttpHeaders();
		this.verificarListaPrecios(listaPrecios);
		List<ListaPrecios> listaPreciosResult = this.listaPreciosService.selectListaPrecios(listaPrecios);
		return new ResponseEntity<List<ListaPrecios>>(listaPreciosResult, headers, HttpStatus.OK);
	}
	
	@GetMapping(
            value = "/listaPreciosSearch",
            produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectActualListaPrecios(){
		HttpHeaders headers = new HttpHeaders();
		this.verificarListaPrecios(new ListaPrecios());
		ListaPrecios listaPreciosResult = this.listaPreciosService.selectActualListaPrecios();
		return new ResponseEntity<ListaPrecios>(listaPreciosResult, headers, HttpStatus.OK);
		
	}
	
	@GetMapping(
            value = "/nuevoProducto",
            produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectNuevoProducto(){
		HttpHeaders headers = new HttpHeaders();
		verificarListaPrecios(new ListaPrecios());
		List<Producto> productosResult = this.listaPreciosService.selectNuevoProducto();
		return new ResponseEntity<List<Producto>>(productosResult, headers, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/insertProductoListaActual")
	public ResponseEntity<?> insertProductoListaActual(@RequestBody Producto producto){
		HttpHeaders headers = new HttpHeaders();
		verificarListaPrecios(new ListaPrecios());
		//this.listaPreciosService.u
		return new ResponseEntity<>(null, headers, HttpStatus.OK);
		
	}
	
	private void verificarListaPrecios(ListaPrecios listaPrecios) throws ResourceNotFoundException{
		String message = "";
		List<ListaPrecios> listaPreciosResult = this.listaPreciosService.selectListaPrecios(listaPrecios);
		if(listaPreciosResult.isEmpty()) {
			if(listaPrecios.getListaPrecioId()!= null || listaPrecios.getId() != null || listaPrecios.getDescripcionLista()!=null) {
				if(listaPrecios.getListaPrecioId()!= null && listaPrecios.getListaPrecioId() > 0) {
					message = "ListaPrecios con id: " +listaPrecios.getListaPrecioId()+"  no encontrado";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "ListaPrecios no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "LISTA PRECIO: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}
}