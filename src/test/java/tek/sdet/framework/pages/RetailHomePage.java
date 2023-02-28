package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup{
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}

@FindBy(xpath = "//a[contains(text(),'TEKSCHOOL')]")// THIS IS SAME AS driver.findElement
public WebElement tekschoolLogo;

 @FindBy(id = "searchInput")
 public WebElement searchBarInput;
 
 @FindBy(css = "#searchBtn")
 public WebElement searchButton;
 
 @FindBy(css="img.image")
 public WebElement pokemonImage;
 
 @FindBy(id = "signinLink")
 public WebElement signInOption;
 
 @FindBy(css = "#loginBtn")
 public WebElement accountOption;
 @FindBy(xpath = "//span[text()='All']")
 public WebElement allElements;

  @FindBy (xpath = "//div[@class='sidebar_content-item']//span")
  public List<WebElement> sideBar;
 
		
	}
	


