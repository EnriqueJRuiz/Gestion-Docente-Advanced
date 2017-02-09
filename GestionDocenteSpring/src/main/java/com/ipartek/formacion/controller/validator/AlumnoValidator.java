package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dbms.persistence.Alumno;

public class AlumnoValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		
		return Alumno.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "505", "Tienes que introducir un nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "506", "Tienes que introducir Los apellidos");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "507", "Tienes que introducir un DNI");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "508", "Tienes que introducir un email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "509", "Tienes que introducir un telefono");
		
		Alumno alum = (Alumno) obj;
		if(alum.getCodigo() < Alumno.CODIGO_NULO){
			errors.reject("codigo", new Object[] { "'codigo'" }, "no puede ser menor que "+Alumno.CODIGO_NULO);
		}
		
		if(false) { //validacion de la letra del DNI
			errors.rejectValue("dni","letraDniIncorrecta", new Object[]{"'dni'"},"el dni es incorrecto");
		}
	}

}
