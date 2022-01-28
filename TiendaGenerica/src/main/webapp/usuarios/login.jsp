<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="es">
  <head>
    <!-- Tags para implementar bootstrap-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   <!-- Bootstrap CSS -->
   <!--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous"> -->
   <link rel="stylesheet" href="css/bootstrap.min.css"> 
   <link rel="stylesheet" href="css/estilos.css">
    <script src="js/bootstrap.bundle.min.js"></script>

    <!-- Custom styles for this template -->
    <link href="js/sticky-footer-navbar.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>

    <title>Login - TG</title>
  </head>


  <body>
    <header>
      
      <nav id="header" class="navbar navbar-dark bg-primary">
        <div class="container">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              <img src="./images/tg.png" alt="" width="100" height="70" class="d-inline-block align-text-middle">                          
            </a>
            <label>Bienvenidos a la tienda Genérica</label>
          </div>
      </div>
      </nav>
    </header>

	<section>

  		<div class="container1">
 
			<form method="post" action="/tienda_generica/ServletLogin">
		      <div class="form-group">
		        <label for="usuario">Usuario</label>
		        <input type="text" required="required" name="txtUsuario" maxlength="255" placeholder="Digite su usuario" class="form-control" id="usuario" onKeyUp="habilitar()"></input>
		      </div>
		      <br>
		      <div class="form-group">
		        <div class="form-row">
		          <div class="col">
		            <label for="password">Contraseña</label>
		            <input type="password" required="required" name="pwdContrasena" maxlength="255" placeholder="Digite su contraseña" class="form-control" id="contrasena" onKeyUp="habilitar()"></input>
		          </div>
		          <div class="col">
		            <label for="password"></label>
		            <!-- checkbox que nos permite activar o desactivar la opcion -->
		            <div>
		             <input type="checkbox" id="mostrar_contrasena" title="clic para mostrar contraseña"></input>
		              &nbsp;&nbsp;Mostrar Contraseña</div>
		          </div> 
		        </div>
		      </div>
		       <div id="botones" class="container">
				<input type="submit" name="inicioSesion" value="Iniciar Sesion" class="btn btn-primary" disabled="disabled" id="iniciar_sesion"></input>
				<input type="reset" onclick="window.close();" value="Salir" class="btn btn-primary"></input>
				</div>
				
				<br> 
		      </form>
		      <script  src="js/pruebabotones.js"></script>
		</div>
	    <script>
	      $(document).ready(function () {
	        $('#mostrar_contrasena').click(function () {
	          if ($('#mostrar_contrasena').is(':checked')) {
	            $('#contrasena').attr('type', 'text');
	          } else {
	            $('#contrasena').attr('type', 'password');
	          }
	        });
	      });
	      </script> 
	</section>
  	<footer id="footer" class="pb-4 pt-4">
    <div class="containerfoot">
        <div class="row text-center">
            <div class="col-12 col-lg">
              <img src="./images/manual.png" alt="" width="65" height="55" >
              <a href="#">Manual de Usuario</a>
            </div>
            <div class="col-12 col-lg">
              <img src="./images/mision_tic_2022.png" alt="" width="90" height="60" >
              <a href="#">Mision-TIC 2022</a>
            </div>
            <div class="col-12 col-lg">
              <img src="./images/contacto.png" alt="" width="70" height="60" >
              <a href="#">Contáctanos</a>
            </div>
            </div>
        </div>
   
  	</footer>
  	<script src="js/bootstrap.min.js"></script>
  </body>
</html>