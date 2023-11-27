package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;

public class LoginTest extends Base
{
	HomePage home;//object declare	
	LoginPage login;
	UserAccountPage useraccount;
	@Test(priority=1,enabled=true,description="TC003_Verify Valid Login",groups={"Sanity"})

	public void tc_003_verifyValidlogin()
	{
	List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
	String userEmail = data.get(1).get(0);
	String password = data.get(1).get(1);
	home = new HomePage(driver);
	login = home.clickonLoginMenu();
	login.enterUserEmailID(userEmail);//LoginTest method written
	login.enterUserPassword(password);
	useraccount = login.clickonLoginButton();
	String actEmail = useraccount.getEmailText();
	Assert.assertEquals(userEmail, actEmail,ErrorMessages.INVALID_EMAIL_ID); //calling error message method from Error message from Constants(class:ErrorMessages)
	}

}
