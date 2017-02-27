package com.ipartek.formacion.dbms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.persistence.Curso;

public class AlumnoExtractor implements ResultSetExtractor<Map<Integer, Alumno>> {
		private final static Logger LOGGER = LoggerFactory.getLogger(ClienteExtractor.class);

		@Override
		public Map<Integer, Alumno> extractData(ResultSet rs) throws SQLException, DataAccessException {
			Map<Integer, Alumno> alumnos = new HashMap<Integer, Alumno>();
		
			while (rs.next()) {
				
				int codigo = rs.getInt("codigo");
				LOGGER.info("pasa por el while de de cliente para curso");
				Alumno alumno = alumnos.get(codigo);

				if (alumno == null) {// si el cliente no esta en el mapa
					alumno = new Alumno();
					alumno.setNombre(rs.getString("nombre"));
					alumno.setDni(rs.getString("dni"));
					alumno.setCodigoPostal(rs.getInt("codigoPostal"));
					alumno.setDireccion(rs.getString("direccion"));
					alumno.setEmail(rs.getString("email"));
					alumno.setPoblacion(rs.getString("poblacion"));
					alumno.setTelefono(String.valueOf(rs.getInt("telefono")));
					alumno.setActivo(rs.getBoolean("activo"));
					alumno.setCodigo(rs.getInt("codigo"));
					alumno.setfNacimiento(rs.getDate("fNacimiento"));
					alumnos.put(alumno.getCodigo(), alumno);
				}
				
				Long cCurso = rs.getLong("cursocodigo");
				
				if (cCurso != null && cCurso > 0) {
					Curso curso = new Curso();
					curso.setCodigo(rs.getLong("cursocodigo"));
					curso.setNombre(rs.getString("cursonombre"));
					curso.setfInicio(rs.getDate("finicio"));
					curso.setfFin(rs.getDate("ffin"));
					curso.setnHoras(rs.getInt("nhoras"));
					alumno.getCursos().put(cCurso, curso);
					LOGGER.info("pasa por cursocodigo");
					
				}
				
			}

			return alumnos;
		}
	}