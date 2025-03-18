package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	

	@Test
	public void verify_account_registration()
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastName(randomString().toUpperCase());
		arp.setEmail(randomString()+"@gmail.com");//randomly generated the email
		arp.setTelephone(randomNumber());
		String password= randomAlphaNumeric();
		arp.setPassword(password);
		arp.setConfirmPassword(password);
		arp.clickPrivacyPolicy();
		arp.clickContinue();
		String confmsg=arp.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
	
	
}
