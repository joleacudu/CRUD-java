<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ubosque.mintic.frontend.servlet.ConsultarServlet" %>
<%@ page import="com.ubosque.mintic.frontend.dto.UsuarioDTO" %>
<%@ page import="com.ubosque.mintic.frontend.dto.ClienteDTO" %>
<%@ page import="com.ubosque.mintic.frontend.logica.ClienteLogica" %>
<%@ page import="com.ubosque.mintic.frontend.dto.ProductoDTO" %>
<%@ page import="com.ubosque.mintic.frontend.logica.ProductoLogica" %>
<html lang="es">
  <head>
    <!-- Tags para implementar bootstrap-->
    <meta charset="utf-8">
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   <!-- Bootstrap CSS -->
   <!--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous"> -->
   <link rel="stylesheet" href="css/bootstrap.min.css"> 
   <link rel="stylesheet" href="css/estilos_menu.css">
   <link rel="stylesheet" href="css/strength.css">
   
   <script src="js/bootstrap.bundle.min.js"></script>

    <style>
        #myform input[type="password"],#myform input[type="text"]{
        background:transparent;
        width:84%;
        }
        #myform input[type="password"]:focus,#myform input[type="text"]:focus{
        outline:0;
        }
        .strength_meter{
        position: absolute;
        left: 105px;
        top: 0px;
        width: 84%;
        height: 36px;
        z-index:-1;
        border-radius:0px;
        padding-right:0px;
        }
        .strength_meter div{
        width:0%;
        height: 39px;
        text-align: right;
        color: #000;
        line-height: 43px;
        padding-right: 12px;
        }
        .strength_meter div p{
        position: absolute;
        top: 22px;
        right: 0px;
        color: #FFF;
        font-size:13px;
        }
        .veryweak{
        background-color: #FFA0A0;
        border-color: #F04040!important;
        width:100%!important;
        }
        .weak{
        background-color: #FFB78C;
        border-color: #FF853C!important;
        width:100%!important;
        }
        .medium{
        background-color: #FFEC8B;
        border-color: #FC0!important;
        width:100%!important;
        }
        .strong{
        background-color: #C3FF88;
        border-color: #8DFF1C!important;
        width:100%!important;
        }
    </style>
    
    <title>Menu - TG</title>

  </head>

  <body>
    <header>
      
      <nav id="header" class="navbar navbar-dark bg-primary">
        <div class="container">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="./images/tg.png" alt="" width="100" height="70" class="d-inline-block align-text-middle">                          
            </a>
            <label>Tienda Generica</label>
          </div>
      </div>
      </nav>
    </header>

