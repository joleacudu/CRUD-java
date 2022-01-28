package com.ubosque.mintic.backend.controlador;

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
import com.ubosque.mintic.backend.entidad.Proveedore;
import com.ubosque.mintic.backend.servicio.ProveedorServicio;

@RestController
@RequestMapping(path = "proveedore")
public class ProveedorControlador {

		@Autowired
		private ProveedorServicio servicio;
		
		@PostMapping(path = "/consulta")
		//CONSULTA DE PROVEEDOR POR NUMERO DE NIT
		public @ResponseBody ResponseEntity consultarProveedor(@RequestBody Proveedore proveedorNuevo) {
			
			Proveedore proveedorBuscado = servicio.buscarProveedorServicio(proveedorNuevo.getNitProveedor());
			
			ResponseEntity respuesta = null;	
			
			if(proveedorBuscado != null) {
				respuesta = new ResponseEntity(proveedorBuscado,HttpStatus.OK);
				
			}else {
				respuesta = new ResponseEntity("no encontrado",HttpStatus.NOT_ACCEPTABLE);
			}
			
			return respuesta;
		}
		
		
		@PostMapping 
		///CREACION DE PROVEEDOR///
		public @ResponseBody ResponseEntity crearProveedor(@RequestBody Proveedore proveedorNuevo) {
			
			boolean respuestaServicio = servicio.crearProveedorServicio(proveedorNuevo);
			
			ResponseEntity respuesta = null;
			if(respuestaServicio) {
				respuesta = new ResponseEntity(HttpStatus.OK);
			}else {
				respuesta = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
			}
			
			return respuesta;
		}
		
		
		
	
		@PostMapping (path = "/actualizar")
		//ACTUALIZACION DE DATOS DE PROVEEDOR///
		public @ResponseBody ResponseEntity actualizarProveedor(@RequestBody Proveedore proveedorCambiado) {
			
			boolean respuestaServicio = servicio.actualizarProveedorServicio(proveedorCambiado);
			
			ResponseEntity respuesta = null;
			if(respuestaServicio) {
				respuesta = new ResponseEntity("ACTUALIZADO",HttpStatus.OK);
			}else {
				respuesta = new ResponseEntity("NO ACTUALIZADO",HttpStatus.NOT_ACCEPTABLE);
			}
			
			return respuesta;
		}
		
		
		@PostMapping (path = "/borrar")
		//BORRADO DE DATOS DE PROVEEDOR POR NUMERO DE CEDULA//////////////////
		public @ResponseBody ResponseEntity borrarProveedor(@RequestBody Proveedore proveedorNuevo) {
			
			boolean respuestaServicio = servicio.borrarProveedorServicio(proveedorNuevo.getNitProveedor());
			
			ResponseEntity respuesta = null;
			if(respuestaServicio) {
				respuesta = new ResponseEntity("BORRADO",HttpStatus.OK);
			}else {
				respuesta = new ResponseEntity("NO BORRADO",HttpStatus.NOT_ACCEPTABLE);
			}
			
			return respuesta;
		}
		

		
}
