package com.ubosque.mintic.frontend.logica;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ubosque.mintic.frontend.dao.ProveedorDAO;
import com.ubosque.mintic.frontend.dto.ProveedorDTO;


public class ProveedorLogica {
	private ProveedorDAO dao;
	
	public boolean crearProveedor(ProveedorDTO dto) {
		dao = new ProveedorDAO();
		return dao.crearProveedor(dto);
	}
	
	//public boolean ingresarCedula(ProveedorDTO dto) {
	//	dao = new ProveedorDAO();
	//	return dao.consultarCedula(dto);
	//}
	
	public ProveedorDTO ingresarNit(ProveedorDTO dto) {
		dao = new ProveedorDAO();
		ProveedorDTO prov = new ProveedorDTO();
		String usuarioJson = dao.consultarNit(dto);
        Type listType = new TypeToken<ProveedorDTO>(){}.getType();
        Gson gson = new Gson();
        prov = gson.fromJson(usuarioJson, listType);
		//return dao.consultarCedula(dto);
        return prov;
	}
	
	public boolean actualizarProveedor(ProveedorDTO dto) {
		dao = new ProveedorDAO();
		return dao.actualizarProveedor(dto);
	}
	
	public boolean borrarProveedor(ProveedorDTO dto) {
		dao = new ProveedorDAO();
		return dao.eliminarProveedor(dto);
	}
}
