package com.expand.questions;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.PerformsTasks;

@Subject("the URL of the page")
public class urlDeLaPagina implements Question < String >{
	
	@Override
    public String answeredBy(Actor actor) {
		
        return BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
    }

}