<section>
    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="false" name="menu_usuario">Usuarios</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Clientes</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill" data-bs-target="#pills-contact" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">Proveedores</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-products-tab" data-bs-toggle="pill" data-bs-target="#pills-products" type="button" role="tab" aria-controls="pills-products" aria-selected="false">Productos</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-ventas-tab" data-bs-toggle="pill" data-bs-target="#pills-ventas" type="button" role="tab" aria-controls="pills-ventas" aria-selected="false">Ventas</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-reports-tab" data-bs-toggle="pill" data-bs-target="#pills-reports" type="button" role="tab" aria-controls="pills-reports" aria-selected="false">Reportes</button>
        </li>
    </ul>
    <div class="tab-content" id="pills-tabContent">

 <!--        Contenido del primer tab USUARIOS ******************************************************************** -->

           
           <div class="tab-pane fade" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
            <br>
            <form action="/tienda_generica/CrudUsuariosServlet" method="post" id="myform" name="formulario"> 
            	<div class="row">
                <div class="col">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Cédula</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Ingrese Cédula" onkeypress="return soloNumeros(event)"  id="campo_cedula"  name ="campo_ced" required="required" value="<c:out value="${campo_cedulau}"></c:out>">
                    </div>
                    
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Nombres</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Ingrese Nombres" onkeypress="return soloLetras(event)"id="campo_nombre"  name ="campo_nom" value="<c:out value="${campo_nombreu}"></c:out>">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default" >Correo</span>
                        <input type="email" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="texto@texto.com" id="campo_correo" name ="campo_corr" value="<c:out value="${campo_emailu}"></c:out>">
                    </div>                    

                </div>
                <div class="col">

                    
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Usuario</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Ingrese Usuario" id="campo_usuario" name ="campo_usu" value="<c:out value="${campo_u}"></c:out>">
                    </div>
                    
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Contraseña</span>
                        <input type="password" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Ingrese Contraseña" id="campo_password" name ="campo_pass"  value="<c:out value="${campo_passwordu}"></c:out>">
                    </div>
                </div>
                </div>
				<div class="col-12">
                    <center><button type="reset" class="btn btn-primary">Limpiar</button></center>
                </div>

		
            <script src="js/jquery.min.js"></script>
            <script src="js/strength.min.js"></script>
            <script id="rendered-js">
                $(document).ready(function ($) {
                $('#campo_password').strength({                   
                    strengthClass: 'strength',
                    strengthMeterClass: 'strength_meter',
                    strengthButtonClass: 'button_strength',
                    strengthButtonText: 'Mostrar Password',
                    strengthButtonTextToggle: 'Ocultar Password' });
                });
            </script>
            <br>
            <div  class="row row-cols-lg-auto g-3 align-items-center" id="grupobotones">
                
                <div class="col-12">
                    <button type="submit" class="btn btn-primary" id="boton_consultar" name="boton_consu">Consultar</button>
                </div>
                
                <div class="col-12">               	
                  	<button type="submit" class="btn btn-primary"  id="boton_crear" name="boton_crea">Crear</button>            
                </div>

                <div class="col-12"> 
                    <button type="submit" class="btn btn-primary"  name="boton_actu">Actualizar</button>
                </div>
                
                <div class="col-12">
                    <button type="submit" class="btn btn-primary"  name="boton_borra">Borrar</button>
                </div>
            </div>
 
			
		</form>	  
		<script src="js/leerDatos.js"></script>
		<script src="js/scripts_validacion.js"></script>
			
       </div>
        
 <!--  Contenido del segundo tab Clientes ******************************************************************** -->   
 
        <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
            <br>
            <form method="post" action="/tienda_generica/CrudClientesServlet" >
            <div class="row">
                <div class="col">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Cédula</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Ingrese Cédula" onkeypress="return soloNumeros(event)" name ="campo_cedulac" required>
                    </div>
                    
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Nombres</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Ingrese Nombre" onkeypress="return soloLetras(event)" name ="campo_nombrec" >
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default" >Dirección</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Ingrese Dirección" name ="campo_direccionc">
                    </div>                    

                </div>
                <div class="col">

                    
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Teléfono</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"placeholder="Ingrese Teléfono" onkeypress="return soloNumeros(event)" name ="campo_telefonoc">
                    </div>
                    
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Correo Electrónico</span>
                        <input type="email" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="texto@texto.com" name ="campo_correoc" >
                    </div>
                </div>
            </div>
            <br>
            <br>

            <div class="row row-cols-lg-auto g-3 align-items-center" id="grupobotones">
                <div class="col-12">
                    <button type="submit" class="btn btn-primary" name ="boton_consultac">Consultar</button>
                </div>
            
                <div class="col-12">
                <button type="submit" class="btn btn-primary" name ="boton_crearc">Crear</button>
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-primary" name ="boton_actualizac">Actualizar</button>
                </div>
                
                <div class="col-12">
                    <button type="submit" class="btn btn-primary" name ="boton_borrac">Borrar</button>
                </div>

                <div class="col-12">
                    <button type="reset" class="btn btn-primary">Limpiar</button>
                </div>
            </div>
        </form>
        </div>
 <!--        Contenido del tercer tab Proovedores ******************************************************************** -->    
        <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">
            <br>
            <form method="post" action="/tienda_generica/CrudProveedoresServlet" >
            <div class="row">
                <div class="col">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">NIT</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" onkeypress="return soloNumeros(event)" placeholder="Ingrese NIT" name="campo_nitp" required>
                    </div>
                    
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Nombre Proveedor</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" onkeypress="return soloLetras(event)" placeholder="Ingrese Nombre Proveedor" name="campo_nombrep">
                    </div>
                    
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Dirección</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Ingrese dirección Proveedor" name="campo_direccionp">
                    </div>
                </div>
                <div class="col">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default" >Teléfono</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Ingrese Teléfono" onkeypress="return soloNumeros(event)" name="campo_telefonop">
                    </div>
                    
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">Ciudad</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Ingrese Ciudad Proveedor" onkeypress="return soloLetras(event)"name="campo_ciudadp">
                    </div>
                </div>
              </div>
              <br>
              <br>

            <div class="row row-cols-lg-auto g-3 align-items-center" id="grupobotones">
                <div class="col-12">
                    <button type="submit" class="btn btn-primary" name="boton_consultap">Consultar</button>
                </div>
              
                <div class="col-12">
                  <button type="submit" class="btn btn-primary" name="boton_crearp">Crear</button>
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-primary" name="boton_actualizap">Actualizar</button>
                </div>
                
                <div class="col-12">
                    <button type="submit" class="btn btn-primary" name="boton_borrap">Borrar</button>
                </div>

                <div class="col-12">
                    <button type="reset" class="btn btn-primary">Limpiar</button>
                </div>
            </div>  
        </form>          
        </div>
 <!--        Contenido del cuarto tab Productos ******************************************************************** -->  
    <div class="tab-pane fade" id="pills-products" role="tabpanel" aria-labelledby="pills-products-tab">
    <br>
    <br><br><br>
    	<form method="post" action="/tienda_generica/CargarCsvServlet" enctype="multipart/form-data" >
        <!--  <div class="row row-cols-lg-auto g-3 align-items-center" style="justify-content:center">  -->             
         <!--    <div class="col-12"> -->
                <input type="file" name="archivo" accept=".csv" multiple class="btn btn-primary" id="archivo"></input>
          <!--   </div> -->
        <!--  </div> -->
            <br><br>
         <!-- <div class="row row-cols-lg-auto g-3 align-items-center" id="grupobotones">-->
           <!--  <div class="col-12">-->
            <button type="submit" class="btn btn-primary" name="cargar_arc" id="cargarArc">Cargar</button>
           <!--  </div>-->
        <!-- </div>  -->
        </form>  
    </div>
