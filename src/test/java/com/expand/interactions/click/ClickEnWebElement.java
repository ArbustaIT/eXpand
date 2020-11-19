package com.expand.interactions.click;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class ClickEnWebElement implements Interaction  {
	private final WebElementFacade element;
	

	@Step("{0} hace click en #target")
    public <T extends Actor> void performAs(T theUser) {
        element.click();
    }

    public ClickEnWebElement(WebElementFacade element) {
        this.element = element;
    }

}
