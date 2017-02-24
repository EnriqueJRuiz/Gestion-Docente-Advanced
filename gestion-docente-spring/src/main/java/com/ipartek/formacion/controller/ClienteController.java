package com.ipartek.formacion.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.ipartek.formacion.dbms.persistence.Cliente;
import com.ipartek.formacion.dbms.persistence.Curso;
import com.ipartek.formacion.service.interfaces.ClienteService;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Inject
	private ClienteService cS;
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);
	ModelAndView mav = null;
	
	@Resource(name="clienteValidator")//para injectar el validator si hay mas de una ClassValidator si usan el mismo.
	private Validator validator = null;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("clientes/clientes");
		List<Cliente> clientes= cS.getAll();
		mav.addObject("listadoClientes", clientes);//request
		LOGGER.trace("pasa por getAll()");
		return mav;
	}
	
	@RequestMapping(value="/{id}")
	public ModelAndView getById(@PathVariable("id") int id){
		mav = new ModelAndView("clientes/cliente");
		mav.addObject("cliente",cS.getById(id));
		return mav;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveCliente(Model model,@ModelAttribute("cliente") @Validated Cliente cliente ,BindingResult bindingResult){ //validate spring valid java
		String destino = "";
		
		if (bindingResult.hasErrors()) {
			LOGGER.info("cliente tiene errores");
			destino = "/clientes/cliente";
		}else{
			destino = "redirect:/clientes";
			if(cliente.getCodigo() > Cliente.CODIGO_NULO){
				LOGGER.info(cliente.toString());
				cS.update(cliente);
			}else{
				LOGGER.info(cliente.toString());
				cS.create(cliente);
			}
		}
		return destino;
	}
	
	@RequestMapping(value="/addCliente")
	public String addCliente(Model model){
		model.addAttribute("cliente", new Cliente());
		LOGGER.trace("");
		return "clientes/cliente";
	}
	
	@RequestMapping(value="/deleteCliente/{id}")
	public String deleteCliente(@PathVariable("id") int id){
		LOGGER.info(Integer.toString(id));
		cS.delete(id);
		return "redirect:/clientes";
	}
	@RequestMapping(value="/verCliente/{id}")
	public ModelAndView verCliente(@PathVariable("id") int id){
		mav = new ModelAndView("clientes/informe");
		Cliente cliente = cS.getInforme(id);
		mav.addObject("cliente", cliente);//request
		return mav;
	}
	
}
