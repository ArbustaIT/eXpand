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

public static Target menu =Target.the("el Menú principal").locatedBy("//mat-toolbar[@class='top-bar mat-toolbar mat-primary mat-toolbar-single-row']//button[@class='mat-icon-button']");

public static Target portal 				= Target.the("El menú ").locatedBy("");
public static Target portal_Canaldigital	= Target.the("El menú ").locatedBy("");

public static Target MonitoreoDeCanalesDigitales			= Target.the("El menú ").locatedBy("");
public static Target MonitoreoDeCanalesDigitales_Agentes	= Target.the("El menú ").locatedBy("");

public static Target Administracion 					= Target.the("El menú 'Administración' ").locatedBy("//mat-expansion-panel-header[@id='mat-expansion-panel-header-5']//mat-panel-title[@class='mat-expansion-panel-header-title']");
public static Target Administracion_Basico				= Target.the("El menú 'Básico' ").locatedBy("//mat-expansion-panel-header[@id='mat-expansion-panel-header-6']//mat-panel-title[@class='mat-expansion-panel-header-title']");
public static Target Administracion_Basico_Etiquetas	= Target.the("El menú 'Etiquetas' ").locatedBy("//span[contains(text(),'Etiquetas')]");
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
