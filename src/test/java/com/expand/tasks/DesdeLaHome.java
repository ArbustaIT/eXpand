package com.expand.tasks;

import com.expand.pageObjects.Home_Portal;
import com.expand.pageObjects.Administracion_Basico_Etiquetas;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import com.expand.interactions.*;
//import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class DesdeLaHome implements Task {

	
	public static Performable irAAdminisrtaciónBasicoEtiquetas() {
		
		return Instrumented.instanceOf(DesdeLaHome.class).newInstance();
	}

	private Home_Portal home_portal;
	private Administracion_Basico_Etiquetas etiquetas;

	@Override
	@Step("{0} se dirige a Administración > Básico > Etiquetas.")
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		actor.attemptsTo(Click.en(home_portal.menu),
				Click.en(home_portal.Administracion),
				Click.en(home_portal.Administracion_Basico),
				Click.en(home_portal.Administracion_Basico_Etiquetas)
				);
		actor.asksFor(the(etiquetas.celda(1))).isCurrentlyVisible();
	}
	}

