package com.expand.pageObjects;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.targets.Target;

public class MonitoreoDeCanalesDigitales extends Home_Portal {

	public static class Agentes{
		public static Target sel_FechaInicio 	= Target.the("la fecha de inicio").locatedBy("//input[@id='mat-input-8']");
		public static Target sel_FechaFin 		= Target.the("la fecha de fin").locatedBy("//input[@id='mat-input-9']");
		public static Target cmb_Colas 			= Target.the("el combo de listado de colas").locatedBy("//input[@id='mat-input-9']");
		public static Target cmb_Agentes 		= Target.the("el combo de listado de agentes").locatedBy("//span[@class='mat-select-placeholder ng-tns-c16-67 ng-star-inserted']");
		public static Target cmb_Etiquetas 		= Target.the("el combo de listado de etiquetas").locatedBy("//span[@class='mat-select-placeholder ng-tns-c16-70 ng-star-inserted']");

		public static Target btm_Filtrar 		= Target.the("el botón 'Filtrar'").locatedBy("//span[@class='mat-select-placeholder ng-tns-c16-70 ng-star-inserted']");

		public static Target lbl_ConversacionesFinalizadas = Target.the("la conversación finalizada").locatedBy("//span[@class='mat-select-placeholder ng-tns-c16-70 ng-star-inserted']");

		public static Target btn_Exportar 		= Target.the("el botón 'Exportar'").locatedBy("//span[@class='mat-select-placeholder ng-tns-c16-70 ng-star-inserted']");

		//================================================================================================
		//Fila y columna de las celdas de historial
		public static Target lbl_CeldaHistorial (int fila , int columna) {
			fila = fila <=0? 1:fila;
			columna = columna <=0? 1:columna;
			columna = columna >4? 4:columna;
			Target celdaHistorial =Target.the("").locatedBy("//mat-row["+fila+"]//mat-cell["+columna+"]");
			return celdaHistorial;	
		}
		
		public static Target lbl_CeldaHistorial (int fila ) {
			return lbl_CeldaHistorial(fila,1);
		}
		
		public static Target lbl_CeldaHistorial () {
			return lbl_CeldaHistorial(1,1);
		}
		//================================================================================================
		
		class EstadísticasAgente{
			public  Target lbl_TituloVentana 			= Target.the("el titulo de la ventana emergente").locatedBy("//h2[@id='mat-dialog-title-6']");
			
			public  Target lbl_NombreUsuario 			= Target.the("el nombre de usuario")			.locatedBy("//expand-app-dialog-monitoring-dchann-agent-stats[1]/div[1]/div[1]/div[1]/mat-card[1]/mat-card-content[1]");
			public  Target lbl_NroAgente 				= Target.the("el número del agente")			.locatedBy("//expand-app-dialog-monitoring-dchann-agent-stats[1]/div[1]/div[1]/div[2]/mat-card[1]/mat-card-content[1]");
			public  Target lbl_Nombre 					= Target.the("el nombre del agente")			.locatedBy("//expand-app-dialog-monitoring-dchann-agent-stats[1]/div[1]/div[1]/div[3]/mat-card[1]/mat-card-content[1]");
			public  Target lbl_CorreoElectronico 		= Target.the("el mail del agente")				.locatedBy("//expand-app-dialog-monitoring-dchann-agent-stats[1]/div[1]/div[1]/div[4]/mat-card[1]/mat-card-content[1]");
			public  Target lbl_TiempoLogueado 			= Target.the("el tiempo logueado")				.locatedBy("//expand-app-dialog-monitoring-dchann-agent-stats[1]/div[1]/div[1]/div[5]/mat-card/mat-card-content");
			public  Target lbl_TiempoPausado 			= Target.the("el tiempo pausado")				.locatedBy("//expand-app-dialog-monitoring-dchann-agent-stats[1]/div[1]/div[1]/div[6]/mat-card[1]/mat-card-content[1]");
			public  Target lbl_TiempoPromedioDeRespuesta= Target.the("el tiempo promedio de respuesta")	.locatedBy("//expand-app-dialog-monitoring-dchann-agent-stats[1]/div[1]/div[1]/div[7]/mat-card[1]/mat-card-content[1]");
			public  Target lbl_DuracionPromedio 		= Target.the("la duración promedio")			.locatedBy("//expand-app-dialog-monitoring-dchann-agent-stats[1]/div[1]/div[1]/div[8]/mat-card[1]/mat-card-content[1]");
			public  Target lbl_Colas 					= Target.the("el listado de colas")				.locatedBy("//expand-app-dialog-monitoring-dchann-agent-stats[1]/div[1]/div[1]/div[9]/mat-card[1]/mat-card-content[1]");
			
