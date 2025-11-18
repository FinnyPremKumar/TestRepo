package Utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class CaptureScreenshot {
	WebDriver	driver;
	public void Ss() throws IOException {
		LocalDateTime time=LocalDateTime.now();
		String currentTime=time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("screenshots/"+currentTime+"TC_.png"));
	}
	public String getScenarioName(Scenario scenario) {
		return scenario.getName();
	}
	@AfterStep
	public String afterStep(Scenario scenario) throws IOException {
	    String scenarioName = scenario.getName(); // Get scenario name from feature file
	    // OR, if you want to sanitize it for file/folder usage:
	    String safeScenarioName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_");
	    System.out.println(safeScenarioName);
	    String folderPath = "screenshots/" + scenarioName;
	    File folder = new File(folderPath);
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }
	    return folderPath;
	}
	public CaptureScreenshot(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}