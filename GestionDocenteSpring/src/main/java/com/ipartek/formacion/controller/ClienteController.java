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
import com.ipartek.formacion.dbms.persistence.Cliente;
import com.ipartek.formacion.service.interfaces.ClienteService;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Inject
	private ClienteService cS;
	private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	ModelAndView mav = null;
	
	@Resource(name="ClienteValidator")//para injectar el validator si hay mas de una ClassValidator si usan el mismo.
	private Validator validator = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("clientes/clientes");
		List clientes= cS.getAll();
		mav.addObject("listadoClientes", clientes);//request
		logger.trace("pasa por getAll()");
		return mav;
	}
	
	@RequestMapping(value="/{id}")
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("clientes/cliente");
		mav.addObject("cliente",cS.getById(id));
		return mav;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveCliente(@ModelAttribute("cliente") @Validated Cliente cliente, Model model, BindingResult bindingResult){ //validate spring valid java
		String destino = "";
		if (bindingResult.hasErrors()) {
			logger.info("cliente tiene errores");
			destino = "/clienes/clientes";
		}else{
			destino = "redirect:/clientes";
			if(cliente.getCodigo() > Cliente.CODIGO_NULO){
				logger.info(cliente.toString());
				cS.update(cliente);
			}else{
				logger.info(cliente.toString());
				cS.create(cliente);
			}
		}
		return destino;
	}
	
	@RequestMapping(value="/addCliente")
	public String addCliente(Model model){
		model.addAttribute("cliente", new Cliente());
		return "clientes/cliente";
	}
	
	@RequestMapping(value="/deleteCliente/{id}")
	public String deleteAlumno(@PathVariable("id") int id){
		cS.delete(id);
		return "redirect:/clientes";
	}
	
	
}
