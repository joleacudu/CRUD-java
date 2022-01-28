package com.ubosque.mintic.backend.repositorio;

import org.springframework.stereotype.Repository;

import com.ubosque.mintic.backend.entidad.Producto;
import com.ubosque.mintic.backend.entidad.Usuario;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto, String> {

	public Producto findByCodigoProducto(String codigo); //funcion que busca por numero de cedula
	
}
