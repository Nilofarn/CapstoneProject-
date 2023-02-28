package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup{
public RetailAccountPage() {
	PageFactory.initElements(getDriver(), this);
}
@FindBy(xpath = "//img[@alt='profile pic']")
public WebElement accountProfilePicture;

@FindBy(id = "accountLink")  //   //a[@id='accountLink']
public WebElement accountButton;

@FindBy(id = "nameInput")
public WebElement nameInputField;

@FindBy(css = "#personalPhoneInput")
public WebElement phoneNumberField;

@FindBy(xpath= "//button[@id='personalUpdateBtn']")
public WebElement updateButton;

@FindBy(xpath= "//p[contains(text(),'Add a payment method')]")// Next test case
public WebElement addPaymentMethod;

@FindBy(id = "cardNumberInput")  //  //input[@name='cardNumber']
public WebElement cartNumberfield;

@FindBy(xpath="//input[@id='nameOnCardInput']")
public WebElement nameOnCartField;

@FindBy(id="expirationMonthInput")
public WebElement expirationMonthField;

@FindBy(css= "#expirationYearInput")
public WebElement expirationYearField;

@FindBy(xpath="//input[@name='securityCode']")
public WebElement securtiyCodeField;

@FindBy(id="paymentSubmitBtn")
public WebElement addYourCardField;

@FindBy(xpath="//div[text()='Payment Method added sucessfully']")
public WebElement successMessageForAddingCard;
}
