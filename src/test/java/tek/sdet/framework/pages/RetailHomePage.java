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
 public WebElement searchBarInput; // I am using it (add to Cart) next Scenario as well
 
 @FindBy(css = "#searchBtn")
 public WebElement searchButton; // I am using it (add to cart) next Scenario
 
 @FindBy(css="img.image")
 public WebElement pokemonImage;
 
 @FindBy(id = "signinLink")
 public WebElement signInOptionBtn;
 
 @FindBy(css = "#loginBtn")
 public WebElement accountOption;
 @FindBy(xpath = "//span[text()='All']")
 public WebElement allElements;

  @FindBy (xpath = "//div[@class='sidebar_content-item']//span")
  public List<WebElement> sideBar;
  
  // ....Verify User can add an item to cart...
 @FindBy(xpath="//Select[@id='search']")
 public WebElement AllDepartmentSection;
 
@FindBy(xpath= "//p[contains(text(),'Kasa Outdoor Smart Plug')]")
public WebElement kasaSmartplug;
 @FindBy(xpath="//select[@class='product__select']") 
 public WebElement QtyQuantitySection;
 @FindBy(xpath="//span[contains(text(),'Add to Cart')]")
 public WebElement addToCartBtn;
 @FindBy(id = "cartBtn")
 public WebElement CartButton;
		
	}
	


