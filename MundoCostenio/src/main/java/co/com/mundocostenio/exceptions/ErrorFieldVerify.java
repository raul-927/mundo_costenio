package co.com.mundocostenio.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

@Component
public class ErrorFieldVerify {
	
	
	public List<ErrorField> verificarCamposVacios(List<FieldError> fieldErrorList){
		List<ErrorField> fieldErrorListResult = new ArrayList<>();
			for(FieldError fieldError: fieldErrorList) {
				ErrorField errorField = new ErrorField();
				errorField.setDefaultMessage(fieldError.getDefaultMessage());
				errorField.setField(fieldError.getField());
				fieldErrorListResult.add(errorField);
			}
		return fieldErrorListResult;
	}
}
