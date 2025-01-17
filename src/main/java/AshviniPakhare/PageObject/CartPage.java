package AshviniPakhare.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import AshviniPakhare.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents
{
	WebDriver driver;
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;

	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
	}
	
//	List<WebElement> cartProducts =driver.findElements(By.cssSelector(".cartSection h3"));
//	Boolean match=cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
//	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	public Boolean verifyProductDisplay(String productName)
	{
		Boolean match=cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout()
	{
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
}
