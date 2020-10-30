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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.expand.pageObjects.*;
import com.expand.pageObjects.Discador.Detalles_Campaña;
import com.expand.pageObjects.Discador.campañas_Activas;
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
import net.serenitybdd.screenplay.questions.targets.TargetText;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
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
public class Test_Discador {
	@Managed(driver = "chrome")
    public WebDriver suNavegador;
	
	public Actor Fer =Actor.named("Fer");
	
   //Agregamos
    public Login login;
    public Home home;
    public Discador.Crear_Campaña_Paso1 CrearCampaña;
    public Discador.Crear_Campaña_Paso2 ContactosCampaña;
    
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
	public void Test_Crear_Campaña() throws InterruptedException {		
		when(Fer).attemptsTo(
				Click.on(home.MNU_Discador),
						Click.on(Discador.BTN_Crear_campaña));
		
		and(Fer).attemptsTo(Scroll.to(Discador.Crear_Campaña_Paso1.txt_Nombre),
				Enter.keyValues("Demo campaña").into(Discador.Crear_Campaña_Paso1.txt_Nombre)
				);
		Fer.remember("Nombre de la campaña", 
				Discador.Crear_Campaña_Paso1.txt_Nombre.resolveFor(Fer).getTextValue()
				);
		
		andThat(Fer).attemptsTo(
				Click.on(CrearCampaña.cal_FechaDeInicio),
				Hit.the(Keys.ENTER).into(CrearCampaña.cal_SelFechaDeInicio(5)),
				Click.on(CrearCampaña.cal_FechaDeFinalizacion),
				Hit.the(Keys.ENTER).into(CrearCampaña.cal_SelFechaDeFin(15)));
		and(Fer).attemptsTo(
				Click.on(CrearCampaña.cbo_HoraDeInicio(11)),
				Click.on(CrearCampaña.cbo_MinutoDeInicio(45)));
		
		and(Fer).attemptsTo(
				Click.on(CrearCampaña.cbo_HoraDeFinalizacion(21)),
				Click.on(CrearCampaña.cbo_MinutoDeFin(0)));
		
		and(Fer).attemptsTo(
				Click.on(CrearCampaña.cob_TipoDeCampaña),
				WaitUntil.the(CrearCampaña.opc_TipoDeCampaña_WhatsApp, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(CrearCampaña.opc_TipoDeCampaña_WhatsApp));
		
		and(Fer).attemptsTo(
				Click.on(CrearCampaña.cbo_Canal),
				WaitUntil.the(CrearCampaña.opc_Canal_opc_2, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(CrearCampaña.opc_Canal_opc_2));
		
		and(Fer).attemptsTo(
				Click.on(CrearCampaña.cbo_Template),
				WaitUntil.the(CrearCampaña.opc_Template_Informa, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(CrearCampaña.opc_Template_Informa));
		
		and(Fer).attemptsTo(Click.on(CrearCampaña.btn_crear));
		
		//Fase 2: Contactos.
		and(Fer).attemptsTo(
				Click.on(ContactosCampaña.lbl_agregarContactos),
				Click.on(ContactosCampaña.btn_agregarContactos),
				Enter.theValue("Fer").into(ContactosCampaña.txt_Nombre),
				Enter.theValue("+541153413898").into(ContactosCampaña.txt_Telefono),
				Enter.theValue("Demo automation").into(ContactosCampaña.txt_InfoAdicional1),
				Enter.theValue("Discador").into(ContactosCampaña.txt_InfoAdicional2),
				Click.on(ContactosCampaña.btn_Agregar),
				Click.on(ContactosCampaña.btn_Finalizar)
				)
		;
		
//		then(Fer).should(
//				eventually(
//						seeThat(
//								Remembered.valueOf("Nombre de la campaña").answeredBy(Fer),
//								Discador.Detalles_Campaña.LBL_Titulo.resolveFor(Fer).getTextContent(), 
//								is(Fer.recall("Nombre de la campaña").toString())
//								)
//							)
//						);
		
		System.out.println(Discador.Detalles_Campaña.LBL_Titulo.resolveFor(Fer).getTextContent());
		
		then(Fer).should(
				eventually(
						seeThat(Text.of(Discador.Detalles_Campaña.LBL_Titulo).viewedBy(Fer).asAQuestion()
								,is(Fer.recall("Nombre de la campaña").toString())
								)
							)
						);
	}
	
	@Test
	public void Test_Crear_Campaña_Sel_calendario() throws InterruptedException {	
		when(Fer).attemptsTo(
				Click.on(home.MNU_Discador),
						Click.on(Discador.BTN_Crear_campaña));
		
		and(Fer).attemptsTo(Scroll.to(Discador.Crear_Campaña_Paso1.txt_Nombre),
				Enter.keyValues("Demo campaña").into(Discador.Crear_Campaña_Paso1.txt_Nombre)
				);
		Fer.remember("Nombre de la campaña", 
				Discador.Crear_Campaña_Paso1.txt_Nombre.resolveFor(Fer).getTextValue()
				);
		
		andThat(Fer).attemptsTo(
				Click.on(CrearCampaña.cal_FechaDeInicio),
				Click.on(CrearCampaña.cal_SelFechaDeInicio_BETA(5)),
				Click.on(CrearCampaña.cal_FechaDeFinalizacion),
				Click.on(CrearCampaña.cal_SelFechaDeFin_BETA(15)
						));
		
	}
	


	@After
    public void after() throws IOException { 
    	Runtime.getRuntime().exec("cmd.exe /c mvn serenity:aggregate");
   	}

}


