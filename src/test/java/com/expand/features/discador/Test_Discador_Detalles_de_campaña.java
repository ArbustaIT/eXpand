package com.expand.features.discador;

import static org.junit.Assert.*;
import org.apache.bcel.generic.Select;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
 
//Anotaciones de JUnit
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.expand.UI.*;
import com.expand.UI.Discador.Detalles_Campaña;
import com.expand.UI.Discador.campañas_Activas;
import com.expand.questions.*;
import com.expand.steps.*;
//import com.framework.questions.Pagina;


import net.serenitybdd.core.pages.PageObject;
// Actor, habilidades, preguntas, acctiones y tareas de Serrenity Screenplay
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.questions.UnresolvedTargetWebElementState;
import net.serenitybdd.screenplay.questions.targets.TargetAttribute;
import net.serenitybdd.screenplay.questions.targets.TargetAttributes;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.WebDriverQuestion;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.*;
import net.serenitybdd.screenplay.questions.*;
 
//Anotaciones para la preparación de los casos de prueba de serenity.
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
 
//Núcleo de la forma de escribir casos de prueba con serenity screenplay + heramientas de comparación y preguntas.
import static net.serenitybdd.screenplay.GivenWhenThen.*;


import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.util.Optional;


import org.junit.Test;


@RunWith(SerenityRunner.class)
public class Test_Discador_Detalles_de_campaña {
	@Managed(driver = "chrome")
    public WebDriver suNavegador;
	
	public Actor Fer =Actor.named("Fer");
	
   //Agregamos
    public Login login;
    public Home home;
    
    @Before
    public void setup() {
    	String Usuario = "fbarrionuevo";
		String Contraseña = "fbarrionuevo";
		
    Fer.can(BrowseTheWeb.with(suNavegador))	;
    Fer.attemptsTo(Open.browserOn().the(login),
			  Enter.keyValues(Usuario).into(login.Txt_Usuario),
			  Enter.keyValues(Contraseña).into(login.Txt_Contraseña),
			  Click.on(login.BTN_Ingresar)); 
    }
	
	@Ignore
	@Test
	public void Test_Pausar_reanudar_Campaña() throws InterruptedException {		
		String Usuario = "fbarrionuevo";
		String Contraseña = "fbarrionuevo";
		
		
		when(Fer).attemptsTo(
				Click.on(home.MNU_Discador));
		
		//------------------------------------
		System.out.println("Play Es visible: \n"+ Discador.campañas_Activas.BTN_Play.resolveFor(Fer).isVisible());
		System.out.println("Play Es Mostrado : \n"+ Discador.campañas_Activas.BTN_Play.resolveFor(Fer).isDisplayed());
		System.out.println("Play Esta habilitado: \n"+ Discador.campañas_Activas.BTN_Play.resolveFor(Fer).isEnabled());
		//System.out.println("Play Es clickeable: \n"+ Discador.campañas_Activas.BTN_Play.resolveFor(Fer).isClickable());
		System.out.println("Play Es presente: \n"+ Discador.campañas_Activas.BTN_Play.resolveFor(Fer).isPresent());
		System.out.println("Play Es visible atributo HTML: \n" + TheTarget.attributeNamed("visibility").forTarget(Discador.campañas_Activas.BTN_Play).answeredBy(Fer).toString());
		System.out.println("Play Es visible CSS: \n" + TheTarget.cssValueNamed("visibility").forTarget(Discador.campañas_Activas.BTN_Play).answeredBy(Fer).toString());
		//Discador.campañas_Activas.BTN_Play.resolveFor(Fer).click();
		System.out.println("---------------------");
		System.out.println("Pausa Es visible: \n"+ Discador.campañas_Activas.BTN_Pause.resolveFor(Fer).isVisible());
		System.out.println("Pausa Es Mostrado : \n"+ Discador.campañas_Activas.BTN_Pause.resolveFor(Fer).isDisplayed());
		System.out.println("Pausa Esta habilitado: \n"+ Discador.campañas_Activas.BTN_Pause.resolveFor(Fer).isEnabled());
		//System.out.println("Pausa Es clickeable: \n"+ Discador.campañas_Activas.BTN_Pause.resolveFor(Fer).isClickable());
		System.out.println("Pausa Es presente: \n"+ Discador.campañas_Activas.BTN_Pause.resolveFor(Fer).isPresent());
		System.out.println("Pausa Es visible atributo HTML: \n" + TheTarget.attributeNamed("visibility").forTarget(Discador.campañas_Activas.BTN_Pause).answeredBy(Fer).toString());
		System.out.println("Pausa Es visible CSS: \n" + TheTarget.cssValueNamed("visibility").forTarget(Discador.campañas_Activas.BTN_Pause).answeredBy(Fer).toString());
		System.out.println("---------------------");

		//-----------------------------------
		
		String BTN_Pausa_se_muestra= Discador.campañas_Activas.BTN_Pause.resolveFor(Fer).isDisplayed()? "true": "false";
		
		switch (BTN_Pausa_se_muestra) {
		case "true":
			andThat(Fer).attemptsTo(Click.on(Discador.campañas_Activas.BTN_Pause));
			
			then(Fer).should(eventually(seeThat(TheValue.of(Discador.campañas_Activas.BTN_Play.resolveFor(Fer).isDisplayed()), is(true)
					)));
			
			break;
		
		case "false":
		
			andThat(Fer).attemptsTo(Click.on(Discador.campañas_Activas.BTN_Play));
			then(Fer).should(eventually(seeThat(TheTarget.attributeNamed("src").forTarget(Discador.campañas_Activas.BTN_Play)
					,containsString("Play.png"))));
			break;
		
		default:
			break;
		}
		
			
			
			
				
		
	}
	
	@Test
	public void Test_Detalles_de_la_Campaña() throws InterruptedException {		
		String Usuario = "fbarrionuevo";
		String Contraseña = "fbarrionuevo";
		
		
		when(Fer).attemptsTo(
				Click.on(home.MNU_Discador));
		and(Fer).remember("Campaña_Seleccionada", TheTarget.textOf(Discador.campañas_Activas.LBL_Titulo_De_La_Campaña));
		andThat(Fer).attemptsTo(Click.on(Discador.campañas_Activas.LBL_Titulo_De_La_Campaña));
		
		
		then(Fer).should(eventually(seeThat(TheTarget.textOf(Detalles_Campaña.LBL_Titulo)
				, is(Fer.recall("Campaña_Seleccionada").toString()))));
	}

	@Test
	public void Test_vacío() {
		
	}


	@After
    public void after() throws IOException { 
    	Runtime.getRuntime().exec("cmd.exe /c mvn serenity:aggregate");
   	}

}


