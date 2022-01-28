package com.ubosque.mintic.frontend.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubosque.mintic.frontend.dto.ClienteDTO;
import com.ubosque.mintic.frontend.dto.ProveedorDTO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;
import com.ubosque.mintic.frontend.logica.ClienteLogica;
import com.ubosque.mintic.frontend.logica.ProveedorLogica;
import com.ubosque.mintic.frontend.logica.UsuarioLogica;

/**
 * Servlet implementation class BorrarServlet
 */
@WebServlet("/BorrarServlet")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void borrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String cedulaDigitada = request.getParameter("campo_ced");

		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setCedulaUsuario(cedulaDigitada);

		UsuarioLogica logica = new UsuarioLogica();
		boolean existeUsuario = logica.borrarUsuario(dto);
		if(existeUsuario) {
			response.sendRedirect("/tienda_generica/menu/menu.jsp");
		}
	}

	protected void borrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String cedulaDigitada = request.getParameter("campo_cedulac");

		ClienteDTO dto = new ClienteDTO();
		dto.setCedulaCliente(cedulaDigitada);		
		ClienteLogica logica = new ClienteLogica();
		boolean existeCliente = logica.borrarCliente(dto);
		if(existeCliente) {
			response.sendRedirect("/tienda_generica/menu/menu.jsp");
		}
	}
	
	protected void borrarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nitDigitado = request.getParameter("campo_nitp");

		ProveedorDTO dto = new ProveedorDTO();
		dto.setNitProveedor(nitDigitado);		
		ProveedorLogica logica = new ProveedorLogica();
		boolean existeProveedor = logica.borrarProveedor(dto);
		if(existeProveedor) {
			response.sendRedirect("/tienda_generica/menu/menu.jsp");
		}
	}
}
