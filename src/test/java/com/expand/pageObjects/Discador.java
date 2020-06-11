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
public class Discador extends PaginaBase {
	
	private static  WebDriverWait wait ;
	private static WebDriver driver;
	
	public Discador(WebDriver driver) {
		super(driver);
		this.driver = getDriver();
		wait = new WebDriverWait(getDriver(),10);
		// TODO Auto-generated constructor stub
	}
	
	public static Target CMB_Filtro_de_campaña	= Target.the("el Combobox 'filtro de campañas'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_selectFilter\"]");
	public static Target LBL_Titulo_Seccion 	= Target.the("la etiqueta del titulo de la sección").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_title\"]");
	public static Target BTN_Creditos 			= Target.the("el botón 'Créditos'").located(By.id("main_moduleContent_current_view_active_module_creditsCount_chartBtn"));
	public static Target LBL_Uso_de_Credito_actual = Target.the("el Combobox 'filtro de campañas'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_creditsCount_creditsLbl\"]");
	public static Target BTN_Crear_campaña 		= Target.the("el botón 'Crear campaña'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_createCampaign_button\"]");
	public static Target LBL_Campañas_Activas	= Target.the("La sección 'Activas'").locatedBy("//span[@id='main_moduleContent_current_view_active_module_listActiveActive_columnHeaderIcon_text']");
	
	//Campañas activas...
	
	//static Target BTN_PlayPause_Campaña = Target.the("el botón 'Play/Pause'").locatedBy("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/div["+ NroCampaña +"]/div[1]/span[2]/img[1]");
	
	public static class campañas_Activas{
		//ID del contenedor de las campañas.
		static String Base = "//div[@id='main_moduleContent_current_view_active_module_listActiveActive_repeater']";
		//Numero de fila de la campaña seleccionada.
		public static int NroCampaña =1;
		
		
		
		public static Target BTN_Play	=	Target.the("el botón 'Play' de la campaña Nro '"+NroCampaña+"'.").locatedBy(Base+"/div["+ NroCampaña +"]/div[1]/span[2]/img[1]");
		public static Target BTN_Pause	=	Target.the("el botón 'Pause' de la campaña Nro '"+NroCampaña+"'.").locatedBy(Base+"/div["+ NroCampaña +"]/div[1]/span[1]/img[1]");
		
		//		public static Target LBL_Titulo  = 						Target.the("control").locatedBy("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/span[1]");
		//		public static Target LBL_FechaInicio = 					Target.the("control").locatedBy("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/label[2]");
		//		public static Target LBL_FechaFin = 					Target.the("control").locatedBy("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/label[4]");
		//		public static Target LBL_Nro_Contactos =				Target.the("control").locatedBy("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]");
		//		public static Target LBL_Porcentaje_de_mensajes =		Target.the("control").locatedBy("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]");
		//		public static Target LBL_Lineas_Ocupadas_o_Permitidas =	Target.the("control").locatedBy("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]");
		//		public static Target BTN_Editar_campaña =				Target.the("control").locatedBy("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/span[1]/img[1]");
		//		public static Target BTN_Archivar_campaña =				Target.the("control").locatedBy("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/span[3]/img[1]");
		//		public static Target LBL_Titulo  = 						Target.the("control").locatedBy("Base+"/div["+ NroCampaña +"]/div[1]/div[2]/div[1]/span[1]");
		public static Target LBL_Titulo_De_La_Campaña=			Target.the("el Titulo de la campaña Nro. " +NroCampaña).locatedBy(Base+"/div["+ NroCampaña +"]/div[2]/div[1]/span[1]");
		public static Target LBL_FechaInicio = 					Target.the("control").locatedBy(Base+"/div["+ NroCampaña +"]/div[1]/div[2]/label[2]");
		public static Target LBL_FechaFin = 					Target.the("control").locatedBy(Base+"/div["+ NroCampaña +"]/div[2]/label[4]");
		public static Target LBL_Nro_Contactos =				Target.the("control").locatedBy(Base+"/div["+ NroCampaña +"]/div[3]/div[1]");
		public static Target LBL_Porcentaje_de_mensajes =		Target.the("control").locatedBy(Base+"/div["+ NroCampaña +"]/div[5]/div[1]");
		public static Target LBL_Lineas_Ocupadas_o_Permitidas =	Target.the("control").locatedBy(Base+"/div["+ NroCampaña +"]/div[7]/div[1]");
		public static Target BTN_Editar_campaña =				Target.the("control").locatedBy(Base+"/div["+ NroCampaña +"]/div[8]/span[1]/img[1]");
		public static Target BTN_Archivar_campaña =				Target.the("control").locatedBy(Base+"/div["+ NroCampaña +"]/div[8]/span[3]/img[1]");
	}
	
	public static class Detalles_Campaña {
		
		
		public static Target LBL_Titulo			= Target.the("el Titulo de la campaña")				.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_name\"]");
																											
		public static Target btn_EstadoCampaña 	= Target.the("el botón de pausa/play de la campaña").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_status_campaign\"]");
		public static Target lbl_Editar 		= Target.the("el botón de Editar campaña")			.locatedBy("//img[@id='main_moduleContent_current_view_active_module_editBtn']");
		public static Target lbl_MensajeTestigo = Target.the("el botón de Mensaje testigo")			.locatedBy("//img[@id='main_moduleContent_current_view_active_module_editBtn']");
		public static Target lbl_Reportes 		= Target.the("el botón de Reportes")				.locatedBy("//img[@id='main_moduleContent_current_view_active_module_editBtn']");
		
		
		//contactos
		public static Target LBL_Completados=	Target.the("el label 'Completados'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_contact_stats_container_lblContactsComplete\"]");
		public static Target LBL_Descartados=	Target.the("el label 'descartados'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_contact_stats_container_lblContactsRejected\"]");
		public static Target LBL_Anulados	=	Target.the("el label 'Anulados'")	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_contact_stats_container_lblContactsCancel\"]");
		public static Target LBL_Pendientes =	Target.the("el label 'Pendientes'")	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_contact_stats_container_lblContactsPending\"]");
		public static Target LBL_Total		=	Target.the("el label 'Total'")		.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_lblcountContacts\"]");
		
		//Mensaje a enviar
		public static Target LBL_Mensaje	=	Target.the("el mensaje enviado por la campaña")	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_textContainer\"]");
		public static Target LBL_Param1		=	Target.the("el parámetro 1 del mensaje")		.locatedBy("/html/body/div[1]/div[3]/div[2]/div/div/div[4]/div/div[1]/div/div[2]/div/div/pre/span[1]/span");
		public static Target LBL_Param2		=	Target.the("el parámetro 2 del mensaje")		.locatedBy("/html/body/div[1]/div[3]/div[2]/div/div/div[4]/div/div[1]/div/div[2]/div/div/pre/span[2]/span");
		
		//Config
		public static Target LBL_FechaInicio				=	Target.the("la Fecha de inicio de la campaña")					.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_lblFechaInicio\"]");
		public static Target LBL_FechaFin					= 	Target.the("la Fecha de fin de la campaña")						.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_lblFechaFin\"]");
		public static Target LBL_FechasParaNOEnvíarMensajes	=	Target.the("chequea las Fechas que no se deben enviar mensajes").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_noCallDateCont\"]");
		public static Target LBL_DiasParaEnvíarMensajes		=	Target.the("los días que pueden enviarse los mensajes")			.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_lblvaliddays\"]");
		public static Target LBL_HoraDeInicio				=	Target.the("la hora de inicio de la campaña")					.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_lblhourstart\"]");
		public static Target LBL_HoraDeFinalizacion			=	Target.the("la hora de finalización de la campaá")				.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet0_sheetsInformation_lblhoursfin\"]");
		
		public static Target tab_Contactos;
		//Filtros
		public static Target cbo_Filtrar						= Target.the("").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_selectFilter\"]");
		public static Target opc_FiltrarTodosLosContactos		= Target.the("").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_selectFilter_option\"]");
		public static Target opc_FiltrarContactosPendientes		= Target.the("").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_selectFilter_option2\"]");
		public static Target opc_FiltrarContactosCompletados	= Target.the("").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_selectFilter_option3\"]");
		public static Target opc_FiltrarContactoscancelados		= Target.the("").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_selectFilter_option4\"]");
		public static Target opc_FiltrarContactosRechazados		= Target.the("").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_selectFilter_option5\"]");
		public static Target txt_Buscar							= Target.the("").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_toolbar_search_searchField\"]");;
		public static Target BTN_AgregarContacto				= Target.the("").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_toolbar_add_button\"]");;
		
		//tabla
		//Encabezados
		public static Target col_EncabezadoNombre			= Target.the("el encabezado 'Nombre'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_contactList_itemHeader_columnHeader\"]");
		public static Target col_EncabezadoTelefono			= Target.the("el encabezado 'Teléfono'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_contactList_itemHeader_columnHeader2_text\"]");
		public static Target col_EncabezadoUltimoIntento	= Target.the("el encabezado 'Último intento'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_contactList_itemHeader_columnHeader3_text\"]");
		public static Target col_EncabezadoUltimoResultado	= Target.the("el encabezado 'Último resultado'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_contactList_itemHeader_columnHeader4_text\"]");
		public static Target col_EncabezadoEstado			= Target.the("el encabezado 'Estado'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_contactList_itemHeader_columnHeader5_text\"]");
		
		//Emconrtando el patron de la tabla, vi que los xpath generados automaticamente se diferenciaban por un indice.
		//Pero si era la primera fila no tenian ninguno.
		static int Nro_registro =0;
		//Para solventar temporalmente esto, use la expresion +(Nro_registro == 0 ? "": Nro_registro)+ para concatenar esas partes del xpath
		public static Target Registro_Nombre 			= Target.the("el Nombre de la fila" + Nro_registro)				.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_contactList_repeater_control"+(Nro_registro == 0 ? "": Nro_registro)+"_item_name\"]");
		public static Target Registro_Telefono 			= Target.the("el Teléfono de la fila" + Nro_registro)			.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_contactList_repeater_control"+(Nro_registro == 0 ? "": Nro_registro)+"_item_numcall\"]");
		public static Target Registro_UltimoIntento 	= Target.the("el Ultimo intento de la fila" + Nro_registro)		.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_contactList_repeater_control"+(Nro_registro == 0 ? "": Nro_registro)+"_item_attempttimestamp\"]");
		public static Target Registro_UltimoResultado 	= Target.the("el Ultimo resultado de la fila" + Nro_registro)	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_contactList_repeater_control"+(Nro_registro == 0 ? "": Nro_registro)+"_item_lastattempt\"]");
		public static Target Registro_Estado 			= Target.the("el Estado de la fila" + Nro_registro)				.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_contactList_repeater_control"+(Nro_registro == 0 ? "": Nro_registro)+"_item_state\"]");
		
		public static Target lbl_InfoAdicParam1			= Target.the("el nombre del parametro 1 en info adicional")	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_infoExtra_control216\"]");
		public static Target lbl_InfoAdicParam2 		= Target.the("el nombre del parametro 2 en info adicional")	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_infoExtra_control218\"]");
		public static Target lbl_InfoAdicValorParam1 	= Target.the("el valor del parametro 1 en info adicional")	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_infoExtra_control217\"]");
		public static Target lbl_InfoAdicValorParam2 	= Target.the("el valor del parametro 2 en info adicional")	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_infoExtra_control219\"]");
		public static Target lbl_MensajedeConversacion 	= Target.the("el contenido del mensaje enviado")			.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_dashboardtabs_sheetsContainer_sheet1_sheetsContacts_contactListNew_stateLogs_wpconversation_hconversationsContainer_control3\"]");
		
	}
	
	public static class Crear_Campaña_Paso1 extends Discador {
		public Crear_Campaña_Paso1(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
		
		public static Target txt_Nombre			= Target.the("el Nombre de la campaña")	.locatedBy("//input[@id='main_moduleContent_current_view_active_module_new_campaign_form_inpName']");
		public static Target cal_FechaDeInicio	= Target.the("La Fecha de inicio")
		//.locatedBy("//*[@id='main_moduleContent_current_view_active_module_new_campaign_form_inpFechaInicio_input_date']");
		.locatedBy("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]");
		//Grilla calendario
		public static Target cal_SelFechaDeInicio(int dia) {
			WebElement elemento= driver.findElement(By.xpath(cal_FechaDeInicio.getCssOrXPathSelector()));
			String xpath ="";
			
			//Al abrirse el calendario y presionar Izquierda o derecha cambiamos el foco a el.
			elemento.sendKeys(Keys.LEFT);
			//Guardamos el elemento en una variable
			elemento= driver.switchTo().activeElement();
			
			//si el día que pasamos es mayor, vamos a la derecha, sino a la izquierda.
			while (Integer.parseInt(elemento.getText()) != dia){
				if	(Integer.parseInt(elemento.getText()) > dia){  
					elemento.sendKeys(Keys.LEFT);
					}else{
					elemento.sendKeys(Keys.RIGHT);
				}
				elemento= driver.switchTo().activeElement();
			}
			//Guardamos el xpath elemento
			xpath= getAbsoluteXPath(elemento);
			Target opciones = Target.the("el día " +dia)		.locatedBy(xpath);
			//Lo retornamos para interactuar con un enter en nuestro TC.
			return opciones;
		}
		//=======================================================
		//=======================================================
		//Son procedimientos en beta para seleccionar el día en el calendario. Pueden no funcionar...
		public static Target cal_SelFechaDeInicio_BETA(int dia) {
			WebElement elemento= driver.findElement(By.xpath(cal_FechaDeInicio.getCssOrXPathSelector()));
			String xpath ="";
			
			//Al abrirse el calendario y presionar Izquierda o derecha cambiamos el foco a el.
			elemento.sendKeys(Keys.LEFT);
			//Guardamos el elemento en una variable
			//elemento= driver.switchTo().activeElement();
			//System.out.println(getAbsoluteXPath(elemento));
			
			//Guardamos el xpath elemento
			//xpath= getAbsoluteXPath(elemento);
			xpath = "/html[1]/body[1]/div[121]/div[2]/div[1]/div[2]/div[1]/span["+dia+"]";
			Target opciones = Target.the("el día " +dia)		.locatedBy(xpath);
			//Lo retornamos para interactuar con un enter en nuestro TC.
			return opciones;
		}
		//-------------------------------------------------------
		public static Target cal_SelFechaDeFin_BETA(int dia) {
			WebElement elemento= driver.findElement(By.xpath(cal_FechaDeFinalizacion.getCssOrXPathSelector()));
			String xpath ="";
			
			//Al abrirse el calendario y presionar Izquierda o derecha cambiamos el foco a el.
			elemento.sendKeys(Keys.LEFT);
			//Guardamos el elemento en una variable
			//elemento= driver.switchTo().activeElement();
			//System.out.println(getAbsoluteXPath(elemento));
			
			//Guardamos el xpath elemento
			//xpath= getAbsoluteXPath(elemento);
			xpath = "/html[1]/body[1]/div[122]/div[2]/div[1]/div[2]/div[1]/span["+dia+"]";
			Target opciones = Target.the("el día " +dia)		.locatedBy(xpath);
			//Lo retornamos para interactuar con un enter en nuestro TC.
			return opciones;
		}
		//=======================================================
		//=======================================================
		public static Target cal_FechaDeFinalizacion = Target.the("la fecha de finalizacion").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_inpFechaFin_input_date\"]");
		//Grilla calendario
		public static Target cal_SelFechaDeFin(int dia) {
			WebElement elemento = driver.findElement(By.xpath(cal_FechaDeFinalizacion.getCssOrXPathSelector()));
			elemento.sendKeys(Keys.LEFT);
			String xpath = "";
			elemento= driver.switchTo().activeElement();
			
			while (Integer.parseInt(elemento.getText()) != dia){
				if	(Integer.parseInt(elemento.getText()) > dia){  
					elemento.sendKeys(Keys.LEFT);
					}else{
					elemento.sendKeys(Keys.RIGHT);
				}
				elemento= driver.switchTo().activeElement();
			} 
			xpath= getAbsoluteXPath(elemento);
			Target opciones = Target.the("el día " +dia)		.locatedBy(xpath);
			
			return opciones;
			
		}
		
		
		
		public static Target chk_SinFechaDeFinalizacion = Target.the("la opción 'Sin fecha de finalización'").locatedBy("//*[@id=\"checkDateEnd\"]");
		
		public static class DiasQuePuedeLlamar {
			public static Target chk_Lunes 		= Target.the("").locatedBy("//*[@id=\"checkMonday\"]");
			public static Target chk_Martes 	= Target.the("").locatedBy("//*[@id=\"checkTuesday\"]");
			public static Target chk_Miercoles 	= Target.the("").locatedBy("//*[@id=\"checkWendsday\"]");
			public static Target chk_Jueves 	= Target.the("").locatedBy("//*[@id=\"checkThursday\"]");
			public static Target chk_Viernes 	= Target.the("").locatedBy("//*[@id=\"checkFriday\"]");
			public static Target chk_Sabado 	= Target.the("").locatedBy("//*[@id=\"checkSaturday\"]");
			public static Target chk_Domingo 	= Target.the("").locatedBy("//*[@id=\"checkSunday\"]");
		}
		
		public static Target cal_fechasParaNoLlamar = Target.the("la opción de fechas para no relizar llamadas o mensajes").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_labelDontCallDays\"]");
		
		
		public static Target txt_HoraDeInicio		= Target.the("la hora de inicio de la campaña")		
		.locatedBy("//*[@id='main_moduleContent_current_view_active_module_new_campaign_form_cmdhourStart']");
		
		public static Target cbo_HoraDeInicio(int hora)  {
			Click.on(txt_HoraDeInicio);
			String xpath =	"//*[@id='main_moduleContent_current_view_active_module_new_campaign_form_cmdhourStart_option"+(hora==0?"":hora)+"']";
			Target opciones = Target.the("la hora " +hora)		.locatedBy(xpath);
			
			WaitUntil.the(opciones, isVisible()).forNoMoreThan(10).seconds();
			
			Click.on(opciones);
			return opciones;
		}
		public static Target txt_MinutoDeInicio 	= Target.the("el minuto de inicio de la campaña")		.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_cmdminStart\"]");
		public static Target cbo_MinutoDeInicio(int hora) {
			Click.on(txt_MinutoDeInicio);
			String xpath ="//option[@id='main_moduleContent_current_view_active_module_new_campaign_form_cmdminStart_option"+(hora==0?"":hora)+"']";
			
			Target opciones = Target.the("el minuto " +hora)		.locatedBy(xpath);
			
			WaitUntil.the(opciones, isVisible()).forNoMoreThan(10).seconds();;
			return opciones;
		}
		
		public static Target txt_HoraDeFinalizacion	= Target.the("la hora de finalización de la campaña")	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_cmdhourEnd\"]");
		public static Target cbo_HoraDeFinalizacion(int hora) {
			Click.on(txt_HoraDeFinalizacion);
			String xpath ="//option[@id='main_moduleContent_current_view_active_module_new_campaign_form_cmdhourEnd_option"+(hora==0?"":hora)+"']";
			
			Target opciones = Target.the("la hora " +hora)		.locatedBy(xpath);
			
			WaitUntil.the(opciones, isVisible()).forNoMoreThan(10).seconds();
			Click.on(opciones);
			return opciones;
		}
		
		public static Target txt_MinutoDeFin 		= Target.the("el minuto de fin de la campaña")		.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_cmdminEnd\"]");
		public static Target cbo_MinutoDeFin(int hora) throws InterruptedException {
			Click.on(txt_MinutoDeFin);
			String xpath ="//option[@id='main_moduleContent_current_view_active_module_new_campaign_form_cmdminEnd_option"+(hora==0?"":hora)+"']";
			Target opciones = Target.the("el minuto " +hora)		.locatedBy(xpath);
			
			WaitUntil.the(opciones, isVisible()).forNoMoreThan(10).seconds();
			Click.on(opciones);
			return opciones;
		}
		
		
		public static Target txt_LineasSimultaneas 	= Target.the("las lineas simultaneas").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_linesS\"]");
		
		public static Target cob_TipoDeCampaña 	= Target.the("el tipo de campaña").locatedBy("//select[@id='main_moduleContent_current_view_active_module_new_campaign_form_selectTypeCampaign']");
		public static Target opc_TipoDeCampaña_WhatsApp = Target.the("la opción 'WhatsApp'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_selectTypeCampaign_option3\"]");
		
		
		public static Target cbo_Canal 			= Target.the("el canal").locatedBy("//select[@id='main_moduleContent_current_view_active_module_new_campaign_form_whatsappContainer_selectTemplate']");
		public static Target opc_Canal_opc_2 = Target.the("el canal configurado").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_whatsappContainer_selectChannel_option2\"]");
		
		public static Target cbo_Template 		= Target.the("la plantilla").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_whatsappContainer_selectTemplate\"]");
		public static Target opc_Template_Instalacion = Target.the("la plantilla 'Instalación'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_whatsappContainer_selectTemplate_option2\"]");
		
		public static Target opc_Template_Informa = Target.the("la plantilla 'informa'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_whatsappContainer_selectTemplate_option3\"]");
		
		
		public static Target btn_crear 		= Target.the("el botón Crear").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_okCampaign_button\"]");
		public static Target btn_Cancelar 	= Target.the("el botón 'Cancelar'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_new_campaign_form_whatsappContainer_selectTemplate\"]");
		
		
		
	}
	
	public static class Crear_Campaña_Paso2 {
		public static Target lbl_MensajeDeEstado 	= Target.the("el mensaje de estado de la campaña").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_h2_noContactos\"]");
		public static Target lbl_agregarContactos 	= Target.the("la opción 'Agregar Contactos'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_textinpAgregarContactos_button_label\"]");
		public static Target btn_agregarContactos 	= Target.the("el botón 'Agregar'")	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_contacts_container_contactList_toolbar_add_button\"]");
		public static Target txt_Nombre 			= Target.the("el campo 'Nombre'")	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_contacts_container_contactList_contactPopup_inpContactName\"]");
		public static Target txt_Telefono 			= Target.the("el campo 'Teléfono'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_contacts_container_contactList_contactPopup_inpPhone\"]");
		public static Target txt_InfoAdicional1 	= Target.the("el campo de info adicional 1").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_contacts_container_contactList_contactPopup_dataGrid_repeater_control_value\"]");
		public static Target txt_InfoAdicional2 	= Target.the("el campo de info adicional 2").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_contacts_container_contactList_contactPopup_dataGrid_repeater_control2_value\"]");
		
		public static Target btn_Buscar		= Target.the("la caja de texto de búsqueda").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_contacts_container_contactList_toolbar_search_searchField\"]");
		public static Target btn_Agregar	= Target.the("el botón 'Agregar'").locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_contacts_container_contactList_contactPopup_acceptButton_button\"]");
		public static Target btn_cancelar	= Target.the("el botón 'Cancelar'")	.locatedBy("//*[@id=\"main_moduleContent_current_view_active_module_contacts_container_contactList_contactPopup_cancelItem_button\"]");
		public static Target btn_Finalizar	= Target.the("el botón 'Finalizar'").locatedBy("//a[@id='main_moduleContent_current_view_active_module_cancelCampaign2_button']");
	}
	
	public static String getAbsoluteXPath(WebElement element)
	{
	    return (String) ((JavascriptExecutor) driver).executeScript(
	            "function absoluteXPath(element) {"+
	                    "var comp, comps = [];"+
	                    "var parent = null;"+
	                    "var xpath = '';"+
	                    "var getPos = function(element) {"+
	                    "var position = 1, curNode;"+
	                    "if (element.nodeType == Node.ATTRIBUTE_NODE) {"+
	                    "return null;"+
	                    "}"+
	                    "for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling) {"+
	                    "if (curNode.nodeName == element.nodeName) {"+
	                    "++position;"+
	                    "}"+
	                    "}"+
	                    "return position;"+
	                    "};"+

	                    "if (element instanceof Document) {"+
	                    "return '/';"+
	                    "}"+

	                    "for (; element && !(element instanceof Document); element = element.nodeType == Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {"+
	                    "comp = comps[comps.length] = {};"+
	                    "switch (element.nodeType) {"+
	                    "case Node.TEXT_NODE:"+
	                    "comp.name = 'text()';"+
	                    "break;"+
	                    "case Node.ATTRIBUTE_NODE:"+
	                    "comp.name = '@' + element.nodeName;"+
	                    "break;"+
	                    "case Node.PROCESSING_INSTRUCTION_NODE:"+
	                    "comp.name = 'processing-instruction()';"+
	                    "break;"+
	                    "case Node.COMMENT_NODE:"+
	                    "comp.name = 'comment()';"+
	                    "break;"+
	                    "case Node.ELEMENT_NODE:"+
	                    "comp.name = element.nodeName;"+
	                    "break;"+
	                    "}"+
	                    "comp.position = getPos(element);"+
	                    "}"+

	                    "for (var i = comps.length - 1; i >= 0; i--) {"+
	                    "comp = comps[i];"+
	                    "xpath += '/' + comp.name.toLowerCase();"+
	                    "if (comp.position !== null) {"+
	                    "xpath += '[' + comp.position + ']';"+
	                    "}"+
	                    "}"+

	                    "return xpath;"+

	                    "} return absoluteXPath(arguments[0]);", element);
	}
	
	
}
