package com.ubosque.mintic.backend.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubosque.mintic.backend.entidad.Cliente;
import com.ubosque.mintic.backend.entidad.Usuario;
import com.ubosque.mintic.backend.repositorio.ClienteRepositorio;
import com.ubosque.mintic.backend.repositorio.ClienteRepositorio;

@Service

public class ClienteServicio {
	
	@Autowired
	private ClienteRepositorio repositorio;
	
	public boolean crearClienteServicio(Cliente clienteNuevo) {
		repositorio.save(clienteNuevo);
		return true;
	}
	

	public Cliente buscarClienteServicio(String cedula) {
		Cliente clienteConsulta = repositorio.findByCedulaCliente(cedula);
		return clienteConsulta;
	}
	
	public List<Cliente> consultarClienteServicio(){
		
		List lista = (List) repositorio.findAll();
		return lista;
	}
	
	public boolean actualizarClienteServicio(Cliente clienteCambiado) {
			repositorio.save(clienteCambiado);
			return true;
		
		
	}
	
	public boolean borrarClienteServicio(String cedula) {
			repositorio.deleteById(cedula);
	
			return true;
		
		
	}

}
