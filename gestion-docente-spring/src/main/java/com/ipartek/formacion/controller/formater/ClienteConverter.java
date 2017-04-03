package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.clientes.ClienteServiceRemote;
import com.ipartek.formacion.persistence.Cliente;



public class ClienteConverter implements Converter<String, Cliente> {
	@Autowired
	 ClienteServiceRemote clS;
	 private static final Logger LOGGER = LoggerFactory.getLogger(ClienteConverter.class);
	 
	
	@Override
	public Cliente convert(String arg0) {
		LOGGER.info(arg0.toString());
		return clS.getById(Long.parseLong((String) arg0));
	}

}
