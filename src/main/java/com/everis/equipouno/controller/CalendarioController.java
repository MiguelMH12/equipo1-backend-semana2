package com.everis.equipouno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.equipouno.model.Calendario;
import com.everis.equipouno.model.Inscripcion;
import com.everis.equipouno.service.CalendarioService;

@RestController
@RequestMapping("calendario")
public class CalendarioController {

	@Autowired
	private CalendarioService calendarioService;
	
	@GetMapping("/{idCalendario}")
	public List<Inscripcion> consultarInscripciones(@PathVariable int idCalendario){
		return calendarioService.consultarInscripciones(idCalendario);
	}
	
	@GetMapping("/")
	public List<Calendario> listar() {
		return calendarioService.listar();
	}
	
	@PostMapping("/")
	public Calendario insertar(@RequestBody Calendario calendario) {
		return calendarioService.insertar(calendario);
	}
	@PutMapping("/")
	public Calendario actualizar(@RequestBody Calendario calendario) {
		return calendarioService.actualizar(calendario);
	}
	@DeleteMapping("/{idCalendario}")
	public boolean eliminar(@PathVariable int idCalendario) {
		 return calendarioService.eliminar(idCalendario);
	}
}
