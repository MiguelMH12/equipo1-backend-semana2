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

import com.everis.equipouno.model.Usuario;
import com.everis.equipouno.service.UsuarioService;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioServicio;
	
	@GetMapping("/")
	public List<Usuario> listar(){
		return usuarioServicio.listar();
	}
	
	@PostMapping("/")
	public Usuario insertar(@RequestBody Usuario usuario) {
		return usuarioServicio.insertar(usuario);
	}
	
	@PutMapping("/")
	public Usuario actualizar(@RequestBody Usuario usuario) {
		return usuarioServicio.actualizar(usuario);
	}
	
	@DeleteMapping("/{idusuario}")
	public boolean borrar(@PathVariable int idusuario) {
		return usuarioServicio.eliminar(idusuario);
	}
}
