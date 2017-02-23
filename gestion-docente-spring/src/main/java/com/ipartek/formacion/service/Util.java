package com.ipartek.formacion.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Util {
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
	
	public static boolean validarDni(String dni) {
		boolean incorrecto=true;
		
			String cadenaVerificacion ="TRWAGMYFPDXBNJZSQVHLCKE";
			try {
				String cadenaCaracter = dni.substring(0, dni.length()-1);
				int nCadena= Integer.parseInt(cadenaCaracter);
				
				
				char letraValidacion = cadenaVerificacion.charAt(nCadena % 23);
				
				/* esto es igual que lo anterior
				int posicion = nCadena%23;
				int cadenaSobrante = 23 - posicion - 1;
				String letraValidacion = cadenaVerificacion.substring(posicion,cadenaVerificacion.length()-cadenaSobrante);
				*/
				
				
					if (letraValidacion == dni.charAt(dni.length()-1)){
					incorrecto=false;
				}
			} catch (Exception e) {
				LOGGER.info(e.getMessage());
				incorrecto = true;
	}
			
		
		return incorrecto;
	}
}
