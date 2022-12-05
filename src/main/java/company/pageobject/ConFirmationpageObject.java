package company.pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import company.AbstractComponents.AbstractComponent;


public class ConFirmationpageObject extends AbstractComponent { //inherit

	WebDriver driver;
	
	public ConFirmationpageObject(WebDriver driver) {//constructor
		super(driver); //send driver to parent class AbstractComponent.java using super()
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText(); //Thank you
	 */
	
	//PageFactory design
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	//action method
	public String getConfirmationMessage()
	{
		return confirmationMessage.getText();
	}
	
	
}
