package pages;

import application.ApplicationContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class HomePage extends Page{
    private final By acceptCookies = By.xpath("//div[@id='box-cookie-notice']//button[@name='accept_cookies']");

    @FindBy(xpath = "//section[@id='box-popular-products']//article[@class='product-column']")
    private List<WebElement> popularProducts;

    @FindBy(xpath = "//div[@id='cart']")
    private WebElement cart;

    @FindBy(xpath = "//*[contains(@class,'badge') and contains(@class,'quantity')]")
    private WebElement countLabel;

    @FindBy(xpath = "//a[@class='logotype']")
    private WebElement label;

    Random random = new Random();

    public HomePage(ApplicationContext appContext) {
        super(appContext);
        PageFactory.initElements(driver, this);
    }

    public HomePage open() {
        driver.get(appContext.getBaseUrl());
        if(wait.until(ExpectedConditions.elementToBeClickable(acceptCookies)).isDisplayed()){
            new Actions(driver).moveToElement(driver.findElement(acceptCookies)).pause(500).click().perform();
        }
        return this;
    }

    public DuckPage selectDuck() {
        int index = random.nextInt(popularProducts.size()) + 1;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='box-popular-products']//article[@class='product-column']["+index+"]" ))).click();
        return new DuckPage(appContext);
    }

    public ShoppingCartPage selectCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
        return new ShoppingCartPage(appContext);
    }

    public HomePage waitTillHomePageLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(label));
        return this;
    }

    public String getDucksCountInCart() {
        return countLabel.getText();
    }
}
