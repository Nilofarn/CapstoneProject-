package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{
	public RetailOrderPage() {
	PageFactory.initElements(getDriver(), this);
	}
@FindBy(id= "orderLink")
public WebElement OrdersSectionBtn;
@FindBy(xpath="//img[@class='order__item-img']")
public WebElement lightBulps;
@FindBy(xpath="//button[@id='cancelBtn']")
public WebElement cancelOrderButton;
@FindBy(id=" reasonInput")
public WebElement cancelationReasonInput;// to return an item i found the same id for Item damaged, can i use that
@FindBy(id ="orderSubmitBtn")
public WebElement CancelOrderbutton;
@FindBy(xpath="//p[contains(text(),'Your Order Has Been Cancelled')]")
public WebElement cancelationMessage;


@FindBy(id = "returnBtn")
public WebElement returnButton;

@FindBy (id = "dropOffInput")
public WebElement dropOffInput;

@FindBy(id = "reviewBtn")
public WebElement reviewText;

@FindBy(id = "headlineInput")
public WebElement headlineValue;

@FindBy(id = "descriptionInput")
public WebElement descriptionInput;

@FindBy(id = "reviewSubmitBtn")
public WebElement addYourReviewButton;

@FindBy(xpath="//div[@id='nmoznck']")
public WebElement YourReviewAddedSuccessfullyMessage;

}
