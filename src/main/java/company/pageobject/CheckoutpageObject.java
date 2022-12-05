package company.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import company.AbstractComponents.AbstractComponent;

public class CheckoutpageObject extends AbstractComponent { //inherit
	WebDriver driver;
	
	public CheckoutpageObject(WebDriver driver) {//constructor
		super(driver); //send driver to parent class AbstractComponent.java using super()
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	/*
	 driver.findElement(By.cssSelector("[placeholder='Select Country']"))
	 driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
	 driver.findElement(By.cssSelector(".action__submit"))
	 */
	

	//PageFactory design
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By results=By.cssSelector(".ta-results");
	By appearsubmit = By.cssSelector(".action__submit");

	//method
	public void selectCountry(String CountryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country,CountryName).build().perform();
		waitForElementToAppear((results));
		selectCountry.click();
		
	}
	
	public ConFirmationpageObject submitOrder() {
		waitForElementToAppear(appearsubmit);
		WebElement placeOrder = submit;
		JavascriptExecutor(placeOrder);
		return new ConFirmationpageObject(driver);
	}
	
}
