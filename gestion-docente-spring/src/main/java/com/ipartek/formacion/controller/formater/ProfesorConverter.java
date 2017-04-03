package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.persistence.Profesor;
import com.ipartek.formacion.profesor.ProfesorServiceRemote;

public class ProfesorConverter implements Converter<String, Profesor> {
	@Autowired
	 ProfesorServiceRemote pS;
	 private static final Logger LOGGER = LoggerFactory.getLogger(ProfesorConverter.class);
	 
	
	@Override
	public Profesor convert(String arg0) {
		LOGGER.info(arg0.toString());
		return pS.getById(Long.parseLong((String) arg0));
	}

}
