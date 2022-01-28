package com.ubosque.mintic.frontend.logica;

import java.io.IOException;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ubosque.mintic.frontend.dao.UsuarioDAO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;



public class UsuarioLogica {
	
	private UsuarioDAO dao;
	
	public UsuarioDTO ingresar(UsuarioDTO dto) {
		//dao = new UsuarioDAO();
		//return dao.consultarPorUsuarioYContrasena(dto);
		dao = new UsuarioDAO();
		UsuarioDTO uss = new UsuarioDTO();
		String usuarioJson = dao.consultarPorUsuarioYContrasena(dto);
        Type listType = new TypeToken<UsuarioDTO>(){}.getType();
        Gson gson = new Gson();
        uss = gson.fromJson(usuarioJson, listType);
		//return dao.consultarCedula(dto);
        return uss;
		
	}
	
	public boolean crearUsuario(UsuarioDTO dto) {
		dao = new UsuarioDAO();
		return dao. crearUsuario(dto);
	}
	
	public UsuarioDTO ingresarCedula(UsuarioDTO dto) {
		dao = new UsuarioDAO();
		UsuarioDTO uss = new UsuarioDTO();
		String usuarioJson = dao.consultarCedula(dto);
        Type listType = new TypeToken<UsuarioDTO>(){}.getType();
        Gson gson = new Gson();
        uss = gson.fromJson(usuarioJson, listType);
		//return dao.consultarCedula(dto);
        return uss;
	}
	
	public boolean actualizarUsuarios(UsuarioDTO dto) {
		dao = new UsuarioDAO();
		return dao.actualizarUsuario(dto);
	}
	
	public boolean borrarUsuario(UsuarioDTO dto) {
		dao = new UsuarioDAO();
		return dao.eliminarUsuario(dto);
	}
	
	//public ArrayList<UsuarioDTO> listar(){
		//dao = new UsuarioDAO();
		//String json = dao.listarUsuarios();
		
		//ArrayList<UsuarioDTO> lista;
		//if(json  != null) {
       //     Type listType = new TypeToken<ArrayList<UsuarioDTO>>(){}.getType();
       //     Gson gson = new Gson();
       //     lista = gson.fromJson(json, listType);
       // }else {
       // 	lista = new ArrayList<UsuarioDTO>();
       // }
		//return lista;
	//}
	
	public ArrayList<UsuarioDTO> listar() throws IOException, ParseException{
		dao = new UsuarioDAO();
		ArrayList<UsuarioDTO> lista = dao.getJSON();
		return lista;
	}
}
