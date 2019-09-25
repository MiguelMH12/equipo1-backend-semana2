package com.everis.equipouno.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import com.everis.equipouno.model.Curso;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


//JUnit para Spring Boot
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class CursoControllerTest {
	//Mock es un objeto de prueba (dummie) simulacion de peticiones y respuestas  http
	private MockMvc mvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	//Inicializamos el objeto Mock
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testListar() throws Exception {
		String url = "/curso/";
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);
		String jsonRespuesta = resultado.getResponse().getContentAsString();
		//System.out.println(jsonRespuesta);
		//Convertimos a lista de cursos mejor
		ObjectMapper mapper = new ObjectMapper();
		List<Curso> cursos =  mapper.readValue(jsonRespuesta, new TypeReference<List<Curso>>() {});
		//Otras validaciones
		assertNotNull(cursos);  //QUe no vengan listas vacias
		assertTrue(cursos.size() > 0);  //QUe sea una lista con elementos
		for(Curso curso : cursos) {
			assertTrue(curso.getNombrecurso() != null);  //Que traiga nombre del curso
		}
		
	}

	@Test
	public void testInsertar() throws Exception {
		String url = "/curso/";
		//insertamos varios cursos
		for(int i = 0; i < 50; i++) {
			Curso curso = new Curso();
			curso.setNombrecurso("Miguel Junit" + i);
			curso.setDescripcion("Descripcion Junit" + i);
			//Jackson //Para no usar Gson y convertir a String
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(curso);
			
			//Enviamos la peticion (Json) mediante un post
			MvcResult resultado = mvc.perform(MockMvcRequestBuilders.post(url).
					contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(json)).andReturn();
			
			int status = resultado.getResponse().getStatus();
			assertTrue(status == 200);  //Exitosa la peticion
			String jsonRespuesta = resultado.getResponse().getContentAsString();  //Obtenemos la respuesta que viene y la convertimos a un JSON
			//Nos regresa un objeto de tipo curso, para omitir la ultima linea podemos validar que estamos recibiendo un id mayor a 0
			Curso cursoInsertado = mapper.readValue(jsonRespuesta, Curso.class);
			assertTrue(cursoInsertado.getId() > 0);
			//assertTrue(jsonRespuesta.contains("id"));
		}
		
	}
	
	@Test
	public void testActualizar() throws Exception {
		String url = "/curso/";
		Curso curso = new Curso();
		//Para actualizar tenemos que enviar el id o llave primaria
		curso.setId(2);
		curso.setNombrecurso("Curso Actualizado");
		curso.setDescripcion("Curso Actualizado");
		//Jackson //Para no usar Gson y convertir a String
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(curso);
		
		//Enviamos la peticion (Json) mediante un put
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.put(url).
				contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(json)).andReturn();
		
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);  //Exitosa la peticion
		String jsonRespuesta = resultado.getResponse().getContentAsString();  //Obtenemos la respuesta que viene y la convertimos a un JSON
		//Nos regresa un objeto de tipo curso, para omitir la ultima linea podemos validar que estamos recibiendo un id mayor a 0
		Curso cursoActualizado = mapper.readValue(jsonRespuesta, Curso.class);
		//Verificamos que el nombre del curso sea el nuevo que actualizamos
		assertTrue(cursoActualizado.getNombrecurso().equals("Curso Actualizado"));
		//assertTrue(jsonRespuesta.contains("id"));
	}
	
	@Test
	public void testEliminar() throws Exception {
		//enviamos en la url el id del curso que queremos eliminar, uno de los ultimos para no afeectar otros procesos
		String url = "/curso/7";
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.delete(url)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);  //Exitosa la peticion
		String json = resultado.getResponse().getContentAsString();
		assertTrue(json.equals("true"));
	}


}
