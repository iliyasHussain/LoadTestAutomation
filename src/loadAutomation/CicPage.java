package loadAutomation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CicPage extends DriverSetup {
	
	public WebDriver driver;
	
	public CicPage(WebDriver driver){
		this.driver = driver;
	}

	public void CheckSkill(String skill) throws IOException{
		driver = Setup();
		driver.get("https://skillcert.aka.amazon.com/itemgroup/application/search.html");
		driver.findElement(By.xpath("//input[@name='searchString']")).sendKeys(skill);
		driver.findElement(By.xpath("//a[@id='basicSearchButton']")).click();
		driver.findElement(By.xpath("//*[@id='title']/tbody/tr/td[1]/a")).click(); 
		String appName = driver.findElement(By.xpath("//h1[@id='appTitle']")).getText();
		try{
		Select dropdown = new Select(driver.findElement(By.id("versionSelectList")));
		dropdown.selectByVisibleText("N/A-LIVE");
		driver.findElement(By.xpath("//*[@id='badgingTab']")).click();
		WebElement badge = driver.findElement(By.xpath("//td[contains(text(),'Packaging Skill')]"));
		String badgeValue = badge.findElement(By.xpath("//tbody//tr[19]//td[2]//div[1]")).getText();
		if(badgeValue.equalsIgnoreCase("yes")){
		System.out.println("already badged");
		}else{
			//add packaging badge
			badge.click();
			System.out.println(driver.findElement(By.xpath("//a[@class='button large']")).getText());
			//pull skill to review, add badge and push back to live
			//yet to code!!!
		}
		}catch (Exception e){
			System.out.println("No live version available for: "+appName+" - "+skill);
		}
		driver.close();
	}
}
