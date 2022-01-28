package com.ubosque.mintic.backend.repositorio;

import org.springframework.stereotype.Repository;

import com.ubosque.mintic.backend.entidad.Cliente;
import com.ubosque.mintic.backend.entidad.Usuario;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, String>{
	
//public Usuario findByClienteAndPassword(String usuario, String password);//funcion que busca por usuario y contrasena - LOGIN
	
	public Cliente findByCedulaCliente(String cedula); //funcion que busca por numero de cedula

}
