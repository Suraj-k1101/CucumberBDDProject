package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObject.AddNewCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;
import utilities.ReadConfig;

import org.apache.logging.log4j.*;

public class BaseClass { //here we writes all the common methods and common variables which is requires for stepDefiniton file
	//and all step definition files will extends(inherits) this BaseClass 
	//BaseClass will be our Parent class and all our step definition files class will be child class
	

	public static WebDriver driver;
	public LoginPage lp; // loginPage class object
	public AddNewCustomerPage addNewCust;  //object of AddNewCustomerPage class
	public SearchCustomerPage searchCustPg; // object of SearchCustomerPage class 
	public static Logger log;
	public ReadConfig readconfig; //object of Properties class for reading config.Properties file
	//this method will generate random email id
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
		
		
	}
	
	

	
	
	
	

}
