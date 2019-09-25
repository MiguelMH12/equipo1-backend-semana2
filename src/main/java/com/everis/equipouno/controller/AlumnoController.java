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

import com.everis.equipouno.model.Alumno;
import com.everis.equipouno.service.AlumnoService;

@RestController
@RequestMapping("alumnos")
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoServicio;
	
	@GetMapping("/")
	public List<Alumno> listar(){
		return alumnoServicio.listar();
	}
	
	@PostMapping("/")
	public Alumno insertar(@RequestBody Alumno alumno) {
		return alumnoServicio.insertar(alumno);
	}
	
	@PutMapping("/")
	public Alumno actualizar(@RequestBody Alumno alumno) {
		return alumnoServicio.actualizar(alumno);
	}
	
	@DeleteMapping("/{id}")
	public boolean borrar(@PathVariable int id) {
		return alumnoServicio.borrar(id);
	}

}
