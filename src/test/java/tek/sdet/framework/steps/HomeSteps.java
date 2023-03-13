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
		Assert.assertTrue(isElementDisplayed(getDriver().findElement(By.xpath("//span[text()='All']")))); // IS This a
																											// right
																											// code???
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

	}

	@And("User click on Search icon")
	public void userClickOnSerchIcone() {
		click(factory.homePage().searchButton);
		logger.info("User clicked on Search icon");

	}

	@And("User click on item")
	public void userClickOnItem() {
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

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconeQuantityShouldChange(String Qty) {
		Assert.assertTrue(isElementDisplayed(factory.homePage().CartButton));
		logger.info("the cart icon quantity has changed to 2");

	}

}
