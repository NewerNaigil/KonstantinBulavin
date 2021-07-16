package ru.training.at.hw6.driver;

import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

    private static WebDriver webDriver;

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        String driverType = System.getProperty("driver.type") == null ? "local" : System.getProperty("driver.type");
        String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        if (Objects.isNull(webDriver)) {
            webDriver = WebDriverFactory.createWebDriver(driverType, browserName);
        }
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
