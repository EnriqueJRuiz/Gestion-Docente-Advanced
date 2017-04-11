package com.ipartek.formacion.service;

import static org.junit.Assert.*;

import java.util.DuplicateFormatFlagsException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    @Before
    public void setUp() throws Exception {
        alumno = new Alumno();
        alumno.setNombre("Jon Koldobika");
        alumno.setApellidos("Ajuriagogeaskoa Belaustegigoitia");
        alumno.setDni("30658168Z");
        alumno.setCodigoPostal(48006);
        alumno.setTelefono("987654321");
        alumno.setEmail("algo@algo.com");
    }
	
	 @Test
	    public void testClase() {
	        assertEquals("class com.ipartek.formacion.service.AlumnoServiceImp", this.as.getClass().toString());
	    }

	
	@Test(expected = DuplicateKeyException.class)
	public void create() {
		Alumno alum = as.create(alumno);
		assertNotNull("el alumno es nulo",alum);
		assertTrue("el codigo del alumno es mayor a 0",alum.getCodigo()>0);
		assertEquals("el nombre no es identico", alum.getNombre(),alumno.getNombre());
		alum = as.create(alum);
		as.delete(alum.getCodigo());
	}
	@Test
	public void delete(){
		
	}
	
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    	
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	
    }



    @After
    public void tearDown() throws Exception {
    	
    }
}



