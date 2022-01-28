<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.ubosque.mintic.frontend.servlet.ConsultarServlet" %>
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="com.ubosque.mintic.frontend.dto.UsuarioDTO" %>
  <%@ page import="com.ubosque.mintic.frontend.logica.UsuarioLogica" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LISTADO DE USUARIOS</h1>
<table>
<% 
ArrayList<UsuarioDTO> lista = (ArrayList<UsuarioDTO>) request.getAttribute("lista_usuarios");
for (UsuarioDTO User : lista){
%>
<tr>
<td><%=User.getCedulaUsuario()%></td>
<td><%=User.getNombreUsuario()%></td>
<td><%=User.getEmailUsuario()%></td>
<td><%=User.getPassword()%></td>
<td><%=User.getUsuario()%></td>
</tr>
<%
}
%>
</table>
</body>
</html>