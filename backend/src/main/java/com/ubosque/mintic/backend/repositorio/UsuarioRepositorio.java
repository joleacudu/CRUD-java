package com.ubosque.mintic.backend.repositorio;

import org.springframework.stereotype.Repository;

import com.ubosque.mintic.backend.entidad.Usuario;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, String>{
	
	public Usuario findByUsuarioAndPassword(String usuario, String password);//funcion que busca por usuario y contrasena - LOGIN
	
	public Usuario findByCedulaUsuario(String cedula); //funcion que busca por numero de cedula
	

}
