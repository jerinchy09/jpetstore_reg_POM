package Object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	WebDriver driver;
	
	By sign_in = By.xpath("//*[@id=\"MenuContent\"]/a[2]");
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public void sign_in() {
		driver.findElement(sign_in).click();
	}
	
	
}
