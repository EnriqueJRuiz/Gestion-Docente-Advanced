package com.ipartek.formacion.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class AlumnoServiceTest {

	@Autowired
	AlumnoService as;
		
	Alumno alumno;
	
	 @Test
	    public void testClase() {
	        assertEquals("class com.ipartek.formacion.service.AlumnoServiceImp", this.as.getClass().toString());
	    }

	
	@Test
	public void create() {
		
	}
	
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    	
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	
    }

    @Before
    public void setUp() throws Exception {
        alumno = new Alumno();
        alumno.setNombre("Jon Koldobika");
        alumno.setApellidos("Ajuriagogeaskoa Belaustegigoitia");
        alumno.setDni("30658168Z");
        alumno.setCodigoPostal(48006);

    }

    @After
    public void tearDown() throws Exception {
    }
}



