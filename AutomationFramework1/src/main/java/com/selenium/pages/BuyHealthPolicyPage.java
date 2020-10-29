package com.selenium.pages;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.FluentWait;



public class BuyHealthPolicyPage {
	WebDriver driver;
	public BuyHealthPolicyPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="(//span[.='health'])[3]/..")
	private WebElement health_link;
	@FindBy(how=How.XPATH, using="//*[@src= '/health/Self.svg']")
	private WebElement self_button;
	@FindBy(how=How.XPATH, using="//button[.='Get Plan']")
	private WebElement getPlan_button;
	@FindBy(how=How.XPATH, using="//*[@src='/travel/birthday.svg']/../input")
	private WebElement birtDate_webedt;
	@FindBy(how=How.XPATH, using="//*[.='Your Mobile Number']/../input")
	private WebElement custMobileNumber_webedt;
	@FindBy(how=How.XPATH, using="//*[.='See Plan']/../button")
	private WebElement seePlan_button;
	@FindBy(how=How.XPATH, using="//*[.='View Premium Breakup']/../button")
	private WebElement buyNow_button;
	@FindBy(how=How.XPATH, using="(//span[.='health'])[3]")
	private WebElement health_Link;
	@FindBy(how=How.XPATH, using="(//button[.='I am Good to Go'])[1]")
	private WebElement IamGood_button;
	@FindBy(how=How.XPATH, using="(//button[.='Continue'])[1]")
	private WebElement continue_button;
	@FindBy(how=How.XPATH, using="//*[.='Name']/../input")
	private WebElement name_webedt;
	@FindBy(how=How.XPATH, using="(//*[.='Mobile Number']/../input")
	private WebElement mobNumb_webedt;
	@FindBy(how=How.XPATH, using="//*[.='Email Address']/../input")
	private WebElement emailId_webedt;
	//Define Password Field
	@FindBy(how=How.XPATH, using="//*[@id='tnc']")
	private WebElement termAndCon_chkbox;
	//Define Login Button
	@FindBy(how=How.XPATH, using="//*[@type='submit']")
	private WebElement pay_btn;
	@FindBy(how=How.XPATH, using="(//*[.='Just A Few Details Before You Pay'])[4]")
	private WebElement asserttxt_lbl;
	
	public void clickHealth()
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("--Polling");
				WebElement element = health_link;
				if(element.isDisplayed()){
					System.out.println("Element Found");
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
		health_link.click();
	}
	public void clickSelf()
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("--Polling");
				WebElement element = self_button;
				if(element.isDisplayed()){
					System.out.println("Element Found");
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
		self_button.click();
	}
	public void clickGetPlan()
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("--Polling");
				WebElement element = getPlan_button;
				if(element.isDisplayed()){
					System.out.println("Element Found");
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
		getPlan_button.click();
	}
	public void clickIamGoodButton()
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("--Polling");
				WebElement element = IamGood_button;
				if(element.isDisplayed()){
					System.out.println("Element Found");
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
		IamGood_button.click();
	}
	public void setBirthDate(String dob)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("--Polling");
				WebElement element = birtDate_webedt;
				if(element.isDisplayed()){
					System.out.println("Element Found");
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
		birtDate_webedt.sendKeys(dob);
	}
	public void setMandMobileNo(String mobNo)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("--Polling");
				WebElement element = custMobileNumber_webedt;
				if(element.isDisplayed()){
					System.out.println("Element Found");
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
		System.out.println(mobNo);
		custMobileNumber_webedt.sendKeys(mobNo);
	}
	public void clickSeePlan()
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("--Polling");
				WebElement element = seePlan_button;
				if(element.isDisplayed()){
					System.out.println("Element Found");
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
		seePlan_button.click();
	}
	public void clickBuyNowButton()
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("--Polling");
				WebElement element = buyNow_button;
				if(element.isDisplayed()){
					System.out.println("Element Found");
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
		buyNow_button.click();
	}
	public void clickContinue()
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("--Polling");
				WebElement element = continue_button;
				if(element.isDisplayed()){
					System.out.println("Element Found");
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
		continue_button.click();
	}
	public void setName(String name)
	{
		name_webedt.sendKeys(name);
	}
	public void setCustMobNumber(String mobNo)
	{
		mobNumb_webedt.sendKeys(mobNo);
	}
	public void setEmailId(String email)
	{
		emailId_webedt.sendKeys(email);
	}
	public void clickTC()
	{
		WebElement element = termAndCon_chkbox;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public void clickPayButon()
	{
		pay_btn.click();
	}
	public String getLabel()
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("--Polling");
				WebElement element = asserttxt_lbl;
				if(element.isDisplayed()){
					System.out.println("Element Found");
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
		return asserttxt_lbl.getText();
	}
}
