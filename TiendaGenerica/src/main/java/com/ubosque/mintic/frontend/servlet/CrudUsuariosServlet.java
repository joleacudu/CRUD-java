package com.ubosque.mintic.frontend.servlet;

import java.io.IOException;
import java.util.ArrayList;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubosque.mintic.frontend.dto.UsuarioDTO;
import com.ubosque.mintic.frontend.logica.UsuarioLogica;

/**
 * Servlet implementation class CrudUsuariosServlet
 */
@WebServlet("/CrudUsuariosServlet")
public class CrudUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudUsuariosServlet() {
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
		String consulta_us =request.getParameter("boton_consu");
		String crear_us =request.getParameter("boton_crea");
		String actualizar_us =request.getParameter("boton_actu");
		String borrar_us =request.getParameter("boton_borra");
		String lista_users = request.getParameter("lista_users");
		int bot=0;
		if (consulta_us != null) {
			bot=1;
		}
		if(crear_us != null){
			bot=2;
		}
		if(actualizar_us != null){
			bot=3;
		}
		if(borrar_us != null){
			bot=4;
		}
		if(lista_users != null){
			bot=5;
		}
		
		switch(bot) {
		case 1: 
			ConsultarServlet consulta = new ConsultarServlet();
			consulta.consultarUsuario(request, response);
			break;
		
		case 2: CrearServlet crear = new CrearServlet();
		crear.crearUsuario(request, response);
		break;
		
		case 3:	
			ActualizarServlet actualizar = new ActualizarServlet();
			actualizar.actualizarUsuario(request, response);
			break;
				
		case 4:	BorrarServlet borrar= new BorrarServlet();
		borrar.borrarUsuario(request, response);
		break;
		
		//case 5:	ConsultarServlet lista_usuarios = new ConsultarServlet();
		//lista_usuarios.listarUsuarios(request, response);
		//break;
		}

		
	}

}
