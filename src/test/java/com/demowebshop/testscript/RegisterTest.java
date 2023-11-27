package com.demowebshop.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utilities.ExcelUtility;

public class RegisterTest extends Base
{
	HomePage home;//object declare	
	LoginPage login;
	@Test
	public void tc_004_verifyErrorwithinValidlogin()
	{
	List<ArrayList<String>> data = ExcelUtility.excelDataReader("RegisterPage");
	
	
	String username = data.get(1).get(0);
	String password = data.get(1).get(1);
	home = new HomePage(driver);
	login = home.clickonLoginMenu();
	login.enterUserEmailID(username);//LoginTest method written
	login.enterUserPassword(password);
	
	}

}
