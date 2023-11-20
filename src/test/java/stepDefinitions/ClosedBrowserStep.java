package stepDefinitions;

import io.cucumber.java.en.Then;

public class ClosedBrowserStep extends BaseClass{

	@Then("Close Browser")
	public void close_browser() {

		driver.close();
//		driver.quit();
		
		log.info("Browser closed");

	}
	
}
