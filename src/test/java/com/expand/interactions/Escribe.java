package com.expand.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import com.expand.interactions.escribe.EscribeElTextoEnBy;
import com.expand.interactions.escribe.EscribeElTextoEnTarget;
import com.expand.interactions.escribe.EscribeEnWebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;


	public class Escribe {

	    private final String theText;

	    public Escribe(String theText) {
	        this.theText = theText;
	    }

	    public static Escribe elTexto(String texto) {
	        return new Escribe(texto);
	    }

	    public static SendKeys lasPulsacionesDeTeclas(String texto) {
	        return new SendKeys(texto);
	    }

	    public EnterValue en(String cssOrXpathForElement) {
	        return instrumented(EscribeElTextoEnTarget.class, theText, Target.the(cssOrXpathForElement).locatedBy(cssOrXpathForElement));
	    }

	    public EnterValue en(Target target) {
	        return instrumented(EscribeElTextoEnTarget.class, theText, target);
	    }

	    public EnterValue en(WebElementFacade element) {
	        return instrumented(EscribeEnWebElement.class, theText, element);
	    }

	    public EnterValue en(By... locators) {
	        return instrumented(EscribeElTextoEnBy.class, theText, locators);
	    }
	}

