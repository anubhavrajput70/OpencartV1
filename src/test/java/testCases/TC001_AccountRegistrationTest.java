package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verify_account_registration() {
		logger.info("*********** Starging TC001_AccountRegistrationTest ***********");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*********** clicked on myAccount link ***********");
			hp.clickRegister();
			logger.info("*********** clicked on register link ***********");

			AccountRegistrationPage arp = new AccountRegistrationPage(driver);

			logger.info("*********** providing customer details ***********");
			arp.setFirstName(randomString().toUpperCase());
			arp.setLastName(randomString().toUpperCase());
			arp.setEmail(randomString() + "@gmail.com");// randomly generated the email
			arp.setTelephone(randomNumber());
			String password = randomAlphaNumeric();
			arp.setPassword(password);
			arp.setConfirmPassword(password);
			arp.clickPrivacyPolicy();
			arp.clickContinue();

			logger.info("*********** validating expected msg ***********");
			String confmsg = arp.getConfirmationMsg();
			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("*********** test failed ***********");
				logger.debug("*********** debug logs ***********");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {

			Assert.fail();
		}
		logger.info("*********** finished TC001_AccountRegistrationTest ***********");
	}

}
