package com.expand.interactions.escribe;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.thucydides.core.annotations.Step;

import java.util.stream.Stream;

public class EscribeEnWebElement extends EnterValue {

    private WebElementFacade element;

    public EscribeEnWebElement(String theText, WebElementFacade element) {
        super(theText);
        this.element = element;
    }

    @Step("{0} escribe '#theText' en #element")
    public <T extends Actor> void performAs(T theUser) {
        element.type(theText);
        if (getFollowedByKeys().length > 0) {
            element.sendKeys(getFollowedByKeys());
        }
    }
}
