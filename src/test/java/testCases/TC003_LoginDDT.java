package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) // getting data provider from differnt
																				// class
	public void verifyLoginDDT(String email, String password, String exp) {
		
		logger.info("******* staring TC_003_LoginDDT *******");
		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setpassword(password);
			lp.clickLogin();

			// MyAccountPage
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyaccountPageExist();

			/*
			 * data is valid - login success - test pass - logout data is valid - login
			 * failed - test fail
			 * 
			 * data is invalid - login success - test failed -logout data is invalid - login
			 * failed
			 */
			if (exp.equalsIgnoreCase("valid")) {
				if (targetPage == true) {
					Assert.assertTrue(true);
					macc.clickLogout();
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("invalid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("******* Finish TC_003_LoginDDT *******");

	}

}
