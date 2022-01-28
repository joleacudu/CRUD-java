package com.ubosque.mintic.frontend.dao;

import javax.ws.rs.client.Entity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.ubosque.mintic.frontend.dto.ClienteDTO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;


public class ClienteDAO {
	public static void main(String[] args) {

	}
	
	
/////CONSULTA USUARIO POR CEDULA///////	
	public String consultarCedula(ClienteDTO dto) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/clientes/consulta");
		String respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE),String.class);
		//Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		return respuesta;
			
	}
	


	
	///////CREACION USUARIO //////////
	public boolean crearCliente(ClienteDTO cli) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(cli);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/clientes");
		Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==200) {
			System.out.println("creado cliente");
			return true;
		}
		return false;
	}
/////ACTUALIZAR CLIENTE ///////		
	public boolean actualizarCliente(ClienteDTO cli) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(cli);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/clientes/actualizar");
		Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==200) {
			System.out.println("actualizado cliente");
			return true;
		}
		return false;
	}
	
/////ELIMINAR CLIENTE POR CEDULA///////	
	public boolean eliminarCliente(ClienteDTO dto) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/clientes/borrar");
		Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==200) {
			System.out.println("eliminado cliente");
			return true;
		}
		return false;
	}
	
	public static ArrayList<ClienteDTO> getJSON() throws IOException, ParseException{
		URL url = new URL("http://localhost:5000/clientes/listado");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for(int i=0; i<inp.length; i++) {
			json += (char)inp[i];
		}
		ArrayList<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		lista = parsingClientes(json);
		http.disconnect();
		return lista;
		
	}
	
	public static ArrayList<ClienteDTO> parsingClientes(String json) throws ParseException{
		JSONParser jsonParser = new JSONParser();
		ArrayList<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		JSONArray clientes = (JSONArray) jsonParser.parse(json);
		Iterator i = clientes.iterator();
		while(i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			ClienteDTO cliente = new ClienteDTO();
			cliente.setCedulaCliente(innerObj.get("cedulaCliente").toString());
			cliente.setDireccionCliente(innerObj.get("direccionCliente").toString());
			cliente.setEmailCliente(innerObj.get("emailCliente").toString());
			cliente.setNombreCliente(innerObj.get("nombreCliente").toString());
			cliente.setTelefonoCliente(innerObj.get("telefonoCliente").toString());
			lista.add(cliente);
		}
		return lista;
	}
}
