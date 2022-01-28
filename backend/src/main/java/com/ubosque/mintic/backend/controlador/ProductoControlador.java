package com.ubosque.mintic.backend.controlador;

import java.util.ArrayList;
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

import com.ubosque.mintic.backend.entidad.Producto;
import com.ubosque.mintic.backend.entidad.Proveedore;
import com.ubosque.mintic.backend.servicio.ProductoServicio;

@RestController
@RequestMapping(path = "productos")

public class ProductoControlador {
	@Autowired
	private ProductoServicio servicio;
	
	@PostMapping(path = "/cargar")
	//CREACION DE PRODUCTOS DESDE CSV//
	public @ResponseBody ResponseEntity cargarProductos(@RequestBody ArrayList<Producto> productosNuevos) {
		
		boolean respuestaServicio = servicio.crearProductosServicio(productosNuevos);
		
		ResponseEntity respuesta = null;
		if(respuestaServicio) {
			respuesta = new ResponseEntity(HttpStatus.OK);
		}else {
			respuesta = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
	
	@PostMapping(path = "/consulta")
	//CONSULTA DE PROVEEDOR POR NUMERO DE NIT
	public @ResponseBody ResponseEntity consultarProducto(@RequestBody Producto productoNuevo) {
		
		Producto productoBuscado = servicio.buscarProductoServicio(productoNuevo.getCodigoProducto());
		
		ResponseEntity respuesta = null;	
		
		if(productoBuscado != null) {
			respuesta = new ResponseEntity(productoBuscado,HttpStatus.OK);
			
		}else {
			respuesta = new ResponseEntity("no encontrado",HttpStatus.NOT_ACCEPTABLE);
		}
		
		return respuesta;
	}
}
