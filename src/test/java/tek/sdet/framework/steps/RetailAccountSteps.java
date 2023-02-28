package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	@When("User click on Account option")  //
	public void userClickOnAccountOption() {
		click(factory.accountPage().accountButton);
		logger.info("user clicked on Account option");
	}
	@And("User update Name {string} and Phone {string}")
	public void userUpdateName(String nameValue, String phoneValue) {
		sendText(factory.accountPage().nameInputField,nameValue);
		sendText(factory.accountPage().phoneNumberField,phoneValue);
		logger.info("user entered name and phone number");
	}
	@And("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().updateButton);
		logger.info("user clicked on Update button");
		
	}
	@Then("user profile information should be updated")
	public void userProfileInfomationShouldBeUpdated() {
		Assert.assertTrue(isElementDisplayed(factory.accountPage().updateButton));// is the code right??
		logger.info("user profile information should be updated");
		
	}
	@And ("User click on Add a payment method link")
	public void userClickOnAddPaymentMethodLink() {
		click(factory.accountPage().addPaymentMethod);
		logger.info("user clicked on add payment btn");
		
	}
	@And ("User fill Debit or credit card information")
	public void userFillDebidOrCreditCartInfprmation(DataTable dataTable) {
		
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
		sendText(factory.accountPage().cartNumberfield,data.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCartField,data.get(0).get("nameOnCart"));
		sendText(factory.accountPage().expirationMonthField,data.get(0).get("expirationMonth"));
		sendText(factory.accountPage().expirationYearField,data.get(0).get("expitationYear"));
		 logger.info("user filled Debit or Credit information");
		 
	}
	   @And ("User click on Add your card button")
	   public void userClickOnAddYourCartButton() {
		   click(factory.accountPage().addYourCardField);
		   logger.info("user clicked on Add Your cart field");
	   }
	   @Then("a message should be displayed {string}")  //how can i write a method for this, because it has single quote
	   public void aMessageShouldBeDisplayedPaymentMethodAddedSuccessfully(String message) {
		   waitTillPresence(factory.accountPage().successMessageForAddingCard);
		   Assert.assertEquals(message, factory.accountPage().successMessageForAddingCard.getText());
		   logger.info("user added payment method successfully");
	   }
}
