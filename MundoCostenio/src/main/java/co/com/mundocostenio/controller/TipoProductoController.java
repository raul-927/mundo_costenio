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

import co.com.mundocostenio.domain.model.TipoProducto;
import co.com.mundocostenio.exceptions.BindingResultException;
import co.com.mundocostenio.exceptions.ErrorField;
import co.com.mundocostenio.exceptions.ErrorFieldVerify;
import co.com.mundocostenio.exceptions.ResourceNotFoundException;
import co.com.mundocostenio.services.TipoProductoService;

@RestController
@CrossOrigin(origins = "*")
public class TipoProductoController {
	
	@Autowired
	private TipoProductoService tipoProductoService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	
	@RequestMapping(
			value ="/tipoProducto", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> insert(@RequestBody @Valid TipoProducto tipoProducto, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		TipoProducto result = this.tipoProductoService.insert(tipoProducto);
		
		return new ResponseEntity<TipoProducto>(result, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/tipoProducto", method =RequestMethod.PUT,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody TipoProducto tipoProducto){
		HttpHeaders headers = new HttpHeaders();
		this.verificarTipoProducto(tipoProducto);
		if(tipoProducto.getTipProdId() == null || tipoProducto.getTipProdId() ==0) {
			throw new  BindingResultException("tipProdId no debe ser null o cero");
		}
		TipoProducto result = this.tipoProductoService.update(tipoProducto);
		
		return new ResponseEntity<TipoProducto>(result, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/tipoProducto", method =RequestMethod.DELETE,
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody TipoProducto tipoProducto){
		HttpHeaders headers = new HttpHeaders();
		this.verificarTipoProducto(tipoProducto);
		if(tipoProducto.getTipProdId() == null || tipoProducto.getTipProdId() ==0) {
			throw new  BindingResultException("tipProdId no debe ser null o cero");
		}
		int result = this.tipoProductoService.delete(tipoProducto.getTipProdId());
		
		return new ResponseEntity<Integer>(result, headers, HttpStatus.OK);
	}
	
	@RequestMapping(
			value ="/tipoProductos", method =RequestMethod.POST,
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectTipoProducto(@RequestBody TipoProducto tipoProducto) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		this.verificarTipoProducto(tipoProducto);
		List<TipoProducto> result = this.tipoProductoService.selectTipoProducto(tipoProducto);
		
		return new ResponseEntity<List<TipoProducto>>(result, headers, HttpStatus.OK);
	}
	
	private void verificarTipoProducto(TipoProducto tipoProducto) throws ResourceNotFoundException{
		String message ="";
		List<TipoProducto> tipoProductoResult = this.tipoProductoService.selectTipoProducto(tipoProducto);
		if(tipoProductoResult.isEmpty()) {
			if(tipoProducto.getTipProdId()!= null || tipoProducto.getId() != null || tipoProducto.getDescTipoProducto()!=null) {
				if(tipoProducto.getTipProdId()!= null && tipoProducto.getTipProdId() > 0) {
					message = "TipoProducto con id: " +tipoProducto.getTipProdId()+"  no encontrado";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "TipoProducto no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "TIPO PRODUCTO: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}

}
