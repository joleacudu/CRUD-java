package com.ubosque.mintic.backend.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubosque.mintic.backend.entidad.Producto;
import com.ubosque.mintic.backend.entidad.Proveedore;
import com.ubosque.mintic.backend.entidad.Usuario;
import com.ubosque.mintic.backend.repositorio.ProductoRepositorio;
import com.ubosque.mintic.backend.repositorio.UsuarioRepositorio;

@Service
public class ProductoServicio {
	@Autowired
	private ProductoRepositorio repositorio;
	
	public boolean crearProductosServicio(List<Producto> productos ){
		//List lista = (List) 
		repositorio.saveAll(productos);
		return true;
	}
	public Producto buscarProductoServicio(String codigo) {
		Producto productoConsulta = repositorio.findByCodigoProducto(codigo);
		return productoConsulta;
	}
}
