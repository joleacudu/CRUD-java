package com.ubosque.mintic.backend.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubosque.mintic.backend.entidad.Cliente;
import com.ubosque.mintic.backend.entidad.Usuario;
import com.ubosque.mintic.backend.servicio.ClienteServicio;

@RestController
@RequestMapping(path = "clientes")

public class ClienteControlador {
	
	@Autowired
	private ClienteServicio servicio;
	
	@PostMapping(path = "/consulta")
	//CONSULTA DE CLIENTE POR NUMERO DE CEDULA//
		public @ResponseBody ResponseEntity consultarCliente(@RequestBody Cliente clienteNuevo) {
				
			Cliente clienteBuscado = servicio.buscarClienteServicio(clienteNuevo.getCedulaCliente());

			ResponseEntity respuesta = null;
			
			if(clienteBuscado != null) {				
				respuesta = new ResponseEntity(clienteBuscado,HttpStatus.OK);
				System.out.println(clienteBuscado);
			}else {
				respuesta = new ResponseEntity("no encontrado",HttpStatus.NOT_ACCEPTABLE);
			}
			
			return respuesta;
		}
		
	@PostMapping (path = "/listado")
	public  @ResponseBody ResponseEntity listarClientes() {
		
		List<Cliente> lista = servicio.consultarClienteServicio();
		ResponseEntity respuesta = new ResponseEntity(lista,HttpStatus.OK);
		return respuesta;
	}
	
		@PostMapping
		//CREACION DE CLIENTE//
		public @ResponseBody ResponseEntity crearCliente(@RequestBody Cliente clienteNuevo) {
			
			boolean respuestaServicio = servicio.crearClienteServicio(clienteNuevo);
			
			ResponseEntity respuesta = null;
			if(respuestaServicio) {
				respuesta = new ResponseEntity(HttpStatus.OK);
			}else {
				respuesta = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
			}
			
			return respuesta;
		}


	
		@PostMapping (path = "/actualizar")
		//ACTUALIZACION DE DATOS DE CLIENTE///////
		public @ResponseBody ResponseEntity actualizarCliente(@RequestBody Cliente clienteCambiado) {
			
			boolean respuestaServicio = servicio.actualizarClienteServicio(clienteCambiado);
			
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
		public @ResponseBody ResponseEntity borrarCliente(@RequestBody Cliente clienteNuevo) {
			
			boolean respuestaServicio = servicio.borrarClienteServicio(clienteNuevo.getCedulaCliente());
			
			ResponseEntity respuesta = null;
			if(respuestaServicio) {
				respuesta = new ResponseEntity("BORRADO",HttpStatus.OK);
			}else {
				respuesta = new ResponseEntity("NO BORRADO",HttpStatus.NOT_ACCEPTABLE);
			}
			
			return respuesta;
		}
}
