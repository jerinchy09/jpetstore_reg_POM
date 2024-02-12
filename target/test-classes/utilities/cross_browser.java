package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cross_browser {
	WebDriver driver;
	String filepath = "E:\\Nexvalli\\Eclipse Wrokspace\\jpetstore_reg_POM\\config.properties";

	// public WebDriver browser_inititate(String browser) throws IOException {
	public WebDriver browser_inititate(String b) throws IOException {

		FileInputStream fis = new FileInputStream(filepath);
		Properties p = new Properties();
		p.load(fis);

		// System.out.println(browser);
		// String browsername = p.getProperty("browser");
		String url = p.getProperty("url");
		switch (b) {
			case "Chrome": {
				driver = new ChromeDriver();
				driver.get(url);
				break;
			}
	
			case "Firefox": {
				driver = new FirefoxDriver();
				driver.get(url);
				break;
	
			}
			case "Edge": {
				driver = new EdgeDriver();
				driver.get(url);
				break;
			}
		}
		return driver;
	}
}
