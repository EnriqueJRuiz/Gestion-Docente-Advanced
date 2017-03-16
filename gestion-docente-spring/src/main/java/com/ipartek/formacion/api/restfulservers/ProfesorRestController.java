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
import com.ipartek.formacion.dbms.persistence.Profesor;
import com.ipartek.formacion.service.interfaces.ProfesorService;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorRestController {

		@Autowired
		ProfesorService pS;
		
		@RequestMapping( method = RequestMethod.GET)
		public ResponseEntity<List<Profesor>> getAll(){
			List<Profesor> profesores = pS.getAll();
			ResponseEntity<List<Profesor>> response = null;
			if(profesores == null || profesores.isEmpty()){
				response = new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT); 
			}else{
				response = new ResponseEntity<List<Profesor>>(profesores, HttpStatus.OK);
			}
			return response;
		}
		
		@RequestMapping( method = RequestMethod.POST)
		public ResponseEntity<Void> create(@RequestBody Profesor profesor, UriComponentsBuilder ucBuilder){
			Profesor profdni = pS.getByDni(profesor.getDni());
			Profesor profnss = pS.getByNss(profesor.getnSS());
			ResponseEntity<Void> response=null;
			if(profdni != null){
				response= new ResponseEntity<Void>(HttpStatus.CONFLICT);
			} else {
				if(profnss != null){
					response= new ResponseEntity<Void>(HttpStatus.CONFLICT);
				} else {
					try{
					Profesor aux = pS.create(profesor);
					HttpHeaders headers = new HttpHeaders();
					headers.setLocation(ucBuilder.path("/api/profesores/{codigo}").buildAndExpand(aux.getCodigo()).toUri());
					response = new ResponseEntity<Void>(headers,HttpStatus.CREATED);
					}catch(Error e){
						response = new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
					}
				}
			}
			
			return response;
		}
		
		@RequestMapping(value="/{codigo}", method = RequestMethod.GET)
		public ResponseEntity<Profesor> getById(@PathVariable("codigo") int id){
			Profesor profesor = pS.getById(id);
			ResponseEntity<Profesor> response = null;
			if (profesor == null){// 404
				response = new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND) ;
			}else{// 200
				response = new ResponseEntity<Profesor>(profesor, HttpStatus.OK);
			}
			return response;
		}
		
		@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
		public ResponseEntity<Profesor> update(@PathVariable("codigo") int id,@RequestBody Profesor profesor){
			Profesor prof = pS.getById(id);
			ResponseEntity<Profesor> response = null;
			if(prof == null){
				response= new ResponseEntity<Profesor> (HttpStatus.NOT_FOUND);
			}else{
				prof = pS.update(profesor);
				response = new ResponseEntity<Profesor>(prof, HttpStatus.ACCEPTED);
			}
			return response;
		}
		
		@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
		public ResponseEntity<Profesor> deleteAlumno(@PathVariable("codigo") int id) {
			Profesor prof = pS.getById(id);
			ResponseEntity<Profesor> response = null;
			if(prof == null){
				response= new ResponseEntity<Profesor> (HttpStatus.NOT_FOUND);
			}else{
				pS.delete(id);
				response = new ResponseEntity<Profesor>(prof, HttpStatus.NO_CONTENT);
			}
			return response;
		}
}
