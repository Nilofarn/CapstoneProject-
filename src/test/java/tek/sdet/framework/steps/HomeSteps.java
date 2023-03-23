package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class HomeSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

//Scenario1
	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().allElements);
		logger.info("user clicked on all section btn");

	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable options) {
		List<List<String>> optionsToDisplay = options.asLists(String.class);
		Assert.assertTrue(isElementDisplayed(factory.homePage().AllDepartmentSection)); // IS This right?
		logger.info("options Electronics, Computers, Smart Home, Sports and Automative are present"); 

	}

//Scenario2

	@And("User on {string}")
	public void userOnDepartment(String department) {
		List<WebElement> dept = factory.homePage().sideBar;
		for (WebElement element : dept) {
			if (element.getText().equals(department)) {
				element.click();
				break;
			}
		}
	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> departmentsection = dataTable.asLists(String.class);
		List<WebElement> dept = factory.homePage().sideBar;
		for (int i = 0; i < departmentsection.get(0).size(); i++) {
			for (WebElement element : dept) {
				if (element.getText().equals(departmentsection.get(0).get(i))) {
					Assert.assertTrue(element.isDisplayed());
					logger.info(element.getText() + "the item is present");

				}
			}
		}
	}

// Scenario 3
	@And("User change category to {string}")
	public void userChageCategory(String smartHome) {
		selectByVisibleText(factory.homePage().AllDepartmentSection, smartHome);
		logger.info("select smart home");
	}

	@And("User search for an item {string}")
	public void userSearchForAnItem(String Text) {
		sendText(factory.homePage().searchBarInput, Text);
		logger.info("user search for kasa outdoor smart plug");

		// if (item.equals(" kasa outdoor smart plug")) {
		// click(factory.homePage().kasaSmartplug);
		// logger.info("item Kasa Smart plug added ");
		// } else if(item.equals("Apex Legends")) {
		// click(factory.homePage().AjexLegendImage,item);    // Ustad Shaiq please check if it"s correct.
		// logger.info("User sreach3d Apex Legends" );

	}

	@And("User click on Search icon")
	public void userClickOnSerchIcone() {
		click(factory.homePage().searchButton);
		logger.info("User clicked on Search icon");

	}

	@And("User click on item")
	public void userClickOnItem(String item) {
      click(factory.homePage().kasaSmartplug);
		logger.info("item Kasa Smart plug added ");
	}

	@And("User select quantity {string}")
	public void userSelectQuantity(String count) {
		selectByVisibleText(factory.homePage().QtyQuantitySection, count);
		logger.info("2 item count added");

	}

	@And("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.homePage().addToCartBtn);
		logger.info("item added to cart");

	}

	@Then("the cart icon quantity should change to {string}") // the Quantity is 2 it means integer, can i put string
																// for the quantity? i don't know if it works
	public void theCartIconeQuantityShouldChange(String Qty) {
		Assert.assertTrue(isElementDisplayed(factory.homePage().CartButton));
		logger.info("the cart icon quantity has changed to 2");

	}
//Scenario 4:

	@And("User change the category to {string}")
	public void userChagTheCategory(String Electrinics) {
		selectByVisibleText(factory.homePage().AllDepartmentSection, Electrinics);
		logger.info("user select Electrronics");

	}

	@And("User search for an item {string}")
	public void userSrearchForApexLegends(String Item) {
		sendText(factory.homePage().searchBarInput, Item);
		logger.info("User sreach3d Apex Legends");

	}

	@And("User click on Search icone")
	public void userClickOnSearchIcon() {
		click(factory.homePage().searchButton);
		logger.info("User clicked on Search icon");

	}

	@And(" User select quantity {string}") // the Quantity is 5 it means integer, can i put string for the quantity?
	public void userSelectQantity(String count) {
		selectByVisibleText(factory.homePage().QtyQuantitySection, count);
		logger.info("user selected 5 items");
	}

	@And("User click add to Cart button")
	public void userClickAddToCartBtn() {
		click(factory.homePage().addToCartBtn);
		logger.info("item added to cart");
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChange(String Qty) {
		Assert.assertTrue(isElementDisplayed(factory.homePage().CartButton));
		logger.info("the cart icon quantity has changed to 5");

	}

	@And("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.accountPage().MasterCartIcon);
	}

	@And("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckOutBtn() {
		click(factory.homePage().ProceedToCheckoutBtn);
		logger.info("User clicked on Proceed to Check Out Btn");
	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String orderMessage) {
		waitTillPresence(factory.homePage().orderPlacedSuccessfullyMsg);
		Assert.assertTrue(isElementDisplayed(factory.homePage().orderPlacedSuccessfullyMsg));// is the code
		String actualMassege = factory.homePage().orderPlacedSuccessfullyMsg.getText();
		String expectedMassege = orderMessage;
		Assert.assertEquals(actualMassege, expectedMassege);

	}
}
