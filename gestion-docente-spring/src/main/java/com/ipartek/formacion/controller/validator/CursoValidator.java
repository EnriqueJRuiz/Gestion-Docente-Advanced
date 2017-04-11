package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ipartek.formacion.persistence.Curso;

public class CursoValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {

		return Curso.class.equals(paramClass);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {

	}

}