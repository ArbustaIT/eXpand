package com.expand.pageObjects;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.pages.PageObject;

public class PaginaBase extends PageObject {
	public PaginaBase(WebDriver driver) {
		super(driver);
	}

	//Clase con funcionalidades que van a tener todas las páginas que vamos usar dentro del Page Object.
	 public void compararTituloDePaginaEsperado(String tituloEsperado) {
		 assertThat(getTitle().contains(tituloEsperado));
	 }
	 
	 public String chequearTituloDePagina() {
		 return getTitle();
	 }
}