function IrACrearServlet(DireccionACambiar){
    DireccionACambiar = /tienda_generica/CrearServlet
    document.formulario.action = DireccionACambiar;
    document.formulario.submit();
    alert("crear");
}

function IrAConsultarServlet(DireccionACambiar){
    DireccionACambiar = /tienda_generica/ConsultarServlet
    document.formulario.action = DireccionACambiar;
    alert("consulta");
    document.formulario.submit();
}

function IrAActualizarServlet(DireccionACambiar){
    DireccionACambiar = /tienda_generica/ActualizarServlet
    document.formulario.action = DireccionACambiar;
    alert("actualiza");
    document.formulario.submit();
}

function IrABorrarServlet(DireccionACambiar){
    DireccionACambiar = /tienda_generica/BorrarServlet
    document.formulario.action = DireccionACambiar;
    alert("borra");
    document.formulario.submit();
}