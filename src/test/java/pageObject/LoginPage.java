package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rDriver) {

		ldriver = rDriver;

		PageFactory.initElements(rDriver, this);

	}

//---------------------WebElement locators-----------------	

	@FindBy(xpath = "//input[@id = 'Email']")
	WebElement email;

	@FindBy(xpath = "//input[@id = 'Password']")
	WebElement password;

	@FindBy(xpath = "//button[@type  = 'submit']")
	WebElement loginButton;
	

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutButton;

//---------User Actions Methods on WebElement----------------------

	public void enterEmail(String emailAddrs) {

		email.clear();
		email.sendKeys(emailAddrs);

	}

	public void enterPassword(String pwd) {

		password.clear();
		password.sendKeys(pwd);

	}

	public void clickOnLoginButton() {

		loginButton.click();

	}
	
	public void clickOnLogoutButton() {

		logoutButton.click();

	}
	

}
