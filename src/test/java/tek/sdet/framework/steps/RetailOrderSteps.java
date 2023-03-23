package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {
	POMFactory factory = new POMFactory();
// Scenario1
	@And("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.orderPage().OrdersSectionBtn);
		logger.info("User cliked on order Section");

	}

	@And("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		click(factory.orderPage().lightBulps);
		logger.info("User clicked on first order in list");
	}

	@And("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		click(factory.orderPage().cancelOrderButton);
		logger.info("User clicked on cancel order btn");
	}

	@And("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReasonBoughtWrongItem(String reason) {
		click(factory.orderPage().cancelationReasonInput);
		selectByVisibleText(factory.orderPage().cancelationReasonInput, reason);// How to write
		logger.info("User select the cancelation Reason ‘Bought wrong item’");

	}

	@And("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.orderPage().cancelOrderButton);
	}

	@Then("a cancelation message should be displayed ‘Your Order Has Been Cancelled’")
	public void aCancelationMessageShouldBeDisplayedYourOrderHasBeenCancelled() {
	 Assert.assertTrue(isElementDisplayed(factory.orderPage().cancelationMessage));
		waitTillPresence(factory.orderPage().cancelationMessage);
		logger.info("a cancelation message is displayed");

	}

//Scenario #2
	@And("User click on Return Items button")
	public void userClikOnReturnItemBtn() {
		click(factory.orderPage().returnButton);
logger.info("user clicked on Return Btn");
	}

	@And("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String reason) {
click(factory.orderPage().cancelationReasonInput);
selectByVisibleText(factory.orderPage().cancelationReasonInput,reason);
logger.info("User clicked on the Return Reason input");

	}

	@And("User select the drop off service {string}")
	public void userSelectTheDropOffService(String DropOff) {
		click(factory.orderPage().dropOffInput);
		selectByVisibleText(factory.orderPage().dropOffInput, DropOff);
		logger.info("user selected the drop off service FedEx");
	}

	@And("User click on Return Order button")
	public void userClickOnReturnOrderBtn() {
click(factory.orderPage().returnButton);
logger.info("User clickes on Return Order Btn");
	}

	@Then("a cancelation message should be displayed {string}")
	public void CancelationMessageShouldBeDisplayed(String Massege) {
		Assert.assertTrue(isElementDisplayed(factory.orderPage().cancelationMessage));// is the code right?
		String actualMassege = factory.orderPage().cancelationMessage.getText();
		String expectedMassege = "Return was successful";
		Assert.assertEquals(actualMassege, expectedMassege);
		logger.info("Return was successful");
	}	
	
	
	//SCENARIO#3
	 @And(" User click on Review button")
	 public void userClickOnReviewBtton() {
		 click(factory.orderPage().reviewText);
		 logger.info("User clicked on Review Btn");
	 }
	 
	@And ("User write Review headline {string} and {string}")
	public void userWriteReviewHeadline(String  headlineValue, String reviewText) {
		sendText(factory.orderPage().headlineValue ,headlineValue);
		sendText(factory.orderPage().reviewText, reviewText);
		logger.info("user review the order");
	}
	@And ("User click Add your Review button")
	public void userClickAddYourReviowButton() {
	click(factory.orderPage().addYourReviewButton);
	logger.info("User clicked on add review Btn");		
		
	}	
	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayedYourReviewWasAddedSuccessfully(String reviewMessage) {
		waitTillPresence(factory.orderPage().YourReviewAddedSuccessfullyMessage);
		Assert.assertTrue(isElementDisplayed(factory.orderPage().YourReviewAddedSuccessfullyMessage));// is the code right?
		String actualMassege = factory.orderPage().YourReviewAddedSuccessfullyMessage.getText();
		String expectedMassege = reviewMessage;
		Assert.assertEquals(actualMassege, expectedMassege);
		logger.info(" Massege  Review added Succesfully ");
	}
	
}
	 

	

