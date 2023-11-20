package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AddNewCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;
import utilities.ReadConfig;
//child of BaseClass
public class LoginFeatureStepDef extends BaseClass { // FOR EVERY STEP IN FEATURE FILE WE ARE CREATING METHOD HERE IN STEP DEFINITION
									// FILE
	@Before("@Sanity")
	public void setup1()
	{   //we can use multiple @Before annotations 
		//we have to use or execute this code before each and every test scenarios:-
		
	
		
		//initialize logger:-
		log = LogManager.getLogger("LoginFeatureStepDef");
		
		System.out.println("Setup1- Sanity method is executed..");
		
/*		String browser = readconfig.getBrowser();
		
		//launch browser
		if(browser.equalsIgnoreCase("Chrome"))           //BY USING equalsIgnoreCase METHOS WE CAN IGNORE CASE SENSITIVTY HERE
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}

		log.fatal("Setup1 executed...");
		
		} */
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//@Before:- whenever any test scenario will executed this block of code under @Before will execute first before each test scenario
		//@Before(order = higher number) will executes secondly and @After(order = lower number) executes first -opposite of @After
		//@Before("@Sanity") this is conditional hook
		
		log.info("Setup1 executed....");
		
	}
	
	@Before("@regression")
	public void setup2()
	{
		//we have to use or execute this code before each and every test scenarios:-
		
		//initialize logger:-
		log = LogManager.getLogger("LoginFeatureStepDef");
		
		System.out.println("Setup2- Regression method is executed..");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//@Before:- whenever any test scenario will executed this block of code under @Before will execute first before each test scenario
		//@Before("@regression") this is conditional hook
		//this hooks play same roles like testNg 
		
		log.info("Setup2 executed....");
		
	}

	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		
		lp = new LoginPage(driver);
		addNewCust = new AddNewCustomerPage(driver);
		searchCustPg = new SearchCustomerPage(driver);
		
		log.info("Chrome Browser Launched");

	}

	@When("User Opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
		
		log.info("url opened");

	}

	@When("User Enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {

		lp.enterEmail(emailadd);
		lp.enterPassword(password);
		
		log.info("email address and password entered");
		
	}

	@When("click on Login")
	public void click_on_login() {

		lp.clickOnLoginButton();

		log.info("Clicked on login button");
		
	}

	// ===========//////////Login
	// feature///////////=============================================================

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {

			log.warn("Test passed: Login feature - page title matched.");
			
			Assert.assertTrue(true); // pass

		} else {

			Assert.assertTrue(false); // fail
			
			log.warn("Test failed: Login feature - page title not matched.");

		}

	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {

//		driver.switchTo().alert().accept();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lp.clickOnLogoutButton();
		
		log.info("User click on Log out link");

	}

