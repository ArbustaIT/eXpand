package com.expand.questions;
//Creamos la clase "Pagina" el cual agregamos una función que llamara a otra clase responsable
//de responder con el dato requerido.

public class Pagina {
    public static urlDeLaPagina urlActual() {
        return new urlDeLaPagina();
    }
}
