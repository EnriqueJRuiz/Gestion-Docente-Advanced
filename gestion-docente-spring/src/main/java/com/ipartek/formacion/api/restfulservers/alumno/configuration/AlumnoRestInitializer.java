package com.ipartek.formacion.api.restfulservers.alumno.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ipartek.formacion.api.restfulservers.CORSFilter;

public class AlumnoRestInitializer{ //extends AbstractAnnotationConfigDispatcherServletInitializer {

	//@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AlumnoRestControllerConfigurantion.class};
	}

	//@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	//@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	//@Override
	protected Filter[] getServletFilters() {
		Filter[]filter={new CORSFilter()};
		return filter;
	}

}
