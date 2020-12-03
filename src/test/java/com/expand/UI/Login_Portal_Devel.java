package com.expand.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("http://canalesdigitales-devel.expand/expand/")
public class Login_Portal_Devel extends PaginaBase{
	public Target Txt_Usuario = Target.the("Caja de texto 'Usuario'").located(By.id("mat-input-0"));
	public Target Txt_Contraseña = Target.the("Caja de texto 'Contraseña'").located(By.id("mat-input-1"));
	public Target BTN_Ingresar = Target.the("Botón 'Ingresar'").located(By.xpath("//expand-app-login[1]/form[1]/button[1]"));
	//public Target Lbl_OlvideMiContraseña = Target.the("Link 'Olvide miContraseña'").located(By.id("login_loginForm_forgotPasswordButton_button"));

	
}
