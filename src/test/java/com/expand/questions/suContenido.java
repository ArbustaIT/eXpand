package com.expand.questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.PerformsTasks;

@Subject("El URL de la página")
public class suContenido implements Question < String >{
	
	@Override
    public String answeredBy(Actor actor) {
		
        return Text.of("//body[1]").viewedBy(actor).asString();
    }

}
