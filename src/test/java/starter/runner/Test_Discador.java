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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import starter.steps.Navegador;
import starter.steps.login;;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Narrative(text={"Prueba de automation."})
public class Test_Discador extends Navegador {
	
	//@Steps
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
		@WithTags({ @WithTag(type = "Visualización", name = "Discador") })
	    @Title("Prueba de loguearse e ir a discador para visualizar sus opciones.")
	    @Test
	    public void Test_Visualizar_Discador() throws InterruptedException {
			login = new login(driver);
			System.out.println("Logueandose con credenciales...");
			login.loguearse("fbarrionuevo", "fbarrionuevo"); 
			Thread.sleep(2000);
			WebElement discador_botton = driver.findElement(By.id("Web3.LeftBar_categoryDialer_control"));
			discador_botton.click();
	        Thread.sleep(10000);
	        System.out.println("Chequeando URL: \n" + login.getCurrentUrl());
			
			Assert.assertEquals(login.getCurrentUrl(),"http://canalesdigitales.expand/frontEnd/dialer/");
			} 
		
		
		
		
		@SuppressWarnings("deprecation")
		@WithTags({ @WithTag(type = "Campaña", name = "Visualizar campaña") })
	    @Title("Visualizar el contenido de una campaña.")
	    @Test
	    public void Test_Loguearse_Visualizar_Campaña() throws InterruptedException {
			login = new login(driver);
			System.out.println("Logueandose con credenciales...");
			login.loguearse("fbarrionuevo", "fbarrionuevo"); 
			Thread.sleep(2000);
			System.out.println("Chequeando URL: \n" + login.getCurrentUrl());
			//Assert.assertTrue(login.chequearrUrlDeIngreso());
			
			WebElement discador_botton = driver.findElement(By.id("Web3.LeftBar_categoryDialer_control"));
					discador_botton.click();
			        Thread.sleep(10000);
			        
			        int Nro= 2;
			        String xpathCampaña = "/html/body/div[1]/div[3]/div[2]/div/div/div[5]/div[2]/div[1]/div[1]/div[2]/div/div[" + (Nro) + "]/div[2]/div/span";
			WebElement campaña = driver.findElement(By.xpath(xpathCampaña));
			String nombreCampaña = campaña.getText();
			        campaña.click();
			        Thread.sleep(10000);
			        WebElement tituSeccionCampaña = driver.findElement(By.xpath("//*[@id=\"main_moduleContent_current_view_active_module_name\"]"));
			        Assert.assertEquals(tituSeccionCampaña.getText(), nombreCampaña);
			} 
		
		
		//Fer:- FALTA EL ASSERT PARA ESTE CASO...
		@SuppressWarnings({ "deprecation", "unchecked" })
		@WithTags({ @WithTag(type = "Campaña", name = "Visualizar campaña") })
	    @Title("Visualizar el contenido de una campaña.")
	    @Test
	    public void Test_Loguearse_Crear_Campaña() throws InterruptedException {
			
			login = new login(driver);
			System.out.println("Logueandose con credenciales...");
			login.loguearse("fbarrionuevo", "fbarrionuevo"); 
			Thread.sleep(2000);
			System.out.println("Chequeando URL: \n" + login.getCurrentUrl());
			//Assert.assertTrue(login.chequearrUrlDeIngreso());
			
			WebElement discador_botton = driver.findElement(By.id("Web3.LeftBar_categoryDialer_control"));
					discador_botton.click();
			        Thread.sleep(4000);
			        
		/*
		 * int Nro= 2; String xpathCampaña =
		 * "/html/body/div[1]/div[3]/div[2]/div/div/div[5]/div[2]/div[1]/div[1]/div[2]/div/div["
		 * + (Nro) + "]/div[2]/div/span"; WebElement campaña =
		 * driver.findElement(By.xpath(xpathCampaña)); String nombreCampaña =
		 * campaña.getText(); campaña.click(); Thread.sleep(10000); WebElement
		 * tituSeccionCampaña = driver.findElement(By.xpath(
		 * "//*[@id=\"main_moduleContent_current_view_active_module_name\"]"));
		 * Assert.assertEquals(tituSeccionCampaña.getText(), nombreCampaña);
		 */
		WebElement BTN_Crear_Campaña = driver.findElement(By.id("main_moduleContent_current_view_active_module_createCampaign_button"));	
		BTN_Crear_Campaña.click();
		
		Thread.sleep(2000);
		//Label o etiqueta que indica el paso 1.
		WebElement Lbl_Nueva_Campaña = driver.findElement(By.id("main_moduleContent_current_view_active_module_top_wizard_wiz1_wizLabel"));
		//Nombre Campaña.
		WebElement Txt_Nombre_campaña = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_inpName"));
		//Rango de fechas.
		WebElement Cal_Fecha_Inicio = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_inpFechaInicio_input_date"));
		WebElement Cal_Fecha_Fin = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_inpFechaFin_input_date"));
		WebElement Chk_Sin_FechaFin = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_labelCheckNoFechaFin"));
		//Días Activos de la campaña.
		WebElement Chk_Lunes = driver.findElement(By.id("checkMonday"));
		WebElement Chk_Martes = driver.findElement(By.id("checkTuesday"));
		WebElement Chk_Miercoles = driver.findElement(By.id("checkWendsday"));
		WebElement Chk_Jueves = driver.findElement(By.id("checkThursday"));
		WebElement Chk_Viernes = driver.findElement(By.id("checkFriday"));
		WebElement Chk_Sabado = driver.findElement(By.id("checkSaturday"));
		WebElement Chk_Domingo = driver.findElement(By.id("checkSunday"));
		//Horas Activas de la semana.
		WebElement Txt_Inicio_Hora = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_cmdhourStart"));
		WebElement Txt_Inicio_Minuto = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_cmdminStart"));
		WebElement Txt_Fin_Hora = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_cmdhourEnd"));
		WebElement Txt_Fin_Minuto = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_cmdminEnd"));
		WebElement Cmb_Tipo_Campaña = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_selectTypeCampaign"));
		WebElement Cmb_Canal = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_whatsappContainer_selectChannel"));
		WebElement Cmb_Template = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_whatsappContainer_selectTemplate"));
		WebElement Btn_Crear = driver.findElement(By.id("main_moduleContent_current_view_active_module_new_campaign_form_okCampaign_button"));
		
		
		Txt_Nombre_campaña.sendKeys("Test Campaña automation");
		Cal_Fecha_Inicio.click();
		new Actions(driver).moveToElement(Cal_Fecha_Inicio).click().perform();
		Thread.sleep(100);
		
		//Dia de iniciio en el calendario.
		//De izquierda a derecha se toma el número de casilla que indica el día.
		//Este al llegar al margen bajara de fila.
		int Nro_Día = 8;
		String XP_Cal_Dia_Inicio ="/html/body/div[241]/div[2]/div/div[2]/div/span[" + Nro_Día + "]";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XP_Cal_Dia_Inicio)));
		WebElement Cal_Dia_Inicio = driver.findElement(By.xpath(XP_Cal_Dia_Inicio));
		Cal_Dia_Inicio.click();
		
		Thread.sleep(500);
		
		Cal_Fecha_Fin.click();
		Nro_Día = 32;
		String XP_Cal_Dia_fin ="/html/body/div[242]/div[2]/div/div[2]/div/span[" + Nro_Día + "]";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XP_Cal_Dia_fin)));
		WebElement Cal_Dia_fin = driver.findElement(By.xpath(XP_Cal_Dia_fin));
		Cal_Dia_fin.click();
		
		Thread.sleep(500);
		Cmb_Tipo_Campaña.sendKeys(Keys.ENTER);
		Cmb_Tipo_Campaña.sendKeys(Keys.ARROW_DOWN);
		Cmb_Tipo_Campaña.sendKeys(Keys.ARROW_DOWN);
		Cmb_Tipo_Campaña.sendKeys(Keys.ENTER);
		
		Thread.sleep(500);
		Cmb_Canal.sendKeys(Keys.ENTER);
		Cmb_Canal.sendKeys(Keys.ARROW_DOWN);
		Cmb_Canal.sendKeys(Keys.ENTER);
		
		Thread.sleep(500);
		Cmb_Template.sendKeys(Keys.ENTER);
		Cmb_Template.sendKeys(Keys.ARROW_DOWN);
		Cmb_Template.sendKeys(Keys.ARROW_DOWN);
		Cmb_Template.sendKeys(Keys.ENTER);
		
		Btn_Crear.click();
		////////////////////////////////
		//Paso 2 de 3: Cargar contactos.
		////////////////////////////////
		WebElement Lbl_Agregar_contactos = driver.findElement(By.id("main_moduleContent_current_view_active_module_textinpAgregarContactos_button_label"));
		Lbl_Agregar_contactos.click();
		
		WebElement Btn_Agregar = driver.findElement(By.id("main_moduleContent_current_view_active_module_contacts_container_contactList_toolbar_add_button"));
		Btn_Agregar.click();
		
		
		WebElement Txt_Contactos_Nombre = driver.findElement(By.id("main_moduleContent_current_view_active_module_contacts_container_contactList_contactPopup_inpContactName"));
		Txt_Contactos_Nombre.sendKeys("Fernando");
		
		WebElement Txt_Contactos_Numero = driver.findElement(By.id("main_moduleContent_current_view_active_module_contacts_container_contactList_contactPopup_inpPhone"));
		Txt_Contactos_Numero.sendKeys("+5491153413898");
		
		WebElement Txt_Info_Adicional_1 = driver.findElement(By.id("main_moduleContent_current_view_active_module_contacts_container_contactList_contactPopup_dataGrid_repeater_control_value"));
		Txt_Info_Adicional_1.sendKeys("Fer");
		
		WebElement Txt_Info_Adicional_2 = driver.findElement(By.id("main_moduleContent_current_view_active_module_contacts_container_contactList_contactPopup_dataGrid_repeater_control2_value"));
		Txt_Info_Adicional_2.sendKeys("Programa");
		
		WebElement Brn_Agregar_datos = driver.findElement(By.id("main_moduleContent_current_view_active_module_contacts_container_contactList_contactPopup_acceptButton_button"));
		Brn_Agregar_datos.click();
		
		Thread.sleep(500);
		WebElement Brn_Agregar_Eventos = driver.findElement(By.id("main_moduleContent_current_view_active_module_toEventsBtn_button"));
		Brn_Agregar_Eventos.click();
		
		WebElement Brn_Agregar_finalizar = driver.findElement(By.id("main_moduleContent_current_view_active_module_evtsFinishBtn_button"));
		Brn_Agregar_finalizar.click();
		
		} 
		
		@After
		public void tearDown() {
			//driver.close();
			//driver.quit();
		}
}
