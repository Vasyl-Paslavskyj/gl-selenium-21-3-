package pages;

import application.ApplicationContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;
    ApplicationContext appContext;

    public Page(ApplicationContext appContext) {
        this.appContext = appContext;
        this.driver = appContext.getDriver();
        this.wait = new WebDriverWait(driver, 10);

    }

    protected boolean isElementPresent(By element) {
        return driver.findElements(element).size() > 0;
    }
}
