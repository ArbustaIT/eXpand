package com.expand.questions;
//Creamos la clase "Pagina" el cual agregamos una función que llamara a otra clase responsable
//de responder con el dato requerido.

import com.expand.UI.Login_Portal;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ContenidoDeLaCajaDeTexto implements Question < String >{
		
		@Override
	    public String answeredBy(Actor actor) {
			
	        return Text.of(Login_Portal.Txt_Usuario).viewedBy(actor).asString();
	    }

}
