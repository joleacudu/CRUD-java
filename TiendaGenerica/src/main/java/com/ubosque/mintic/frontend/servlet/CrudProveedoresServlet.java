package com.ubosque.mintic.frontend.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrudProveedoresServlet
 */
@WebServlet("/CrudProveedoresServlet")
public class CrudProveedoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudProveedoresServlet() {
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
		String consulta_pro =request.getParameter("boton_consultap");
		String crear_pro =request.getParameter("boton_crearp");
		String actualizar_pro =request.getParameter("boton_actualizap");
		String borrar_pro =request.getParameter("boton_borrap");
		
		if(consulta_pro != null){
			ConsultarServlet consulta = new ConsultarServlet();
			consulta.consultarProveedor(request, response);
		}
		if(crear_pro != null){
			CrearServlet crear = new CrearServlet();
			crear.crearProveedor(request, response);
		}
		if(actualizar_pro != null){
			ActualizarServlet actualizar = new ActualizarServlet();
			actualizar.actualizarProveedor(request, response);
		}
		if(borrar_pro != null){
			BorrarServlet borrar= new BorrarServlet();
			borrar.borrarProveedor(request, response);			
		}
	}
	

}
