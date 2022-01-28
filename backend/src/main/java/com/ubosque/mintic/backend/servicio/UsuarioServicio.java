package com.ubosque.mintic.backend.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubosque.mintic.backend.entidad.Usuario;
import com.ubosque.mintic.backend.repositorio.UsuarioRepositorio;


@Service
public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public boolean crearUsuarioServicio(Usuario usuarioNuevo) {
		repositorio.save(usuarioNuevo);
		return true;
	}
	
	public Usuario autenticarUsuarioServicio(String usuario, String password) {
		Usuario usuarioBuscado = repositorio.findByUsuarioAndPassword(usuario, password);
		return usuarioBuscado;
	}

	public Usuario buscarUsuarioServicio(String cedula) {
		Usuario usuarioConsulta = repositorio.findByCedulaUsuario(cedula);
		return usuarioConsulta;
	}

	
	public List<Usuario> consultarUsuariosSevicio(){
		
		List lista = (List) repositorio.findAll();
		return lista;
	}
	
	
	
	public boolean actualizarUsuarioServicio(Usuario usuarioCambiado) {
			repositorio.save(usuarioCambiado);
			return true;
		
		
	}
	
	public boolean borrarUsuarioServicio(String cedula) {
			repositorio.deleteById(cedula);
	
			return true;
		
		
	}

	
}
