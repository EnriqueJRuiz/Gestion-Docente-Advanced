package com.ipartek.formacion.dbms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dbms.dao.interfaces.ClienteDAO;
import com.ipartek.formacion.dbms.mappers.AlumnoMapper;
import com.ipartek.formacion.dbms.mappers.ClienteMapper;
import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.dbms.persistence.Cliente;

@Repository("clienteDaoImp")
public class ClienteDAOImp implements ClienteDAO {

	private DataSource dataSource;
	private SimpleJdbcCall JdbcCall;
	private JdbcTemplate template;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfesorDAOImp.class);

	@Autowired // = que inject
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Cliente create(Cliente cliente) {
		final String SQL="clienteCreate";
		
		this.JdbcCall = new SimpleJdbcCall(dataSource);
		
		JdbcCall.withProcedureName(SQL);
		
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pnombre", cliente.getNombre())
				.addValue("pidentificador", cliente.getIdentificador())
				.addValue("ptelefono", cliente.getTelefono())
				.addValue("pemail", cliente.getEmail())
				.addValue("pcodigoPostal", cliente.getCodigoPostal())
				.addValue("pdireccion", cliente.getDireccion())
				.addValue("ppoblacion", cliente.getPoblacion());
		
		LOGGER.info(cliente.toString());
		//se ejecuta la consulta
		Map<String, Object> out = JdbcCall.execute(in);
		//en out se han recogido los parametros out de la consulta a BBDD
		cliente.setCodigo((Integer)out.get("pcodigo"));
		return cliente;
	}

	@Override
	public Cliente getById(int codigo) {
		Cliente cliente = null;
		final String SQL="CALL clientegetById(?)";
		try{
			cliente = template.queryForObject(SQL, new ClienteMapper(),new Object[] { codigo });
			LOGGER.info(cliente.toString());
		}catch(EmptyResultDataAccessException e){
			cliente = new Cliente();
			 LOGGER.info("no se he encontrado Alumno para el codigo: "+ codigo + " "+e.getMessage());
		}	
		return cliente;
	}

	@Override
	public List<Cliente> getAll() {
		final String SQL = "CALL clientegetAll()";
		List<Cliente> clientes = null;
		try{
			clientes = template.query(SQL, new ClienteMapper());
		}catch(EmptyResultDataAccessException e){
			LOGGER.trace(e.getMessage());
			clientes = new ArrayList<Cliente>();
		}
		return clientes;
	}

	@Override
	public Cliente update(Cliente cliente) {
		final String SQL="clienteUpdate";
		this.JdbcCall = new SimpleJdbcCall(dataSource);
		JdbcCall.withProcedureName(SQL);

		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pnombre", cliente.getNombre())
				.addValue("pidentificador", cliente.getIdentificador())
				.addValue("ptelefono", cliente.getTelefono())
				.addValue("pemail", cliente.getEmail())
				.addValue("pcodigoPostal", cliente.getCodigoPostal())
				.addValue("pdireccion", cliente.getDireccion())
				.addValue("ppoblacion", cliente.getPoblacion())
				.addValue("pcodigo", cliente.getCodigo());
		LOGGER.info(cliente.toString());
		
			JdbcCall.execute(in);
		return cliente;
	}

	@Override
	public void delete(int codigo) {
		final String SQL= "clienteDeleteF";
		this.JdbcCall = new SimpleJdbcCall(dataSource);
		JdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pcodigo", codigo);
		LOGGER.info(String.valueOf(codigo));
		
		JdbcCall.execute(in);
	}

	@Override
	public Cliente comprobarIdentificador(String identificador) {
		Cliente cliente = null;
		final String SQL= "CALL clienteIdentificadorUnico(?);";
		try{
			cliente = template.queryForObject(SQL, new ClienteMapper(),new Object[] { identificador });
			LOGGER.info("hay un cliente con ese identificador");
		}catch(EmptyResultDataAccessException e){
			LOGGER.info("NO hay cliente con ese identificador");
		}
		return cliente;
	}
		
}
