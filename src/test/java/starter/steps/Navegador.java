package starter.steps;
 
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navegador {

	protected WebDriver driver;
	protected FluentWait wait = null;
	
	//private String URLBase = "http://canalesdigitales.expand/frontEnd/login";
	private String URLBase = "https://phptravels.org/clientarea.php";
	private String navegador = "chrome";

	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public  Navegador() {
		
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
        //wait = new WebDriverWait(driver, 20);
        //driver.get(URLBase);
        driver.manage().window().maximize();
        
        wait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS) 			
        		.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
        
        
        //this.driver= driver;
        
    }

    public String getCurrentUrl() {
    	return driver.getCurrentUrl();
    }
    
    public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return this.driver;
	}
	
   
    
}
