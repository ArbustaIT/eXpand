package com.expand.interactions.escribe;

import net.serenitybdd.core.collect.NewList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actions.WebElementLocator;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EscribeElTextoEnBy extends EnterValue {

    private final List<By> locators;

    protected WebElement resolveFor(Actor theUser) {
        return WebElementLocator.forLocators(locators).andActor(theUser);
    }

    public EscribeElTextoEnBy(String theText, By... locators) {
        super(theText);
        this.locators = NewList.copyOf(locators);
    }

    @Step("{0} escribe '#theText' en #locators")
    public <T extends Actor> void performAs(T theUser) {
        resolveFor(theUser).sendKeys(theText);
        if (getFollowedByKeys() != null && getFollowedByKeys().length > 0) {
            resolveFor(theUser).sendKeys(getFollowedByKeys());
        }
    }
}
