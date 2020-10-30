package com.expand.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.targets.Target;

public class Home extends PaginaBase {

	public static Target MNU_Administración;
	public static Target MNU_Monitoreo;
	public static Target MNU_Listado_de_campañas;
	public static Target MNU_Campañas_SMS;
	//public Target MNU_Discador =Target.the("control").locatedBy("/html[1]/body[1]/div[1]/div[3]/div[1]/ul[1]/li[5]/a[1]");
	public Target MNU_Discador =Target.the("control").located(By.id("Web3.LeftBar_categoryDialer_control"));

}
