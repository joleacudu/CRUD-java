package com.ubosque.mintic.frontend.servlet;

import java.io.IOException;
import java.util.ArrayList;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

//import com.google.gson.Gson;
import com.ubosque.mintic.frontend.dto.ClienteDTO;
import com.ubosque.mintic.frontend.dto.ProveedorDTO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;
import com.ubosque.mintic.frontend.logica.ClienteLogica;
import com.ubosque.mintic.frontend.logica.ProveedorLogica;
import com.ubosque.mintic.frontend.logica.UsuarioLogica;

/**
 * Servlet implementation class ConsultarServlet
 */
@WebServlet("/ConsultarServlet")
public class ConsultarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 *
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void consultarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String cedulaDigitada = request.getParameter("campo_ced");
		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setCedulaUsuario(cedulaDigitada);
		
		UsuarioLogica logica = new UsuarioLogica();
		UsuarioDTO existeUsuario = logica.ingresarCedula(dto);
		
		String dato = existeUsuario.getCedulaUsuario();
		String dato2 = existeUsuario.getNombreUsuario();
		String dato3 = existeUsuario.getEmailUsuario();
		String dato4 = existeUsuario.getUsuario();
		String dato5 = existeUsuario.getPassword();
		
		System.out.println(dato);
		System.out.println(dato2);
		System.out.println(dato3);
		System.out.println(dato4);
		System.out.println(dato5);

		request.getSession().setAttribute("campo_cedulau", dato);
		request.getSession().setAttribute("campo_nombreu", dato2);
		request.getSession().setAttribute("campo_emailu", dato3);
		request.getSession().setAttribute("campo_u", dato4);
		request.getSession().setAttribute("campo_passwordu", dato5);
		response.sendRedirect("/tienda_generica/menu/menu.jsp");
	
		
		
	}
	
	protected void consultarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String cedulaDigitada = request.getParameter("campo_cedulac");
				
		ClienteDTO dto = new ClienteDTO();
		dto.setCedulaCliente(cedulaDigitada);
		
		ClienteLogica logica = new ClienteLogica();
		ClienteDTO existeCliente = logica.ingresarCedula(dto);
		System.out.println(existeCliente.getNombreCliente());
		
		String dato = existeCliente.getCedulaCliente();
		String dato2 = existeCliente.getNombreCliente();
		String dato3 = existeCliente.getEmailCliente();
		String dato4 = existeCliente.getDireccionCliente();
		String dato5 = existeCliente.getTelefonoCliente();
		
		String iden1 = "Cliente";
		String iden2 = "Cedula";
		String iden3 = "Nombre";
		String iden4 = "Correo";
		String iden5 = "Direccion";
		String iden6 = "Telefono";

		request.setAttribute("campo_cedulau", dato);
		request.setAttribute("campo_nombreu", dato2);
		request.setAttribute("campo_emailu", dato3);
		request.setAttribute("campo_u", dato4);
		request.setAttribute("campo_telefonoc", dato5);
	
		request.setAttribute("iden1", iden1);
		request.setAttribute("iden2", iden2);
		request.setAttribute("iden3", iden3);
		request.setAttribute("iden4", iden4);
		request.setAttribute("iden5", iden5);
		request.setAttribute("iden6", iden6);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/menu/respuesta_consulta.jsp");
		rd.forward(request,response);
	}
	
	protected void consultarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nitDigitado = request.getParameter("campo_nitp");
				
		ProveedorDTO dto = new ProveedorDTO();
		dto.setNitProveedor(nitDigitado);
		
		ProveedorLogica logica = new ProveedorLogica();
		ProveedorDTO existeProveedor = logica.ingresarNit(dto);
		System.out.println(existeProveedor.getNombreProveedor());

		String dato = existeProveedor.getNitProveedor();
		String dato2 = existeProveedor.getCiudadProveedor();
		String dato3 = existeProveedor.getNombreProveedor();
		String dato4 = existeProveedor.getDireccionProveedor();
		String dato5 = existeProveedor.getTelefonoProveedor();
		
		String iden1 = "Proveedor";
		String iden2 = "NIT";
		String iden3 = "Ciudad";
		String iden4 = "Nombre";
		String iden5 = "Direccion";
		String iden6 = "Telefono";

		request.setAttribute("campo_cedulau", dato);
		request.setAttribute("campo_nombreu", dato2);
		request.setAttribute("campo_emailu", dato3);
		request.setAttribute("campo_u", dato4);
		request.setAttribute("campo_telefonoc", dato5);
	
		request.setAttribute("iden1", iden1);
		request.setAttribute("iden2", iden2);
		request.setAttribute("iden3", iden3);
		request.setAttribute("iden4", iden4);
		request.setAttribute("iden5", iden5);
		request.setAttribute("iden6", iden6);
		
		ArrayList<UsuarioDTO> lista = (ArrayList<UsuarioDTO>) request.getAttribute("lista_usuarios");
		for (UsuarioDTO User : lista){
			User.getCedulaUsuario();
			User.getNombreUsuario();
			User.getEmailUsuario();
			User.getPassword();
			User.getUsuario();
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/menu/respuesta_consulta.jsp");
		rd.forward(request,response);
	}
	
	protected void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		UsuarioLogica logica = new UsuarioLogica();
		ArrayList<UsuarioDTO> listaUsuarios;
		try {
			listaUsuarios = logica.listar();
			System.out.print(listaUsuarios);
			request.setAttribute("lista_usuarios", listaUsuarios);
			RequestDispatcher rd;
			rd = request.getServletContext().getRequestDispatcher("/menu/respuesta_usuarios.jsp");
			rd.forward(request,response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}
	
	protected void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		ClienteLogica logica = new ClienteLogica();
		ArrayList<ClienteDTO> listaClientes;
		try {
			listaClientes = logica.listar();
			System.out.print(listaClientes);
			request.setAttribute("lista_clientes", listaClientes);
			RequestDispatcher rd;
			rd = request.getServletContext().getRequestDispatcher("/menu/respuesta_clientes.jsp");
			rd.forward(request,response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}
	
}
