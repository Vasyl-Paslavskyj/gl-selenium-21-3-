package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DuckPage;
import pages.HomePage;
import pages.ShoppingCartPage;

import static units.TestUtils.getBASE_URL;

public class LiteCartApplication {
    public static WebDriver driver;
    private final HomePage homePage;
    private final DuckPage duckPage;
    private final ShoppingCartPage shoppingCartPage;

    public LiteCartApplication(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        ApplicationContext appContext = new ApplicationContext();
        appContext.setDriver(driver);
        appContext.setBaseUrl(getBASE_URL());

        homePage = new HomePage(appContext);
        duckPage = new DuckPage(appContext);
        shoppingCartPage = new ShoppingCartPage(appContext);
    }

    public void openPage() {
        homePage.open();
    }

    public void selectProduct() {
        homePage.selectDuck();
    }

    public void selectCart() {
        homePage.selectCart();
    }

    public void addProduct(int i) {
        duckPage.addDuck(i).navigatingBackwardInBrowserHistory();
    }

    public void removeProducts() {
        shoppingCartPage.removeDucks();
    }

    public void navigateOnHome() {
        shoppingCartPage.navigatingOnHomePage().waitTillHomePageLoad();
    }

    public String getDucksCountInCart() {
        return homePage.getDucksCountInCart();
    }

    public void closeApp(){
        driver.quit();
    }

}
