package com.everis.equipouno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.equipouno.model.Curso;
import com.everis.equipouno.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> listar(){
		return cursoRepository.findAll();
	}
	
	public Curso insertar(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public Curso actualizar(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	
	public boolean borrar(int id) {
		if(cursoRepository.existsById(id)) {
			cursoRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

}
