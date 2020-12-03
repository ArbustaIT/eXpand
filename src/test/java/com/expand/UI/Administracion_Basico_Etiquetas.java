package com.expand.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class Administracion_Basico_Etiquetas extends Home_Portal {

//	public Administracion_Basico_Etiquetas(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}

	//FER.attemptsTo(SelectFromOptions.byVisibleText("Filtar por todas las etiquetas").from(ClientDetails.FAVORITE_COLOR));
	public Target cmb_Filtrar = Target.the("el combo 'filtrar'").locatedBy("/html[1]/body[1]/expand-app-root[1]/expand-app-main[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/expand-app-admin[1]/expand-app-tags-list[1]/mat-card[1]/mat-card-content[1]/expand-app-actions-menu-generic[1]/div[1]/div[1]/expand-app-select-search-field[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]");
	public Target txt_buscar = Target.the("la caja de texto de búsqueda").locatedBy("/html[1]/body[1]/expand-app-root[1]/expand-app-main[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/expand-app-admin[1]/expand-app-tags-list[1]/mat-card[1]/mat-card-content[1]/expand-app-actions-menu-generic[1]/div[1]/div[2]/expand-app-text-search-field[1]/mat-form-field[1]/div[1]/div[1]/div[3]/input[1]");
	public Target btn_agregar = Target.the("el botón 'Agregar'").locatedBy("//button[@class='action-field mat-flat-button mat-primary ng-star-inserted']");
	public Target btn_EncabezadoNombre = Target.the("el encabezado 'Nombre'").locatedBy("//button[contains(text(),'Nombre')]");
	public Target btn_EncabezadoDescripcion = Target.the("el encabezado 'Descripción'").locatedBy("//button[contains(text(),'Descripción')]");
	public Target btn_EncabezadoEtiquetados = Target.the("el encabezado  'Etiquetados'").locatedBy("//button[contains(text(),'Etiquetados')]");
	public Target btn_EncabezadoEsDelSistema = Target.the("el encabezado '¿Es del sistema?'").locatedBy("//button[contains(text(),'Es del sistema?')]");
	public Target celda (int fila, int col) {
		return Target.the("la fila " +fila+", columna " +col).locatedBy("//mat-row["+fila+"]//mat-cell["+col+"]//mat-label[1]");
	}

	WebElementFacade texto;

	public Target celda (int fila) {
		return celda(fila, 1);

	}
	public Target celda () {
		return celda(1, 1);
	}

	public WebElement celda_WE (int fila, int col) {
		return getDriver().findElement(By.xpath("//mat-row["+fila+"]//mat-cell["+col+"]//mat-label"));
	}

	public Target btn_OpcionesDeCelda(int fila) {
		return Target.the("el botón de opciones de la fila").locatedBy("//mat-row["+fila+"]//mat-cell[5]//button[1]");
	}
	public Target btn_OpcionesDeCelda() {
		return btn_OpcionesDeCelda(1);
	}

	public void Eliminar_Etiqueta_Por_Nombre ( Actor actor, String Nombre) throws InterruptedException {
		int A =0;
		Target celda =null;
		String contenido ="";
		int B=0;

		//es un bucle que empieza a interactuar con las filas de la grilla en búsqueda del tag que se le pasa.
		//Si no lo encuentra lo saltea, pero si lo encuentra lo elimina.
		do {


			A++;
			Thread.sleep(500);
			celda = celda(A);

			contenido = Text.of(celda).viewedBy(actor).asString();
//			System.out.println(B);
//			System.out.println("====Comparando Elemento de la tabla =====\n"+
//					String.format("%s %d, %s \n %s \n %b \n", 
//							actor.getName() +" esta chequeando la fila Nro: ", A,	
//							contenido ,
//							Nombre ,
//							(contenido.equals(Nombre))
//							) +
//					"====Fin de la comparacion ================" );

			if (A> 10) {
				A=0;
				B= B+1;
			}

		} while (	contenido.equals(Nombre) == false  && B<3	);

		if (contenido.equals(Nombre)) {
			actor.attemptsTo(
					Click.on(btn_OpcionesDeCelda(A)),
					Click.on("//mat-label[contains(text(),'Eliminar')]"),
					Click.on("//span[contains(text(),'Aceptar')]"));
		} else {
			System.out.println("No se encontro elemento entre las etiquetas. \nSalteando eliminado del elemento.");
		}








	}

}