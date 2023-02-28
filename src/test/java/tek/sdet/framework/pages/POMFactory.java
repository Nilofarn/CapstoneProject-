package tek.sdet.framework.pages;

import tek.sdet.framework.base.BaseSetup;

public class POMFactory extends BaseSetup {
	private RetailHomePage homePage;
	private RetailSignInPage signInPage;
	private RetailAccountPage accountPage;
	
	public POMFactory() {
		
		this.signInPage = new RetailSignInPage();
		this.homePage = new RetailHomePage();
		this.accountPage = new RetailAccountPage();
	
	}

	public RetailHomePage homePage() {
		return this.homePage;
	}

	public RetailSignInPage signInPage() {
		return this.signInPage;
	}
	public RetailAccountPage accountPage() {
		return this.accountPage;
	}
	
}