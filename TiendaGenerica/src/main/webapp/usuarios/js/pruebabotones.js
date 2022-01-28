function habilitar(){ 
    var usu = document.getElementById("usuario");
    var pass = document.getElementById("contrasena");
    var sesion = document.getElementById("iniciar_sesion");
    if(usu.value != "" && pass.value!= ""){
        sesion.disabled = false;
    }else{
        sesion.disabled = true;
    }
}
