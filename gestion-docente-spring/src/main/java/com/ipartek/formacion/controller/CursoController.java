package com.ipartek.formacion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.controller.validator.CursoValidator;
import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.persistence.Profesor;
import com.ipartek.formacion.service.interfaces.AlumnoServiceEJB;
import com.ipartek.formacion.service.interfaces.ClienteServiceEJB;
import com.ipartek.formacion.service.interfaces.CursoService;
import com.ipartek.formacion.service.interfaces.ProfesorServiceEJB;

@Controller
@RequestMapping("/cursos")
public class CursoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);
	@Autowired
	private CursoService cS;
	@Autowired
	private ProfesorServiceEJB pS;
	@Autowired
	private AlumnoServiceEJB aS;
	//@Autowired
	//CursoValidator validator;
	@Autowired
	private ClienteServiceEJB cl;
	
	ModelAndView mav = null;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 		dateFormat.setLenient(false);
		 		//binder.addValidators(validator);
		 		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		 	
		 }
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model){
		List<Curso> cursos = cS.getAll();
		LOGGER.info("tamaño:" + cursos.size());
		model.addAttribute("listadoCursos", cursos);
		return "cursos/cursos";
	}
	
	@RequestMapping("/{codigo}")
	public String getById(@PathVariable("codigo") long codigo, Model model){
		model.addAttribute("curso",cS.getById(codigo));
		return "cursos/curso";
	}
	
	
	@RequestMapping("verCurso/{codigo}")
	public String getInforme(@PathVariable("codigo") long codigo, Model model){
		model.addAttribute("cursoDetalladodo",cS.getInforme(codigo));
		return "cursos/curso";
	}
	
	@RequestMapping(value = "/editCurso/{codigocurso}", method = RequestMethod.GET)
	public ModelAndView editCurso(@PathVariable("codigocurso") long codigocurso) {
		mav = new ModelAndView("/cursos/cursoform");
		Curso curso = cS.getById(codigocurso);
		mav.addObject("curso", curso);
		List<Profesor> profesores = pS.getAll();
	 	LOGGER.info("tamaño:" + profesores.size());
  		mav.addObject("listadoProfesores", profesores);
  		mav.addObject("listadoClientes", cl.getAll());
  		mav.addObject("listadoAlumnos", aS.getAll());
		return mav;
		
	}
	@RequestMapping(value="addCurso")
	public ModelAndView addCurso() {
		mav = new ModelAndView("/cursos/cursoform");
		Curso curso = new Curso();
		curso.setActivo(true);
		mav.addObject("curso", curso);
		List<Profesor> profesores = pS.getAll();
		LOGGER.info("nº "+profesores.size());
  		mav.addObject("listadoProfesores", profesores);
  		mav.addObject("listadoClientes", cl.getAll());
  		mav.addObject("listadoAlumnos", aS.getAll());
  		return mav;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveCurso( Model model,@ModelAttribute("curso")@Valid Curso curso,BindingResult bindingResult){
		String destino = "";
		if (bindingResult.hasErrors()) {
			LOGGER.info("curso tiene errores");
			model.addAttribute("listadoProfesores", pS.getAll());
			model.addAttribute("listadoAlumnos", aS.getAll());
			model.addAttribute("listadoClientes", cl.getAll());

			destino = "/cursos/cursoformulario";
		}else{
			destino = "redirect:/cursos";
			if(curso.getCodigo() > Curso.CODIGO_NULO){
				LOGGER.info(curso.toString());
				cS.update(curso);
			}else{
				LOGGER.info(curso.toString());
				cS.create(curso);
			}
		}
		return destino;
		
	}
	
	@RequestMapping(value = "/deleteCurso/{codigocurso}")
	public String deleteCurso(@PathVariable("codigocurso") long codigocurso) {
		 
		return "redirect:/cursos";
	}	
	
}
