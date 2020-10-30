package com.expand.tasks;

import com.expand.pageObjects.Administracion_Basico_Etiquetas;
import com.expand.pageObjects.Administracion.Basico.Etiquetas;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.core.steps.Instrumented.InstrumentedBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Eliminar  implements Task {

	private Administracion_Basico_Etiquetas Etiquetas;
	private String tag;

	public Eliminar(String tag) {
		super();
		this.tag = tag;
	}
	public static Performable laEtiqueta(String tag) {
		return Instrumented.instanceOf(Eliminar.class).withProperties(tag);
	}
	@Override
	public <T extends Actor> void performAs(T actor) {
		try {
			Etiquetas.Eliminar_Etiqueta_Por_Nombre(actor,tag);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

}