			public  Target Conversaciones_finalizadas 					= Target.the("La sección de Conversaciones finalizadas")					.locatedBy("//expand-app-monitoring-dchann-charts[1]/div[1]/h3[1]");
			public  Target Conversaciones_finalizadas_Total 			= Target.the("el total de conversaciones")									.locatedBy("//expand-app-monitoring-dchann-charts[1]/div[1]/div[1]/expand-app-advanced-pie-chart[1]/ngx-charts-advanced-pie-chart[1]/div[1]/div[2]/ngx-charts-advanced-legend[1]/div[1]/div[1]/div[1]");
			public  Target Conversaciones_finalizadas_Agentes 			= Target.the("el total de agentes")											.locatedBy("//expand-app-monitoring-dchann-charts[1]/div[1]/div[1]/expand-app-advanced-pie-chart[1]/ngx-charts-advanced-pie-chart[1]/div[1]/div[2]/ngx-charts-advanced-legend[1]/div[1]/div[2]/div[1]/div[1]/div[2]");
			public  Target Conversaciones_finalizadas_AgentesPorc 		= Target.the("el porcentaje de agentes")									.locatedBy("//expand-app-monitoring-dchann-charts[1]/div[1]/div[1]/expand-app-advanced-pie-chart[1]/ngx-charts-advanced-pie-chart[1]/div[1]/div[2]/ngx-charts-advanced-legend[1]/div[1]/div[2]/div[1]/div[1]/div[4]");
			public  Target Conversaciones_finalizadas_TimeoutAgente 	= Target.the("el número de conversaciones con timeout del agente")			.locatedBy("//expand-app-monitoring-dchann-charts[1]/div[1]/div[1]/expand-app-advanced-pie-chart[1]/ngx-charts-advanced-pie-chart[1]/div[1]/div[2]/ngx-charts-advanced-legend[1]/div[1]/div[2]/div[1]/div[2]/div[2]");
			public  Target Conversaciones_finalizadas_TimeoutAgentePorc = Target.the("el porcentaje de las conversaciones con timeout del agente")	.locatedBy("//expand-app-monitoring-dchann-charts[1]/div[1]/div[1]/expand-app-advanced-pie-chart[1]/ngx-charts-advanced-pie-chart[1]/div[1]/div[2]/ngx-charts-advanced-legend[1]/div[1]/div[2]/div[1]/div[2]/div[4]");
			public  Target Conversaciones_finalizadas_TimeoutCliente 	= Target.the("el número de conversaciones con timeout del cliente")			.locatedBy("//expand-app-monitoring-dchann-charts[1]/div[1]/div[1]/expand-app-advanced-pie-chart[1]/ngx-charts-advanced-pie-chart[1]/div[1]/div[2]/ngx-charts-advanced-legend[1]/div[1]/div[2]/div[1]/div[3]/div[2]");
			public  Target Conversaciones_finalizadas_TimeoutClientePorc= Target.the("el porcentaje de las conversaciones con timeout del cliente")	.locatedBy("//expand-app-monitoring-dchann-charts[1]/div[1]/div[1]/expand-app-advanced-pie-chart[1]/ngx-charts-advanced-pie-chart[1]/div[1]/div[2]/ngx-charts-advanced-legend[1]/div[1]/div[2]/div[1]/div[3]/div[2]");
			public  Target Conversaciones_transferida_Total 			= Target.the("el número de conversaciones transferidas")					.locatedBy("//div[@class='cdk-overlay-container']//div[4]//div[2]");
			public  Target Conversaciones_transferida_Porc				= Target.the("el porcentaje de las conversaciones transferidas")			.locatedBy("//div[@class='cdk-overlay-container']//div[4]//div[4]");
			
			public  Target btn_cerrar = Target.the("el botón 'Cerrar'").locatedBy("/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/expand-app-dialog-monitoring-dchann-agent-stats[1]/div[2]/button[1]/span[1]");
		}
		
	}
	
	public static class Canales{
		public static Target sel_FechaInicio 	= Target.the("la fecha de inicio").locatedBy("//input[@id='mat-input-17']");
		public static Target sel_FechaFin 		= Target.the("la fecha de fin").locatedBy("//input[@id='mat-input-18']");
		public static Target sel_Canales 		= Target.the("la fecha de fin").locatedBy("//span[@class='mat-select-placeholder ng-tns-c19-95 ng-star-inserted']");
		public static Target btn_Filtrar 		= Target.the("el botón 'filtrar'").locatedBy("//button[@class='action-field mat-flat-button mat-primary ng-star-inserted']");	
	}
}
