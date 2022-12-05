package company.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import company.AbstractComponents.AbstractComponent;

public class LandingPageObject extends AbstractComponent { //inherit
	WebDriver driver;
	
	public LandingPageObject(WebDriver driver) {//constructor
		super(driver); //send driver to parent class AbstractComponent.java using super()
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	/*
	 driver.findElement(By.id("userEmail")).sendKeys("sadik@gmail.com");
	 driver.findElement(By.id("userPassword")).sendKeys("Pass2020#");
	 driver.findElement(By.id("login")).click();
	 //.ng-tns-c4-12.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	 */
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	//PageFactory design
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCataloguePageObject loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		/*
		ProductCataloguePageObject productCatalogue = new ProductCataloguePageObject(driver);//object of ProductCatalogue class
		return productCatalogue;
		*/
		return new ProductCataloguePageObject(driver);//object of ProductCatalogue class
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
}
