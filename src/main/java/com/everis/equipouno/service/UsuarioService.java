package com.everis.equipouno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.equipouno.model.Usuario;
import com.everis.equipouno.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	public List<Usuario> listar(){
		return usuarioRepositorio.findAll();
	}
	
	public Usuario insertar(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}
	
	public Usuario actualizar(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}
	
	public boolean eliminar(int idusuario) {
		if(usuarioRepositorio.existsById(idusuario)) {
			usuarioRepositorio.deleteById(idusuario);
			return true;
		}else {
			return false;
		}
	}
}
