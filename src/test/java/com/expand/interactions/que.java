package com.expand.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class que implements Interaction{

	private final String descripcion;

	@Step("{0} vio que #descripcion")
	public <T extends Actor> void performAs(T theUser) {

	}

	public que(String descripcion) {
		this.descripcion = descripcion;
	}
}