<!--        Contenido del quinto tab Ventas ******************************************************************** --> 
        <div class="tab-pane fade show active" id="pills-ventas" role="tabpanel" aria-labelledby="pills-ventas-tab" style="text-align: center;">
        <form>
				<!--<form>-->
                <div class="row row-cols-lg-auto g-3 align-items-center" id="linea_ppal" style=" margin-left: 220px;">
                
                	  <%
                	  		String cedulaDigitada = "";
        					ClienteDTO dto = new ClienteDTO();
        					ClienteLogica logica = new ClienteLogica();
        					ClienteDTO existeCliente = new ClienteDTO();
        					cedulaDigitada = request.getParameter("cli_cedula");
        					
        					if(cedulaDigitada != null){
        						dto.setCedulaCliente(cedulaDigitada);
    							existeCliente = logica.ingresarCedula(dto);
        					}	
        					
		
        				%>
                	<!--  <form method="post" action="/tienda_generica/CrudClientesServlet">-->
                	<div class="col-12">
                      <div class="input-group">
                        <div class="input-group-text">Cedula Ingresada</div>
                        <input type="text" class="form-control" id="inlineFormInputGroupUsername" placeholder="Número de Cédula" onkeypress="return soloNumeros(event)"id="cli_cedula" name="cli_cedula" value="<c:out value="${usu_ced}"></c:out>" disabled>
                      </div>
                    </div>
                    <div class="col-12">
                      <div class="input-group">
                        <div class="input-group-text">Cédula</div>
                        <input type="text" class="form-control" id="inlineFormInputGroupUsername" placeholder="Número de Cédula" onkeypress="return soloNumeros(event)"id="cli_cedula" name="cli_cedula" value = "<%= existeCliente.getCedulaCliente()!=null? existeCliente.getCedulaCliente():""%>">
                      </div>
                    </div>
                    
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary" id="cli_venta" name="cli_venta">Consultar</button>
                      </div>
                      <div class="col-12">
    
                    <div class="input-group">
                          <div class="input-group-text">Cliente</div>
                          <input type="text" class="form-control" id="inlineFormInputGroupUsername" value= "<%= existeCliente.getNombreCliente()!=null? existeCliente.getNombreCliente():""%>" disabled>
                        </div>
                    </div>
    			
                    <div class="col-12">
                        <div class="input-group">
                          <div class="input-group-text">Consecutivo</div>
                          <input type="text" class="form-control" id="inlineFormInputGroupUsername" >
                        </div>
                    </div> 
                 </div> 	  
                 <!--</form>-->
                
               
                <br>
                <div class="tabla" style="  align-items: center; margin-left: 160px; margin-right: 150px;">

                	
                    <div class="row">
                        <div class="col-2"><label for="">Codigo Producto</label></div>
                        <div class="col-1" id="botones_consu"></div>
                        <div class="col-2"><label for="">Nombre Producto</label></div>
                        <div class="col"><label for="">Precio unitario</label></div>
                        <div class="col-1"><label for="">Cantidad</label></div>
                        <div class="col-1"><label for="">Iva Prod.</label></div>
                        <div class="col-2"><label for="">Valor Total</label></div>
                    </div>
                   <!--<form>-->
                		<%
                	  		String productoDigitado = "";
        					ProductoDTO dtop = new ProductoDTO();
                        	ProductoLogica logicap = new ProductoLogica();
                        	ProductoDTO existeProducto = new ProductoDTO();
                        	productoDigitado = request.getParameter("cod_uno");
        					
        					if(productoDigitado != null){
        						dtop.setCodigoProducto(productoDigitado);
        						existeProducto = logicap.ingresarCodigo(dtop);
        						String codigo1 = existeProducto.getCodigoProducto();

        					}	
        					
        				%>	

        				
        				
        				<div class="row">
                        <div class="col-2">
                            <div class="input-group mb-2">
                                <span class="input-group-text">#</span>
                                <input type="text" class="form-control" name="cod_uno" value ="<%= existeProducto.getCodigoProducto()!=null? existeProducto.getCodigoProducto():""%>">
                              </div>
                        </div>	
                      
                        <div class="col-1">
                            <button type="submit" class="btn btn-primary" id="produno" name="produno">Consultar</button>
                        </div>
                        <div class="col-2">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="nombreProUno" value="<%= existeProducto.getNombreProducto()!=null? existeProducto.getNombreProducto():""%>" disabled>
                              </div>
                        </div>
                        
                         <div class="col">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="valorUno" id="valorUno" value="<%= existeProducto.getPrecioVenta()!=null? existeProducto.getPrecioVenta():""%>"disabled>
                              </div>
                        </div>  
                                             
                        <div class="col-1">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="cantUno" id="cantUno" onchange="multiplicar()">
                              </div>
                        </div>
                        <div class="col-1">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="ivaUno" id="ivaUno" value="<%= existeProducto.getIvacompra()!=null? existeProducto.getIvacompra():""%>" disabled>
                              </div>
                        </div>
                        <div class="col-2">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="resultadoUno" id="resultadoUno" disabled>
                              </div>
                        </div>
                    </div>
					
        			<!--</form>-->
        			
        			<script type="text/javascript">
        			function multiplicar(){
        				  m1 = document.getElementById("valorUno").value;
        				  m2 = document.getElementById("cantUno").value;
        				  r = m1*m2;
        				  document.getElementById("resultadoUno").value = r;
        				}
        			</script>
        			
        			
        			<!--<form>-->
        			<%
                	  		//String productoDigitado2 = "";
        					ProductoDTO dtop2 = new ProductoDTO();
                        	ProductoLogica logicap2 = new ProductoLogica();
                        	ProductoDTO existeProducto2 = new ProductoDTO();
                        	String productoDigitado2 = request.getParameter("cod_dos");
        					
        					if(productoDigitado2 != null){
        						dtop2.setCodigoProducto(productoDigitado2);
        						existeProducto2 = logicap2.ingresarCodigo(dtop2);
        						String codigo2 = existeProducto.getCodigoProducto();
        				
        					}	
        					
        				%>	
                    <div class="row">
                        <div class="col-2">
                            <div class="input-group mb-2">
                                <span class="input-group-text">#</span>
                                <input type="text" class="form-control" name="cod_dos" value="<%= existeProducto2.getCodigoProducto()!=null? existeProducto2.getCodigoProducto():""%>">
                              </div>
                        </div>
                        <div class="col-1">
                            <button type="submit" class="btn btn-primary" id="prodos" name="prodos">Consultar</button>
                        </div>
                        <div class="col-2">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control"  name="nombreProDos" value="<%= existeProducto2.getNombreProducto()!=null? existeProducto2.getNombreProducto():""%>" disabled>
                              </div>
                        </div>
                        <div class="col">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="valorDos" id="valorDos" value="<%= existeProducto2.getPrecioVenta()!=null? existeProducto2.getPrecioVenta():""%>" disabled>
                        </div>
                        </div> 
                        <div class="col-1">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="cantDos" id="cantDos" onchange="multiplicar2()">
                              </div>
                        </div>
                        <div class="col-1">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="ivaDos" id="ivaDos" value="<%= existeProducto2.getIvacompra()!=null? existeProducto2.getIvacompra():""%>" disabled>
                              </div>
                        </div>
                        <div class="col-2">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="resultadoDos" id="resultadoDos" disabled>
                              </div>
                        </div>
                    </div>
                    <!--</form>-->
        			
                    <script type="text/javascript">
        			function multiplicar2(){
        				  m1 = document.getElementById("valorDos").value;
        				  m2 = document.getElementById("cantDos").value;
        				  r = m1*m2;
        				  document.getElementById("resultadoDos").value = r;
        				}
        			</script>
        			
        			
        			<!--<form>-->
        			<%
                	  		//String productoDigitado3 = "";
        					ProductoDTO dtop3 = new ProductoDTO();
                        	ProductoLogica logicap3 = new ProductoLogica();
                        	ProductoDTO existeProducto3 = new ProductoDTO();
                        	String productoDigitado3 = request.getParameter("cod_tres");
        					
        					if(productoDigitado3 != null){
        						dtop3.setCodigoProducto(productoDigitado3);
        						existeProducto3 = logicap3.ingresarCodigo(dtop3);
        						String codigo3 = existeProducto.getCodigoProducto();
        				
        					}	
        					
        				%>	
                    <div class="row">
                        <div class="col-2">
                            <div class="input-group mb-2">
                                <span class="input-group-text">#</span>
                                <input type="text" class="form-control" name="cod_tres" value="<%= existeProducto3.getCodigoProducto()!=null? existeProducto3.getCodigoProducto():""%>">
                              </div>
                        </div>
                        <div class="col-1">
                            <button type="submit" class="btn btn-primary" id="protres" name="protres">Consultar</button>
                        </div>
                        <div class="col-2">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control"  name="nombreProTres" value="<%= existeProducto3.getNombreProducto()!=null? existeProducto3.getNombreProducto():""%>" disabled>
                              </div>
                        </div>
                        <div class="col">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="valorTres" id="valorTres" value="<%= existeProducto3.getPrecioVenta()!=null? existeProducto3.getPrecioVenta():""%>" disabled>
                        </div>
                        </div>                        
                        <div class="col-1">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="cantTres" id="cantTres" onchange="multiplicar3()">
                              </div>
                        </div>
                        <div class="col-1">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="ivaTres" id="ivaTres" value="<%= existeProducto3.getIvacompra()!=null? existeProducto3.getIvacompra():""%>" disabled>
                              </div>
                        </div>
                        <div class="col-2">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" name="resultadoTres" id="resultadoTres" disabled >
                              </div>
                        </div>
                    </div>
        			<script type="text/javascript">
        			function multiplicar3(){
        				  m1 = document.getElementById("valorTres").value;
        				  m2 = document.getElementById("cantTres").value;
        				  r = m1*m2;
        				  document.getElementById("resultadoTres").value = r;
        				}
        			</script>                    
        			<!--</form>  -->

                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1"></div>
                        <div class="col"></div>
                        <div class="col-1"><label for="">Total Venta</label></div>
                        <div class="col-2">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" id="subtotal" onclick="calculoTotal()">
                              </div>
                        </div>
                     <script type="text/javascript">
        				function calculoTotal(){
        				  m1 = document.getElementById("resultadoUno").value;
        				  m2 = document.getElementById("resultadoDos").value;
        				  m3 = document.getElementById("resultadoTres").value;
        				  i1 = document.getElementById("ivaUno").value;
        				  i2 = document.getElementById("ivaDos").value;
        				  i3 = document.getElementById("ivaTres").value;
        				  var n1 = parseInt(m1);
        				  var n2 = parseInt(m2);
        				  var n3 = parseInt(m3);
        				  var v1 = parseInt(i1)*0.01;
        				  var v2 = parseInt(i2)*0.01;
        				  var v3 = parseInt(i3)*0.01;
        				  
        				  r = n1+n2+n3;
        				  r2 = (n1*v1)+(n2*v2)+(n3+v3)
        				  r3 = r + r2
        				  document.getElementById("subtotal").value = r;
        				  document.getElementById("totalIva").value = r2;
        				  document.getElementById("totalNeto").value = r3;
        				 
        				}
        				
        			</script>  
                    </div>
        
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1"></div>
                        <div class="col"></div>
                        <div class="col-1"><label for="">Total IVA</label></div>
                        <div class="col-2">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" id="totalIva">
                              </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-1"></div>
                        <div class="col">
                            <button type="submit" class="btn btn-primary">Confirmar</button>
                        </div>
                        <div class="col-1"><label for="">Total con IVA</label></div>
                        <div class="col">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" id="totalNeto">
                              </div>
                        </div>
                    </div>
                </div>
    </form>
            </div>
        
