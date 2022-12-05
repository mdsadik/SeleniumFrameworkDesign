package company.AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import company.pageobject.CartpageObject;
import company.pageobject.OrderspageObject;

public class AbstractComponent {
	WebDriver driver;
	
	/*
	 driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	 routerlink="/dashboard/myorders"
	*/
	
	//PageFactory design
		@FindBy(css="[routerlink*='cart']")
		WebElement cartHeader;
	
	//PageFactory design
		@FindBy(css="[routerlink*='myorders']")
		WebElement ordersHeader;	
	
	public AbstractComponent(WebDriver driver) {//constructor
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Explicit wait
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	//Explicit wait
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	//Explicit wait
	public void waitForElementfToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	public CartpageObject gotoCartPage() {
		cartHeader.click();
		CartpageObject cartPage= new CartpageObject(driver);
		return cartPage;
	}
	
	
	public void JavascriptExecutor(WebElement ite)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ite);
	}
	
	public OrderspageObject gotoOrdersPage() {
		ordersHeader.click();
		OrderspageObject ordersPage= new OrderspageObject(driver);
		return ordersPage;
	}
	
}
