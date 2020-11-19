package com.expand.interactions.click;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class ClickEnTarget implements Interaction  {
	private final Target target;

	@Step("{0} hace click en #target")
	public <T extends Actor> void performAs(T theUser) {
        target.resolveFor(theUser).click();
    }

    public ClickEnTarget(Target target) {
        this.target = target;
    }

}
