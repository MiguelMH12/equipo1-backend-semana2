package com.everis.equipouno.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.everis.equipouno.Application;
import com.everis.equipouno.model.Alumno;
import com.everis.equipouno.model.Calendario;
import com.everis.equipouno.model.Curso;
import com.everis.equipouno.model.Inscripcion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class InscripcionControllerTest {
	
	private MockMvc mvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testListar() throws Exception {
		String url = "/inscripcion/";
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);
		String jsonRespuesta = resultado.getResponse().getContentAsString();
		//System.out.println(jsonRespuesta);
		ObjectMapper mapper = new ObjectMapper();
		List<Inscripcion> inscripciones =  mapper.readValue(jsonRespuesta, new TypeReference<List<Inscripcion>>() {});
		//Otras validaciones
		assertNotNull(inscripciones);  //QUe no vengan listas vacias
		assertTrue(inscripciones.size() > 0);  //QUe sea una lista con elementos
	}

	@Test
	public void testInsertar() throws Exception {
		String url = "/inscripcion/";
		Inscripcion inscripcion = new Inscripcion();
		Alumno alumno = new Alumno();
		Calendario calendario = new Calendario();
		
		alumno.setNombre("Un Alumno2 JUnit");
		alumno.setApaterno("Apaterno2 Junit");
		alumno.setAmaterno("Amaterno2 JUnit");
		
		calendario.setId(3);
		
		inscripcion.setAlumno(alumno);
		inscripcion.setCalendario(calendario);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(inscripcion);
		
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.post(url).
				contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(json)).andReturn();
		
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);  //Exitosa la peticion
		String jsonRespuesta = resultado.getResponse().getContentAsString();  
		Inscripcion inscripcionInsertada = mapper.readValue(jsonRespuesta, Inscripcion.class);
		assertTrue(inscripcionInsertada.getId() > 0);
	}

	@Test
	public void testActualizar() throws Exception {
		String url = "/inscripcion/";
		Inscripcion inscripcion = new Inscripcion();
		Alumno alumno = new Alumno();
		Calendario calendario = new Calendario();
		
		alumno.setId(4);
		calendario.setId(4);
		
		inscripcion.setId(8);
		inscripcion.setAlumno(alumno);
		inscripcion.setCalendario(calendario);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(inscripcion);
		
		
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.put(url).
				contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(json)).andReturn();
		
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200); 

	}

	@Test
	public void testEliminiar() throws Exception {
		String url = "/inscripcion/7";
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.delete(url)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);  //Exitosa la peticion
		String json = resultado.getResponse().getContentAsString();
		assertTrue(json.equals("true"));
	}

}
