package com.ubosque.mintic.frontend.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrudClientesServlet
 */
@WebServlet("/CrudClientesServlet")
public class CrudClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudClientesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String consulta_cli =request.getParameter("boton_consultac");
		String crear_cli =request.getParameter("boton_crearc");
		String actualizar_cli =request.getParameter("boton_actualizac");
		String borrar_cli =request.getParameter("boton_borrac");
		String lista_clients = request.getParameter("lista_clients");
		
		if(consulta_cli != null){
			ConsultarServlet consulta = new ConsultarServlet();
			consulta.consultarCliente(request, response);
		}
		if(crear_cli != null){
			CrearServlet crear = new CrearServlet();
			crear.crearCliente(request, response);
		}
		if(actualizar_cli != null){
			ActualizarServlet actualizar = new ActualizarServlet();
			actualizar.actualizarCliente(request, response);
		}
		if(borrar_cli != null){
			BorrarServlet borrar= new BorrarServlet();
			borrar.borrarCliente(request, response);			
		}
		if(lista_clients != null){
			ConsultarServlet consulta = new ConsultarServlet();
			consulta.listarClientes(request, response);		
		}
	}

}
