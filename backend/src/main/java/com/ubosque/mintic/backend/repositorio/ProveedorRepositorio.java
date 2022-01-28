package com.ubosque.mintic.backend.repositorio;

import org.springframework.stereotype.Repository;

import com.ubosque.mintic.backend.entidad.Proveedore;

import org.springframework.data.repository.CrudRepository;

public interface ProveedorRepositorio extends CrudRepository<Proveedore, String>{
	
	//public Usuario findByUsuarioAndPassword(String usuario, String password);//funcion que busca por usuario y contrasena - LOGIN
	
	public Proveedore findByNitProveedor(String nit); //funcion que busca por numero de nit

}