/*	@Then("Close Browser")
	public void close_browser() {

		driver.close();
//		driver.quit();
		
		log.info("Browser closed");

	}  */

	// ===========//////////Add new
	// customer/////////////=============================================

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		
		String actualTitle = addNewCust.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		
		if(actualTitle.equals(expectedTitle))
		{
			log.info("User can view Dashboard - test passed");
			
			Assert.assertTrue(true);
			
		}
		else
		{
			
			Assert.assertTrue(false);
			
			log.warn("User cant view Dashboard- test failed");
	
		}

	}

	@When("User click on Customers Menu")
	public void user_click_on_customers_menu() {
		
		addNewCust.clickOnCustomersMenu();
		
		log.info("Customer menu clicked..");

	}

	@When("click on Customers Menu Item")
	public void click_on_customers_menu_item() {

		addNewCust.clickOnCustomersMenuItem();
		
		log.info("Customer menu item clicked");
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		
		addNewCust.clickOnAddnew();
		
		log.info("clicked on Add new button..");

	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {

		String actualTitle = addNewCust.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		
		if(actualTitle.equals(expectedTitle))
		{
			log.info("User can view Add new customer page - passed");
			
			Assert.assertTrue(true); //pass
			
		}
		else
		{
			
			log.info("User cant view Add new customer page -failed");
			
			Assert.assertTrue(false); //fail
			
		}
		
		
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		
	//	addNewCust.enterEmail("noahmills@gmail.com");
		addNewCust.enterEmail(generateEmailId() +"@gmail.com");
		addNewCust.enterPassword("noah1234");
		addNewCust.enterFirstName("Noah");
		addNewCust.enterLastName("Mills");
		addNewCust.enterGender("Male");
		addNewCust.enterDob("2/11/1990");
		addNewCust.enterCompanyName("Dolce & Gabana");
		addNewCust.clickIstaxexempt_checkkbox();
		addNewCust.enterAdminComment("Admin content");
		addNewCust.enterManagerOfVendor("Vendor 2");
		
		log.info("customer information entered");
		

	}

	@When("click on Save button")
	public void click_on_save_button() {

		addNewCust.clickOnSave();
		
		log.info("click on Save button");
		
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMessage) {

		String bodyTagText = driver.findElement(By.tagName("body")).getText();
		
		if(bodyTagText.contains(expectedConfirmationMessage))
		{
			
			log.info("User can view confirmation message - passed");
			
			Assert.assertTrue(true); //for pass
			
		}
		else
		{
		
			log.warn("User cant view confirmation message - failed");
			
			Assert.assertTrue(false); //for fail
			
		}
		
	}
	
	@Then("close browser")
	public void closeBrowser() {

       driver.close();
//       driver.quit();
		
	}
	
//=========//////////search customer/////////////===============================
	
@When("click on customer Email")
public void click_on_customer_email() {
  
	searchCustPg.enterEmailAddress("victoria_victoria@nopCommerce.com");
	
	log.info("email address entered");
	
}

@When("click on Search button")
public void click_on_search_button() {
 
	searchCustPg.clickOnSearchButton();
	
	log.info("clicked on Search button");
	
}

@Then("User should found Email in the Search table")
public void user_should_found_email_in_the_search_table() {
   
	String expectedEmail = "victoria_victoria@nopCommerce.com";
	
//	Assert.assertTrue(searchCustPg.searchCustomerByEmail(expectedEmail));
	
	//OR we can write our assertion this way too
	if(searchCustPg.searchCustomerByEmail(expectedEmail)==true)
	{
		
		Assert.assertTrue(true);
		
		log.info("User should found Email in the Search table - passed");
		
	}
	else
	{
		
		Assert.assertTrue(false);
		
		log.info("User should found Email in the Search table - failed");
		
	}  
		
}

//====//////serach customer by Name//////////==================================================


@When("Enter customer FisrtName")
public void enter_customer_fisrt_name() {
  
	searchCustPg.enterFirstName("Steve");
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

@When("Enter customer LastName")
public void enter_customer_last_name() {
  
	searchCustPg.enterLastName("Gates");
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

@Then("user should found Name in the Search table")
public void user_should_found_name_in_the_search_table() {
 

	String expectedName = "Steve Gates";
	
//	Assert.assertTrue(searchCustPg.searchCustomerByName(expectedName));
	
	//OR we can write our assertion this way too
	if(searchCustPg.searchCustomerByName(expectedName)==true)
	{
		
		Assert.assertTrue(true);
		
	}
	else
	{
		
		Assert.assertTrue(false);
		
	}  
	

}

//@After
public void teardown(Scenario sc)  //we have created (Scenario sc) here object of Scenario class (sc) as for parameterization
{
	//this block of code under the @After annotation will get executed after every test scenario execution
	
	System.out.println("TearDown1 method executed..");
	if(sc.isFailed()==true)   //this block will get executed when any scenario get failed because we use - if(sc.isFailed()==true)
	{
		//Screenshot code//:-
		//Convert web driver object to TakesScreenshot
		
		String filePath = "C:\\Users\\ks\\eclipse-workspace\\CucumberDemo\\Screenshot\\failedScreenshot.png";
		TakesScreenshot srcshot = ((TakesScreenshot)driver);
		
		//Call getScreenshotAs method to create image file:
		File SourceFile = srcshot.getScreenshotAs(OutputType.FILE);
		
		//Move image file to new destination :-
		File destFile = new File(filePath);
		
		//Copy file at destination:-
		try {
			FileUtils.copyFile(SourceFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	driver.quit();
	
}

@AfterStep
 public void addScreenshot(Scenario scenario)
 {  //this method basically we are using for extent report for capturing screenshot:-
	 
	 if(scenario.isFailed())
	 {
		 final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 
		 //attach image file report(data, media type, name of the attachment)
		 scenario.attach(screenshot, "image/png", scenario.getName());
		 
		 
	 }
	 
	 
 }

  
/*@After(order = 2)
public void teardown2()
{
	//this block of code under the @After annotation will get executed after each and every test scenario execution
	
	System.out.println("TearDown2 method executed..");
	driver.quit();
	//@After annotation also can use multiple times
	//@After(order = higher number) will executes first an then @After(order = lower number) executes -opposite of @Before
	
}  */


@BeforeStep
public void beforeStepMethodDemo()
{
	
	System.out.println("This is Before Step..");
	
}


@AfterStep
public void afterStepMethodDemo()
{
	
	System.out.println("This is After Step..");
	
}
          


}
