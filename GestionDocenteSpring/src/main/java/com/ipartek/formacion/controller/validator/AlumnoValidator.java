package com.ipartek.formacion.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.service.Util;

public class AlumnoValidator implements Validator {
	private static final Logger LOGGER = LoggerFactory.getLogger(AlumnoValidator.class);
	
	@Override
	public boolean supports(Class<?> paramClass) {
		
		return Alumno.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "form.nombreRequerido", "Tienes que introducir un nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "form.apellidoRequerido", "Tienes que introducir Los apellidos");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "form.emailRequerido", "Tienes que introducir un DNI");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "form.dniRequerido", "Tienes que introducir un email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "form.telefonoRequerido", "Tienes que introducir un telefono");
		
		Alumno alum = (Alumno) obj;
		if(alum.getCodigo() < Alumno.CODIGO_NULO){
			errors.reject("codigo", new Object[] { "'codigo'" }, "no puede ser menor que "+Alumno.CODIGO_NULO);
		}
		
		if(alum.getNombre().length() < 3 || alum.getNombre().length() > 50){
			errors.rejectValue("nombre", "form.longitudNombreIncorrecta", new Object[] {"'nombre'"}, "Tamaño del nombre incorrecto");
		} 
		
		if(alum.getApellidos().length() < 7 || alum.getApellidos().length() > 250){
			errors.rejectValue("apellidos","form.apellidoRequerido", new Object[] {"'apellidos'"}, "Tamaño de los apellidos incorrecto");
		} 
		
		
		if(alum.getEmail().length() > 250){
			errors.rejectValue("email", "form.longitudDireccionIncorrecta", new Object[] {"'email'"}, "Tamaño del identificador incorrecto");
		}
		
		if(alum.getTelefono().length() != 9){
			errors.rejectValue("telefono", "form.telefonoIncorrecto", new Object[] {"'telefono'"}, "Tamaño del telefono incorrecto");
		}
		
		if(Util.validarDni(alum.getDni())) { //validacion de la letra del DNI
			errors.rejectValue("dni","form.letraDniIncorrecta", new Object[]{"'dni'"},"el dni es incorrecto tiene que ser 8 numero y letra Mayúscula correcta");
		}
		
	
	}

}