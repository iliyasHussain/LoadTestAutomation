package loadAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverSetup {
	public static WebDriver driver;
	public static Properties prop= new Properties();;
	
	public static WebDriver Setup() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\iliyash\\OfficeTools\\LoadTestFramework\\src\\resources\\framework.properties");
    	prop.load(fis);
    	String browser= prop.getProperty("Browser");
    	if(browser.equalsIgnoreCase("chrome")){
    		System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
    		driver = new ChromeDriver();
    		driver.manage().window().maximize();
    		
    	}
    	driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    	return driver;
	}
}
