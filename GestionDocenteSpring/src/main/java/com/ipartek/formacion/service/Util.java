package com.ipartek.formacion.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipartek.formacion.controller.ClienteController;

public class Util {
	private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	public static boolean validarDni(String dni) {
		boolean incorrecto=false;
		if(dni.length()==9){
			String ultimoCaracter = dni.substring(dni.length()-1);
			String cadenaCaracter = dni.substring(0, dni.length()-1);
			String cadenaVerificacion ="TRWAGMYFPDXBNJZSQVHLCKE";
			int nCadena= Integer.parseInt(cadenaCaracter);
			int resultado = nCadena%23;
			int posicion = 23 - resultado;
			String letraValidacion = cadenaVerificacion.substring(resultado,cadenaVerificacion.length()-(posicion-1));
			logger.info("el resultado es = "+ letraValidacion + " la letra es: " + ultimoCaracter);
				if (!letraValidacion.equals(ultimoCaracter)) {
				incorrecto=true;
			}
		}
		return incorrecto;
	}
}
