package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshot {
	public void take_screenshot(WebDriver driver, String testmethodname) throws IOException {
		//	Screenshot
		TakesScreenshot shot = (TakesScreenshot) driver;
		File src =shot.getScreenshotAs(OutputType.FILE);		
		File dest = new File("E:\\Nexvalli\\Eclipse Wrokspace\\jpetstore_reg_POM\\target\\shot_jpetstore_POM_"+testmethodname+".jpg");
		// get Apache commons.io from maven repository to pom.xml 
		FileUtils.copyFile(src,dest);
	}

}
