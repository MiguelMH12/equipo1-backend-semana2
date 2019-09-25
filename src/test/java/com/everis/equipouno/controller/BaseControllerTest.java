package com.everis.equipouno.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.everis.equipouno.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public abstract class BaseControllerTest {  //abstracta paara que se pueda usar solo por herencia
	
		protected MockMvc mvc;  //Solo lo usan las clases hijas
		@Autowired
		private WebApplicationContext webApplicationContext;
		@Before
		public void setUp() {
			mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		}

}
