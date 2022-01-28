function consultar(){
    //obterner valores de los campos
    var cedula = document.getElementById("campo_cedula").value;
    //para verificar que estoy leyendo los campos los muestro con un alert
    //console.log(cedula)
    //alert(cedula)
}

function crearBorrar(){
    //obterner valores de los campos
    var cedula = document.getElementById("campo_cedula").value;
    var nombre = document.getElementById("campo_nombre").value;
    var apellido = document.getElementById("campo_apellido").value;
    var correo = document.getElementById("campo_correo").value;
    var password = document.getElementById("campo_password").value;
    var usuario = document.getElementById("campo_usuario").value;

    //para verificar que estoy leyendo los campos los muestro con un alert
   // alert(cedula+"    "+nombre +"   "+ apellido +"   "+ correo +"   "+ password +"   "+ usuario)
}

function actualizar(){
    //obterner valores de los campos
    var nombre = document.getElementById("campo_nombre").value;
    var apellido = document.getElementById("campo_apellido").value;
    var correo = document.getElementById("campo_correo").value;
    var password = document.getElementById("campo_password").value;
    var usuario = document.getElementById("campo_usuario").value;

    //para verificar que estoy leyendo los campos los muestro con un alert
    //alert(nombre +"   "+ apellido +"   "+ correo +"   "+ password +"   "+ usuario)
}