package starter.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.thucydides.core.annotations.Step;
/*import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;*/


public class login extends PaginaBase{
	//WebDriver driver =null;
	WebDriverWait wait;	
	private String URLBase = "http://canalesdigitales.expand/frontEnd/login";
	
	
	public login(WebDriver pdriver) {
		super(pdriver);
		//driver = pdriver;
		
		System.out.println("Inicializando elementos...");
		PageFactory.initElements(driver, this);
		inicio();
	}
	
	@FindBy(id="login_loginForm_user")
	protected WebElement TXT_user;
	
	@FindBy(id="login_loginForm_password")
	protected WebElement TXT_pass;
	
	@FindBy(id="main_moduleHeader_control")
	protected WebElement Logo;
	
	@FindBy(id="login_loginForm_enterButton_button")
	protected WebElement BTN_login;
	
	@Step("Como usuario frecuente, ingreso al sitio desde la página de login.")  
	private void inicio() {
		driver.get(URLBase);
	}
	
	@Step("Cuando ingreso con el usuario {0} y la contraseña {1} de manera correcta.")
	public void loguearse(String Usuario, String Contraseña) throws InterruptedException {
		TXT_user.sendKeys(Usuario);
		TXT_pass.sendKeys(Contraseña);

		BTN_login.click();
		Thread.sleep(2000);
	}
	
	@Step("Cuando ingreso con el usuario {0} erroneamente.")
	public void loguearse_error(String Usuario) throws InterruptedException {
		TXT_user.sendKeys(Usuario);
		TXT_pass.sendKeys("Contraseña");

		BTN_login.click();
		Thread.sleep(2000);
	}

	@Step("Si las credenciales son correctas, debería encontrarme en el sitio principal luego del login.")
	public boolean chequearrUrlDeIngreso() {
		return login.getCurrentUrl()=="http://canalesdigitales.expand/frontEnd/panel";
	}
	
	public static String getCurrentUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}
	
	
	
}
