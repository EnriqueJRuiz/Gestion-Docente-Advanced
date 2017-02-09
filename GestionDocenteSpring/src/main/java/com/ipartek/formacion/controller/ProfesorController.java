package com.ipartek.formacion.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.dbms.persistence.Profesor;
import com.ipartek.formacion.service.interfaces.ProfesorService;

@Controller
@RequestMapping(value="/profesores")
public class ProfesorController {
	
	@Inject
	private ProfesorService pS;
	private static final Logger logger = LoggerFactory.getLogger(ProfesorController.class);
	ModelAndView mav = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("profesores/profesores");
		List profesores = pS.getAll();
		mav.addObject("listadoProfesores", profesores);
		logger.trace("pasa por getAll()");
		return mav;
	}
	
	@RequestMapping(value="/{id}")
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("aprofesores/profesor");
		mav.addObject("profesor",pS.getById(id));
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProfesor(@ModelAttribute("profesor")@Valid Profesor profesor, Model model, 
			BindingResult bindingResult){
		String destino = "";
			
		if (bindingResult.hasErrors()){
			logger.info("profesor tiene errores");
			destino = "";
		}else{
			destino = "redirect:/profesores";
			if (profesor.getCodigo() > Profesor.CODIGO_NULO){
				pS.update(profesor);
			}else{
				pS.create(profesor);
			}
		}
		return destino;
	}
	
	@RequestMapping(value="/addProfesor")
	public String addAlumno(Model model){
		model.addAttribute("profesor", new Profesor());
		return "profesores/profesor";
	}
	
	@RequestMapping(value="/deleteProfesor/{id}")
	public String deleteAlumno(@PathVariable("id") int id){
		pS.delete(id);
		return "redirect:/prodesores";
	}
	
}
