package com.expand.questions;

import org.openqa.selenium.WebDriver;

import com.expand.pageObjects.Login_Portal;
import com.expand.pageObjects.Login_Portal_Devel;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.PerformsTasks;

@Subject("El URL de la página")
public class urlDeLaPagina implements Question < String >{
	
	@Override
//    public String answeredBy(Actor actor) {
//		
//        return BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
//    }
    public String answeredBy(Actor actor) {
		
        return Text.of(Login_Portal.Txt_Usuario).viewedBy(actor).asString();
    }

}
