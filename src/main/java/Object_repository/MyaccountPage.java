package Object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyaccountPage {
	
	public String m;
	WebDriver driver;
	By welcomeContent = By.id("WelcomeContent");
	public MyaccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public String myAccount() {
		
		return m=driver.findElement(welcomeContent).getText();
		
	}
}
