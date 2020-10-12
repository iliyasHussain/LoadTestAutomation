package loadAutomation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WikiPage extends DriverSetup {

	public static WebDriver driver;
	static String strA, strB;
	static WebElement searchSkillA, searchSkillB;

	public WikiPage(WebDriver driver) {
		WikiPage.driver = driver;
	}

	// public void FindSkill(String skill) throws IOException {
	public static void main(String[] args) throws IOException {
		driver = Setup();
		driver.get("https://w.amazon.com/bin/view/Alexa_Dev_Marketing_Load_Test_Results");
		WebElement body = driver.findElement(By.tagName("body"));
		String text = body.getText();

		int n = driver.findElements(By.tagName("table")).size();
		int tableNum = 0;
		System.out.println("Number of tables = " + n);

		String[] ID = { "amzn1.ask.skill.460c7ead-9f94-41e7-b574-61de5d837927" };
		if (text.contains(ID[0])) {
			System.out.println("Already Tested -- Checking for Load results!!");
			
			first: for (int i = 1; i <= n; i++) {
				
				for (int j = 2; j <= 11; j++) {
						if (i >= 25) {
							try{
							searchSkillB = driver.findElement(By
									.xpath("//*[@id='xwikicontent']/table[" + i + "]/tbody/tr[" + j + "]/td[2]/span"));
							strB = searchSkillB.getText();
							if (strB.equalsIgnoreCase(ID[0])) {
								tableNum = i;
								System.out.println("Already Tested -- Skill is in table: " + tableNum);
								
								String loadRes = driver.findElement(By.xpath("//*[@id='xwikicontent']/table[" + tableNum
										+ "]/tbody/tr[" + j + "]/td[8]/span")).getText();
								System.out.println("Load Test was: " + loadRes);
								if(loadRes.equalsIgnoreCase("fail")){
									System.out.println("I am in B block");
									WriteData.WriteToFile(strB);
								}
								break;
							}
							} catch(Exception e){
								System.out.println("Skill not found");
							}
						}
						searchSkillA = driver.findElement(
								By.xpath("//*[@id='xwikicontent']/table[" + i + "]/tbody/tr[" + j + "]/td[2]"));
						strA = searchSkillA.getText();

						if (strA.equalsIgnoreCase(ID[0])) {
							tableNum = i;
							System.out.println("Already Tested -- Skill is in table: " + tableNum);

							String loadRes = driver.findElement(By
									.xpath("//*[@id='xwikicontent']/table[" + tableNum + "]/tbody/tr[" + j + "]/td[8]"))
									.getText();
							System.out.println("Load Test was: " + loadRes);
							if(loadRes.equalsIgnoreCase("fail")){
								System.out.println("I'm in A block");
								WriteData.WriteToFile(strA);
							}
							break;
						}
				
					}
				
					if (strA.equalsIgnoreCase(ID[0])) {
						System.out.println(strA);
						break first;
					}
				}
			
			driver.close();
			}
	}
}


