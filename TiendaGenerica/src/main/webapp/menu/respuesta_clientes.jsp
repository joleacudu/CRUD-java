<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.ubosque.mintic.frontend.servlet.ConsultarServlet" %>
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="com.ubosque.mintic.frontend.dto.ClienteDTO" %>
 <%@ page import="com.ubosque.mintic.frontend.logica.ClienteLogica" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LISTADO DE CLIENTES</h1>
<table>
<% 
ArrayList<ClienteDTO> lista = (ArrayList<ClienteDTO>) request.getAttribute("lista_clientes");
for (ClienteDTO Client : lista){
%>
<tr>
<td><%=Client.getCedulaCliente()%></td>
<td><%=Client.getNombreCliente()%></td>
<td><%=Client.getEmailCliente()%></td>
<td><%=Client.getDireccionCliente()%></td>
<td><%=Client.getTelefonoCliente()%></td>
</tr>
<%
}
%>
</table>
</body>
</html>