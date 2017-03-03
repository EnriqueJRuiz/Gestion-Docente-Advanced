package com.ipartek.formacion.controller.validator;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.service.Util;
import com.ipartek.formacion.service.interfaces.AlumnoService;

public class AlumnoValidator implements Validator {
	
	@Inject
	AlumnoService aS;
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
		
		LOGGER.info("pasas por la validacion");
		
		Alumno alum = (Alumno) obj;
		if(alum.getCodigo() < Alumno.CODIGO_NULO){
			errors.reject("codigo", new Object[] { "'codigo'" }, "no puede ser menor que "+Alumno.CODIGO_NULO);
		}
		
		if(alum.getNombre().length() < 3 || alum.getNombre().length() > 50){
			errors.rejectValue("nombre", "form.longitudNombreIncorrecta", new Object[] {"'nombre'"}, "· Tamaño del nombre minimo de 3 caracteres y maximo de 50");
		} 
		
		if(alum.getApellidos().length() < 7 || alum.getApellidos().length() > 250){
			errors.rejectValue("apellidos","form.longitudapellidoIncorrecta", new Object[] {"'apellidos'"}, "Tamaño de los apellidos minimo de 7 caracteres y maximo de 150");
		} 
		
		
		if( alum.getEmail().length() > 150){
			errors.rejectValue("email", "form.longitudDireccionIncorrecta", new Object[] {"'email'"}, "Tamaño del EMAIL No puede ser de mas de 250 caracteres");
		}
		
		if(alum.getTelefono().length() != 9){
			errors.rejectValue("telefono", "form.telefonoIncorrecto", new Object[] {"'telefono'"}, "Tamaño del telefono es de 9 digitos");
		}
		
		if(Util.validarDni(alum.getDni())) { //validacion de la letra del DNI
			errors.rejectValue("dni","form.letraDniIncorrecta", new Object[]{"'dni'"},"el dni es incorrecto tiene que ser 8 numero y letra Mayúscula correcta");
		}else{ 
			Alumno alumComprobar = aS.comprobarDni(alum.getDni());
			if(alumComprobar != null){
				if(alum.getCodigo() == Alumno.CODIGO_NULO || (!alum.equals(alumComprobar) && alum.getDni().equalsIgnoreCase(alumComprobar.getDni()))){
						errors.rejectValue("dni","form.letraDniIncorrecta", new Object[]{"'dni'"},"el dni es incorrecto, ya esta almacenado");
				}
			}
		}
		
		
		if( alum.getDireccion().length() > 250){
			errors.rejectValue("direccion", "form.longitudDireccionIncorrecta", new Object[] {"'direccion'"}, "Tamaño de la Direccion No puede ser de mas de 250 caracteres");
		}
		
		if( alum.getPoblacion().length() > 150){
			errors.rejectValue("poblacion", "form.longitudPoblacionIncorrecta", new Object[] {"'poblacion'"}, "Tamaño de  la Poblacion No puede ser de mas de 150 caracteres");
		}
		
		if( alum.getCodigoPostal() > 50000){
			errors.rejectValue("codigoPostal", "form.longitudCodigoPostalIncorrecta", new Object[] {"'codigoPostal'"}, "El Codigo Postal en España es un número menos a 50000");
		}
		
		if( alum.getnHermanos() > 99){
			errors.rejectValue("nHermanos", "form.longitudnHermanosIncorrecta", new Object[] {"'nHermanos'"}, "Tamaño maximo de hermanos es de 99");
		}
		
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(new Date());
			int anyo18ago = gc.get(GregorianCalendar.YEAR) - 18;// 1999
			gc.set(GregorianCalendar.YEAR, anyo18ago);
			if (gc.getTime().before(alum.getfNacimiento())) {
				errors.rejectValue("fNacimiento", "form.longitudnfNacimientoIncorrecta", new Object[] {"'fNacimiento'"}, "No se puede tener menos de 18 años");
			}
	}
}