package com.ipartek.formacion.dbms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ipartek.formacion.dbms.persistence.Cliente;
import com.ipartek.formacion.persistence.Curso;

public class ClienteExtractor implements ResultSetExtractor<Map<Integer, Cliente>> {
	private final static Logger LOGGER = LoggerFactory.getLogger(ClienteExtractor.class);

	@Override
	public Map<Integer, Cliente> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
	
		while (rs.next()) {
			
			int codigo = rs.getInt("codigo");
			LOGGER.info("pasa por el while de de cliente para curso");
			Cliente cliente = clientes.get(codigo);

			if (cliente == null) {// si el cliente no esta en el mapa
				cliente = new Cliente();
				cliente.setNombre(rs.getString("nombre"));
				cliente.setIdentificador(rs.getString("identificador"));
				cliente.setCodigoPostal(rs.getInt("codigopostal"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setEmail(rs.getString("email"));
				cliente.setPoblacion(rs.getString("poblacion"));
				cliente.setTelefono(String.valueOf(rs.getInt("telefono")));
				cliente.setActivo(rs.getBoolean("activo"));
				cliente.setCodigo(rs.getInt("codigo"));
			
				clientes.put(cliente.getCodigo(), cliente);
			}
			
			Long cCurso = rs.getLong("cursocodigo");
			
			if (cCurso != null) {
				Curso curso = new Curso();
				curso.setCodigo(rs.getLong("cursocodigo"));
				curso.setNombre(rs.getString("cursonombre"));
				curso.setfInicio(rs.getDate("finicio"));
				curso.setfFin(rs.getDate("ffin"));
				curso.setnHoras(rs.getInt("nhoras"));
				cliente.getCursos().put(cCurso, curso);
				LOGGER.info("pasa por cursocodigo");
				
			}
			
		}

		return clientes;
	}
}
