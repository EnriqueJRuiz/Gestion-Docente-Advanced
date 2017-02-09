package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dbms.persistence.Cliente;

public class ClienteValidator implements Validator{

	@Override
	public boolean supports(Class<?> paramClass) {	
		return Cliente.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "505", "Tienes que introducir un nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "507", "Tienes que introducir un DNI o NIF");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "508", "Tienes que introducir un email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "509", "Tienes que introducir un teléfono");
		
		
		Cliente clien = (Cliente) obj;
		if(clien.getCodigo() < Cliente.CODIGO_NULO){
			errors.reject("codigo", new Object[] {"'codigo'"}, "no puede ser menor que "+Cliente.CODIGO_NULO);
		}
		
	}

}
