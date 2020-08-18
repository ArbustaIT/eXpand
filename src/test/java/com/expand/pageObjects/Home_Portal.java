package com.expand.pageObjects;

import org.apache.pdfbox.contentstream.operator.graphics.MoveTo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.*;


public class Home_Portal extends PaginaBase {
public Home_Portal(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public static Target menu =Target.the("el Menú principal").locatedBy("//mat-toolbar[@class='top-bar mat-toolbar mat-primary mat-toolbar-single-row']//button[@class='mat-icon-button']");

public static Target portal 				= Target.the("El menú ").locatedBy("");
public static Target portal_Canaldigital	= Target.the("El menú ").locatedBy("");

public static Target MonitoreoDeCanalesDigitales			= Target.the("El menú ").locatedBy("");
public static Target MonitoreoDeCanalesDigitales_Agentes	= Target.the("El menú ").locatedBy("");

public static Target Administracion 					= Target.the("El menú 'Administración' ").locatedBy("//mat-expansion-panel-header[@id='mat-expansion-panel-header-5']//mat-panel-title[@class='mat-expansion-panel-header-title']");
public static Target Administracion_Basico				= Target.the("El menú 'Básico' ").locatedBy("//mat-expansion-panel-header[@id='mat-expansion-panel-header-6']//mat-panel-title[@class='mat-expansion-panel-header-title']");
public static Target Administracion_Basico_Etiquetas	= Target.the("El menú 'Etiquetas' ").locatedBy("//body[@class='mat-typography']/expand-app-root/expand-app-main[@class='ng-star-inserted']/div[@class='main-container']/mat-sidenav-container[@class='main-content mat-drawer-container mat-sidenav-container mat-drawer-transition mat-drawer-opened']/mat-sidenav[@class='mat-drawer mat-sidenav ng-tns-c10-2 ng-trigger ng-trigger-transform mat-drawer-over ng-star-inserted']/div[@class='mat-drawer-inner-container']/expand-app-sidebar/mat-nav-list[@class='mat-nav-list']/mat-accordion[@class='mat-accordion']/mat-expansion-panel[@class='main-category mat-expansion-panel ng-tns-c16-24 ng-star-inserted mat-expanded mat-expansion-panel-spacing']/div[@id='cdk-accordion-child-5']/div[@class='mat-expansion-panel-body']/mat-accordion[@class='mat-accordion']/mat-expansion-panel[@class='secondary-category mat-expansion-panel ng-tns-c16-26 ng-star-inserted mat-expanded mat-expansion-panel-spacing']/div[@id='cdk-accordion-child-6']/div[@class='mat-expansion-panel-body']/a[1]/div[1]");
public static Target Administracion_Basico_Pausas		= Target.the("El menú ").locatedBy("");
public static Target Administracion_Basico_Localidades	= Target.the("El menú ").locatedBy("");
public static Target Administracion_Basico_Departamentos= Target.the("El menú ").locatedBy("");

public static Target Administracion_Telefonia					= Target.the("El menú ").locatedBy("");
public static Target Administracion_Telefonia_LlamadasSalientes	= Target.the("El menú ").locatedBy("");

public static Target Administracion_CanalesDigitales				= Target.the("El menú ").locatedBy("");
public static Target Administracion_CanalesDigitales_CanalWhatsapp	= Target.the("El menú ").locatedBy("");
public static Target Administracion_CanalesDigitales_Colas			= Target.the("El menú ").locatedBy("");
public static Target Administracion_CanalesDigitales_Agentes		= Target.the("El menú ").locatedBy("");

public static Target Administracion_Sistema			= Target.the("El menú ").locatedBy("");
public static Target Administracion_Sistema_Claves	= Target.the("El menú ").locatedBy("");

}
