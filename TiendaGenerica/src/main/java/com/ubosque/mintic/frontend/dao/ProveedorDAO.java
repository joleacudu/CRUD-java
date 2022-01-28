package com.ubosque.mintic.frontend.dao;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.ubosque.mintic.frontend.dto.ClienteDTO;
import com.ubosque.mintic.frontend.dto.ProveedorDTO;


public class ProveedorDAO {
/////CONSULTA PROVEEDOR POR NIT///////	
	public String consultarNit(ProveedorDTO dto) {
		Gson gson = new Gson();
		String proveedorJSON = gson.toJson(dto);
		
		Client proveedor = ClientBuilder.newClient();
		WebTarget servicioREST = proveedor.target("http://localhost:5000/proveedore/consulta");		
		String respuesta = servicioREST.request().post(Entity.entity(proveedorJSON, MediaType.APPLICATION_JSON_TYPE),String.class);
		//Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		return respuesta;
	
	}
	


	
	///////CREACION PROVEEDOR //////////
	public boolean crearProveedor(ProveedorDTO pro) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(pro);
		
		Client proveedor = ClientBuilder.newClient();
		WebTarget servicioREST = proveedor.target("http://localhost:5000/proveedore");
		Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==200) {
			System.out.println("creado proveedor");
			return true;
		}
		return false;
	}
/////ACTUALIZAR PROVEEDOR ///////		
	public boolean actualizarProveedor(ProveedorDTO pro) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(pro);
		
		Client proveedor = ClientBuilder.newClient();
		WebTarget servicioREST = proveedor.target("http://localhost:5000/proveedore/actualizar");
		Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==200) {
			System.out.println("actualizado proveedor");
			return true;
		}
		return false;
	}
	
/////ELIMINAR PROVEEDOR POR NIT///////	
	public boolean eliminarProveedor(ProveedorDTO dto) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(dto);
		
		Client proveedor = ClientBuilder.newClient();
		WebTarget servicioREST = proveedor.target("http://localhost:5000/proveedore/borrar");
		Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==200) {
			System.out.println("eliminado proveedor");
			return true;
		}
		return false;
	}
}
