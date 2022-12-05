package company.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import company.AbstractComponents.AbstractComponent;

public class ProductCataloguePageObject extends AbstractComponent {
	WebDriver driver;
	
	
	//pro.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	//driver.findElement(By.cssSelector(".ng-animating"))
	
	public ProductCataloguePageObject(WebDriver driver) {//constructor
		super(driver);//send driver to parent class AbstractComponent.java using super()
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	
	
	//PageFactory design
	@FindBy(css=".mb-3")
	List<WebElement> products;
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
		
	@FindBy(css=".ng-animating")
	WebElement snipper;
	
	//Method
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) 
	{
		WebElement pro=getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return pro;
	}
	
	public void addProductToCart(String productName) 
	{
		WebElement pro=getProductByName(productName);
		pro.findElement(addToCart).click();

		waitForElementToAppear(toastMessage);
		waitForElementfToDisappear(snipper);
	}
	
}
