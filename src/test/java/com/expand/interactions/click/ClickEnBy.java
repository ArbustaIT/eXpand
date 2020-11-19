package com.expand.interactions.click;

import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.ByAction;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class ClickEnBy extends ByAction {

    @Step("{0} hace click en #locators")
    public <T extends Actor> void performAs(T theUser) {
        resolveFor(theUser).click();
    }

    public ClickEnBy(By... locators) {
        super(locators);
    }

    public ClickEnBy(List<By> locators) {
        super(locators.toArray(new By[]{}));
    }

}
