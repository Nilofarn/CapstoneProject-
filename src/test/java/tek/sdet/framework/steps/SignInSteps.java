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
public class SignInSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	@When("User click on signin option") 
	public void userClickOnSignInOption() {
		click(factory.homePage().signInOptionBtn);
		logger.info("user clicked on Signin option button");  /// I already have, so why it shows that i didn't defined?? 
	}
	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String emailValue, String passValue) {
		sendText(factory.signInPage().emailField,emailValue);
		sendText(factory.signInPage().passwordField,passValue);
		logger.info("user entered email and password");
	}
	@And("User click on login button")
	public void userClickOnLoginBtn() {
		click(factory.signInPage().loginButton);
		logger.info("user click on Login button");
		
	}
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(isElementDisplayed(factory.signInPage().loginButton));
		logger.info("user should be logged in into accout");
		
	}
	 
	@And("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.signInPage().createNewAccountButton);
		logger.info("user clicked on new create acout btn");
	}
	@And("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
	 List<Map<String, String>> data = dataTable.asMaps(String.class,String.class);
	 sendText(factory.signInPage().newAccountNameField,data.get(0).get("name"));
	 sendText(factory.signInPage().createNewAccoutEmailField,data.get(0).get("email"));
	 sendText(factory.signInPage().createNewAccoutPasswordfield,data.get(0).get("password"));
	 sendText(factory.signInPage().createNewAccoutConfirmPassField,data.get(0).get("confirmpass"));
	 logger.info("user filled the signUp information form");
	}
	@And("User click on SignUp button")
	public void userClickOnSignUpButton() {
	    click(factory.signInPage().createNewAccoutSignupOption);
	    logger.info("user clicked on signUp option");
	}
	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() { 
		waitTillClickable(factory.accountPage().accountProfilePicture);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().accountProfilePicture));
		logger.info("user is logged into account");
	}
	
	}


