package com.ipartek.formacion.ws.curso;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.ipartek.formacion.curso.CursoServiceRemote;
import com.ipartek.formacion.persistence.Curso;

/**
 * Session Bean implementation class CursoServiceBeanSOAP
 */
@WebService(endpointInterface = "com.ipartek.formacion.ws.curso.CursoServiceSOAPRemote")
@Stateless(name = "CursoServiceSOAP")
public class CursoServiceBeanSOAP implements CursoServiceSOAPRemote {

    @EJB//CDI  <--> JNDI
    CursoServiceRemote cS;
    
    /**
     * Default constructor. 
     */
    public CursoServiceBeanSOAP() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Curso> getAll() {
        
        return cS.getAll();
    }

}