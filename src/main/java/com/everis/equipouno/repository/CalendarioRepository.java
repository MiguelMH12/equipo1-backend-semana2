package com.everis.equipouno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.equipouno.model.Calendario;


@Repository
public interface CalendarioRepository extends JpaRepository<Calendario,Integer>{
	
}
