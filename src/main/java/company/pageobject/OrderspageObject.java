package company.pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import company.AbstractComponents.AbstractComponent;


public class OrderspageObject extends AbstractComponent { //inherit
	WebDriver driver;
	
	public OrderspageObject(WebDriver driver) {//constructor
		super(driver); //send driver to parent class AbstractComponent.java using super()
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	driver.findElement(By.cssSelector(".totalRow button")).click(); //click check out
	tr td:nth-child(3)
	 */
	
	//PageFactory design
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productNames;
	
	
	public Boolean VerifyOrdersDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
}
