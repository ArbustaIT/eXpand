package starter.runner;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Feature;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import starter.steps.Navegador;
import starter.steps.login;;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Narrative(text={"Prueba de automation."})
public class Test_Login extends Navegador {
	
	
	public login login = null;
	
	//Ejecutar desde el pom> run as > serenity:aggregate
	/*
	SetUp
	Al extender de la clase "Navegador", se ejecuta el constructor que hace todo el trabajo de
	Setup y se reutilizan las siguientes variables de allí:
	protected WebDriver driver;
	protected WebDriverWait wait;
	private String navegador = "chrome";
	*/		


		@SuppressWarnings("deprecation")
		@WithTags({ @WithTag(type = "Logueo", name = "Logueo correcto") })
	    @Title("Prueba de loguearse.")
	    @Test
	    public void Test_Loguearse() throws InterruptedException {
			login = new login(driver);
			System.out.println("Logueandose con credenciales...");
			login.loguearse("fbarrionuevo", "fbarrionuevo"); 
			Thread.sleep(2000);
			System.out.println("Chequeando URL: \n" + login.getCurrentUrl());
			Assert.assertEquals(login.getCurrentUrl(),"http://canalesdigitales.expand/frontEnd/panel");
			} 
		
		
		
		@SuppressWarnings("deprecation")
		@WithTags({ @WithTag(type = "Logueo", name = "Logueo incorrecto") })
	    @Title("Prueba de loguearse. Otras credenciales")
	    @Test
	    public void Test_Loguearse_otras_Credenciales() throws InterruptedException {
			login = new login(driver);
			System.out.println("Logueandose con credenciales...");
			login.loguearse("fbarrionuevo", "fbarrionuevo2"); 
			Thread.sleep(2000);
			System.out.println("Chequeando URL: \n" + login.getCurrentUrl());
			Assert.assertTrue(login.chequearrUrlDeIngreso());
			} 
		
		
		
		
		@After
		public void tearDown() {
			driver.close();
			driver.quit();
		}
}
