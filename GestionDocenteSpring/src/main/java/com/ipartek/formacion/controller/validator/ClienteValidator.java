package com.ipartek.formacion.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.controller.ClienteController;
import com.ipartek.formacion.dbms.persistence.Cliente;

public class ClienteValidator implements Validator{
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteValidator.class);
	@Override
	public boolean supports(Class<?> paramClass) {	
		
		return Cliente.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "form.nombreRequerido", "Tienes que introducir un nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "identificador", "form.indentificadorRequerido", "Tienes que introducir un DNI o NIF");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "form.emailRequerido", "Tienes que introducir un email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "form.telefonoRequerido", "Tienes que introducir un teléfono");
		LOGGER.info("pàsa");
		
		Cliente clien = (Cliente) obj;
		
		if(clien.getCodigo() < Cliente.CODIGO_NULO){
			errors.reject("codigo", new Object[] {"'codigo'"}, "no puede ser menor que "+Cliente.CODIGO_NULO);
		}
		
		if(clien.getNombre().length() < 3 || clien.getNombre().length() > 50){
			errors.rejectValue("nombre", "form.longitudNombreIncorrecta", new Object[] {"'nombre'"}, "Tamaño del nombre incorrecto");
		} 
		
		if(clien.getEmail().length() > 250){
			errors.rejectValue("email", "form.longitudDireccionIncorrecta", new Object[] {"'email'"}, "Tamaño del identificador incorrecto");
		}
		
		if(clien.getTelefono().length() != 9){
			errors.rejectValue("telefono", "form.telefonoIncorrecto", new Object[] {"'telefono'"}, "Tamaño del telefono incorrecto");
		}
		
		
		
	}

}
