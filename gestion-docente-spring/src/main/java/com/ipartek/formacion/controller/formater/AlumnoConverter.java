package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.alumno.AlumnoServiceRemote;
import com.ipartek.formacion.persistence.Alumno;

public class AlumnoConverter implements Converter<String,Alumno>{

	@Autowired
	 AlumnoServiceRemote aS;
	 private static final Logger LOGGER = LoggerFactory.getLogger(AlumnoConverter.class);	

	@Override
	public Alumno convert(String arg0) {
		LOGGER.info(arg0.toString());
		return aS.getById(Long.parseLong((String) arg0));
	}
	

}
