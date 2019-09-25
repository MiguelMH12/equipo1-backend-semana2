package com.everis.equipouno.controller;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.everis.equipouno.model.Inscripcion;
import com.everis.equipouno.model.Pago;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PagoControllerTest  extends BaseControllerTest{
	
	@Before
	public void setUp() {
		super.setUp();  //invoca al metodo setUp d ela clase padre
	}

	@Test
	public void testInsertar() throws Exception{
		String url = "/pagos/";
		Pago pago = new Pago();
		pago.setFechaPago(new Date());
		pago.setMonto(5000);
		
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setId(3);
		
		pago.setInscripcion(inscripcion); //Se asocia la inscripcion al pago
		ObjectMapper mapper = new ObjectMapper();
		String pagojson = mapper.writeValueAsString(pago);
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.post(url).
				contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(pagojson)).andReturn();
		int codigo = resultado.getResponse().getStatus();
		assertTrue(codigo == 200);
		
	}

}
