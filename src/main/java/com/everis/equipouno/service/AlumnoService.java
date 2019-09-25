package com.everis.equipouno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.equipouno.model.Alumno;
import com.everis.equipouno.repository.AlumnoRepository;

@Service
public class AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepositorio;
	
	public List<Alumno> listar(){
		return alumnoRepositorio.findAll();
	}
	
	public Alumno insertar(Alumno alumno) {
		return alumnoRepositorio.save(alumno);
	}
	
	public Alumno actualizar(Alumno alumno) {
		return alumnoRepositorio.save(alumno);
	}
	
	public boolean borrar (int id) {
		if(alumnoRepositorio.existsById(id)) {
			alumnoRepositorio.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}
