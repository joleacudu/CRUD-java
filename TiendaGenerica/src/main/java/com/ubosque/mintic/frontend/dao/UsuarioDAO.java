package com.ubosque.mintic.frontend.dao;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Entity;
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
import com.ubosque.mintic.frontend.dto.UsuarioDTO;



public class UsuarioDAO {
	
	public static void main(String[] args) {
		//UsuarioDTO dto = new UsuarioDTO();
		//dto.setCedulaUsuario("202020");
		//dto.setEmailUsuario("correo@mail.com");
		//dto.setNombreUsuario("Nombre Correo");
		//dto.setUsuario("admininicial");
		//dto.setPassword("admin123456");
		//UsuarioDAO dao = new UsuarioDAO();
		//dao.crearUsuario(dto);
		//dao.listarUsuarios();
		//dao.consultarPorUsuarioYContrasena(dto);
		//dao.consultarCedula(dto);
	}
	
	/////LOGIN//////
	public String consultarPorUsuarioYContrasena(UsuarioDTO dto) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/login");
		String respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE),String.class);
		//if(respuesta != null) {
			//System.out.println("logeo");
			//return respuesta;
		//}else if(respuesta == null) {
			//return false;
		//}
		return respuesta;		
	}
/////CONSULTA USUARIO POR CEDULA///////	
	public String consultarCedula(UsuarioDTO dto) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/consulta");		
		//Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		String respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE),String.class);
		//if(respuesta.getStatus()==200) {
		//	System.out.println("consultado");			
		//	return true;
		//}else if(respuesta.getStatus()==204) {
		//	return false;
		//}
		return respuesta;		
	}
	


	
	///////CREACION USUARIO //////////
	public boolean crearUsuario(UsuarioDTO usr) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(usr);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios");
		Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==200) {
			System.out.println("creado");
			return true;
		}
		return false;
	}
/////ACTUALIZAR USUARIO ///////		
	public boolean actualizarUsuario(UsuarioDTO usr) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(usr);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/actualizar");
		Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==200) {
			System.out.println("actualizado");
			return true;
		}
		return false;
	}
	
/////ELIMINAR USUARIO POR CEDULA///////	
	public boolean eliminarUsuario(UsuarioDTO dto) {
		Gson gson = new Gson();
		String usuarioJSON = gson.toJson(dto);
		
		Client cliente = ClientBuilder.newClient();
		WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/borrar");
		Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
		if(respuesta.getStatus()==200) {
			System.out.println("eliminado");
			return true;
		}
		return false;
	}
////LISTAR USUARIOS ////	
	//public String listarUsuarios(){
		//Client cliente = ClientBuilder.newClient();
		//WebTarget servicioREST = cliente.target("http://localhost:5000/usuarios/listado");
		//String respuesta = servicioREST.request().get(String.class);//devuelve es un arreglo
		
		
		//return respuesta;
	//}
	public static ArrayList<UsuarioDTO> getJSON() throws IOException, ParseException{
		URL url = new URL("http://localhost:5000/usuarios/listado");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for(int i=0; i<inp.length; i++) {
			json += (char)inp[i];
		}
		ArrayList<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		lista = parsingUsuarios(json);
		http.disconnect();
		return lista;
		
	}
	
	public static ArrayList<UsuarioDTO> parsingUsuarios(String json) throws ParseException{
		JSONParser jsonParser = new JSONParser();
		ArrayList<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		JSONArray usuarios = (JSONArray) jsonParser.parse(json);
		Iterator i = usuarios.iterator();
		while(i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			UsuarioDTO usuario = new UsuarioDTO();
			usuario.setCedulaUsuario(innerObj.get("cedulaUsuario").toString());
			usuario.setEmailUsuario(innerObj.get("emailUsuario").toString());
			usuario.setNombreUsuario(innerObj.get("nombreUsuario").toString());
			usuario.setPassword(innerObj.get("password").toString());
			usuario.setUsuario(innerObj.get("usuario").toString());
			lista.add(usuario);
		}
		return lista;
	}
	
	


}