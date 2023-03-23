package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.bouncycastle.asn1.dvcs.Data;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

//SCENARIO 1
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekschoolLogo));

	}

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.accountPage().accountButton);
		logger.info("user clicked on Account option");
	}

	@And("User update Name {string} and Phone {string}")
	public void userUpdateName(String nameValue, String phoneValue) {
		clearTextUsingSendKeys(factory.accountPage().nameInputField);
		sendText(factory.accountPage().nameInputField, nameValue);
		clearTextUsingSendKeys(factory.accountPage().phoneNumberField);
		sendText(factory.accountPage().phoneNumberField, phoneValue);
		logger.info("user entered name and phone number");
	}

	@And("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().updateButton);
		logger.info("user clicked on Update button");
	}

	@Then("user profile information should be updated")
	public void userProfileInfomationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInfoUpdateMassege);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdateMassege));// is the code right?
		String actualMassege = factory.accountPage().personalInfoUpdateMassege.getText();
		String expectedMassege = "Pesonal information Updated successfully";
		Assert.assertEquals(actualMassege, expectedMassege);
		logger.info("user profile information should be updated");
	}

	// Scenario 2
	@And("User click on Add a payment method link")
	public void userClickOnAddPaymentMethodLink() {
		click(factory.accountPage().addPaymentMethod);
		logger.info("user clicked on add payment btn");

	}

	@And("User fill Debit or credit card information")
	public void userFillDebidOrCreditCartInfprmation(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().cartNumberfield, data.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCartField, data.get(0).get("nameOnCart"));
		sendText(factory.accountPage().expirationMonthField, data.get(0).get("expirationMonth"));
		sendText(factory.accountPage().expirationYearField, data.get(0).get("expitationYear"));
		logger.info("user filled Debit or Credit information");

	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayedPaymentMethodAddedSuccessfully(String message) {
		waitTillPresence(factory.accountPage().successMessageForAddingCard);
		Assert.assertEquals(message, factory.accountPage().successMessageForAddingCard.getText());
		logger.info("user added payment method successfully");
	}

	// Scenario 3
	@And("User click on Master Card")
	public void userClickOnMasterCard() {
		click(factory.accountPage().MasterCartIcon);
		logger.info("User clicked on Master card icon");
	}

	@And("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountPage().editIcon);
		logger.info("user clicked on Edit option");

	}

	@And("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {

		List<Map<String, String>> editCart = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(factory.accountPage().cartNumberfield);// Method in CommenUtitiy calss  =  public void clearTextUsingSendKeys(WebElement toClear) {
		sendText(factory.accountPage().cartNumberfield, editCart.get(0).get("cartNamber"));                       // toClear.sendKeys(Keys.CONTROL + "a");
		clearTextUsingSendKeys(factory.accountPage().nameOnCartField); 
		sendText(factory.accountPage().nameInputField, editCart.get(0).get("nameOnCartField")); 

		selectByVisibleText(factory.accountPage().expirationMonthField, editCart.get(0).get("expirationMonthField"));// public void selectByVisibleText(WebElement ele, String visibleText) {
		                                                                                                            //Select select = new Select(ele);
		                                                                                                           //select.selectByVisibleText(visibleText);
		selectByVisibleText(factory.accountPage().expirationYearField, editCart.get(0).get("expirationYearField"));
		clearTextUsingSendKeys(factory.accountPage().securtiyCodeField);
		sendText(factory.accountPage().securtiyCodeField, editCart.get(0).get("securtiyCodeField"));
		logger.info("user edited information");
	}

	@Then("a message should be displayed {string}")
	public void aMassgeShouldBeDisplayed() {
		waitTillPresence(factory.accountPage().personalInfoUpdateMassege);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdateMassege));
		String actualMassege = factory.accountPage().personalInfoUpdateMassege.getText();
		String expectedMassege = "Pesonal information Updated successfully";
		Assert.assertEquals(actualMassege, expectedMassege);
		logger.info("user profile information should be updated");
	}

// Scenario # 4
	@And("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().AddAddressOption);
		logger.info("User clicked on Add Address Option");
	}

	@And("user fill new address form with below information")
	public void userFillNewAddressFormWIthBelowInformation(DataTable dataTable) {
		List<Map<String, String>> Addressdata = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().countryDropdown,  Addressdata.get(0).get("country"));
		sendText(factory.accountPage().fullNameiPUT, Addressdata.get(0).get("fullName"));
		sendText(factory.accountPage().phoneNumberInput, Addressdata.get(0).get("phoneNumber"));
		sendText(factory.accountPage().streetNumber, Addressdata.get(0).get("streetAddress"));
		sendText(factory.accountPage().ApartmentInput, Addressdata.get(0).get("apartment"));
		sendText(factory.accountPage().cityInputField, Addressdata.get(0).get("City"));
		selectByVisibleText(factory.accountPage().StateDropdownOption, Addressdata.get(0).get("state"));
		sendText(factory.accountPage().zipCodeInput, Addressdata.get(0).get("zipCode"));
		logger.info("user filled new address form with upper information");
	}

	@And ("User click Add Your Address button")
	public void usreClickAddYourAddressButton() {
		click(factory.accountPage().addressBtn);
		logger.info("user click on add your address button");	
		
	}
	@Then ("a message should be displayed {string}")
	public void anAddAddressMessageShouldBeDisplayed(String string) {
		waitTillPresence(factory.accountPage().addAddressSuccessfullyMsg);
		String actualMassege = factory.accountPage().addAddressSuccessfullyMsg.getText();
		String expectedMassege = "Address Added successfully";
		Assert.assertEquals(actualMassege, expectedMassege);
		
	}	
}
