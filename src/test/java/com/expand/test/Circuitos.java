package com.expand.test;

import static org.junit.Assert.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import org.junit.Before;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import net.serenitybdd.cucumber.CucumberWithSerenity;

//@ExtendWith(SerenityRunner.class) 
//@RunWith(CucumberWithSerenity.class)
class Circuitos {
	private WebDriver driver;
	private String URLBase = "http://canalesdigitales.expand/frontEnd/login";
    @SuppressWarnings("deprecation")
    @Before
    public void SetUp() {
    String navegador = "chrome";
        switch (navegador){
        case "firefox":
            System.setProperty("webdriver.chrome.driver", "C:\\automation\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
            break;
        case "chrome":
            //System.setProperty("webdriver.chrome.driver", "C:\\automation\\driver\\Chromedriver\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "C:\\automation\\driver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
            break;
        default:
            break;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URLBase);
        driver.manage().window().maximize();
    }
	

	@After
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	void test_Login() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement user_box = driver.findElement(By.id('login_loginForm_user');
		WebElement user_box = driver.findElement(By.id("login_loginForm_user"));
		user_box.sendKeys("fbarrionuevo");
		WebElement       pass_box = driver.findElement(By.id("login_loginForm_password"));
		pass_box.sendKeys("fbarrionuevo");

		WebElement login = driver.findElement(By.id("login_loginForm_enterButton_button"));
		login.click();
		
		WebElement Logo =  driver.findElement(By.id("main_moduleHeader_control"));
		wait.until(ExpectedConditions.elementToBeClickable(Logo) );
		System.out.print(driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "http://canalesdigitales.expand/frontEnd/panel");
	}
	
	@Test
	void test_EditCampañas() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement user_box = driver.findElement(By.id('login_loginForm_user');
		WebElement user_box = driver.findElement(By.id("login_loginForm_user"));
		user_box.sendKeys("fbarrionuevo");
		WebElement       pass_box = driver.findElement(By.id("login_loginForm_password"));
		pass_box.sendKeys("fbarrionuevo");

		WebElement login = driver.findElement(By.id("login_loginForm_enterButton_button"));
		login.click();
		
		WebElement Logo =  driver.findElement(By.id("main_moduleHeader_control"));
		wait.until(ExpectedConditions.elementToBeClickable(Logo) );
		//System.out.print(driver.getCurrentUrl());
		
		WebElement discador_botton = driver.findElement(By.id("Web3.LeftBar_categoryDialer_control"));
		discador_botton.click();
		
		Thread.sleep(5000);
		//Seleccionamos la 1ra campaña activa de la lista.
		int Nro= 2;
		String xpathCampaña = "/html/body/div[1]/div[3]/div[2]/div/div/div[5]/div[2]/div[1]/div[1]/div[2]/div/div[" + Nro + "]/div[2]/div/span";
		WebElement campaña = driver.findElement(By.xpath((xpathCampaña)));
		String nombreCampaña = campaña.getText();
		campaña.click();
		
		Thread.sleep(5000);
		WebElement tituSeccionCampaña= driver.findElement(By.xpath("//*[@id='main_moduleContent_current_view_active_module_name']"));
		assertEquals(tituSeccionCampaña.getText(), nombreCampaña);
	}

}
