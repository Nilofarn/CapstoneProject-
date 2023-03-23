package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;



public class RetailAccountPage extends BaseSetup{
public RetailAccountPage() {
	PageFactory.initElements(getDriver(), this);
}
@FindBy(xpath = "//img[@id='profileImage']")
public WebElement accountProfilePicture;

@FindBy(id = "accountLink")  //   //a[@id='accountLink']accountLink
public WebElement accountButton;

@FindBy(id = "nameInput")
public WebElement nameInputField;

@FindBy(css = "#personalPhoneInput")
public WebElement phoneNumberField;

@FindBy(css="#personalUpdateBtn")////button[@id='personalUpdateBtn']]
public WebElement updateButton;

@FindBy(xpath= "//div[text()='Personal Information Updated Successfully']")
public WebElement personalInfoUpdateMassege;
@FindBy(xpath="//p[text()='Add a payment method']")
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

//@FindBy(id="paymentSubmitBtn")
//public WebElement addYourCardField;

@FindBy(xpath="//div[text()='Payment Method added sucessfully']")
public WebElement successMessageForAddingCard;

@FindBy(xpath="//p[@class='account__payment-sub-title']")
public WebElement MasterCartIcon;
@FindBy(xpath="//button[text()='Edit']")
public WebElement editIcon;

@FindBy(xpath = "//div[@class='account__address-new']")
public WebElement AddAddressOption;

  

@FindBy(id = "countryDropdown")
public WebElement countryDropdown;

@FindBy(id ="fullNameInput")
public WebElement fullNameiPUT;

@FindBy(id="phoneNumberInput")
public WebElement phoneNumberInput;

@FindBy(id ="addressBtn")
public WebElement addressBtn;

@FindBy(id="streetInput")
public WebElement streetNumber;

@FindBy (id = "placeholder")
public WebElement ApartmentInput;

@FindBy (id = "cityInput")
public WebElement cityInputField;

@FindBy (xpath = " //select[@class='account__address-new-dropdown']")
public WebElement StateDropdownOption;

@FindBy (id = "zipCodeInput")
public WebElement zipCodeInput;
@FindBy(xpath = "//div[text()='Adress Added Successfully']")
public WebElement addAddressSuccessfullyMsg;		





}
