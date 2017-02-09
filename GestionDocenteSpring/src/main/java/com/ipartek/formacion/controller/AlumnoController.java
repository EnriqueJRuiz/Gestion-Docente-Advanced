package com.ipartek.formacion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@Resource(name="alumnoValidator")//para injectar el validator si hay mas de una ClassValidator si usan el mismo.
	private Validator validator = null;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), false, 10));//validar fecha
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("alumnos/alumnos");
		List alumnos= aS.getAll();
		mav.addObject("listadoAlumnos", alumnos);//request
		logger.trace("pasa por getAll()");
		return mav;
	}
	
	@RequestMapping(value="/{id}")
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("alumnos/alumno");
		mav.addObject("alumno",aS.getById(id));
		return mav;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("alumno") @Validated Alumno alumno, Model model, BindingResult bindingResult){ //validate spring valid java
		String destino = "";
		if (bindingResult.hasErrors()) {
			logger.info("alumno tiene errores");
			destino = "/alumnos/alumno";
		}else{
			destino = "redirect:/alumnos";
			if(alumno.getCodigo() > alumno.CODIGO_NULO){
				aS.update(alumno);
			}else{
				aS.create(alumno);
			}
		}
		return destino;
	}
	
	@RequestMapping(value="/addAlumno")
	public String addAlumno(Model model){
		model.addAttribute("alumno", new Alumno());
		return "alumnos/alumno";
	}
	
	@RequestMapping(value="/deleteAlumno/{id}")
	public String deleteAlumno(@PathVariable("id") int id){
		aS.delete(id);
		return "redirect:/alumnos";// redirige a alumnos/alumnos de arriba para volver a cargar la lista.
	}
	
}
