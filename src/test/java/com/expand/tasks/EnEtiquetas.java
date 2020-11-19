package com.expand.tasks;


import com.expand.pageObjects.administracion.Basico.Etiquetas;
import com.expand.pageObjects.administracion.Basico.Etiquetas_Agregar;
import com.opera.core.systems.scope.WaitState;

import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousPerformable;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import com.expand.interactions.*;

import net.serenitybdd.screenplay.actions.DriverTask;
//import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.StepFactory;

import static org.hamcrest.Matchers.*;

import java.text.MessageFormat;

import org.apache.bcel.generic.Select;
import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static java.text.MessageFormat.format;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.WebDriverQuestion;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.*;

public class EnEtiquetas {

	//	public static Performable UnaEtiqueta(String NombreTag) {
	//		return Instrumented.instanceOf(UnaEtiqueta.class).withProperties(NombreTag,  null,  false);
	//	}

	public static Performable EliminarLaEtiqueta(String NombreTag) {
		Actor actor = Serenity.sessionVariableCalled("Actor");

		Performable Tarea = null;

		if (BrowseTheWeb.as(actor).getDriver().getCurrentUrl().contains("es/admin/basic/tags/create") == false){

			String tituloTarea = String.format("{0} elimina la etiqueta con el nombre '%s'",
					NombreTag
					);

			int A =0;
			Target celda =null;
			String contenido ="";
			int B=0;
			A = actor.recall("La fila de la etiqueta");

			celda = buscarEtiquetaPorNombre(NombreTag);
			contenido = BrowseTheWeb.as(actor).getDriver().findElement(By.xpath(celda.getCssOrXPathSelector())).getText();
			//Si encuentra la etiqueta hace la tarea de borrarla.
			if (contenido.equals(NombreTag)) {
				Tarea =	Task.where("",
						Click.en(Etiquetas.btn_OpcionesDeCelda(A)),
						Click.en("//mat-label[contains(text(),'Eliminar')]"),
						Click.en("//span[contains(text(),'Aceptar')]")).withNoReporting();
			} else {
				System.out.println("No se encontro elemento entre las etiquetas. \nSalteando eliminado del elemento.");
			}


		} else {
			System.out.println("Salteando la seciencia de eliminación.\nNo se encuentra en la sección \"/admin/basic/tags\"");
			Tarea =	Task.where("").withNoReporting();
		}
		return Tarea;
	}

	public static Performable EliminarLaEtiquetaYCancelar(String NombreTag) {
		Actor actor = Serenity.sessionVariableCalled("Actor");
		WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();

		Performable Tarea = null;
		if (driver.getCurrentUrl().contains("es/admin/basic/tags/create") == false){

			String tituloTarea = String.format("{0} elimina la etiqueta con el nombre '%s'",
					NombreTag
					);

			int A =0;
			Target celda =null;
			String contenido ="";
			celda = buscarEtiquetaPorNombre(NombreTag);
			A = actor.recall("La fila de la etiqueta");

			contenido = driver.findElement(By.xpath(celda.getCssOrXPathSelector())).getText();
			//Si encuentra la etiqueta hace la tarea de borrarla pero cancela al final.
			if (contenido.equals(NombreTag)) {
				Tarea =	Task.where("",
						Click.en(Etiquetas.btn_OpcionesDeCelda(A)),
						Click.en("//mat-label[contains(text(),'Eliminar')]"),
						Click.en("//span[contains(text(),'Cancelar')]"));
			} else {
				System.out.println("No se encontro elemento entre las etiquetas. \nSalteando eliminado del elemento.");
			}


		} else {
			System.out.println("Salteando la seciencia de eliminación.\nNo se encuentra en la sección \"/admin/basic/tags\"");
			Tarea =	Task.where("").withNoReporting();
		}
		return Tarea;
	}


	public static Target buscarEtiquetaPorNombre(String nombreTag) {
		Target celda = null;
		int A = 0;
		Actor actor = Serenity.sessionVariableCalled("Actor");

		String contenido ="";
		int B = 0;

		//es un bucle que empieza a interactuar con las filas de la grilla en búsqueda del tag que se le pasa.
		//Si no lo encuentra lo saltea, pero si lo encuentra lo elimina.
		do {

			A++;

			//Espera medio segundo.
			try {Thread.sleep(500);} 
			catch (InterruptedException e) {e.printStackTrace();}
			
			if(Etiquetas.celda(A).resolveFor(actor).isPresent() ){
				//Busca de la grilla de etiquetas una etiqueta cuya fila es dada por el indice "A".
				celda = Etiquetas.celda(A);

				//Trata de leer el contenido de esa etiqueta y guardarla en una variable String.
				contenido = (Etiquetas.celda(A).resolveFor(actor).isPresent() == true?actor.asksFor(TheTarget.textOf(Etiquetas.celda(A))):contenido);

				System.out.println(contenido);
				//contadores para la fila y los intentos por si hay bucles infinitos
			}else { System.out.println(MessageFormat.format("La fila {0} no está presente.",A));}
			if (A> 10) {A=0;B= B+1;}
			if (B>=3) {break;}
			//} while (	contenido.equals(nombreTag) == false );
			//La tabla de listado de etiquetas remueve espacios al final y al principio... (Solución temporal)
		} while (	contenido.equals(nombreTag.trim()) == false );
		actor.remember("La fila de la etiqueta", A);
		return celda;
	}

