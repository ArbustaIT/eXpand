package com.expand.features.etiquetas;

import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
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
import org.openqa.selenium.support.ui.Wait;
import java.time.temporal.TemporalUnit;

import com.expand.UI.*;
import com.expand.UI.administracion.Basico.Etiquetas_Agregar;
import com.expand.questions.*;
import com.expand.steps.*;
import com.expand.tasks.DesdeLaHome;

import com.expand.tasks.Iniciar;

import gherkin.formatter.model.Step;

import com.expand.tasks.EnEtiquetas;
import com.expand.tasks.EnEtiquetas.filtroSistemaBuilder;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
// Actor, habilidades, preguntas, acctiones y tareas de Serrenity Screenplay
//import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.questions.targets.*;
import net.serenitybdd.screenplay.questions.WebDriverQuestion;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.*;


//Anotaciones para la preparación de los casos de prueba de serenity.
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.StepFactory;
import net.thucydides.junit.annotations.UseTestDataFrom;

//Núcleo de la forma de escribir casos de prueba con serenity screenplay + heramientas de comparación y preguntas.
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;
import java.text.MessageFormat;

import static java.time.temporal.ChronoUnit.SECONDS;
import java.util.Optional;

import org.junit.Test;
import static java.lang.System.out;
import static java.text.MessageFormat.format;
//Runner sin parametros.
//@RunWith(SerenityRunner.class)

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("credenciales.csv")
@Narrative(text = { "Dado que soy un usuario valido en el sitio.", 
		"Cuando entro a la sección de etiquetas.",
"Deberia poder administrar las etiquetas que se usan dentro del sistema."})
public class Administración_de_etiquetas {


	@Managed(driver = "chrome")
	public WebDriver suNavegador;

	public Actor Fer =Actor.named("Fer");

	String cUsuario;
	String cContraseña;
	String tag ="WSTimeoutAgente";
	String descripcion;

	//Agregamos
	public Login_Portal login;
	public Home_Portal home_portal;
	public Administracion_Basico_Etiquetas Etiquetas;
	public Etiquetas_Agregar Agregar;

	@Before
	public void preSetup() {
		Fer.can(BrowseTheWeb.with(suNavegador));
		BrowseTheWeb.as(Fer).setImplicitTimeout(20, SECONDS);
		Serenity.setSessionVariable("Actor").to(Fer);

	}

	public static void print(String s) { System.out.println(s); }

	public void setUP() {

		//String cUsuario = "fbarrionuevo";
		//String cContraseña = "fbarrionuevo";

		givenThat(Fer).attemptsTo(Iniciar.Sesion(cUsuario,cContraseña));
		andThat(Fer).attemptsTo(DesdeLaHome.irAAdminisrtaciónBasicoEtiquetas());


	}

	public void setUP2() {
		// Ver un usuario sin permiso.
		String cUsuario = "fbarrionuevo";
		String cContraseña = "fbarrionuevo";
		givenThat(Fer).attemptsTo(Iniciar.Sesion(cUsuario,cContraseña));
	}

	@Test
	public void Test_Acceso_Agente_con_permisos() {		
		setUP();

		then(Fer).should(eventually(seeThat("La URL de la página es ",LaPagina.urlActual(),  is("http://canalesdigitales-devel.expand/expand/es/admin/basic/tags"))));

	}

	@Test
	public void Test_Acceso_Agente_sin_permisos() {		
		setUP2();

		when( Fer).attemptsTo(DesdeLaHome.irAAdminisrtaciónBasicoEtiquetas());

		then(Fer).should(eventually(seeThat(the(
				home_portal.Administracion_Basico_Etiquetas
				), not(isPresent()) 
				)));

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
		tag = "AutomationTag";  
		descripcion ="Descripcion de ejemplo"; //No toma acentos en las descripciónes. 

		when(Fer).attemptsTo(EnEtiquetas.agregarUnaEtiqueta(tag, descripcion),
				WaitUntil.the(Etiquetas.celda(1) , isCurrentlyVisible() ) );

		//Ver otros métodos de detectar que no se vean los elementos.
		then(Fer).should(eventually(seeThat(TheValue.of(Etiquetas.containsText(tag)), is(true) ) ));


	}

