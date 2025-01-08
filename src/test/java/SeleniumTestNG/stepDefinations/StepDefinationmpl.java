package SeleniumTestNG.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AshviniPakhare.PageObject.CartPage;
import AshviniPakhare.PageObject.CheckoutPage;
import AshviniPakhare.PageObject.ConfirmationPage;
import AshviniPakhare.PageObject.LandingPage;
import AshviniPakhare.PageObject.ProductCatalogue;
import SeleniumTestNG.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationmpl extends BaseTest
{
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommers page")
	public void i_landed_on_Ecommers_page() throws IOException
	{
		landingPage=launchApplication();		
	}
	
	@Given("^logged in with username (.+) and password (.+)$")
	public void logged_in_usename_and_password(String username, String password)
	{
		productCatalogue=landingPage.loginApplication(username , password);
	}
	
	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	
	@When("^Checkout (.+) and submit the Order$")
	public void Checkout_and_submit_the_order(String productName)
	{
		CartPage cartPage=productCatalogue.goToCart();		
		Boolean match=cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.seletCountry("india");
		confirmationPage=checkoutPage.submitOrder();
		driver.close();
	}
	
	
	@Then("{string} message is displayed on confirmationPage")
	public void confirmation_message_is_displayed(String string)
	{
		String confrimationMessage=confirmationPage.getConfimationMessage();
		Assert.assertTrue(confrimationMessage.equalsIgnoreCase(string));
	}
	
	@Then("^\"([^\"]*)\"message is displayed$")
    public void something_message_is_displayed(String strArg1)
    {
		Assert.assertEquals(strArg1, landingPage.getErrorMessage());
		driver.close();
    }
	

}
