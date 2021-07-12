package application;

import dataUtils.PropertyData;
import org.openqa.selenium.WebDriver;

public class ApplicationContext {
    private WebDriver driver;
    private String baseUrl;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String BASE_URL) {
        this.baseUrl = BASE_URL;
    }
}
