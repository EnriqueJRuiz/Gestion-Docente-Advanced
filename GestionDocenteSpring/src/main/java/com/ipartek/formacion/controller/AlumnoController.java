package com.ipartek.formacion.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnoController {
	
	@Inject//crea y destruye un objeto de aS sin tener que hacer 
	private AlumnoService aS;
	private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	ModelAndView mav = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("alumnos/alumnos");
		List alumnos= aS.getAll();
		mav.addObject("listadoAlumnos", alumnos);//request
		logger.trace("pasa por getAll()");
		return mav;
	}
	
	@RequestMapping(value="/{codigo}")
	public ModelAndView getById(@PathVariable("codigo") int codigo){
		mav = new ModelAndView("alumnos/alumno");
		mav.addObject("alumno",aS.getById(codigo));
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("alumno") Alumno alumno, Model model){
		String destino = "";
		if(alumno.getCodigo() > alumno.CODIGO_NULO){
			aS.update(alumno);
		}else{
			aS.create(alumno);
		}
		return destino;
	}
	
	@RequestMapping(value="/addAlumno")
	public String addAlumno(Model model){
		model.addAttribute("alumno", new Alumno());
		return "alumnos/alumno";
	}
	
	@RequestMapping(value="/deleteAlumno/{codigo}")
	public String deleteAlumno(@PathVariable("codigo") int codigo){
		aS.delete(codigo);
		return "redirect:/alumnos";// redirige a alumnos/alumnos de arriba para volver a cargar la lista.
	}
	
}
