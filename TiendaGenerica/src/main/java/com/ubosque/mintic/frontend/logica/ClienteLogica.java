package com.ubosque.mintic.frontend.logica;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ubosque.mintic.frontend.dao.ClienteDAO;
import com.ubosque.mintic.frontend.dao.UsuarioDAO;
import com.ubosque.mintic.frontend.dto.ClienteDTO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;

public class ClienteLogica {
	
	private ClienteDAO dao;
		
	public boolean crearCliente(ClienteDTO dto) {
		dao = new ClienteDAO();
		return dao.crearCliente(dto);
	}
	
	//public boolean ingresarCedula(ClienteDTO dto) {
	//	dao = new ClienteDAO();
	///return dao.consultarCedula(dto);
	//}
	
	public ClienteDTO ingresarCedula(ClienteDTO dto) {
		dao = new ClienteDAO();
		ClienteDTO uss = new ClienteDTO();
		String usuarioJson = dao.consultarCedula(dto);
        Type listType = new TypeToken<ClienteDTO>(){}.getType();
        Gson gson = new Gson();
        uss = gson.fromJson(usuarioJson, listType);
		//return dao.consultarCedula(dto);
        return uss;
	}
	
	public boolean actualizarCliente(ClienteDTO dto) {
		dao = new ClienteDAO();
		return dao.actualizarCliente(dto);
	}
	
	public boolean borrarCliente(ClienteDTO dto) {
		dao = new ClienteDAO();
		return dao.eliminarCliente(dto);
	}

	public ArrayList<ClienteDTO> listar() throws IOException, ParseException{
		dao = new ClienteDAO();
		ArrayList<ClienteDTO> lista = dao.getJSON();
		return lista;
	}
}
