package com.everis.equipouno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.equipouno.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository <Alumno, Integer>{

}
