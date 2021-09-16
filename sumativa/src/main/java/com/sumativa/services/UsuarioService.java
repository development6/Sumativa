package com.sumativa.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sumativa.models.Usuario;
import com.sumativa.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository ur;
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.ur=usuarioRepository;
	}

	public Usuario insertarUsuario(@Valid Usuario usuario) {
		// TODO Auto-generated method stub
		return ur.save(usuario);
	}
	
	public ArrayList<Usuario> findAll() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	public void eliminarUsuario(Long id) {
		// TODO Auto-generated method stub
		ur.deleteById(id);
	}

	
	
	
	
	
	
	public Usuario buscarUsuario(Long id) {
		Optional<Usuario> oUsuario=ur.findById(id);
		if(oUsuario.isPresent()) {
			return oUsuario.get();
		}

		return null;
	}

	public void modificarUsuario(@Valid Usuario usuario) {
		// TODO Auto-generated method stub
		ur.save(usuario);
	}

	

}