	@Test
	public void Test_Agregar_etiqueta_en_uso() {		
		setUP();
		tag		= "AutomationTag";  
		descripcion	="Descripcion de ejemplo";

		when( Fer).attemptsTo(EnEtiquetas.agregarUnaEtiqueta(tag, descripcion));
		//Chequear si el texto de [tag] aparece en pantalla.
		then(Fer).should(eventually(seeThat(TheValue.of(Agregar.containsText("Ya existe un tag con el mismo nombre")), is(true) ) ));

	}

	@Test
	public void Test_Agregar_etiqueta_No_Permitidas_Con_tildes() {		
		setUP();
		tag			= "AutomationTag";  
		descripcion	="Descripción de ejemplo"; 


		when(Fer).attemptsTo(EnEtiquetas.agregarUnaEtiqueta(tag, descripcion)
				);
		//Ver otros métodos de detectar que no se vean los elementos.
		then(Fer).should(eventually(seeThat(TheValue.of(suNavegador.getPageSource().contains(tag)), is(true) ) ));

	}

	@Test
	public void Test_Agregar_etiqueta_nombre_vacio() {		
		setUP();
		tag 		= "";  
		descripcion	="Descripcion de ejemplo";

		when( Fer).attemptsTo(EnEtiquetas.agregarUnaEtiqueta(tag, descripcion));

		//Chequear si el texto de [tag] aparece en pantalla.
		then(Fer).should(eventually(seeThat(TheValue.of(Agregar.containsText("Campo requerido")), is(true) ) ));

	}

	@Test
	public void Agregar_una_etiqueta_con_descripcion_vacia() {		
		setUP();
		tag = "Agregar etiqueta descripcion vacio";  
		descripcion ="";
		boolean esDeSistema = false; 


		when( Fer).attemptsTo(EnEtiquetas.agregarUnaEtiquetaSinDescripcion(tag,esDeSistema));

		//Chequear si el texto de [tag] aparece en pantalla.
		then(Fer).should(eventually(seeThat("El sitio contiene la etiqueta '#tag': ",TheValue.of(Etiquetas.containsText(tag)), is(true) ) ).waitingForNoLongerThan(10).seconds());


	}

	@Test
	public void Agregar_una_etiqueta_que_no_es_de_sistema() {		
		setUP();
		tag 		= "Agregar una etiqueta que no es de sistema";  
		descripcion	="etiqueta que no es de sistema";



		when( Fer).attemptsTo(EnEtiquetas.agregarUnaEtiqueta(tag, descripcion));

		//Chequear si el texto de [tag] aparece en pantalla.
		then(Fer).should(eventually(seeThat("El sitio contiene la etiqueta '#nombreTag': ",TheValue.of(Etiquetas.containsText(tag)), is(true) ) ).waitingForNoLongerThan(10).seconds());

	}

	@Test
	public void Agregar_etiqueta_con_el_limite_de_caracteres() {
		setUP();
		tag 		= "Agregar una etiqueta con ciento veintiocho caracteres";  
		descripcion ="El nombre tiene 128 caracteres";

		when( Fer).attemptsTo(EnEtiquetas.agregarUnaEtiquetaCon(tag, descripcion).conUnNombreDe(128).caracteres());
		then(Fer).should(eventually(seeThat("El guardó la etiqueta '#nombreTag' correctamente. ",
				TheValue.of(Etiquetas.containsText(tag))
				,is(true) 
				)).waitingForNoLongerThan(10).seconds());

	}

	@Test
	public void Agregar_etiqueta_superando_el_limite_de_caracteres() {
		setUP();
		tag 		= "Agregar una etiqueta con mas de ciento veintiocho caracteres";  
		descripcion ="El nombre tiene más de 128 caracteres";

		when( Fer).attemptsTo(EnEtiquetas.agregarUnaEtiquetaCon(tag, descripcion).conUnNombreDe(129).caracteres());
		then(Fer).should(eventually(seeThat("El sitio debe mostrar el mensaje 'el número máximo de caracteres permitido es 128'. ",
				LaPagina.suContenido(),
				containsString("el número máximo de caracteres permitido es 128")
				)).waitingForNoLongerThan(10).seconds());

	}

