package com.expand.test;

import com.expand.pageObjects.Administracion;

import static org.junit.Assert.*;
//import org.apache.bcel.generic.Select;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;

//Anotaciones de JUnit
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.expand.pageObjects.*;
import com.expand.questions.*;
import com.expand.steps.*;
//import com.framework.questions.Pagina;
import com.expand.pageObjects.*;

import net.serenitybdd.core.pages.PageObject;
// Actor, habilidades, preguntas, acctiones y tareas de Serrenity Screenplay
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.questions.WebDriverQuestion;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.*;


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
public class Test_Administración_Basico_Etiquetas {
	@Managed(driver = "chrome")
	public WebDriver suNavegador;

	public Actor Fer =Actor.named("Fer");

	//Agregamos
	public Login_Portal_Devel login;
	public Home_Portal home_portal;
	public Administracion_Basico_Etiquetas Etiquetas;
	public Administracion_Basico_Etiquetas_Agregar Agregar;

	//@Before
	public void setUP() {
		String Usuario = "fbarrionuevo";
		String Contraseña = "fbarrionuevo";

		Fer.can(BrowseTheWeb.with(suNavegador));
		Fer.attemptsTo(Open.browserOn().the(login),
				Enter.keyValues(Usuario).into(login.Txt_Usuario),
				Enter.keyValues(Contraseña).into(login.Txt_Contraseña), 
				Click.on(login.BTN_Ingresar)); 
		Fer.attemptsTo(Click.on(home_portal.menu),
				Click.on(home_portal.Administracion),
				Click.on(home_portal.Administracion_Basico),
				Click.on(home_portal.Administracion_Basico_Etiquetas));
	}

	public void setUP2() {
		// Ver un usuario sin permiso.
		String Usuario = "fbarrionuevo";
		String Contraseña = "fbarrionuevo";

		Fer.can(BrowseTheWeb.with(suNavegador));
		Fer.attemptsTo(Open.browserOn().the(login),
				Enter.keyValues(Usuario).into(login.Txt_Usuario),
				Enter.keyValues(Contraseña).into(login.Txt_Contraseña), 
				Click.on(login.BTN_Ingresar)); 
	}

	@Test
	public void Test_Acceso_Agente_con_permisos() {		
		setUP();


		then(Fer).should(eventually(seeThat(Pagina.urlActual(), is("http://canalesdigitales-devel.expand/expand/es/admin/basic/tags"))));

	}

	@Test
	public void Test_Acceso_Agente_sin_permisos() {		
		setUP2();
		when( Fer).attemptsTo(Click.on(home_portal.menu),
				Click.on(home_portal.Administracion),
				Click.on(home_portal.Administracion_Basico),
				Click.on(home_portal.Administracion_Basico_Etiquetas));
		then(Fer).should(eventually(seeThat(TheValue.of(home_portal.Administracion_Basico_Etiquetas.resolveFor(Fer).isPresent()), is(false))));

	}

	@Test
	public void Test_Acceso_Agente_sin_permisos_URL_Directa() {		
		setUP2();

		when( Fer).attemptsTo(Open.browserOn().url("http://canalesdigitales-devel.expand/expand/es/admin/basic/tags")
				);
		//Ver otros métodos de detectar que no se vean los elementos.
		then(Fer).should(eventually(seeThat(TheValue.of(suNavegador.getCurrentUrl()), not(is("http://canalesdigitales-devel.expand/expand/es/admin/basic/tags")) ) ) );

	}
	
	@Test
	public void Test_Agregar_etiqueta_Sin_tildes() {		
		setUP();
		String tag = "AutomationTag";  
		String descr ="Descripcion de ejemplo"; //No toma acentos en las descripciónes. 
		
		givenThat(Fer).attemptsTo(Click.on(Etiquetas.btn_agregar));
		
		when(Fer).attemptsTo(Enter.keyValues(tag).into(Agregar.txt_Nombre),
				Enter.keyValues(descr).into(Agregar.txt_descripción),
				Click.on(Agregar.tgg_EsDeSistema),
				Click.on(Agregar.btn_Agregar)
				);
		
		//Ver otros métodos de detectar que no se vean los elementos.
		then(Fer).should(eventually(seeThat(TheValue.of(Etiquetas.containsText(tag)), is(true) ) ));

	}

	@Test
	public void Test_Agregar_etiqueta_en_uso() {		
		setUP();
		String tag = "AutomationTag";  
		String descr ="Descripcion de ejemplo";

		when( Fer).attemptsTo(Click.on(Etiquetas.btn_agregar),
				Enter.keyValues(tag).into(Agregar.txt_Nombre),
				Enter.keyValues(descr).into(Agregar.txt_descripción),
				Click.on(Agregar.tgg_EsDeSistema),
				Click.on(Agregar.btn_Agregar)
				);
		//Chequear si el texto de [tag] aparece en pantalla.
		then(Fer).should(eventually(seeThat(TheValue.of(Agregar.containsText("Ya existe un tag con el mismo nombre")), is(true) ) ));

	}

