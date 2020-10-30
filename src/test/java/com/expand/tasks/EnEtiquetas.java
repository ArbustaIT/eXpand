package com.expand.tasks;

import com.expand.interactions.Vio;
import com.expand.pageObjects.Administracion.Basico.Etiquetas;
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
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.Matchers.*;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

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
		WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
		Performable Tarea = null;
		if (driver.getCurrentUrl().contains("es/admin/basic/tags/create") == false){

			String tituloTarea = String.format("{0} elimina la etiqueta con el nombre '%s'",
					NombreTag
					);

			int A =0;
			Target celda =null;
			String contenido ="";
			int B=0;
			A = actor.recall("La fila de la etiqueta");

			celda = buscarEtiquetaPorNombre(NombreTag);
			contenido = driver.findElement(By.xpath(celda.getCssOrXPathSelector())).getText();
			//Si encuentra la etiqueta hace la tarea de borrarla.
			if (contenido.equals(NombreTag)) {
				Tarea =	Task.where("",
						Click.on(Etiquetas.btn_OpcionesDeCelda(A)),
						Click.on("//mat-label[contains(text(),'Eliminar')]"),
						Click.on("//span[contains(text(),'Aceptar')]")).withNoReporting();
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
			A = actor.recall("La fila de la etiqueta");

			celda = buscarEtiquetaPorNombre(NombreTag);
			contenido = driver.findElement(By.xpath(celda.getCssOrXPathSelector())).getText();
			//Si encuentra la etiqueta hace la tarea de borrarla pero cancela al final.
			if (contenido.equals(NombreTag)) {
				Tarea =	Task.where("",
						Click.on(Etiquetas.btn_OpcionesDeCelda(A)),
						Click.on("//mat-label[contains(text(),'Eliminar')]"),
						Click.on("//span[contains(text(),'Cancelar')]"));
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
		WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
		String contenido;
		int B = 0;

		//es un bucle que empieza a interactuar con las filas de la grilla en búsqueda del tag que se le pasa.
		//Si no lo encuentra lo saltea, pero si lo encuentra lo elimina.
		do {

			A++;
			//Espera medio segundo.
			try {Thread.sleep(500);} 
			catch (InterruptedException e) {e.printStackTrace();}

			//Busca de la grilla de etiquetas una etiqueta cuya fila es dada por el indice "A".
			celda = Etiquetas.celda(A);

			//Trata de leer el contenido de esa etiqueta y guardarla en una variable String.
			//contenido = Text.of(celda).viewedBy(actor).asString();
			contenido = driver.findElement(By.xpath(celda.getCssOrXPathSelector() )).getText();
			System.out.println(contenido);
			//contadores para la fila y los intentos por si hay bucles infinitos
			if (A> 10) {A=0;B= B+1;}
		} while (	contenido.equals(nombreTag) == false  && B<3	);
		actor.remember("La fila de la etiqueta", A);
		return celda;
	}

	public static Target buscarEtiquetaPorDescripcion(String descripcionTag) {
		Target celda = null;
		int A = 0;
		Actor actor = Serenity.sessionVariableCalled("Actor");
		WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
		String contenido;
		int B = 0;

		//es un bucle que empieza a interactuar con las filas de la grilla en búsqueda del tag que se le pasa.
		//Si no lo encuentra lo saltea, pero si lo encuentra lo elimina.
		do {

			A++;
			//Espera medio segundo.
			try {Thread.sleep(500);} 
			catch (InterruptedException e) {e.printStackTrace();}

			//Busca de la grilla de etiquetas una etiqueta cuya fila es dada por el indice "A".
			celda = Etiquetas.celda(2,A);

			//Trata de leer el contenido de esa etiqueta y guardarla en una variable String.
			//contenido = Text.of(celda).viewedBy(actor).asString();
			contenido = driver.findElement(By.xpath(celda.getCssOrXPathSelector() )).getText();
			System.out.println(contenido);
			//contadores para la fila y los intentos por si hay bucles infinitos
			if (A> 10) {
				A=0;
				B= B+1;
			}

		} while (	contenido.equals(descripcionTag) == false  && B<3	);
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
				Click.on(Etiquetas.btn_agregar.getCssOrXPathSelector()),
				Enter.keyValues(NombreTag).into(Etiquetas.Agregar.txt_Nombre),
				Check.whether(Descripcion != null).andIfSo(
						Enter.keyValues(Descripcion).into(Etiquetas.Agregar.txt_descripción).thenHit(Keys.TAB)
						),
				Check.whether(esDeSistema == true).andIfSo(
						Click.on(Etiquetas.Agregar.tgg_EsDeSistema)
						),
				//				Check.whether(Descripcion.length() <=128 && NombreTag.length() <= 128 ).andIfSo(
				//						Click.on(Etiquetas.Agregar.btn_Agregar)
				//						),
				Check.whether(the(Etiquetas.Agregar.btn_Agregar), isEnabled() ).andIfSo(
						Click.on(Etiquetas.Agregar.btn_Agregar)

						).otherwise(
								Vio.que("el botón 'Agregar deshabilitado'")
								),
				Check.whether(the(Etiquetas.Agregar.lbl_ErrorNombreExistente), isVisible() ).andIfSo(
						Click.on(Etiquetas.Agregar.btn_Cancelar)
						)

				);
		//return Instrumented.instanceOf(UnaEtiqueta.class).withProperties(NombreTag, Descripcion,  false);
	}

	public static fluentBuilder agregarUnaEtiquetaCon(String NombreTag, String Descripcion){
		return new fluentBuilder (NombreTag, Descripcion);
	}

	public static Performable agregarUnaEtiquetaPeroCancelarAlFinal(String NombreTag, String Descripcion){
		Actor actor = Serenity.sessionVariableCalled("Actor");
		WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();


		//Si viene con una descripción, la mostramos en el sujeto de la tarea como "la descripción: ".
		//Sino, lo indicamos como "Sin descripción".
		String tituloTarea = String.format("{0} agrega una etiqueta, con el nombre '%s' y "
				+ (Descripcion.equals("")?"sin descripción":"la descripción: ") +"%s. pero cancela en el paso final.",
				NombreTag,(Descripcion.equals("")?"":"'"+Descripcion+"'")
				);

		return Task.where(tituloTarea,
				WaitUntil.the(Etiquetas.btn_agregar, isClickable()).forNoMoreThan(5).seconds(),
				Click.on(Etiquetas.btn_agregar.getCssOrXPathSelector()),
				Enter.keyValues(NombreTag).into(Etiquetas.Agregar.txt_Nombre),
				Enter.keyValues(Descripcion).into(Etiquetas.Agregar.txt_descripción).thenHit(Keys.TAB),
				Click.on(Etiquetas.Agregar.tgg_EsDeSistema),
				Click.on(Etiquetas.Agregar.btn_Cancelar)
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

		return Task.where("busca la etiquta" + string, 
				Click.on(Etiquetas.txt_buscar), 
				Enter.keyValues(string).into(Etiquetas.txt_buscar).thenHit(Keys.ENTER)
				);
	}


	public static Performable contarEtiquetados() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Performable filtrarPorX() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Performable chequearLasEtiquetasVisibles() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Performable contarLasEtiquetasQueContengan(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Performable vaciarElFiltro() {
		// TODO Auto-generated method stub
		return null;
	}

}

