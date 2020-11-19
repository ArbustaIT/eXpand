package com.expand.pageObjects.administracion.Basico;

import org.openqa.selenium.WebDriver;

import com.expand.pageObjects.Administracion;
import com.expand.pageObjects.Home_Portal;

import net.serenitybdd.screenplay.targets.Target;

public class Etiquetas_Agregar extends Home_Portal {	
		
		public static Target txt_Nombre = Target.the("el campo 'Nombre'")			.locatedBy("//form[1]/mat-form-field[1]/div[1]/div[1]/div[3]/input[1]");
		public static Target txt_descripción = Target.the("el campo 'Descripción'")	.locatedBy("//form[1]/mat-form-field[2]/div[1]/div[1]/div[3]/input[1]");
		public static Target nud_Etiquetados = Target.the("el campo 'Etiquetados'").locatedBy("//input[@id='mat-input-14']");
		public static Target tgg_EsDeSistema = Target.the("el campo '¿Es del sistema?'").locatedBy("//form[1]/mat-form-field[4]/div[1]/div[1]/div[1]/mat-slide-toggle[1]");//"//mat-slide-toggle[@id='mat-slide-toggle-2']");
		public static Target btn_Cancelar = Target.the("el botón 'Cancelar'").locatedBy("//button[@class='mat-flat-button mat-default']");
		public static Target btn_Agregar = Target.the("el botón 'Agregar'").locatedBy("//button[@class='mat-flat-button mat-primary ng-star-inserted']");
		public static Target lbl_ErrorNombreExistente = Target.the("El mensaje 'Ya existe un tag con el mismo nombre'").locatedBy("//strong[contains(text(),'Ya existe un tag con el mismo nombre')]");
		public static Target lbl_ErrorDescripcion = Target.the("el mensaje de error de la descripción").locatedBy("//form[1]/mat-form-field[2]/div[1]/div[2]/div[1]/mat-error[1]");

	}