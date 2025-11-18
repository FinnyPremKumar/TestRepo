package PageObjects;


import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CaptureScreenshot;

public class SearchFuncObj {
	public WebDriver driver;
	CaptureScreenshot ss;
	
	//Search an item from home page
	@FindBy(name = "q")
	WebElement	searchid;
	public void EnterAnItemAndSearch() throws IOException {
		inputAndScreenshot(searchid, "Iphont 16 pro max");
		inputAndScreenshot(searchid, Keys.ENTER);
		//searchid.sendKeys("Iphont 16 pro max"+ Keys.ENTER);
	}
	
	@FindBy(xpath = "//img[@title=\"Flipkart\"]")
	WebElement flipkartIcon;
	public void VerifyFlipkartIcon() {
		Boolean status= flipkartIcon.isDisplayed();
		Assert.assertTrue(status);
	}
	
	public void inputAndScreenshot(WebElement we, String s) throws IOException {
		ss.Ss();
		we.clear();
		we.sendKeys("Iphont 16 pro max");
		ss.Ss();
	}
	public void inputAndScreenshot(WebElement we,Keys k) throws IOException {
		ss.Ss();
		we.sendKeys(k);
		ss.Ss();
	}
	
	//Constructor, PageFactory
	public SearchFuncObj(WebDriver driver) {
		this.driver=driver;
		ss=new CaptureScreenshot(driver);
		PageFactory.initElements(driver, this);
	}
}