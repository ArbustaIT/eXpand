package com.expand.pageObjects;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.targets.Target;

public class Administracion extends Home_Portal {

	public Administracion(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static class Basico {


		//===============================
		public class Etiquetas{
			//FER.attemptsTo(SelectFromOptions.byVisibleText("Filtar por todas las etiquetas").from(ClientDetails.FAVORITE_COLOR));
			public Target cmb_Filtrar = Target.the("el combo 'filtrar'").locatedBy("/html[1]/body[1]/expand-app-root[1]/expand-app-main[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/expand-app-admin[1]/expand-app-tags-list[1]/mat-card[1]/mat-card-content[1]/expand-app-actions-menu-generic[1]/div[1]/div[1]/expand-app-select-search-field[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]");
			public Target txt_buscar = Target.the("la caja de texto de búsqueda").locatedBy("/html[1]/body[1]/expand-app-root[1]/expand-app-main[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/expand-app-admin[1]/expand-app-tags-list[1]/mat-card[1]/mat-card-content[1]/expand-app-actions-menu-generic[1]/div[1]/div[2]/expand-app-text-search-field[1]/mat-form-field[1]/div[1]/div[1]/div[3]/input[1]");
			public Target btn_agregar = Target.the("el botón 'Agregar'").locatedBy("//button[@class='action-field mat-flat-button mat-primary ng-star-inserted']");
			public Target btn_EncabezadoNombre = Target.the("el encabezado 'Nombre'").locatedBy("//button[contains(text(),'Nombre')]");
			public Target btn_EncabezadoDescripcion = Target.the("el encabezado 'Descripción'").locatedBy("//button[contains(text(),'Descripción')]");
			public Target btn_EncabezadoEtiquetados = Target.the("el encabezado  'Etiquetados'").locatedBy("//button[contains(text(),'Etiquetados')]");
			public Target btn_EncabezadoEsDelSistema = Target.the("el encabezado '¿Es del sistema?'").locatedBy("//button[contains(text(),'Es del sistema?')]");
			public Target celda (int fila, int col) {
				return Target.the("").locatedBy("//mat-row["+fila+"]//mat-cell["+col+"]");
			}
			public Target celda (int fila) {
				return celda(fila, 1);
			}
			public Target celda () {
				return celda(1, 1);
			}
			public Target btn_OpcionesDeCelda(int fila) {
				return Target.the("").locatedBy("//mat-row["+fila+"]//mat-cell[5]//button[1]");
			}
			public Target btn_OpcionesDeCelda() {
				return btn_OpcionesDeCelda();
			}

			public class Agregar{
				public Target txt_Nombre = Target.the("el campo 'Nombre'").locatedBy("//input[@id='mat-input-12']");
				public Target txt_descripción = Target.the("el campo 'Descripción'").locatedBy("//input[@id='mat-input-13']");
				public Target nud_Etiquetados = Target.the("el campo 'Etiquetados'").locatedBy("//input[@id='mat-input-14']");
				public Target tgg_EsDeSistema = Target.the("el campo '¿Es del sistema?'").locatedBy("//mat-slide-toggle[@id='mat-slide-toggle-2']");
				public Target btn_Cancelar = Target.the("el botón 'Cancelar'").locatedBy("//button[@class='mat-flat-button mat-default']");
				public Target btn_Agregar = Target.the("el botón 'Agregar'").locatedBy("//button[@class='mat-flat-button mat-primary ng-star-inserted']");
			}

		}
		//===============================
		public class Pausas{
			public Target txt_buscar = Target.the("").locatedBy("");
			public Target btn_agregar = Target.the("").locatedBy("");
		}
		//===============================
		public class Localidades{
			public Target txt_buscar = Target.the("").locatedBy("");
			public Target btn_agregar = Target.the("").locatedBy("");
		}
		//===============================
		public class Departamentos{
			public Target txt_buscar = Target.the("").locatedBy("");
			public Target btn_agregar = Target.the("").locatedBy("");
		}

	}

}
