package company.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import company.TestComponents.BaseTest;
import company.TestComponents.Retry;
import company.pageobject.CartpageObject;
import company.pageobject.CheckoutpageObject;
import company.pageobject.ConFirmationpageObject;
import company.pageobject.ProductCataloguePageObject;

public class ErrorValidationsTest extends BaseTest{ //inherit

		
		@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
		public void LoginErrorValidation() throws IOException
		{
		//String productName= "ZARA COAT 3";
			
		landingPage.loginApplication("sadik@gmail.com", "Pass2020"); //catching the desired PageObject class
		//Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage()); //landingPage.getErrorMessage();
		Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage()); //landingPage.getErrorMessage();
		}
		
		
		@Test
		public void ProductValidation() throws IOException
		{
		String productName= "ZARA COAT 3";
		
		ProductCataloguePageObject productCatalogue=landingPage.loginApplication("al@gmail.com", "Pass2020#"); //catching the desired PageObject class
		//ProductCataloguePageObject productCatalogue = new ProductCataloguePageObject(driver);//object of ProductCatalogue class
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartpageObject cartPage=productCatalogue.gotoCartPage(); //inherit from parent class AbstractComponent and catching the desired PageObject class
		
		//CartpageObject cartPage= new CartpageObject(driver);
		Boolean match=cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);//assertfalse() assertion method will accept only Boolean value false

		}
}