	public static Target buscarEtiquetaPorDescripcion(String descripcionTag) {
		Target celda = null;
		int A = 0;
		Actor actor = Serenity.sessionVariableCalled("Actor");

		String contenido ="";
		int B = 0;

		//es un bucle que empieza a interactuar con las filas de la grilla en búsqueda del tag que se le pasa.
		//Si no lo encuentra lo saltea, pero si lo encuentra lo elimina.
		do {
			A++;
			

				//Espera medio segundo.
				try {Thread.sleep(500);} 
				catch (InterruptedException e) {e.printStackTrace();}
					
				if(Etiquetas.celda(A,2).resolveFor(actor).isPresent() ){
				//Busca de la grilla de etiquetas una etiqueta cuya fila es dada por el indice "A".
				celda = Etiquetas.celda(A,2);

				//Trata de leer el contenido de esa etiqueta y guardarla en una variable String.
				contenido = (celda.resolveFor(actor).isPresent() == true?actor.asksFor(TheTarget.textOf(celda)):contenido);

				//contadores para la fila y los intentos por si hay bucles infinitos

			} else { System.out.println(MessageFormat.format("La fila {0} no está presente.",A));}
			if (A> 10) {A=0;B= B+1;}
			if (B>=3) {break;}
			//La tabla del listado de etiquetas remueve espacios al final y al principio de la descripción... (Solución temporal)
			//} while (	contenido.equals(descripcionTag) == false);
		} while (	contenido.equals(descripcionTag.trim()) == false);
		return celda;
	}


	public static Performable agregarUnaEtiquetaSinDescripcion(String NombreTag, boolean esDeSistema) {
		//reutilizamos la tarea de agregar etiquetas.
		String descr ="";

		return agregarUnaEtiqueta(NombreTag, descr, false);

	}

	public static Performable agregarUnaEtiqueta(String NombreTag, String Descripcion) {
		return agregarUnaEtiqueta(NombreTag, Descripcion, false);
	}

	public static Performable agregarUnaEtiqueta(String NombreTag, String Descripcion, boolean esDeSistema) {
		Actor actor = Serenity.sessionVariableCalled("Actor");
		WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();


		//Si viene con una descripción, la mostramos en el sujeto de la tarea como "la descripción: ".
		//Sino, lo indicamos como "Sin descripción".
		String tituloTarea = String.format("{0} agrega una etiqueta, con el nombre '%s' y "
				+ (Descripcion.equals("")?"sin descripción":"la descripción: ") +"%s.",
				NombreTag,(Descripcion.equals("")?"":"'"+Descripcion+"'")
				);


		return Task.where(tituloTarea,
				WaitUntil.the(Etiquetas.btn_agregar, isClickable()).forNoMoreThan(5).seconds(),
				Click.en(Etiquetas.btn_agregar.getCssOrXPathSelector()),
				Escribe.elTexto(NombreTag).en(Etiquetas_Agregar.txt_Nombre),
				Check.whether(Descripcion != null).andIfSo(
						Escribe.elTexto(Descripcion).en(Etiquetas_Agregar.txt_descripción).thenHit(Keys.TAB)
						),
				Check.whether(esDeSistema == true).andIfSo(
						Click.en(Etiquetas_Agregar.tgg_EsDeSistema)
						),
				//				Check.whether(Descripcion.length() <=128 && NombreTag.length() <= 128 ).andIfSo(
				//						Click.en(Etiquetas_Agregar.btn_Agregar)
				//						),
				Check.whether(the(Etiquetas_Agregar.btn_Agregar), isEnabled() ).andIfSo(
						Click.en(Etiquetas_Agregar.btn_Agregar)

						).otherwise(
								Vio.que("el botón 'Agregar deshabilitado'")
								),
				Check.whether(the(Etiquetas_Agregar.lbl_ErrorNombreExistente), isVisible() ).andIfSo(
						Click.en(Etiquetas_Agregar.btn_Cancelar)
						)

				);
		//return Instrumented.instanceOf(UnaEtiqueta.class).withProperties(NombreTag, Descripcion,  false);
	}

	public static fluentBuilder agregarUnaEtiquetaCon(String NombreTag, String Descripcion){
		return new fluentBuilder (NombreTag, Descripcion);
	}

