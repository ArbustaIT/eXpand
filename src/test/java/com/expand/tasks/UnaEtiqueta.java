package com.expand.tasks;

import static com.expand.pageObjects.Administracion.Basico.Etiquetas;
import static com.expand.pageObjects.Administracion.Basico.Etiquetas.Agregar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import net.thucydides.core.annotations.Step;

public class UnaEtiqueta implements Task{

	private String descr;
	private String tag;
	private Boolean esDeSistema;
	


	public UnaEtiqueta(String tag, String descr, Boolean esDeSistema) {

		this.tag = tag;
		this.descr = descr;
		this.esDeSistema = esDeSistema;
	}


	@Override
	@Step("{0} agrega una nueva etiqueta con el nombre '#tag', la descripción '#descr' indicando si es de sistema (#esDeSistema)")
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Click.on(Etiquetas.btn_agregar));
			
		actor.attemptsTo(Enter.keyValues(tag).into(Etiquetas.Agregar.txt_Nombre));
		if (descr != null) {
			actor.attemptsTo(Enter.keyValues(descr).into(Agregar.txt_descripción));
		}

		if (esDeSistema == true) {
			actor.attemptsTo(Click.on(Agregar.tgg_EsDeSistema));
		}


		actor.attemptsTo(Click.on(Agregar.btn_Agregar));
		
		if (Agregar.lbl_ErrorNombreExistente.resolveFor(actor).isVisible() ){
			actor.attemptsTo(Click.on(Agregar.btn_Cancelar));
		}

	}


	private Performable WaitUntilTargetIsReady(Target txt_Nombre) {
		// TODO Auto-generated method stub
		return null;
	}
}
