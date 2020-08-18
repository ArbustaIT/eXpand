package com.expand.test;

import static org.junit.Assert.*;
import org.apache.bcel.generic.Select;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
 
//Anotaciones de JUnit
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.expand.pageObjects.*;
import com.expand.questions.*;
import com.expand.steps.*;
//import com.framework.questions.Pagina;
import com.expand.pageObjects.*;

import net.serenitybdd.core.pages.PageObject;
// Actor, habilidades, preguntas, acctiones y tareas de Serrenity Screenplay
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.WebDriverQuestion;
import net.serenitybdd.screenplay.Question;
 
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
public class Test_Login {
	@Managed(driver = "chrome")
    public WebDriver suNavegador;
	
	public Actor Fer =Actor.named("Fer");
	
   //Agregamos
    public Login login;
    public Home home;
    public Discador discador;
	
	@Test
	public void Test_Login_Correcto() {		
		String Usuario = "fbarrionuevo";
		String Contraseña = "fbarrionuevo";
		
		  Fer.can(BrowseTheWeb.with(suNavegador));
		  Fer.attemptsTo(Open.browserOn().the(login),
				  Enter.keyValues(Usuario).into(login.Txt_Usuario),
				  Enter.keyValues(Contraseña).into(login.Txt_Contraseña), 
				  Click.on(login.BTN_Ingresar)); 
		 
		  //then(Fer).should(eventually(seeThat(Pagina.urlActual(), is("http://canalesdigitales.expand/frontEnd/panel"))));

	}
	
	@Test
	public void Test_Login_Usuario_vacío() {		
		String Usuario = "";
		String Contraseña = "fbarrionuevo";
		
		  givenThat(Fer).can(BrowseTheWeb.with(suNavegador));
		  when(Fer).attemptsTo(Open.browserOn().the(login),
				  Enter.keyValues(Usuario).into(login.Txt_Usuario),
				  Enter.keyValues(Contraseña).into(login.Txt_Contraseña),
				  Click.on(login.BTN_Ingresar)); 
		  then(Fer).should(eventually(seeThat(Pagina.urlActual(), not(is("http://canalesdigitales.expand/frontEnd/panel")))));

	}
	
	@Test
	public void Test_Login_Contraseña_vacío() {		
		String Usuario = "fbarrionuevo";
		String Contraseña = "fbarrionuevo";
		
		  givenThat(Fer).can(BrowseTheWeb.with(suNavegador));
		  when(Fer).attemptsTo(Open.browserOn().the(login),
				  Enter.keyValues(Usuario).into(login.Txt_Usuario),
				  Enter.keyValues(Contraseña).into(login.Txt_Contraseña),
				  Click.on(login.BTN_Ingresar)); 
		  then(Fer).should(eventually(seeThat(Pagina.urlActual(),not(is("http://canalesdigitales.expand/frontEnd/panel")))));

	}
	
    @After
    public void after() throws IOException { 
    	Runtime.getRuntime().exec("cmd.exe /c mvn serenity:aggregate");
   	}

}


