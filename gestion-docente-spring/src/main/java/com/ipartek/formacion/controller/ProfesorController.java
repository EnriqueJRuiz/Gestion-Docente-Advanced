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

import com.ipartek.formacion.dbms.persistence.Profesor;
import com.ipartek.formacion.service.interfaces.ProfesorService;

@Controller
@RequestMapping(value="/profesores")
public class ProfesorController {
	
	@Inject
	private ProfesorService pS;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfesorController.class);
	ModelAndView mav = null;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("profesores");
		List<Profesor> profesores = pS.getAll();
		mav.addObject("listadoProfesores", profesores);
		LOGGER.trace("pasa por getAll()");
		return mav;
	}
	
	@RequestMapping(value="/{id}")
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("profesor");
		mav.addObject("profesor",pS.getById(id));
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProfesor(Model model, @ModelAttribute("profesor")@Valid Profesor profesor,  
			BindingResult bindingResult){
		String destino = "";
			
		if (bindingResult.hasErrors()){
			LOGGER.info("profesor tiene errores");
			destino = "profesor";
		}else{
			destino = "redirect:/profesores";
			if (profesor.getCodigo() > Profesor.CODIGO_NULO){
				LOGGER.info(profesor.toString());
				pS.update(profesor);
			}else{
				LOGGER.info(profesor.toString());
				pS.create(profesor);
			}
		}
		return destino;
	}
	
	@RequestMapping(value="/addProfesor")
	public String addPorfesor(Model model){
		model.addAttribute("profesor", new Profesor());
		return "profesor";
	}
	
	@RequestMapping(value="/deleteProfesor/{id}")
	public String deleteProfesor(@PathVariable("id") int id){
		pS.delete(id);
		return "redirect:/profesores";
	}
	
}