	@Test
	public void Agregar_etiqueta_con_una_descripcion_con_el_limite_de_caracteres() {
		setUP();
		tag 		= "Etiqueta con ciento veintiocho caracteres de descripcion";  
		descripcion ="El nombre tiene 128 caracteres";

		when( Fer).attemptsTo(EnEtiquetas.agregarUnaEtiquetaCon(tag, descripcion).conUnaDescripcionDe(128).caracteres());
		then(Fer).should(eventually(seeThat("El guardó la etiqueta '#nombreTag' correctamente. ",
				TheValue.of(Etiquetas.containsText(tag))
				,is(true) 
				)).waitingForNoLongerThan(10).seconds());

		Fer.attemptsTo(EnEtiquetas.EliminarLaEtiqueta(tag));
	}

	@Test
	public void agregar_etiqueta_descripcion_mayor_al_limite_de_caracteres() {
		setUP();
		tag 		= "Etiqueta con mas de ciento veintiocho caracteres de descripcion";  
		descripcion ="El nombre tiene más de ciento veintiocho caracteres";

		when( Fer).attemptsTo(EnEtiquetas.agregarUnaEtiquetaCon(tag, descripcion).conUnaDescripcionDe(129).caracteres());
		then(Fer).should(eventually(seeThat("El el mensaje que debería mostrar sitio",
				LaPagina.suContenido(),
				containsString("el número máximo de caracteres permitido es 128")
				)).waitingForNoLongerThan(10).seconds());

		Fer.attemptsTo(EnEtiquetas.EliminarLaEtiqueta(tag));

	}

	@Test
	public void Test_Eliminar_etiqueta() {		
		setUP();
		tag = "Agregar etiqueta descripcion vacio";  

		when(Fer).attemptsTo(Check.whether(TheValue.of(Etiquetas.containsText(tag)), is(true)).andIfSo(EnEtiquetas.EliminarLaEtiqueta(tag)));		
		then(Fer).should(eventually(seeThat("La etiqueta fue eliminada correctamente: ",TheValue.of(Etiquetas.containsText(tag)), is(false) ) ).waitingForNoLongerThan(10).seconds());	
	}

	@Test

	public void Buscar_Etiqueta_por_nombre() {
		setUP();
		String etiqueta ="Agregar una etiqueta con ciento veintiocho caracteres                                                                           " ;
		when(Fer).attemptsTo(EnEtiquetas.BuscarUnaEtiquetaCon(etiqueta));

		then(Fer).should(eventually(seeThat("la tabla de etiquetas: "	,TheTarget.textOf(EnEtiquetas.buscarEtiquetaPorNombre(etiqueta)), containsString(etiqueta) ) ).waitingForNoLongerThan(10).seconds());

	}

	@Test
	public void Buscar_Etiqueta_por_descripción() {
		setUP();

		String descripcion ="El nombre tiene 128 caracteres" ;
		when(Fer).attemptsTo(EnEtiquetas.BuscarUnaEtiquetaCon(descripcion));

		then(Fer).should(eventually(seeThat("la tabla de etiquetas: "	,TheTarget.textOf(EnEtiquetas.buscarEtiquetaPorDescripcion(descripcion)), containsString(descripcion) ) ).waitingForNoLongerThan(10).seconds());

	}


	@Test
	public void Test_Agregar_etiqueta_Y_cancelar() {		
		setUP();
		tag = "AutomationTag";  
		descripcion ="Descripcion de ejemplo"; //No toma acentos en las descripciónes. 

		//givenThat(Fer).attemptsTo(Click.on(Etiquetas.btn_agregar));

		//esta parte agrega una etiqueta pero cancela la acción al final (Esto no sale en el reporte).
		when(Fer).attemptsTo(EnEtiquetas.agregarUnaEtiquetaPeroCancelarAlFinal(tag, descripcion));

		//Ver otros métodos de detectar que no se vean los elementos.
		then(Fer).should(eventually(seeThat(TheValue.of(Etiquetas.containsText(tag)), not(is(true)) ) ));

	}

	@Test
	public void Test_Contar_Etiquetados() {
		setUP();

		//Creamos un target para guardar la celda y un int para la fila.
		when(Fer).attemptsTo(EnEtiquetas.contarEtiquetados());
		
		//Nuestro actor recuerda el numero de etiquetados del proceso anterior.
		String NumeroDeEtiquetados = Fer.recall("Numero De Etiquetados");
		
		//Comparamos el número de etiquetados (Que no sea vacío y sea un número mayor o igual a 0)
		then(Fer).attemptsTo(
				Ensure.that(NumeroDeEtiquetados).isNotBlank(),
				Ensure.that(NumeroDeEtiquetados).asAnInteger().isGreaterThanOrEqualTo(0)
				);

	}


