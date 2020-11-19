package com.expand.pageObjects.administracion.Basico;

import org.openqa.selenium.WebDriver;

import com.expand.pageObjects.Administracion;
import com.expand.pageObjects.Home_Portal;

import net.serenitybdd.screenplay.targets.Target;

public class Etiquetas extends Home_Portal{
	
	//FER.attemptsTo(SelectFromOptions.byVisibleText("Filtar por todas las etiquetas").from(ClientDetails.FAVORITE_COLOR));
	public static Target cmb_Filtrar = Target.the("el combo 'filtrar'").locatedBy("//mat-form-field[1]/div[1]/div[1]/div[3]/mat-select[1]/div[1]/div[1]/span[1]/span[1]");
	public static Target txt_buscar = Target.the("la caja de texto de búsqueda").locatedBy("//mat-form-field[1]/div[1]/div[1]/div[3]/input[1]");
	public static Target btn_agregar = Target.the("el botón 'Agregar'").locatedBy("//expand-app-button-field[1]/div[1]/button[1]");
	public Target btn_EncabezadoNombre = Target.the("el encabezado 'Nombre'").locatedBy("//button[contains(text(),'Nombre')]");
	public Target btn_EncabezadoDescripcion = Target.the("el encabezado 'Descripción'").locatedBy("//button[contains(text(),'Descripción')]");
	public Target btn_EncabezadoEtiquetados = Target.the("el encabezado  'Etiquetados'").locatedBy("//button[contains(text(),'Etiquetados')]");
	public Target btn_EncabezadoEsDelSistema = Target.the("el encabezado '¿Es del sistema?'").locatedBy("//button[contains(text(),'Es del sistema?')]");
	public static Target celda (int fila, int col) {
		return Target.the("").locatedBy("//mat-row["+fila+"]//mat-cell["+col+"]");
	}
	public static Target opcionFiltro (int fila) {
		return Target.the("").locatedBy("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/mat-option["+fila+"]/span[1]");
	}
	
	public static Target celda (int fila) {
		return celda(fila, 1);
	}
	public Target celda () {
		return celda(1, 1);
	}
	public static Target btn_OpcionesDeCelda(int fila) {
		return Target.the("").locatedBy("//mat-row["+fila+"]//mat-cell[5]//button[1]");
	}
	public Target btn_OpcionesDeCelda() {
		return btn_OpcionesDeCelda();
	}

	
	

}

