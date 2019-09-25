package com.everis.equipouno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.equipouno.repository.CalendarioRepository;
import com.everis.equipouno.model.Calendario;
import com.everis.equipouno.model.Inscripcion;



@Service
public class CalendarioService {

	@Autowired
	private CalendarioRepository calendarioRepository;
	
	public List<Calendario> listar(){
		return calendarioRepository.findAll();
	}
	
	public Calendario insertar(Calendario calendario) {
		return calendarioRepository.save(calendario);
	}
	
	public Calendario actualizar(Calendario calendario) {
		return calendarioRepository.save(calendario);
	}
	
	public boolean eliminar(int idCalendario) {
		Calendario encontrada=calendarioRepository.findById(idCalendario).get();
		if(encontrada != null) {
			calendarioRepository.delete(encontrada);
			return true;
		}else {
			return false;
		}
	}

	public List<Inscripcion> consultarInscripciones(int idCalendario) {
		// TODO Auto-generated method stub
		Calendario encontrado=calendarioRepository.findById(idCalendario).get();
		List<Inscripcion> inscripciones = null;
		if(encontrado != null) {
			//getInscripcions al ser la lista LAZY, en este momento es cuando se realiza el SELECT
			//a la tabla inscripcion
			inscripciones = encontrado.getInscripcions();
		}
		return inscripciones;
	}
	

	
}
