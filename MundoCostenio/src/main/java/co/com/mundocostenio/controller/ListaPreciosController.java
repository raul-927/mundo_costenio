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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.mundocostenio.domain.Barrio;
import co.com.mundocostenio.domain.ListaPrecios;
import co.com.mundocostenio.domain.Producto;
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
	
	
	@RequestMapping(
			value ="/listaPrecios", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insertListaPrecios(@RequestBody @Valid ListaPrecios listaPrecios, 
												BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		ListaPrecios listaPreciosResult = this.listaPreciosService.insert(listaPrecios);
		return new ResponseEntity<ListaPrecios>(listaPreciosResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/listaPreciosSearch", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectListaPrecios(@RequestBody ListaPrecios listaPrecios) throws ResourceNotFoundException{ //@PathVariable int id
		HttpHeaders headers = new HttpHeaders();
		this.verificarListaPrecios(listaPrecios);
		List<ListaPrecios> listaPreciosResult = this.listaPreciosService.selectListaPrecios(listaPrecios);
		return new ResponseEntity<List<ListaPrecios>>(listaPreciosResult, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/listaPreciosSearch", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectActualListaPrecios(){
		HttpHeaders headers = new HttpHeaders();
		ListaPrecios listaPreciosResult = this.listaPreciosService.selectActualListaPrecios();
		return new ResponseEntity<ListaPrecios>(listaPreciosResult, headers, HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value ="/nuevoProducto", method =RequestMethod.GET,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectNuevoProducto(){
		HttpHeaders headers = new HttpHeaders();
		List<Producto> productosResult = this.listaPreciosService.selectNuevoProducto();
		return new ResponseEntity<List<Producto>>(productosResult, headers, HttpStatus.OK);
	}
	
	private void verificarListaPrecios(ListaPrecios listaPrecios) throws ResourceNotFoundException{
		String message = "";
		List<ListaPrecios> listaPreciosResult = this.listaPreciosService.selectListaPrecios(listaPrecios);
		if(listaPreciosResult.size() == 0) {
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
				message = "No existen registros en la tabla lista_precios";
				throw new ResourceNotFoundException(message);
			}
		}
	}
}