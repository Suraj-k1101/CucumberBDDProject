package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	
	public WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this );
		
	}
	
	//=========WebElement Locators============================================
	
	//Find Web elements on web page:-
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement linkCustomers_menu;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement linkCustomers_menuItem;
	
	@FindBy(xpath = "//a[@class = 'btn btn-primary']" )
	WebElement butnAddnew ;
	
	@FindBy(xpath = "//input[@id='Email']" )
	WebElement txtEmail ;
	
	@FindBy(xpath = "//input[@id='Password']" )
	WebElement txtPasword ;
	
	@FindBy(xpath = "//input[@id='FirstName']" )
	WebElement txtFirstName ;
	
	@FindBy(xpath = "//input[@id='LastName']" )
	WebElement txtLastName ;
	
	@FindBy(xpath = "//input[@id='Gender_Male']" )
	WebElement MaleGender ;
	
	@FindBy(xpath = "//input[@id='Gender_Female']" )
	WebElement FeMaleGender ;
	
	@FindBy(xpath = "//input[@id='DateOfBirth']" )
	WebElement txtDob ;
	
	@FindBy(xpath = "//input[@id='Company']" )
	WebElement txtCompanyName ;
	
	@FindBy(xpath = "//input[@id='IsTaxExempt']" )
	WebElement checkboxIs_tax_exempt  ;
	
	@FindBy(xpath = "//div[@class='input-group-append']//div[@role='listbox']" )
	WebElement txtNewsletter  ;
	
	@FindBy(xpath = "//div[@class='input-group-append input-group-required']//div[@role='listbox']" )
	WebElement txtCustomerRoles  ;
	
	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement dropdownVendorMgr ;
	
	@FindBy(xpath = "//input[@id='Active']" )
	WebElement checkbox_Active  ;
	
	@FindBy(xpath = "//textarea[@id='AdminComment']" )
	WebElement txtAdminComment  ;
	
	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	WebElement listItemAdministrators;


	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	WebElement listItemRegistered;

	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement listItemGuests;


	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement listItemVendors;
	
	
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement btnSave;
	
	
	
	//Actions Methods for web elements

		public String getPageTitle()
		{
			return ldriver.getTitle();
		}

		public void clickOnCustomersMenu() {
			linkCustomers_menu.click();
		}

		public void clickOnCustomersMenuItem() {
			linkCustomers_menuItem.click();
		}

		public void clickOnAddnew() {
			butnAddnew.click();
		}

		public void enterEmail(String email)
		{
			txtEmail.sendKeys(email);
		}

		public void enterPassword(String password)
		{
			txtPasword.sendKeys(password);
		}
		public void enterFirstName(String firstName)
		{
			txtFirstName.sendKeys(firstName);
		}

		public void enterLastName(String lastName)
		{
			txtLastName.sendKeys(lastName);
		}

		public void enterDob(String dob)
		{
			txtDob.sendKeys(dob);
		}

		public void enterCompanyName(String coName)
		{
			txtCompanyName.sendKeys(coName);
		}

		public void enterAdminComment(String comment)
		{
			txtAdminComment.sendKeys(comment);
		}

		/*public void enterCustomerRoles(String role)  
		{

		}*/

		public void enterManagerOfVendor(String value)
		{
			Select drp=new Select(dropdownVendorMgr);
			drp.selectByVisibleText(value);
		}

		public void enterGender(String gender)
		{
			if(gender.equals("Male"))
			{
				MaleGender.click();
			}
			else if(gender.equals("Female"))
			{
				FeMaleGender.click();
			}
			else//default set Male gender
			{
				MaleGender.click();
			}

		}
		
		public void clickIstaxexempt_checkkbox()
		{
			
			checkboxIs_tax_exempt.click();
	
		}

		

		public void clickOnSave()
		{
			btnSave.click();
		}

	




	
	
	
	
	
	
	
	

}
