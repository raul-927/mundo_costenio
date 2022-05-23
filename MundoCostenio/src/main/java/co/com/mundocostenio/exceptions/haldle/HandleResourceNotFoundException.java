package co.com.mundocostenio.exceptions.haldle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.com.mundocostenio.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class HandleResourceNotFoundException {

	@ResponseBody
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<?> handleException(ResourceNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

}
