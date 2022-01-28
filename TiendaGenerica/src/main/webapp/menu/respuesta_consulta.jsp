<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ubosque.mintic.frontend.servlet.ConsultarServlet" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <!-- Tags para implementar bootstrap-->
    <meta charset="utf-8">
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   <!-- Bootstrap CSS -->
   <!--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous"> -->
   <link rel="stylesheet" href="menu/css/bootstrap.min.css"> 
   <link rel="stylesheet" href="menu/css/estilos_menu.css">
   <link rel="stylesheet" href="menu/css/strength.css">

    <script src="js/bootstrap.bundle.min.js"></script>


    <title>Consulta de <c:out value="${iden1}"/>- TG</title>
</head>
<body>
    <header>
      
        <nav id="header" class="navbar navbar-dark bg-primary">
          <div class="container">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">
                  <img src="menu/images/tg.png" alt="" width="100" height="70" class="d-inline-block align-text-middle">                          
              </a>
              <label>Tienda Generica - Consulta de <c:out value="${iden1}"/> </label>
            </div>
        </div>
        </nav>
    </header>


    <div class="d-grid gap-2 col-6 mx-auto" id="lists_reports" style="margin: 120px;">
        <div class="col">
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default"><c:out value="${iden2}"/></span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"  name ="campo_cedulaconsu" value=<c:out value="${campo_cedulau}"/> disabled>
            </div>
            
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default"><c:out value="${iden3}"/></span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"  name ="campo_nombreconsu" value=<c:out value="${campo_nombreu}"/> disabled>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default" ><c:out value="${iden4}"/></span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"  name ="campo_direccionconsu" value=<c:out value="${campo_emailu}"/> disabled>
            </div>                    
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default"><c:out value="${iden5}"/></span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"  name ="campo_usuarioconsu" value=<c:out value="${campo_u}"/> disabled>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default"><c:out value="${iden6}"/></span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"  name ="campo_usuarioconsu" value=<c:out value="${campo_passwordu}"/> disabled>
            </div>
            <div class="input-group mb-3">
                <a class="btn btn-primary" href="/tienda_generica/menu/menu.jsp" role="button">Regresar</a>
            </div>
        </div>
    </div>


    <footer id="footer" class="pb-4 pt-4">
        <div class="containerfoot">
            <div class="row text-center">
                <div class="col-12 col-lg">
                  <img src="menu/images/manual.png" alt="" width="65" height="55" >
                  <a href="#">Manual de Usuario</a>
                </div>
                <div class="col-12 col-lg">
                  <img src="menu/images/mision_tic_2022.png" alt="" width="90" height="60" >
                  <a href="https://www.misiontic2022.gov.co/portal/">Mision-TIC 2022</a>
                </div>
                <div class="col-12 col-lg">
                  <img src="menu/images/contacto.png" alt="" width="70" height="60" >
                  <a href="#">Contactanos</a>
                </div>
                </div>
            </div>
    </footer>
</body>
</html>