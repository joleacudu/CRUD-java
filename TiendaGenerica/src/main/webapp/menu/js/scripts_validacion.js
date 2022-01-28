var boton = document.getElementById("boton_crear");//traigo las variables por id del html
//boton.addEventListener("click",validarCedula);
//boton.addEventListener("click",validarNombre);
//boton.addEventListener("click",validarApellido);
//boton.addEventListener("click",validarEmail);
//boton.addEventListener("click",validarUsuario);
//boton.addEventListener("click",validarPassword);
emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;

function validarEmail() {
    
    var c =document.getElementById("campo_correo").value;
    console.log(c);
    if (emailRegex.test(c)){
     //alert("La dirección de email " + c + " es correcta.");
    } else {
     //alert("La dirección de email es incorrecta.");
    }
  }

function validarCedula() {
  //obteniendo el valor que se puso en el campo text del formulario
  var miCampoTexto = document.getElementById("campo_cedula").value;
  //la condición
  if (miCampoTexto.length == 0) {
      alert('El campo de Cedula esta incorrecto!');
  }
}

function validarNombre() {
  //obteniendo el valor que se puso en el campo text del formulario
  var miCampoTexto = document.getElementById("campo_nombre").value;
  //la condición
  if (miCampoTexto.length == 0) {
      alert('El campo de Nombres esta incorrecto!');  
  }
}

function validarApellido() {
  //obteniendo el valor que se puso en el campo text del formulario
  var miCampoTexto = document.getElementById("campo_apellido").value;
  //la condición
  if (miCampoTexto.length == 0) {
      alert('El campo de Apellidos esta incorrecto!');     
  }
}

function validarUsuario() {
  //obteniendo el valor que se puso en el campo text del formulario
  var miCampoTexto = document.getElementById("campo_usuario").value;
  //la condición
  if (miCampoTexto.length == 0) {
      alert('El campo de Usuario esta incorrecto!');    
  }
}

function validarPassword() {
  //obteniendo el valor que se puso en el campo text del formulario
  var miCampoTexto = document.getElementById("campo_password").value;
  //la condición
  if (miCampoTexto.length == 0) {
      alert('El campo de Contraseña esta incorrecto!');
  }
}


function soloNumeros(e) {

  key = e.keyCode || e.which; //almacena la entrada del teclado
  teclado = String.fromCharCode(key); //variable para almacenar lo que esta en la entrada del teclado
  numeros = "0123456789"; // declaro una variable con los valores validos
  especiales = "8-37-38-46";//array, teclas especiales que si quiero que se ejecuten
  teclado_especial = false;
  // busco la tecla presionada dentro del array especiales, mediante el for
  for(var i in especiales){
      if (key == especiales[i]){ //valido con un if si lo que se captura por teclado es igual al array
          teclado_especial = true;
          break;
      } 
  }
  if (numeros.indexOf(teclado) == -1 && !teclado_especial) {
    return false;
  }
}

function soloLetras(e) {
  //es el mismo que el de los numeros
  var key = e.keyCode || e.which;
    teclado = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = "8, 37, 39, 46";
    teclado_especial = false;

  for (var i in especiales) {
    if (key == especiales[i]) {
      teclado_especial = true;
      break;
    }
  }
  if (letras.indexOf(teclado) == -1 && !teclado_especial) {
    return false;
  }
}

