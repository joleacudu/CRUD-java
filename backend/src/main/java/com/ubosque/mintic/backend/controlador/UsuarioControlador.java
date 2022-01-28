package com.ubosque.mintic.backend.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubosque.mintic.backend.entidad.Usuario;
import com.ubosque.mintic.backend.servicio.UsuarioServicio;

@RestController
@RequestMapping(path = "usuarios")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioServicio servicio;
	
	@PostMapping(path = "/consulta")

	//CONSULTA DE USUARIO POR NUMERO DE CEDULA//
	public @ResponseBody ResponseEntity consultarUsuario(@RequestBody Usuario usuarioNuevo) {
			
		Usuario usuarioBuscado = servicio.buscarUsuarioServicio(usuarioNuevo.getCedulaUsuario());

		ResponseEntity respuesta = null;
		
		if(usuarioBuscado != null) {
			respuesta = new ResponseEntity(usuarioBuscado ,HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("no encontrado",HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
	
	@PostMapping
	//CREACION DE USUARIO//
	public @ResponseBody ResponseEntity crearUsuario(@RequestBody Usuario usuarioNuevo) {
		
		boolean respuestaServicio = servicio.crearUsuarioServicio(usuarioNuevo);
		
		ResponseEntity respuesta = null;
		if(respuestaServicio) {
			respuesta = new ResponseEntity(HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
	
	/////LISTAR USUARIOS PARA REPORTE/////
	
	@PostMapping (path = "/listado")
	public  @ResponseBody ResponseEntity listarUsuarios() {
		
		List<Usuario> lista = servicio.consultarUsuariosSevicio();
		ResponseEntity respuesta = new ResponseEntity(lista,HttpStatus.OK);
		return respuesta;
	}
	

	
	@PostMapping(path = "/login")
	//CONSULTA DE USUARIO POR USUARIO Y CONTRASENA - LOGIN//
	public @ResponseBody ResponseEntity autenticarUsuario(@RequestBody Usuario usuarioNuevo) {
	
		Usuario usuarioAutenticado = servicio.autenticarUsuarioServicio(usuarioNuevo.getUsuario(), usuarioNuevo.getPassword());
		
		ResponseEntity respuesta = null;
		if(usuarioAutenticado != null) {
			respuesta = new ResponseEntity(usuarioAutenticado,HttpStatus.OK);
			
		}else {
			respuesta = new ResponseEntity("CREDENCIALES INCONRRECTAS",HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}

	
	@PostMapping (path = "/actualizar")
	//ACTUALIZACION DE DATOS DE USUARIO/////
	public @ResponseBody ResponseEntity actualizarUsuario(@RequestBody Usuario usuarioCambiado) {
		
		boolean respuestaServicio = servicio.actualizarUsuarioServicio(usuarioCambiado);
		
		ResponseEntity respuesta = null;
		if(respuestaServicio) {
			respuesta = new ResponseEntity("ACTUALIZADO",HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("NO ACTUALIZADO",HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
	
	
	@PostMapping (path = "/borrar")
	//BORRADO DE DATOS DE USUARIO POR NUMERO DE CEDULA
	public @ResponseBody ResponseEntity borrarUsuario(@RequestBody Usuario usuarioNuevo) {
		
		boolean respuestaServicio = servicio.borrarUsuarioServicio(usuarioNuevo.getCedulaUsuario());
		
		ResponseEntity respuesta = null;
		if(respuestaServicio) {
			respuesta = new ResponseEntity("BORRADO",HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity("NO BORRADO",HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
	

	

}
