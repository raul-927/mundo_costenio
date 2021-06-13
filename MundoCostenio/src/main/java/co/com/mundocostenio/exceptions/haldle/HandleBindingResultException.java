package co.com.mundocostenio.exceptions.haldle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.com.mundocostenio.exceptions.BindingResultException;

@RestControllerAdvice
public class HandleBindingResultException {
	
	@ResponseBody
	@ExceptionHandler(value = BindingResultException.class)
	public ResponseEntity<?> handleException(BindingResultException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

}
