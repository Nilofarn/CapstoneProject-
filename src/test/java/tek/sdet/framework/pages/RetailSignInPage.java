package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailSignInPage extends BaseSetup{
public RetailSignInPage() {
	PageFactory.initElements(getDriver(), this);
	//h1[contains(text(),'Sign in')]
}
@FindBy(css = "#email")
public WebElement emailField;

@FindBy(id = "password")
public WebElement passwordField;

@FindBy(xpath="//button[@id='loginBtn']")
public WebElement loginButton;

@FindBy(id = "newAccountBtn")
public WebElement createNewAccountButton;

@FindBy(css = "#nameInput")
public WebElement newAccountNameField;

@FindBy(id= "emailInput")
public WebElement createNewAccoutEmailField;

@FindBy(id = "passwordInput")
public WebElement createNewAccoutPasswordfield;

@FindBy(xpath="//input[@id='confirmPasswordInput']")
public WebElement createNewAccoutConfirmPassField;

@FindBy(xpath="//button[@id='signupBtn']") //    //button[text()='Sign Up']
public WebElement createNewAccoutSignupOption;

}