	@Test
	public void Test_Eliminar_etiqueta_Y_Cancelar_la_accion() {		
		setUP();
		tag = "WSTimeoutAgente";  
		
		andThat( Fer).attemptsTo(EnEtiquetas.BuscarUnaEtiquetaCon(tag));
		when( Fer).attemptsTo(EnEtiquetas.AgregarLaEtquetaSiNoExiste(tag),EnEtiquetas.EliminarLaEtiquetaYCancelar(tag));	
		then(Fer).should(eventually(seeThat("La etiqueta fue eliminada correctamente: ",TheValue.of(Etiquetas.containsText(tag)), is(true) ) ).waitingForNoLongerThan(10).seconds());	
	}

	@Test
	//@Pending
	public void Test_filtrar_Etiquetas_por_las_del_sistema() {
		setUP();
		//Mockup de prueba de contar etiquetados.
		when(Fer).attemptsTo(EnEtiquetas.filtrarPorLasDelSistema(),EnEtiquetas.BuscarUnaEtiquetaCon(tag));
		then(Fer).should(eventually(seeThat("La cantidad de etiquetas que no coinciden con el filtro: ",TheValue.of(EnEtiquetas.LasEtiquetasQue("No").SonDelSistema() ), is(0) ) ));

	}
	
	@Test
	//@Pending
	public void Test_filtrar_Etiquetas_por_las_que_no_son_del_sistema() {
		setUP();
		//Mockup de prueba de contar etiquetados.
		when(Fer).attemptsTo(EnEtiquetas.filtrarNoDelSistema(),EnEtiquetas.BuscarUnaEtiquetaCon(tag));
		//then(Fer).should(eventually(seeThat("La cantidad de etiquetas que no coinciden con el filtro: ",TheValue.of(EnEtiquetas.LasEtiquetasQueNoSonDelSistema("No")), is(0) ) ));
		then(Fer).should(eventually(seeThat("La cantidad de etiquetas que no coinciden con el filtro: ",TheValue.of(EnEtiquetas.LasEtiquetasQue("Si").SonDelSistema()), is(0) ) ));

	}


	@Test

	public void Test_filtrar_Etiquetas_por_Nombre() {
		setUP();
		tag = "test";
		//Mockup de prueba de contar etiquetados.
		when(Fer).attemptsTo(EnEtiquetas.BuscarUnaEtiquetaCon(tag));
		Fer.remember("Las etiquetas que coinciden con el filtro" , EnEtiquetas.contarLasEtiquetasQueContengan(tag));
		then(Fer).should(eventually(seeThat("La cantidad de etiquetas que coinciden con el filtro: ",TheValue.of(Fer.recall("Las etiquetas que coinciden con el filtro")), equalTo(Fer.recall("La cantidad de etiquetas total")) ) ));

	}

	@Test
	@Pending
	public void Test_filtrar_Etiquetas_por_Nombre_Sin_Resultados() {
		setUP();
		//Mockup de prueba de contar etiquetados.
//		when(Fer).attemptsTo(EnEtiquetas.BuscarUnaEtiquetaCon(tag),EnEtiquetas.contarLasEtiquetasQueContengan(tag));
//		Fer.remember("La cantidad de etiquetas" , EnEtiquetas.LasEtiquetasQueNoSonDelSistema());
//		then(Fer).should(eventually(seeThat("La cantidad de etiquetas: ",TheValue.of(Fer.recall("La cantidad de etiquetas")), is(0) ) ));

	}

	@Test
	@Pending
	public void Test_filtrar_Etiquetas_Y_Vaciar_El_Filtro() {
		setUP();
		//Mockup de prueba de contar etiquetados.
//		when(Fer).attemptsTo(EnEtiquetas.BuscarUnaEtiquetaCon(tag),EnEtiquetas.contarLasEtiquetasQueContengan(tag),EnEtiquetas.vaciarElFiltro());
//		Fer.remember("La cantidad de etiquetas" , EnEtiquetas.LasEtiquetasQueNoSonDelSistema());
//		then(Fer).should(eventually(seeThat("La cantidad de etiquetas: ",TheValue.of(Fer.recall("La cantidad de etiquetas")), is(greaterThan(0)) ) ));

	}


	//==================================================================================================
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


