package com.expand.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.expand.pageObjects.Login_Portal;
import com.expand.pageObjects.Administracion.Basico.Etiquetas;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

public class Iniciar implements Task {
	
public static Login_Portal login;
	private  String cUsuario = "";
	private  String cContraseña = "";
	
	public Iniciar(String cUsuario, String cContraseña) {
		
		this.cUsuario = cUsuario;
		this.cContraseña = cContraseña;
		
	}

	

	public static Performable Sesion(String cUsuario, String cContraseña) {
		return Instrumented.instanceOf(Iniciar.class).withProperties(cUsuario,cContraseña);
	}
	
	
	public static Performable SesionConUnUsuarioInvalido() {
		String cUsuario ="[Usuario inválido]";
		String cContraseña ="[Contraseña inválida]";
		
		return Instrumented.instanceOf(Iniciar.class).withProperties(cUsuario,cContraseña);
	}

	@Override
	@Step("{0} inicia sesión con un usuario válido: #cUsuario, #cContraseña")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.browserOn().the(login),
				Enter.keyValues(cUsuario).into(login.Txt_Usuario),
				Enter.keyValues(cContraseña).into(login.Txt_Contraseña), 
				Click.on(login.BTN_Ingresar)); 
		
	}

	
}
