package com.ipartek.formacion.api.restfulservers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoRestController {

	@Autowired
	AlumnoService aS;
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Alumno>> getAll(){
		List<Alumno> alumnos = aS.getAll();
		ResponseEntity<List<Alumno>> response = null;
		if(alumnos == null || alumnos.isEmpty()){
			response = new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT); 
		}else{
			response = new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Alumno> getById(@PathVariable("codigo") int id){
		Alumno alumno = aS.getById(id);
		ResponseEntity<Alumno> response = null;
		if (alumno == null){// 404
			response = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND) ;
		}else{// 200
			response = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
		}
		return response;
	}
	
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Alumno alumno, UriComponentsBuilder ucBuilder){
		Alumno alum = aS.comprobarDni(alumno.getDni());
		ResponseEntity<Void> response=null;
		if(alum != null){
			response= new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			try{
			Alumno aux = aS.create(alumno);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/api/alumnos/{codigo}").buildAndExpand(aux.getCodigo()).toUri());
			response = new ResponseEntity<Void>(headers,HttpStatus.CREATED);
			}catch(Error e){
				response = new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
		return response;
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	public ResponseEntity<Alumno> update(@PathVariable("codigo") int id,@RequestBody Alumno alumno){
		Alumno alum = aS.getById(id);
		ResponseEntity<Alumno> response = null;
		if(alum == null){
			response= new ResponseEntity<Alumno> (HttpStatus.NOT_FOUND);
		}else{
			alum = aS.update(alumno);
			response = new ResponseEntity<Alumno>(alum, HttpStatus.ACCEPTED);
		}
		return response;
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Alumno> deleteAlumno(@PathVariable("codigo") int id) {
		Alumno alum = aS.getById(id);
		ResponseEntity<Alumno> response = null;
		if(alum == null){
			response= new ResponseEntity<Alumno> (HttpStatus.NOT_FOUND);
		}else{
			aS.delete(id);
			response = new ResponseEntity<Alumno>(alum, HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
}