<!--        Contenido del sexto tab Reportes ******************************************************************** --> 
        <div class="tab-pane fade" id="pills-reports" role="tabpanel" aria-labelledby="pills-reports-tab">
        <div id="lists_bot" style="margin-top:120px;">
        	<div>
        	 <form method="post" action="/tienda_generica/CrudUsuariosServlet">
            	<div class="d-grid gap-2 col-6 mx-auto" id="lists_reports" style="margin: 10px;">
                	<button class="btn btn-primary" type="submit" id="list_users" name="lista_users">Listado de Usuarios</button>              	
            	</div>
            </form>
        	</div>
			<div>
            <form method="post" action="/tienda_generica/CrudClientesServlet">
            	<div class="d-grid gap-2 col-6 mx-auto" id="lists_reports" style="margin: 10px;">
            		<button class="btn btn-primary" type="submit" id="list_clients" name="lista_clients">Listado de Clientes</button>
                	
                </div>
            </form>
            </div>
            <div>
            <form method="post" action="/tienda_generica/CrudVentasServlet">
            	<div class="d-grid gap-2 col-6 mx-auto" id="lists_reports" style="margin: 10px;">
            		 <button class="btn btn-primary" type="submit" id="list_sales">Ventas por Cliente</button>          	
                </div>
            </form>
            </div>
        </div>
      </div>
</section>
<br>
<br><br>
<br>
<br>
<br>
<br>
<footer id="footer" class="pb-4 pt-4">
    <div class="containerfoot">
        <div class="row text-center">
            <div class="col-12 col-lg">
              <img src="./images/manual.png" alt="" width="65" height="55" >
              <a href="#">Manual de Usuario</a>
            </div>
            <div class="col-12 col-lg">
              <img src="./images/mision_tic_2022.png" alt="" width="90" height="60" >
              <a href="https://www.misiontic2022.gov.co/portal/">Mision-TIC 2022</a>
            </div>
            <div class="col-12 col-lg">
              <img src="./images/contacto.png" alt="" width="70" height="60" >
              <a href="#">Contactanos</a>
            </div>
            </div>
        </div>
    </footer>
  </body>
</html>