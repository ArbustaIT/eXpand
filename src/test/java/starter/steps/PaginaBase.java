package starter.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaBase {
	
	private String urlBase = ""; 
	
	protected static final int TIMEOUT = 10;
    private static final int POLLING = 100;
    
    protected static WebDriver driver=null;
    private static WebDriverWait wait;
    
	PaginaBase(WebDriver pdriver){
		this.driver= pdriver;
        
		if (this.driver == null) {
	    	
	    	wait = new WebDriverWait(this.driver, TIMEOUT, POLLING);
	        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, TIMEOUT), this);
	    	//driver.get(urlBase);
	    	}
	}
	
	public String obtenerTituloPagina() {

    	return this.driver.getTitle();
    }
    
    public String urlActual(){
    return this.driver.getCurrentUrl();
    }
    
    public void Salir() {
    	Terminar();
    }
    
    public void Terminar() {
    	if (this.driver !=null) {
    		this.driver.quit();
    	}
    }
    
    protected WebDriver getDriver() {
		return this.driver;
	}
	
}
