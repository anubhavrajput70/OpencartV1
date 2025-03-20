package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"sanity","master"})
	public void verifyLogin()
	{
		logger.info("******* staring TC002_LoginTest ***** ");
		
		try {
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setpassword(p.getProperty("password"));
			lp.clickLogin();
			
			//MyAccountPage
			MyAccountPage macc= new MyAccountPage(driver);
			boolean targetPage= macc.isMyaccountPageExist();
			Assert.assertEquals(targetPage, true,"Login Failed");
			//Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("******* Finished TC002_LoginTest ***** ");
	}

}
