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

import com.everis.equipouno.model.Pago;
import com.everis.equipouno.service.PagoService;

@RestController
@RequestMapping("pagos")
public class PagoController {
	
	@Autowired
	private PagoService pagoService;
	
	@GetMapping("/")
	public List<Pago> listar(){
		return pagoService.listar();
	}
	
	@PostMapping("/")
	public Pago insertar(@RequestBody Pago pago) {
		return pagoService.insertar(pago);
	}
	
	@PutMapping("/")
	public Pago actualizar(@RequestBody Pago pago) {
		return pagoService.actualizar(pago);
	}
	
	@DeleteMapping("/{id}")
	public boolean eliminar(@PathVariable int id) {
		return pagoService.eliminar(id);
	}
}
