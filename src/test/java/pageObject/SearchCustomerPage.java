package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	WebDriver ldriver;

	public SearchCustomerPage(WebDriver rDriver) {

		ldriver = rDriver;

		PageFactory.initElements(rDriver, this);

	}
	
	//===============WebElements Locators=====================================
	
	@FindBy(xpath = "//input[@id = 'SearchEmail']")
	WebElement emailAdd;
	
	@FindBy(xpath = "//button[@id = 'search-customers1']")
	WebElement searchButtn;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
	WebElement searchResult;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr")
	List<WebElement> tableRows;
	
/*	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr[1]//td")
	List<WebElement> tableColumns;  */
	
	@FindBy(xpath = "//input[@id = 'SearchFirstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id = 'SearchLastName']")
	WebElement lastName;
	
	
	
	//============User Actions Methods=========================================
	
	
	//action method to enter email address:-
	public void enterEmailAddress(String email)
	{
		
		emailAdd.sendKeys(email);
		
	}
	
	//action method to perform click on search button:-
	public void clickOnSearchButton()
	{
		
		searchButtn.click();
		
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		
		boolean found = false;
		
		//total no. of rows in a grid:-
		int totalRows = tableRows.size();
		
		//total no. of columns = 
//		int totalColumns = tableColumns.size();
		
		for(int i=1;i<=totalRows;i++)  //to iterate all the rows of the grid
		{
			
			WebElement webElementEmail = ldriver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr["+i+ "]//td[2]"));
			
			String actualEmailAddrs = webElementEmail.getText();
			
			if(actualEmailAddrs.equals(email))
			{
				
				found = true;
				
			}
			
			
			
		}
		
		return found;
			
	}
//===========///////search customer by Name methods///////////=================================================
	
	//action method to enter FirstName :-
	public void enterFirstName(String firstNameText)
	{
		
		firstName.sendKeys(firstNameText);
		
	}
	
	//action method to enter LastName :-
	public void enterLastName(String lastNameText)
	{
		
		lastName.sendKeys(lastNameText);
		
	}
	
	public boolean searchCustomerByName(String name)
	{
		
		boolean found = false;
		
		//total no. of rows in a grid:-
		int totalRows = tableRows.size();
		
		for(int i=1;i<=totalRows;i++)  //to iterate all the rows of the grid
		{
			
			WebElement webElementName = ldriver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr["+i+ "]//td[3]"));
			
			String actualName = webElementName.getText();
			
			if(actualName.equals(name))
			{
				
				found = true;
				break;
				
			}
			
			
		}
		
		return found;
			
	}
	
	

}
