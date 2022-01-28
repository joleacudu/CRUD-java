package com.ubosque.mintic.frontend.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.parser.ParseException;

import com.csvreader.CsvReader;
import com.ubosque.mintic.frontend.dao.ClienteDAO;
import com.ubosque.mintic.frontend.dao.ProductoDAO;
import com.ubosque.mintic.frontend.dto.ProductoDTO;
import com.ubosque.mintic.frontend.dto.ProveedorDTO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;
import com.ubosque.mintic.frontend.logica.ProductoLogica;
import com.ubosque.mintic.frontend.logica.UsuarioLogica;

/**
 * Servlet implementation class CargarCsvServlet
 */
@WebServlet("/CargarCsvServlet")
@MultipartConfig
public class CargarCsvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarCsvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String csv = request.getParameter("archivo");
		Part filePart = request.getPart("archivo");
		InputStream fileContent = filePart.getInputStream();
		//InputStreamReader inputStreamReader = new InputStreamReader(fileContent);
        //Stream<String> streamOfString= new BufferedReader(inputStreamReader).lines();
        //String streamToString = streamOfString.collect(Collectors.joining("\n"));
        //System.out.println(streamToString);
		
        ProductoDAO dao = new ProductoDAO();
        List<List<String>> matriz = dao.parseCsv(fileContent);
        int largo = matriz.size();
        
        System.out.println(matriz);
        System.out.println(largo);
        ArrayList<ProductoDTO> productos = StringToDto(matriz);
        System.out.println(productos);
        
        ProductoLogica logica = new ProductoLogica();
		boolean productosCreados = logica.crearProductos(productos);
		if(productosCreados) {
			System.out.println("cargados los productos");
			response.sendRedirect("/tienda_generica/menu/menu.jsp");
		}
		
	}
	
	public static ArrayList<ProductoDTO> StringToDto(List<List<String>> listadoProductos) {
		
		ArrayList<ProductoDTO> productosFinal = new ArrayList<ProductoDTO>();///Creo lista de productos dto
		ProveedorDTO proveedor = new ProveedorDTO();
		
		for(int i=0 ; i < listadoProductos.size(); i++) {

			
			List<String> producto = new ArrayList<>();

			
			if(producto.addAll(listadoProductos.get(i))) {//capturar lista por lista y validar
				ProductoDTO productosEnvio = new ProductoDTO();
	        	productosEnvio.setCodigoProducto(producto.get(0));
	        	productosEnvio.setNombreProducto(producto.get(1));
	        	proveedor.setNitProveedor(producto.get(2));
	        	productosEnvio.setProveedore(proveedor);
	        	productosEnvio.setPrecioCompra(producto.get(3));
	        	productosEnvio.setIvacompra(producto.get(4));
	        	productosEnvio.setPrecioVenta(producto.get(5));
	        	productosFinal.add(productosEnvio);///llenado de listado de productos DTO
				 System.out.println(producto);
			}
		}
		return productosFinal;
	}
	

}
