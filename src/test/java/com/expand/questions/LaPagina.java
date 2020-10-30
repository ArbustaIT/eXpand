package com.expand.questions;
//Creamos la clase "Pagina" el cual agregamos una función que llamara a otra clase responsable
//de responder con el dato requerido.

public class LaPagina {
    public static urlDeLaPagina urlActual() {
        return new urlDeLaPagina();
    }
    
    public static suContenido suContenido() {
        return new suContenido();
    }
    
    public static suContenido ContenidoDeLaCajaDeTexto() {
        return new suContenido();
    }
    
}
