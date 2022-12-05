package company.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import company.pageobject.LandingPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		String productName= "ADIDAS ORIGINAL";//ADIDAS ORIGINAL, zara coat 3
		
		WebDriverManager.chromedriver().setup();//chromedriver will be downloaded automatically
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		//LandingPageObject landingPage = new LandingPageObject();//object of LandingPage class
		
		driver.findElement(By.id("userEmail")).sendKeys("sadik@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pass2020#");
		driver.findElement(By.id("login")).click();
		
		Thread.sleep(3000); 
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		//Using Stream to iterate each and every items present in the list
		WebElement pro=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		pro.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);//assertTrue() assertion method will accept only Boolean value true
		
		driver.findElement(By.cssSelector(".totalRow button")).click(); //click check out
		
		//Actions
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"can").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		//driver.findElement(By.cssSelector(".action__submit")).click();
		//driver.findElement(By.xpath("//a[contains(@class,'action__submit')]")).click();
		
		WebElement placeOrder = driver.findElement(By.cssSelector(".action__submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", placeOrder);
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText(); //Thank you
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		//driver.close();
		//driver.quit();
	}
}
