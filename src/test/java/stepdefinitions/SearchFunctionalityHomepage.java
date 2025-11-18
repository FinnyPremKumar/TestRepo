package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import PageObjects.SearchFuncObj;
import Utils.CaptureScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFunctionalityHomepage {
	WebDriver driver;
	SearchFuncObj	searchAnItemInHomepage;
	CaptureScreenshot	screenshot;
	public SearchFunctionalityHomepage() throws IOException{
		driver = new ChromeDriver();
		searchAnItemInHomepage=new SearchFuncObj(driver);
		screenshot=new CaptureScreenshot(driver);
	}

	@Before
	public void clearOutputFolder() {
		String folderPath = "screenshots/";
		System.out.println("Before Class2");
	    File folder = new File(folderPath);
	    File[] files = folder.listFiles();
	    if (files != null) { // Some JVMs return null for empty directories
	        for (File file : files) {
	            if (file.isFile()) { // Only delete files, not subfolders
	                file.delete();
	            }
	        }
	    }
	}

	
	@Given("User can login into Amazon Application")
	public void user_can_login_into_amazon_application() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("1");
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		searchAnItemInHomepage.VerifyFlipkartIcon();
		System.out.println("1 Class");
	}

	@And("user should search an item successfully")
	public void user_should_search_an_item_successfully() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("2");
		searchAnItemInHomepage.EnterAnItemAndSearch();
		System.out.println("2 Class");
		}

	@Then("user should land on Search products page")
	public void user_should_land_on_search_products_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("3");
		
		}

	@When("user clicks on any product")
	public void user_clicks_on_any_product() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("4");
		}

	@Then("user should land on Product landing page")
	public void user_should_land_on_product_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("5");
		}
	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
