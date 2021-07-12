package pages;

import application.ApplicationContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingCartPage extends Page{
//    @FindBy(xpath = "//*[@id='box-checkout-cart']/h2")
//    private WebElement shoppingCart;
    By shoppingCart = By.xpath("//*[@id='box-checkout-cart']/h2");

    @FindBy(xpath = "//*[@id='box-checkout-cart']//button[@name='remove_cart_item']")
    private List<WebElement> removeCarts;

    @FindBy(xpath = "//*[@id='box-checkout-cart']//button[@name='remove_cart_item']")
    private WebElement removeCart;

    By noItemsTxt = By.xpath("//*[text()='There are no items in your cart.']");
    By cartItemsTable = By.cssSelector(".items.list-unstyled");
    By back = By.xpath("//*[text()='Back']");

    public ShoppingCartPage(ApplicationContext appContext) {
        super(appContext);
        PageFactory.initElements(driver, this);
    }

    public ShoppingCartPage removeDucks() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(shoppingCart, "Shopping Cart"));
        int size = removeCarts.size();
        for (int item = 0; item < size; item++) {
            new Actions(driver).moveToElement(wait.until(ExpectedConditions.elementToBeClickable(removeCart)))
                    .pause(500).click().perform();
            if(item < size-1) {
                wait.until(ExpectedConditions.presenceOfElementLocated(cartItemsTable));
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(noItemsTxt));
        return this;
    }

    public HomePage navigatingOnHomePage() {
        new Actions(driver).moveToElement(wait.until(ExpectedConditions.presenceOfElementLocated(back)))
                .pause(500).click().perform();
        return new HomePage(appContext);
    }
}