	@Test
	public void Test_Agregar_etiqueta_No_Permitidas_Con_tildes() {		
		setUP();
		String tag = "AutomationTag";  
		String descr ="Descripción de ejemplo"; 
		
		
		givenThat(Fer).attemptsTo(Click.on(Etiquetas.btn_agregar));
		
		when(Fer).attemptsTo(Enter.keyValues(tag).into(Agregar.txt_Nombre),
				Enter.keyValues(descr).into(Agregar.txt_descripción),
				Click.on(Agregar.tgg_EsDeSistema),
				Click.on(Agregar.btn_Agregar)
				);
		//Ver otros métodos de detectar que no se vean los elementos.
		then(Fer).should(eventually(seeThat(TheValue.of(suNavegador.getPageSource().contains(tag)), is(true) ) ));

	}
	
	@Test
	public void Test_Agregar_etiqueta_nombre_vacio() {		
		setUP();
		String tag = "";  
		String descr ="Descripcion de ejemplo";

		when( Fer).attemptsTo(Click.on(Etiquetas.btn_agregar),
				Enter.keyValues(tag).into(Agregar.txt_Nombre),
				Enter.keyValues(descr).into(Agregar.txt_descripción),
				Click.on(Agregar.tgg_EsDeSistema),
				Click.on(Agregar.btn_Agregar)
				);
		//Chequear si el texto de [tag] aparece en pantalla.
		then(Fer).should(eventually(seeThat(TheValue.of(Agregar.containsText("Campo requerido")), is(true) ) ));

	}
	
	@Test
	public void Test_Agregar_etiqueta_descripcion_vacio() {		
		setUP();
		String tag = "Agregar_etiqueta_descripcion_vacio";  
		String descr ="";

		when( Fer).attemptsTo(Click.on(Etiquetas.btn_agregar),
				Enter.keyValues(tag).into(Agregar.txt_Nombre),
				Enter.keyValues(descr).into(Agregar.txt_descripción),
				Click.on(Agregar.tgg_EsDeSistema),
				Click.on(Agregar.btn_Agregar)
				);
		//Chequear si el texto de [tag] aparece en pantalla.
		then(Fer).should(eventually(seeThat(TheValue.of(Etiquetas.containsText(tag)), is(true) ) ));
Target objeto = Target.the("etiqueta").locatedBy("//mat-label[contains(text(),'"+tag+"')]");
Target opcionesObjeto = Target.the("").locatedBy(
		getAbsoluteXPath(suNavegador, suNavegador.findElement(By.xpath(objeto.getCssOrXPathSelector())).findElement(By.xpath("./..")).findElement(By.xpath("./.."))//.findElement(By.xpath("//mat-cell[5]//button[1]"))
				));
//Fer.attemptsTo(Click.on(opcionesObjeto));
System.out.println(objeto.getCssOrXPathSelector());
System.out.println(opcionesObjeto.getCssOrXPathSelector());
//System.out.println(objeto.);
	}
	


	@After
	public void after() throws IOException { 
		Runtime.getRuntime().exec("cmd.exe /c mvn serenity:aggregate");
	}

	
	

	public static String getAbsoluteXPath(WebDriver driver,WebElement element)
	{
	    return (String) ((JavascriptExecutor) driver).executeScript(
	            "function absoluteXPath(element) {"+
	                    "var comp, comps = [];"+
	                    "var parent = null;"+
	                    "var xpath = '';"+
	                    "var getPos = function(element) {"+
	                    "var position = 1, curNode;"+
	                    "if (element.nodeType == Node.ATTRIBUTE_NODE) {"+
	                    "return null;"+
	                    "}"+
	                    "for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling) {"+
	                    "if (curNode.nodeName == element.nodeName) {"+
	                    "++position;"+
	                    "}"+
	                    "}"+
	                    "return position;"+
	                    "};"+

	                    "if (element instanceof Document) {"+
	                    "return '/';"+
	                    "}"+

	                    "for (; element && !(element instanceof Document); element = element.nodeType == Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {"+
	                    "comp = comps[comps.length] = {};"+
	                    "switch (element.nodeType) {"+
	                    "case Node.TEXT_NODE:"+
	                    "comp.name = 'text()';"+
	                    "break;"+
	                    "case Node.ATTRIBUTE_NODE:"+
	                    "comp.name = '@' + element.nodeName;"+
	                    "break;"+
	                    "case Node.PROCESSING_INSTRUCTION_NODE:"+
	                    "comp.name = 'processing-instruction()';"+
	                    "break;"+
	                    "case Node.COMMENT_NODE:"+
	                    "comp.name = 'comment()';"+
	                    "break;"+
	                    "case Node.ELEMENT_NODE:"+
	                    "comp.name = element.nodeName;"+
	                    "break;"+
	                    "}"+
	                    "comp.position = getPos(element);"+
	                    "}"+

	                    "for (var i = comps.length - 1; i >= 0; i--) {"+
	                    "comp = comps[i];"+
	                    "xpath += '/' + comp.name.toLowerCase();"+
	                    "if (comp.position !== null) {"+
	                    "xpath += '[' + comp.position + ']';"+
	                    "}"+
	                    "}"+

	                    "return xpath;"+

	                    "} return absoluteXPath(arguments[0]);", element);
	}
	
}


