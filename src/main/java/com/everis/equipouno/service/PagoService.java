package com.everis.equipouno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.equipouno.model.Pago;
import com.everis.equipouno.repository.PagoRepository;

@Service
public class PagoService {
	
	@Autowired
	private PagoRepository pagoRepository;
	
	public List<Pago> listar(){
		return pagoRepository.findAll();
	}
	
	public Pago insertar(Pago pago) {
		return pagoRepository.save(pago);
	}
	
	public Pago actualizar(Pago pago) {
		return pagoRepository.save(pago);
	}
	
	public boolean eliminar(int id) {
		Pago encontrada = pagoRepository.findById(id).get();
		if(encontrada != null) {
			pagoRepository.delete(encontrada);
			return true;
		}else {
			return false;
		}
	}
}
