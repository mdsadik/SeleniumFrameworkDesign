package company.pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import company.AbstractComponents.AbstractComponent;


public class CartpageObject extends AbstractComponent { //inherit
	WebDriver driver;
	
	public CartpageObject(WebDriver driver) {//constructor
		super(driver); //send driver to parent class AbstractComponent.java using super()
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	Assert.assertTrue(match);//assertTrue() assertion method will accept only Boolean value true
	driver.findElement(By.cssSelector(".totalRow button")).click(); //click check out
	 */
	
	//PageFactory design
	@FindBy(css=".cartSection h3")
	private List<WebElement> productTitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = productTitles.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutpageObject gotoCheckout() {
		checkout.click();
		return new CheckoutpageObject(driver);
	}
	
}
