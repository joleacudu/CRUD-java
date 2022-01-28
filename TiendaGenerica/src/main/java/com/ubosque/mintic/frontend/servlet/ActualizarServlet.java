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
 * Servlet implementation class ActualizarServlet
 */
@WebServlet("/ActualizarServlet")
public class ActualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedulaDigitada = request.getParameter("campo_ced");
		String emailDigitado = request.getParameter("campo_corr");
		String nombreDigitado = request.getParameter("campo_nom");
		String usuarioDigitado = request.getParameter("campo_usu");
		String contrasenaDigitada = request.getParameter("campo_pass");

		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setCedulaUsuario(cedulaDigitada);
		dto.setEmailUsuario(emailDigitado);
		dto.setNombreUsuario(nombreDigitado);
		dto.setUsuario(usuarioDigitado);
		dto.setPassword(contrasenaDigitada);
		
		UsuarioLogica logica = new UsuarioLogica();
		boolean existeUsuario = logica.actualizarUsuarios(dto);
		if(existeUsuario) {
			response.sendRedirect("/tienda_generica/menu/menu.jsp");
		}
	}
	
	protected void actualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedulaDigitada = request.getParameter("campo_cedulac");
		String nombreDigitado = request.getParameter("campo_nombrec");
		String direccionDigitada = request.getParameter("campo_direccionc");
		String telefonoDigitado = request.getParameter("campo_telefonoc");
		String emailDigitado = request.getParameter("campo_correoc");

		
		ClienteDTO dto = new ClienteDTO();
		dto.setCedulaCliente(cedulaDigitada);
		dto.setNombreCliente(nombreDigitado);
		dto.setDireccionCliente(direccionDigitada);
		dto.setTelefonoCliente(telefonoDigitado);
		dto.setEmailCliente(emailDigitado);
		
		ClienteLogica logica = new ClienteLogica();
		boolean existeCliente = logica.actualizarCliente(dto);
		if(existeCliente) {
			response.sendRedirect("/tienda_generica/menu/menu.jsp");
		}
	}
	protected void actualizarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nitDigitado = request.getParameter("campo_nitp");
		String nombreDigitado = request.getParameter("campo_nombrep");
		String direccionDigitada = request.getParameter("campo_direccionp");
		String telefonoDigitado = request.getParameter("campo_telefonop");
		String ciudadDigitada = request.getParameter("campo_ciudadp");
		
		
		ProveedorDTO dto = new ProveedorDTO();
		dto.setNitProveedor(nitDigitado);
		dto.setNombreProveedor(nombreDigitado);
		dto.setDireccionProveedor(direccionDigitada);
		dto.setTelefonoProveedor(telefonoDigitado);
		dto.setCiudadProveedor(ciudadDigitada);
		
		
		ProveedorLogica logica = new ProveedorLogica();
		boolean existeProveedor = logica.crearProveedor(dto);
		if(existeProveedor) {
			response.sendRedirect("/tienda_generica/menu/menu.jsp");
		}
	}
}
