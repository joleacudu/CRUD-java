var boton1 = document.getElementByName("boton_consu");
var boton2 = document.getElementByName("boton_crea");
var boton3 = document.getElementByName("boton_actu");
var boton4 = document.getElementByName("boton_borra");

boton1.addEventListener("click",validarConsulta);
boton2.addEventListener("click",validarNombre);
boton3.addEventListener("click",validarApellido);
boton4.addEventListener("click",validarEmail);

function validarConsulta() {
	if(boton1 != null){
		var serv = "/ConsultarServlet"
		return serv;
	}else{
		return false
	}
  }