	public static Performable agregarUnaEtiquetaPeroCancelarAlFinal(String NombreTag, String Descripcion){
		Actor actor = Serenity.sessionVariableCalled("Actor");
		//WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();

		//Si viene con una descripción, la mostramos en el sujeto de la tarea como "la descripción: ".
		//Sino, lo indicamos como "Sin descripción".
		String tituloTarea = String.format("{0} agrega una etiqueta, con el nombre '%s' y "
				+ (Descripcion.equals("")?"sin descripción":"la descripción: ") +"%s. pero cancela en el paso final.",
				NombreTag,(Descripcion.equals("")?"":"'"+Descripcion+"'")
				);

		return Task.where(tituloTarea,
				WaitUntil.the(Etiquetas.btn_agregar, isClickable()).forNoMoreThan(5).seconds(),
				Click.en(Etiquetas.btn_agregar),
				Escribe.elTexto(NombreTag).en(Etiquetas_Agregar.txt_Nombre),
				Escribe.elTexto(Descripcion).en(Etiquetas_Agregar.txt_descripción).thenHit(Keys.TAB),
				Click.en(Etiquetas_Agregar.tgg_EsDeSistema),
				Click.en(Etiquetas_Agregar.btn_Cancelar)
				);
	}

	public static class fluentBuilder {
		private int numeroCaracteres;
		private String nombreTag; 
		private String descripcion;

		public fluentBuilder(String nombreTag, String descripcion) {
			super();

			this.nombreTag = nombreTag;
			this.descripcion = descripcion;
		}

		public fluentBuilder(String nombreTag, String descripcion, int numeroCaracteres) {
			super();
			this.numeroCaracteres = numeroCaracteres;
			this.nombreTag = nombreTag;
			this.descripcion = descripcion;
		}

		@Step("{0} chequea de ingresar una etiqueta con un nombre de #numeroCaracteres caracteres.")
		public fluentBuilder conUnNombreDe(int numeroCaracteres) {
			String tag = String.format("%s%"+numeroCaracteres +"s",nombreTag,"z" ).substring(0, numeroCaracteres);
			return new fluentBuilder(tag, descripcion);
		}

		@Step("{0} chequea de ingresar una etiqueta con una descripción de #numeroCaracteres caracteres.")
		public fluentBuilder conUnaDescripcionDe(int numeroCaracteres) {
			String desc = String.format("%s%"+numeroCaracteres +"s",descripcion,"z" ).substring(0, numeroCaracteres);
			return new fluentBuilder(nombreTag, desc);
		}

		public Performable caracteres() {
			return EnEtiquetas.agregarUnaEtiqueta(nombreTag, descripcion);
		}
	}


	public static Performable BuscarUnaEtiquetaCon(String string) {

		return Task.where("{0} Busca la etiqueta: '" + string + "'.", 
				Click.en(Etiquetas.txt_buscar), 
				Escribe.elTexto(string).en(Etiquetas.txt_buscar).thenHit(Keys.ENTER)
				);

	}


	public static Performable contarEtiquetados() {
		int fila = 1;
		Target celda = Etiquetas.celda(1,3);
		Actor actor = Serenity.sessionVariableCalled("Actor");
		do {}
			while (celda.resolveFor(actor).isPresent());
		
		Task tarea;
		tarea = Task.where("{0} Lee la cantidad de etiquetados de la celda: '"+ String.valueOf(fila)  + "'.",
				Click.en(Etiquetas.txt_buscar));
		return null;
	}



	public static int LasEtiquetasQueNoSonDelSistema() {
		int fila =1;
		int cantidad =0;
		Target celda = null; 
		Actor actor = Serenity.sessionVariableCalled("Actor");
		do {
			celda = Etiquetas.celda(fila, 4);
			actor.attemptsTo(WaitUntil.the(celda, isVisible()).forNoMoreThan(5).seconds());
			if (Etiquetas.celda(fila, 4).resolveFor(actor).isPresent()) {
				
			
			//leer la columna donde indica si es de sistema o no.
			if (Etiquetas.celda(fila, 4).resolveFor(actor).getTextContent() =="No") {
				cantidad++;
			}

			
			
		//print de debug.
		print(format("Intentando leer la fila {0}. ¿Es visible?: {1}. Contenido \"{2}\"  ", fila,celda.resolveFor(actor).isPresent(),celda.resolveFor(actor).getText()));
			fila++;
			}
		} while (!Etiquetas.celda(fila, 4).resolveFor(actor).isPresent());
		
		actor.attemptsTo(Task.where("Contar la cantidad de etiquetas que no coinciden con el filtro."));
		
		return cantidad;
	}

	public static Performable contarLasEtiquetasQueContengan(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Performable vaciarElFiltro() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Performable filtrarPorLasDelSistema() {
		Target opción = Etiquetas.opcionFiltro(2);
		
		return Task.where("{0} Selecciona la opción filtrar por etiquetas del sistema.", 
				Click.en(Etiquetas.cmb_Filtrar) , WaitUntil.angularRequestsHaveFinished(),
				Click.en(opción)
				);
	}

	
	public static void print(String s) { System.out.println(s); }

	
}

