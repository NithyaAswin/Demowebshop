package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//find element input emailfield
	private final String _subEmailField = "newsletter-email"; //Inspect id and is pasted
	@FindBy(id = _subEmailField ) //if given xpath instead of id then give here as xpath=_subEmailField
	private WebElement subEmailField;
	
	//find element subscribe button
	private final String _subButton = "//input[@id='newsletter-subscribe-button']";
	@FindBy(xpath = _subButton )
	private WebElement subButton;
	
	//find element submessage 
	private final String _subMessage = "newsletter-result-block";
	@FindBy(id = _subMessage)
	private WebElement subMessage;
	
	private final String _loginLink = "//a[@class='ico-login']";
	@FindBy(xpath = _loginLink)
	private WebElement loginLink;
	
	public String getHomePageTitle() //method of tc_001
	{
		String title = page.getPageTitle(driver);
		return title;
	}
	
	//method to enter mailid
	public void enterSubEmailID() //method of tc_002
	{
		String emailID = random.getRandomEmail();
		page.enterText(subEmailField, emailID);
	}
	//method to click subscribe button
	public void clickSubButton()
	{
		subButton.click();
	}
	//method to find message element
	public String getSubMessage()
	{
		//wait.waitForElementToBeVisible(driver, subMessage);
		wait.setHardWait();//to stop exec and wait for message
		String subscribeMessage = page.getElementText(subMessage);
		return subscribeMessage;
	}
	
	//method for login link
	
	public LoginPage clickonLoginMenu()
	{
		page.clickOnElement(loginLink);//on clicking login it goes to new webpage,so return new page for eg LoginPage.
		return new LoginPage(driver);
	}
}
