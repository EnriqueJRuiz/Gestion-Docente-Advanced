package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.service.Util;

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
		
		if(alum.getNombre().length() < 3 || alum.getNombre().length() > 50){
			errors.rejectValue("nombre", null, new Object[] {"'nombre'"}, "Tamaño del nombre incorrecto");
		} 
		
		if(alum.getApellidos().length() > 250){
			errors.rejectValue("apellidos", null, new Object[] {"'apellidos'"}, "Tamaño de los apellidos incorrecto");
		} 
		
		
		if(alum.getEmail().length() > 100){
			errors.rejectValue("email", null, new Object[] {"'email'"}, "Tamaño del identificador incorrecto");
		}
		
		if(alum.getTelefono().length() != 9){
			errors.rejectValue("telefono", null, new Object[] {"'telefono'"}, "Tamaño del telefono incorrecto");
		}
		
			if(Util.validarDni(alum.getDni())) { //validacion de la letra del DNI
				errors.rejectValue("dni","letraDniIncorrecta", new Object[]{"'dni'"},"el dni es incorrecto tiene que ser 8 numero y letra Mayúscula correcta");
			}
		
	}

}