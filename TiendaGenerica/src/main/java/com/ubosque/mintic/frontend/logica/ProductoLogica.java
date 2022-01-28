package com.ubosque.mintic.frontend.logica;

import java.io.IOException;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ubosque.mintic.frontend.dao.ProductoDAO;
import com.ubosque.mintic.frontend.dao.UsuarioDAO;
import com.ubosque.mintic.frontend.dto.ProductoDTO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;


public class ProductoLogica {
	
	private ProductoDAO dao;
	
	public boolean crearProductos(ArrayList<ProductoDTO> dto) {
		dao = new ProductoDAO();
		return dao.crearProductos(dto);
	}
	//public ArrayList<ProductoDTO> importar(ArrayList<ProductoDTO> lista) throws IOException, ParseException{
	//	dao = new ProductoDAO();
	//	lista = dao.importarCSV();
	//	return lista;
	//}
	
	public ProductoDTO ingresarCodigo(ProductoDTO dto) {
		dao = new ProductoDAO();
		ProductoDTO uss = new ProductoDTO();
		String usuarioJson = dao.consultarCodigo(dto);
        Type listType = new TypeToken<ProductoDTO>(){}.getType();
        Gson gson = new Gson();
        uss = gson.fromJson(usuarioJson, listType);
		//return dao.consultarCedula(dto);
        return uss;
	}
	
}
