package com.expand.pageObjects;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.targets.Target;

public class Administracion_Basico_Etiquetas_Agregar extends Home_Portal {

	public Administracion_Basico_Etiquetas_Agregar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public Target txt_Nombre = Target.the("el campo 'Nombre'").locatedBy("//mat-form-field[1]/div[1]/div[1]/div[3]/input[1]");
	public Target txt_descripción = Target.the("el campo 'Descripción'").locatedBy("//mat-form-field[2]/div[1]/div[1]/div[3]/input[1]");
	public Target nud_Etiquetados = Target.the("el campo 'Etiquetados'").locatedBy("//input[@id='mat-input-14']");
	public Target tgg_EsDeSistema = Target.the("el campo '¿Es del sistema?'").locatedBy("//div[@class='mat-slide-toggle-bar']");
	public Target btn_Cancelar = Target.the("el botón 'Cancelar'").locatedBy("//button[@class='mat-flat-button mat-default']");
	public Target btn_Agregar = Target.the("el botón 'Agregar'").locatedBy("//button[@class='mat-flat-button mat-primary ng-star-inserted']");



}
