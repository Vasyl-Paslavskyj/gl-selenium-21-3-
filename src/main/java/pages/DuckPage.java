package pages;

import application.ApplicationContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DuckPage extends Page{
    @FindBy(xpath = "//button[@name='add_cart_product']")
    private WebElement addToCart;

    @FindBy(xpath = "//*[contains(@class,'badge') and contains(@class,'quantity')]")
    private WebElement countLabel;

    public DuckPage(ApplicationContext appContext) {
        super(appContext);
        PageFactory.initElements(driver, this);
    }

    public DuckPage addDuck(int i) {
        new Actions(driver).moveToElement(wait.until(ExpectedConditions.elementToBeClickable(addToCart)))
                .pause(500).click().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(countLabel, String.valueOf(i)));
        return this;
    }

    public HomePage navigatingBackwardInBrowserHistory() {
        driver.navigate().back();
        return new HomePage(appContext);
    }
}
