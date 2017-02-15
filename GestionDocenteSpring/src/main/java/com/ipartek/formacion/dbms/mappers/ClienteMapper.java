package com.ipartek.formacion.dbms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dbms.persistence.Cliente;

public class ClienteMapper implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setCodigo(rs.getInt("codigo"));
		cliente.setNombre(rs.getString("nombre"));
		cliente.setEmail(rs.getString("email"));
		cliente.setTelefono(rs.getString("telefono"));
		cliente.setActivo(rs.getBoolean("activo"));
		cliente.setEmail(rs.getString("email"));
		cliente.setDireccion(rs.getString("direccion"));
		cliente.setPoblacion(rs.getString("poblacion"));
		cliente.setCodigoPostal(rs.getInt("codigoPostal"));
		cliente.setIdentificador(rs.getString("identificador"));
		return cliente;
	}

}
