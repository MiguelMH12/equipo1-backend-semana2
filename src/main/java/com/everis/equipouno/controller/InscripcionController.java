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

import com.everis.equipouno.model.Inscripcion;
import com.everis.equipouno.service.InscripcionService;

@RestController
@RequestMapping("inscripcion")
public class InscripcionController {

	@Autowired
	private InscripcionService inscripcionService;

	@GetMapping("/")
	public List<Inscripcion> listar()
	{
		return inscripcionService.listar();
	}
	
	@PostMapping("/") // conocido como Verbos HTTP
	public Inscripcion insertar(@RequestBody Inscripcion inscripcion)
	{
		return inscripcionService.insetar(inscripcion);		
	}
	
	@PutMapping("/") // conocido como Verbos HTTP
	public Inscripcion actualizar(@RequestBody Inscripcion inscripcion)
	{
		return inscripcionService.actualizar(inscripcion);		
	}
	
	@DeleteMapping("/{idInscripcion}")
	public boolean eliminiar(@PathVariable int idInscripcion)
	{
		return inscripcionService.eliminar(idInscripcion);
	}
	
	
}
