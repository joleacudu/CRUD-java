package com.ubosque.mintic.backend.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubosque.mintic.backend.entidad.Proveedore;
import com.ubosque.mintic.backend.repositorio.ProveedorRepositorio;


@Service

public class ProveedorServicio {
	@Autowired
	private ProveedorRepositorio repositorio;
	
	public boolean crearProveedorServicio(Proveedore proveedorNuevo) {
		repositorio.save(proveedorNuevo);
		return true;
	}
	
	public Proveedore buscarProveedorServicio(String nit) {
		Proveedore proveedorConsulta = repositorio.findByNitProveedor(nit);
		return proveedorConsulta;
	}
	
	public boolean actualizarProveedorServicio(Proveedore proveedorCambiado) {
			repositorio.save(proveedorCambiado);
			return true;
		
		
	}
	
	public boolean borrarProveedorServicio(String nit) {
			repositorio.deleteById(nit);
	
			return true;
		
		
	}
	

	

}
