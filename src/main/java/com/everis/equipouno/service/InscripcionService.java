package com.everis.equipouno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.equipouno.model.Inscripcion;
import com.everis.equipouno.repository.AlumnoRepository;
import com.everis.equipouno.repository.InscripcionRepository;


@Service
public class InscripcionService {

	@Autowired
	private InscripcionRepository inscripcionRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	public List<Inscripcion> listar()
	{
		return inscripcionRepository.findAll();
	}
	
	public Inscripcion insetar(Inscripcion inscripcion)
	{
		if(inscripcion.getAlumno().getId() == null) {
			alumnoRepository.save(inscripcion.getAlumno());
		}
		return inscripcionRepository.save(inscripcion); //INSERT TO

	}
	
	public Inscripcion actualizar(Inscripcion inscripcion)
	{
		return inscripcionRepository.save(inscripcion); //INSERT TO

	}
	
	public boolean eliminar(int idInscripcion)
	{
		Inscripcion encontrada = inscripcionRepository.findById(idInscripcion).get();
		if(encontrada != null)
		{
			inscripcionRepository.delete(encontrada);
			return true;
		}else
		{
			return false;
		}
		
	}
	
}
