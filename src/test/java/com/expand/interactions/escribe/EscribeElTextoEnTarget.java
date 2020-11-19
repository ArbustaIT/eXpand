package com.expand.interactions.escribe;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class EscribeElTextoEnTarget extends EnterValue {

    private Target target;

    public EscribeElTextoEnTarget(String theText, Target target) {
        super(theText);
        this.target = target;
    }

    @Step("{0} escribe '#theText' en #target")
    public <T extends Actor> void performAs(T theUser) {
        target.resolveFor(theUser).type(theText);
        if (getFollowedByKeys().length > 0) {
            target.resolveFor(theUser).sendKeys(getFollowedByKeys());
        }
    }
}
