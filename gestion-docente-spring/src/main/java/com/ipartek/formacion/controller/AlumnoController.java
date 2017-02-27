package com.ipartek.formacion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(AlumnoController.class);
	
	ModelAndView mav = null;
	
	@Resource(name="alumnoValidator")//para injectar el validator si hay mas de una ClassValidator si usan el mismo.El nombre esta en servlet-context.xml
	private Validator validator = null;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), false, 10));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("alumnos/alumnos");
		List<Alumno> alumnos= aS.getAll();
		mav.addObject("listadoAlumnos", alumnos);//request
		LOGGER.trace("pasa por getAll()");
		return mav;
	}
	
	@RequestMapping(value="/{id}")
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("alumnos/alumno");
		mav.addObject("alumno",aS.getById(id));
		return mav;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveAlumno( Model model, @ModelAttribute("alumno") @Validated Alumno alumno,BindingResult bindingResult){ //validate spring valid java
		String destino = "";
		if (bindingResult.hasErrors()) {
			LOGGER.info("alumno tiene errores");
			destino = "/alumnos/alumno";
		}else{
			destino = "redirect:/alumnos";
			if(alumno.getCodigo() > Alumno.CODIGO_NULO){
				LOGGER.info(alumno.toString());
				aS.update(alumno);
			}else{
				LOGGER.info(alumno.toString());
				aS.create(alumno);
			}
		}
		return destino;
	}
	
	@RequestMapping(value="/addAlumno")
	public String addAlumno(Model model){
		model.addAttribute("alumno", new Alumno());
		LOGGER.trace("");
		return "alumnos/alumno";
	}
	
	@RequestMapping(value="/deleteAlumno/{id}")
	public String deleteAlumno(@PathVariable("id") int id){
		LOGGER.info(Integer.toString(id));
		aS.delete(id);
		return "redirect:/alumnos";// redirige a alumnos/alumnos de arriba para volver a cargar la lista.
	}
	
	@RequestMapping(value="/verAlumno/{id}")
	public ModelAndView verAlumno(@PathVariable("id") int id){
		LOGGER.info("llega aqui");
		mav = new ModelAndView("alumnos/informe");
		Alumno alumno = aS.getInforme(id);
		
		mav.addObject("alumno", alumno);//request
		return mav;
	}
	
	
}
