package com.ubosque.mintic.frontend.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.ubosque.mintic.frontend.dto.UsuarioDTO;
import com.ubosque.mintic.frontend.logica.UsuarioLogica;
//import javax.swing.JOptionPane;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class UsuarioLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuarioDigitado = request.getParameter("txtUsuario");
		String contrasenaDigitada = request.getParameter("pwdContrasena");

		UsuarioDTO dto = new UsuarioDTO();
		dto.setUsuario(usuarioDigitado);
		dto.setPassword(contrasenaDigitada);
		
		UsuarioLogica logica = new UsuarioLogica();
		UsuarioDTO existeUsuario = logica.ingresar(dto);
		
		String dato = existeUsuario.getCedulaUsuario();
		String dato2 = existeUsuario.getUsuario();
		String dato3 = existeUsuario.getPassword();
		System.out.println(dato);
		System.out.println(dato2);
		System.out.println(dato3);
		request.getSession().setAttribute("usu_ced", dato);
		
		if(existeUsuario != null) {
			response.sendRedirect("/tienda_generica/menu/menu.jsp");
		}else {
			response.sendRedirect("/tienda_generica/usuario/loginFallido.html");
		}
			
	}

}
