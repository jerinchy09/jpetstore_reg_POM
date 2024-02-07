package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class screenshot {
	public void take_screenshot(WebDriver driver, String testmethodname) throws IOException {
		//	Screenshot
		TakesScreenshot shot = (TakesScreenshot) driver;
		File src =shot.getScreenshotAs(OutputType.FILE);	
		
		//browsername
		 // Get the capabilities of the WebDriver
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();

        // Get the browser name from the capabilities
        String browserName = caps.getBrowserName();
		
		
		File dest = new File("E:\\Nexvalli\\Eclipse Wrokspace\\jpetstore_reg_POM\\target\\shot_jpetstore_POM_"+browserName+"_"+testmethodname+".jpg");
		// get Apache commons.io from maven repository to pom.xml 
		FileUtils.copyFile(src,dest);
	}

}
