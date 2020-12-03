package com.expand.tasks;


import com.opera.core.systems.scope.WaitState;

import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousPerformable;
import net.serenitybdd.screenplay.GivenWhenThen.*;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import com.expand.UI.administracion.Basico.Etiquetas;
import com.expand.UI.administracion.Basico.Etiquetas_Agregar;
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
import net.serenitybdd.screenplay.ensure.Ensure;
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
import org.openqa.selenium.support.ui.Wait;

import static java.text.MessageFormat.format;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.questions.WebDriverQuestion;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.*;

public class EnEtiquetas {
	private static void println(String contenido) {System.out.println(contenido);}
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
		WebDriver driver =  BrowseTheWeb.as(actor).getDriver();

		Performable Tarea = null;
		print("Estamos en:" + driver.getCurrentUrl());

		if (driver.getCurrentUrl().contains("es/admin/basic/tags/create") == false){

			String tituloTarea = String.format("{0} elimina la etiqueta con el nombre '%s'",
					NombreTag
					);

			System.out.println(tituloTarea);

			int A =0;
			Target celda =null;
			String contenido ="";
			celda = buscarEtiquetaPor("Nombre",NombreTag);
			A = actor.recall("La fila de la etiqueta");
			System.out.println("La fila es: " + A);

			contenido = driver.findElement(By.xpath(celda.getCssOrXPathSelector())).getText();
			//Si encuentra la etiqueta hace la tarea de borrarla pero cancela al final.
			if (contenido != null && contenido.equals(NombreTag)) {
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

	public static Target buscarEtiquetaPor(String opcion, String elTextoOValor) {
		//Setup de las variables de esta tarea...
		Target celda = null;
		int fila = 1;
		int filaCoincidencia = -1;
		int columna = 1;
		Actor actor = Serenity.sessionVariableCalled("Actor");
		String contenido ="";
		int bucleLimite = 0;

		switch (opcion) {
		case "Nombre"		 : columna =1; break;
		case "Descripción"	 : columna =2; break;
		case "Etiquetados"	 : columna =3; break;
		case "Es de sistema?": columna =4; break; //Así figura en eXpand.
		default				 : columna =1; break;
		}

		//es un bucle que empieza a interactuar con las filas de la grilla en búsqueda del tag que se le pasa.
		//Si no lo encuentra lo saltea, pero si lo encuentra lo elimina.
		do {

			//Espera medio segundo.
			try {Thread.sleep(500);} 
			catch (InterruptedException e) {e.printStackTrace();}

			if(Etiquetas.celda(fila,columna).resolveFor(actor).isPresent() ){
				//Busca de la grilla de etiquetas una etiqueta cuya fila es dada por el indice "A".
				celda = Etiquetas.celda(fila,columna);

				//Trata de leer el contenido de esa etiqueta y guardarla en una variable String.
				contenido = (Etiquetas.celda(fila,columna).resolveFor(actor).isPresent() == true?actor.asksFor(TheTarget.textOf(Etiquetas.celda(fila,columna))):contenido);

				if (contenido.equals(elTextoOValor.trim())) {filaCoincidencia = fila;}

				System.out.println(format("El contenido de la fila es: {0}",contenido));
				//contadores para la fila y los intentos por si hay bucles infinitos
			}else { println(format("La fila {0} no está presente.",fila));break;}


			if (fila> 10) {fila=0;bucleLimite++;} else {fila++;}

			if (bucleLimite>=3) {break;}
			//} while (	contenido.equals(nombreTag) == false );
			//La tabla de listado de etiquetas remueve espacios al final y al principio... (Solución temporal)

		} while (	contenido.equals(elTextoOValor.trim()) == false );
		actor.remember("La fila de la etiqueta", filaCoincidencia);
		return celda;
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
		WebDriver driver = BrowseTheWeb.as(actor).getDriver();
		String URL_ACTUAL = "";

		//Si viene con una descripción, la mostramos en el sujeto de la tarea como "la descripción: ".
		//Sino, lo indicamos como "Sin descripción".

		actor.attemptsTo(Click.en(Etiquetas.btn_agregar));

		URL_ACTUAL =driver.getCurrentUrl();
		actor.should(eventually(seeThat("La página actal ",TheValue.of(URL_ACTUAL), endsWith("/admin/basic/tags/create"))).waitingForNoLongerThan(10).seconds() );
		//actor.has(Ensure.that(URL_ACTUAL).endsWith("/admin/basic/tags/create"));	



		String tituloTarea = String.format("{0} agrega una etiqueta, con el nombre '%s' y "
				+ (Descripcion.equals("")?"sin descripción":"la descripción: ") +"%s.",
				NombreTag,(Descripcion.equals("")?"":"'"+Descripcion+"'")
				);

		return Task.where(tituloTarea,
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
		Actor actor = Serenity.sessionVariableCalled("Actor");
		int fila = 1;
		String contenidoNroEtiquetados;
		Target celda = Etiquetas.celda(1,3);



		do {
			fila = (int)Math.nextUp(Math.random()*10)+1;
			celda = Etiquetas.celda(fila, 3);
			print(format("Intentando leer la fila {0}. ¿Es visible?: {1}. La etiqueta leída es: {2}, Su contenido es: \"{3}\"  ", 
					fila,
					celda.resolveFor(actor).isPresent(),
					Etiquetas.celda(fila, 1).resolveFor(actor).getText(),
					celda.resolveFor(actor).getText()
					));

			contenidoNroEtiquetados =celda.resolveFor(actor).getText();

		} while (!celda.resolveFor(actor).isPresent());

		actor.remember("Numero De Etiquetados",contenidoNroEtiquetados );
		Task tarea;
		tarea = Task.where("{0} ve que la cantidad de etiquetados de la celda '"+ String.valueOf(fila)  + "' cuyo contenido es '"+Etiquetas.celda(fila, 1).resolveFor(actor).getText()+"' y la cantidad de etiquetados es '"+contenidoNroEtiquetados +"'.");
		return tarea;
	}



	public static int LasEtiquetasDelSistema(String esDeSistema) {
		int fila =1;
		int cantidad =0;
		Target celda = null; 
		println("Buscando las del sistema?: " +esDeSistema);
		
		Actor actor = Serenity.sessionVariableCalled("Actor");
		do {
			print("Iniciando el chequeo de la tabla.");
			celda = Etiquetas.celda(fila, 4);
			
			if (Etiquetas.celda(fila, 4).resolveFor(actor).isPresent()) {
				actor.attemptsTo(WaitUntil.the(celda, isVisible()).forNoMoreThan(5).seconds());
				//leer la columna donde indica si es de sistema o no.
				if (Etiquetas.celda(fila, 4).resolveFor(actor).getTextContent() ==esDeSistema) {
					cantidad++;
				}

				//print de debug.

			}
			try {
				print(format("Intentando leer la fila {0}. ¿Es visible?: {1}. Contenido: \"{2}\"  ", fila,
						celda.resolveFor(actor).isVisible(), celda.resolveFor(actor).getText()));
			} catch (Exception e) {}

			fila++;
		} while (Etiquetas.celda(fila, 4).resolveFor(actor).isPresent());

		actor.attemptsTo(Task.where("Contar la cantidad de etiquetas que no coinciden con el filtro."));

		return cantidad;
	}

	public static int contarLasEtiquetasQueContengan(String tag) {
		int fila =0;
		int cantidad =0;
		Target celda = null; 
		Actor actor = Serenity.sessionVariableCalled("Actor");
		println("Buscando las etiquetas que contengan : '" +tag +"'.");
		
		do {
			
			print("Iniciando el chequeo de la tabla.");
			fila++;
			if (Etiquetas.celda(fila, 4).resolveFor(actor).isPresent()) {
				
				celda = Etiquetas.celda(fila, 1);
				
				actor.attemptsTo(WaitUntil.the(celda, isVisible()).forNoMoreThan(5).seconds());
				//leer la columna donde indica si es de sistema o no.
				if (Etiquetas.celda(fila, 1).resolveFor(actor).getTextContent().contains(tag) || Etiquetas.celda(fila, 2).resolveFor(actor).getTextContent().contains(tag)) {
					cantidad++;
				}

				//print de debug.
				
			} 
			
			try {
				print(format("Intentando leer la fila {0}. ¿Es visible?: {1}. Contenido: \"{2}\"  ", fila,
						celda.resolveFor(actor).isVisible(), celda.resolveFor(actor).getText()));
			} catch (Exception e) {}
			
			
		} while (Etiquetas.celda(fila+1, 1).resolveFor(actor).isPresent());
		
		actor.remember("La cantidad de etiquetas total",fila);
		actor.attemptsTo(Task.where("Contar la cantidad de etiquetas que contengan '"+tag+"'."));

		return cantidad;
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

	public static Performable filtrarNoDelSistema() {
		Target opción = Etiquetas.opcionFiltro(3);

		return Task.where("{0} Selecciona la opción filtrar por etiquetas que no son del sistema.", 
				Click.en(Etiquetas.cmb_Filtrar) , WaitUntil.angularRequestsHaveFinished(),
				Click.en(opción)
				);
	}


	public static void print(String s) { System.out.println(s); }

	public static Boolean ExisteUnaEtiquetaCon(String tag) {
		try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
		Actor actor = Serenity.sessionVariableCalled("Actor");
		Boolean resultado = null;
		Target etiqueta =null;

		println(format("Buscando etiqueta por nombre con el valor \"{0}\"",tag));
		etiqueta=buscarEtiquetaPor("Nombre",tag);

		//Chequea si la etiqueta es null (No se encontro la fila porque no hay resultados).
		if (etiqueta ==null) {
			println(format("No se encontraron etiquetas por Nombre: \"{0}\"",resultado));
		}else {
			//resultado = BrowseTheWeb.as(actor).findAll(By.xpath(etiqueta.getCssOrXPathSelector())).size()>0;
			resultado = etiqueta.resolveFor(actor).isPresent();
			println(format("Chequeando si la etiqueta es visible: \"{0}\"",resultado));	
		}


		if (etiqueta ==null || resultado == null || resultado == false) {
			System.out.println(format("Buscando etiqueta por descripción con el valor \"{0}\"",tag));
			etiqueta=buscarEtiquetaPor("Descripción",tag);
		}

		if (etiqueta ==null || resultado == null ) {
			println(format("No se encontraron etiquetas por descripción: \"{0}\"",resultado));
			resultado = false;
		}else {
			//resultado = BrowseTheWeb.as(actor).findAll(By.xpath(etiqueta.getCssOrXPathSelector())).size()>0;
			resultado = etiqueta.resolveFor(actor).isPresent();
			println(format("Chequeando si la etiqueta es visible: \"{0}\"",resultado));	
		}


		println(format("El resultado final es: \"{0}\"",resultado));
		println(format("Fin del chequeo de las etiquetas."));

		return resultado;
	}

	public static Performable AgregarLaEtquetaSiNoExiste(String tag) {
		try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}

		Actor actor = Serenity.sessionVariableCalled("Actor");
		boolean chequeo = ExisteUnaEtiquetaCon(tag);
		if (chequeo == false) {
			return agregarUnaEtiqueta(tag,"", false);
		} else {
			return Task.where("Observó la etiqueta de entre los resultados.");
		}

	}

	public static filtroSistemaBuilder LasEtiquetasQue(String EsDeSistema) {
		// TODO Auto-generated method stub
		return new filtroSistemaBuilder(EsDeSistema);
	}

	public static class filtroSistemaBuilder{
		static String EsDeSistema;
		public filtroSistemaBuilder(String EsDeSistema){
			super();
			this.EsDeSistema = EsDeSistema;

		}


		public int SonDelSistema() {
			return EnEtiquetas.LasEtiquetasDelSistema(EsDeSistema);
		}
	}


}

