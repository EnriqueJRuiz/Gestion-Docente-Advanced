package com.ipartek.formacion.dbms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ipartek.formacion.dbms.persistence.Cliente;
import com.ipartek.formacion.persistence.Curso;

public class ClienteExtractor implements ResultSetExtractor<Map<Long, Cliente>> {

	@Override
	public Map<Long, Cliente> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Long, Cliente> clientes = new HashMap<Long, Cliente>();
		
		
		while(rs.next()){
			int codigo = rs.getInt("codigo");
			
			Cliente cliente = clientes.get(codigo);
			if(cliente == null ){
				
				cliente = new Cliente();
				cliente.setNombre(rs.getString("nombre"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setActivo(rs.getBoolean("activo"));
				cliente.setEmail(rs.getString("email"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setPoblacion(rs.getString("poblacion"));
				cliente.setCodigoPostal(rs.getInt("codigoPostal"));
				cliente.setIdentificador(rs.getString("identificador"));
				cliente.setCodigo(codigo);
				cliente.setCursos(new HashMap<Long,Curso>());
				
			}
			
			Map<Long,Curso> cursos = new HashMap<Long,Curso>();
		
			Curso curso = new Curso();
			curso.setCodigo(rs.getLong("codigo"));
			curso.setNombre(rs.getString("nombre"));
			curso.setnHoras(rs.getInt("nHoras"));
			curso.setfInicio(rs.getDate("fInicio"));
			curso.setfFin(rs.getDate("fFin"));
			cursos.put(curso.getCodigo(), curso);
			
			cliente.setCursos(cursos);
			clientes.put((long)cliente.getCodigo(), cliente);
			
		}	
		return clientes;
			
	}
		
}
